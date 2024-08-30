DELIMITER $$

CREATE PROCEDURE calculateCategoryProportion(
    IN familyId INT,
    IN familyMemberId INT, -- 去掉 DEFAULT NULL
    IN year INT,           -- 去掉 DEFAULT NULL
    IN month INT,          -- 去掉 DEFAULT NULL
    IN isIncome BOOLEAN
)
BEGIN
    -- 为参数赋默认值
    SET familyMemberId = IFNULL(familyMemberId, NULL);
    SET year = IFNULL(year, NULL);
    SET month = IFNULL(month, NULL);

    DECLARE totalAmount DECIMAL(10, 2);

    -- 动态选择表名
    SET @tableName = IF(isIncome, 'income', 'expense');

    -- 构造SQL查询，按条件动态调整
    SET @sql = CONCAT(
            'SELECT category, SUM(amount) / ',
            '(SELECT SUM(amount) FROM ', @tableName, ' WHERE family_id = ? ',
            IF(familyMemberId IS NOT NULL, ' AND member_id = ? ', ''),
            IF(year IS NOT NULL, ' AND YEAR(', IF(isIncome, 'income_date', 'expense_date'), ') = ? ', ''),
            IF(month IS NOT NULL, ' AND MONTH(', IF(isIncome, 'income_date', 'expense_date'), ') = ? ', ''),
            ') * 100 AS proportion ',
            'FROM ', @tableName, ' WHERE family_id = ? '
               );

    -- 拼接条件
    IF familyMemberId IS NOT NULL THEN
        SET @sql = CONCAT(@sql, ' AND member_id = ? ');
    END IF;

    IF year IS NOT NULL THEN
        SET @sql = CONCAT(@sql, ' AND YEAR(', IF(isIncome, 'income_date', 'expense_date'), ') = ? ');
    END IF;

    IF month IS NOT NULL THEN
        SET @sql = CONCAT(@sql, ' AND MONTH(', IF(isIncome, 'income_date', 'expense_date'), ') = ? ');
    END IF;

    SET @sql = CONCAT(@sql, ' GROUP BY category ORDER BY proportion DESC');

    -- 预处理SQL语句
    PREPARE stmt FROM @sql;

    -- 动态绑定参数
    IF familyMemberId IS NULL AND year IS NULL AND month IS NULL THEN
        EXECUTE stmt USING familyId, familyId;
    ELSEIF familyMemberId IS NOT NULL AND year IS NULL AND month IS NULL THEN
        EXECUTE stmt USING familyId, familyMemberId, familyId, familyMemberId;
    ELSEIF familyMemberId IS NULL AND year IS NOT NULL AND month IS NULL THEN
        EXECUTE stmt USING familyId, year, familyId, year;
    ELSEIF familyMemberId IS NULL AND year IS NOT NULL AND month IS NOT NULL THEN
        EXECUTE stmt USING familyId, year, month, familyId, year, month;
    ELSEIF familyMemberId IS NOT NULL AND year IS NOT NULL AND month IS NULL THEN
        EXECUTE stmt USING familyId, familyMemberId, year, familyId, familyMemberId, year;
    ELSE
        EXECUTE stmt USING familyId, familyMemberId, year, month, familyId, familyMemberId, year, month;
    END IF;

    -- 释放预处理语句
    DEALLOCATE PREPARE stmt;
END$$

DELIMITER ;
