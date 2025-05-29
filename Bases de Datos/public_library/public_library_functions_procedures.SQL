-- Function to calculate the read time based on the number of pages in a book
DELIMITER $$
CREATE FUNCTION read_time(var_number_of_pages INT)
RETURNS INT
BEGIN
    DECLARE var_read_time INT;
    SET var_read_time = var_number_of_pages/30; -- Assuming it takes 1 hour to read 30 pages
    RETURN var_read_time;
END$$

DELIMITER $$
CREATE PROCEDURE flag_customers_with_overdue_books()
BEGIN
    DECLARE number_of_customers INT ;
    DECLARE var_customer_nie VARCHAR(20);
    DECLARE var_overdue_books INT;

    SET number_of_customers = (SELECT DISTINCT COUNT(customer_NIE) FROM customers);

    FOR i IN 1..number_of_customers DO
        SET var_customer_nie = (SELECT customer_NIE FROM customers ORDER BY RAND() LIMIT 1);
        SET var_overdue_books = (SELECT COUNT(*) FROM books WHERE customer_NIE = var_customer_nie AND return_date > DATE_DIFF(CURDATE(), 365));

        IF var_overdue_books > 2 THEN
            UPDATE customers SET red_flag = 1 WHERE customer_NIE = var_customer_nie;
        END IF;
    END FOR;
END$$

-- VIEW to display all the information about books and the number of times they have been borrowed
CREATE VIEW book_borrowing_info AS
SELECT 
    b.book_id,
    b.title,
    b.author,
    b.genre,
    COUNT(bb.borrow_id) AS times_borrowed