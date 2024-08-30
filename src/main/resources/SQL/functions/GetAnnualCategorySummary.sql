DELIMITER $$

CREATE FUNCTION GetAnnualCategorySummary(
    familyId INT,
    memberId INT,
    year INT
)
    RETURNS TEXT
    DETERMINISTIC
BEGIN
    DECLARE result TEXT DEFAULT '';
    DECLARE done INT DEFAULT FALSE;
    DECLARE categoryName VARCHAR(64);
    DECLARE totalIncome DECIMAL(10, 2);
    DECLARE totalExpense DECIMAL(10, 2);

    DECLARE cur CURSOR FOR
        SELECT name
        FROM category;

    DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = TRUE;

    OPEN cur;

    read_loop: LOOP
        FETCH cur INTO categoryName;
        IF done THEN
            LEAVE read_loop;
        END IF;

        -- Calculate total income for the category
        SELECT SUM(amount) INTO totalIncome
        FROM income
        WHERE family_id = familyId
          AND (member_id = memberId OR memberId IS NULL)
          AND YEAR(income_date) = year
          AND category = categoryName;

        -- Calculate total expense for the category
        SELECT SUM(amount) INTO totalExpense
        FROM expense
        WHERE family_id = familyId
          AND (member_id = memberId OR memberId IS NULL)
          AND YEAR(expense_date) = year
          AND category = categoryName;

        -- Append results to the result string
        SET result = CONCAT(result, categoryName, ': Income = ', COALESCE(totalIncome, 0), ', Expense = ', COALESCE(totalExpense, 0), '; ');
    END LOOP;

    CLOSE cur;

    RETURN TRIM(TRAILING '; ' FROM result);
END$$

DELIMITER ;
