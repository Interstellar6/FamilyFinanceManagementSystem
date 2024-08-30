
-- 函数：统计指定家庭成员在特定年份和月份的收入
-- 参数：family_id 家庭ID, member_id 家庭成员ID, year 年份, month 月份, category_name 类别名称（可选）
CREATE FUNCTION GetFamilyMemberCategoryRatios(
    familyId INT,
    memberId INT,
    year INT,
    month INT,
    type VARCHAR(10)
)
    RETURNS TEXT
    DETERMINISTIC
BEGIN
    DECLARE totalAmount DECIMAL(10, 2);
    DECLARE categoryName VARCHAR(64);
    DECLARE categoryAmount DECIMAL(10, 2);
    DECLARE categoryRatio DECIMAL(5, 2);
    DECLARE ratios TEXT DEFAULT '';
    DECLARE done INT DEFAULT FALSE;

    -- 定义游标
    DECLARE cur CURSOR FOR (
        SELECT category, SUM(amount) AS total
        FROM (
                 SELECT category, amount, expense_date AS date FROM expense
                 WHERE family_id = familyId AND (member_id = memberId OR memberId IS NULL)
                   AND (YEAR(expense_date) = year OR year IS NULL)
                   AND (MONTH(expense_date) = month OR month IS NULL)
                   AND type = 'expense'
                 UNION ALL
                 SELECT category, amount, income_date AS date FROM income
                 WHERE family_id = familyId AND (member_id = memberId OR memberId IS NULL)
                   AND (YEAR(income_date) = year OR year IS NULL)
                   AND (MONTH(income_date) = month OR month IS NULL)
                   AND type = 'income'
             ) AS unified
        GROUP BY category
    );

    -- 定义异常处理
    DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = TRUE;

    -- 计算指定类型的总金额
    SELECT SUM(amount) INTO totalAmount
    FROM (
             SELECT amount, expense_date AS date FROM expense
             WHERE family_id = familyId AND (member_id = memberId OR memberId IS NULL)
               AND (YEAR(expense_date) = year OR year IS NULL)
               AND (MONTH(expense_date) = month OR month IS NULL)
               AND type = 'expense'
             UNION ALL
             SELECT amount, income_date AS date FROM income
             WHERE family_id = familyId AND (member_id = memberId OR memberId IS NULL)
               AND (YEAR(income_date) = year OR year IS NULL)
               AND (MONTH(income_date) = month OR month IS NULL)
               AND type = 'income'
         ) AS unified;

    -- 如果未找到总金额，则返回空字符串
    IF totalAmount IS NULL OR totalAmount = 0 THEN
        RETURN ratios;
    END IF;

    -- 打开游标，遍历各个类别
    OPEN cur;
    read_loop: LOOP
        FETCH cur INTO categoryName, categoryAmount;
        IF done THEN
            LEAVE read_loop;
        END IF;
        -- 计算当前类别的比例
        SET categoryRatio = (categoryAmount / totalAmount) * 100;
        -- 将类别和比例追加到结果字符串中
        SET ratios = CONCAT(ratios, categoryName, ': ', categoryRatio, '%, ');
    END LOOP;
    CLOSE cur;

    -- 移除结果字符串末尾的逗号和空格
    RETURN TRIM(TRAILING ', ' FROM ratios);
END;

SELECT GetFamilyMemberCategoryRatios(1, NULL, 2023, NULL, 'expense') AS expense_ratios;

