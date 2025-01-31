DELIMITER $$

-- 函数：统计指定家庭成员在特定年份和月份的支出
-- 参数：family_id 家庭ID, member_id 家庭成员ID, year 年份, month 月份, category_name 类别名称（可选）
CREATE FUNCTION GetMemberMonthlyExpense(
    familyId INT,
    memberId INT,
    year INT,
    month INT,
    category_name VARCHAR(64))
    RETURNS DECIMAL(10, 2)
    DETERMINISTIC
BEGIN
    IF category_name IS NULL THEN
        -- 如果类别未指定，计算总支出
        SELECT SUM(amount) INTO @total_expense
        FROM expense
        WHERE family_id = familyId
          AND member_id = memberId
          AND YEAR(expense_date) = year
          AND MONTH(expense_date) = month;
    ELSE
        -- 如果类别已指定，计算指定类别的支出
        SELECT SUM(amount) INTO @total_expense
        FROM expense
        WHERE family_id = familyId
          AND member_id = memberId
          AND YEAR(expense_date) = year
          AND MONTH(expense_date) = month
          AND category = category_name;
    END IF;

    -- 如果没有支出记录，则返回0
    RETURN COALESCE(@total_expense, 0);
END$$

DELIMITER ;

-- 获取指定家庭成员在2023年5月的总支出
SELECT GetMemberMonthlyExpense(1, 2, 2023, 5, NULL) AS total_expense;

-- 获取指定家庭成员在2023年5月，'食品'类别的支出
SELECT GetMemberMonthlyExpense(1, 2, 2023, 5, LOWER('Food')) AS food_expense;

