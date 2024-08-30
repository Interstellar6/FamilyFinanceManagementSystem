DELIMITER $$

-- 函数：统计指定家庭成员在特定年份和月份的收入
-- 参数：family_id 家庭ID, member_id 家庭成员ID, year 年份, month 月份, category_name 类别名称（可选）
CREATE FUNCTION GetMemberMonthlyIncome(
    familyId INT,
    memberId INT,
    year INT,
    month INT,
    category_name VARCHAR(64))
RETURNS DECIMAL(10, 2)
DETERMINISTIC
BEGIN
    DECLARE total_income DECIMAL(10, 2);

    IF category_name IS NULL THEN
        -- 如果类别未指定，计算总收入
        SELECT SUM(amount) INTO total_income
        FROM income
        WHERE family_id = familyId
          AND member_id = memberId
          AND YEAR(income_date) = year
          AND MONTH(income_date) = month;
    ELSE
        -- 如果类别已指定，计算指定类别的收入
        SELECT SUM(amount) INTO total_income
        FROM income
        WHERE family_id = familyId
          AND member_id = memberId
          AND YEAR(income_date) = year
          AND MONTH(income_date) = month
          AND category = category_name;
    END IF;

    -- 如果没有收入记录，则返回0
    RETURN COALESCE(total_income, 0);
END$$

DELIMITER ;

-- 获取指定家庭成员在2023年5月的总收入
SELECT GetMemberMonthlyIncome(1, 2, 2023, 5, NULL) AS total_income;

-- 获取指定家庭成员在2023年5月，'工资'类别的收入
SELECT GetMemberMonthlyIncome(1, 2, 2023, 5, LOWER('Salary')) AS salary_income;
