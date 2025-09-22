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
-- procedure to flag customers with more than 2 overdue books in the last year
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

-- event to automatically flag customers with more than 2 overdue books in the last year
CREATE EVENT flag_customers_with_overdue_books_event
ON SCHEDULE EVERY 1 DAY
DO
BEGIN
    CALL flag_customers_with_overdue_books();
END$$
-- VIEW to display all the information about books and the number of times they have been borrowed
CREATE VIEW book_borrowing_info AS
SELECT 
    b.*
    COUNT(r.reservation_id) AS times_borrowed
FROM   
    books b
LEFT JOIN
    reservations r ON b.ISBN= r.book_ISBN
GROUP BY 
    b.ISBN, b.title, b.author, b.genre;


-- trigger to update the availability of a book when a reservation is returned
DELIMITER $$
CREATE TRIGGER `reservation_trigger` AFTER UPDATE ON `reservations`
FOR EACH ROW 
BEGIN
    IF (OLD.reservation_state = 'collected' AND NEW.reservation_state = 'returned') THEN 
        UPDATE books 
        SET availiability = 'on_site'
        WHERE ISBN = NEW.book_ISBN;
    END IF;
END$$
DELIMITER ;

-- view to display the aviliable books in the library
CREATE VIEW available_books AS
SELECT b.*
FROM books b
WHERE b.availability = 'on_site';

-- function to check the availability of a book in a given period
DELIMITER $$
CREATE FUNCTION check_availability (var_ISBN INT, var_borrow_date DATE, var_return_date DATE)
RETURNS BOOLEAN DETERMINISTIC
BEGIN
    DECLARE var_availability BOOLEAN;
    SET var_availability = TRUE;
    IF (SELECT COUNT(*) FROM reservations WHERE book_ISBN = var_ISBN AND borrow_date <= var_return_date AND return_date >= var_borrow_date) > 0 THEN
        SET var_availability = FALSE;
    END IF;

    RETURN var_availability;
END$$
DELIMITER;

-- Procedure to return all the openings in the availability for a given book
DELIMITER $$
CREATE PROCEDURE showBookFreeDates ()
BEGIN
    DECLARE var_ISBN INT;
    DECLARE var_borrow_date DATE;
    DECLARE var_return_date DATE;
    DECLARE var_book_name VARCHAR(255);
    DECLARE var_book_author VARCHAR(255);


    DECLARE i INT DEFAULT 0;
    DECLARE attempts INT DEFAULT 0;
    DECLARE max_attempts INT DEFAULT 100;

    WHILE (i < 10 AND attempts < max_attempts) DO
        SET attempts = attempts + 1;
        SET var_ISBN = (SELECT ISBN FROM books ORDER BY RAND() LIMIT 1);
        SET var_borrow_date = DATE_ADD('2024-01-01', INTERVAL FLOOR(RAND() * DATEDIFF('2026-12-31', '2024-01-01')) DAY);
        SET var_return_date = (SELECT DATE_ADD(var_borrow_date, INTERVAL FLOOR(RAND() * 7) DAY));
        SET var_book_name = (SELECT title FROM books WHERE ISBN = var_ISBN);
        SET var_book_author = (SELECT author FROM books WHERE ISBN = var_ISBN);
        
        IF check_availability(var_ISBN, var_borrow_date, var_return_date) THEN
            SELECT var_ISBN, var_book_name, var_book_author, var_borrow_date, var_return_date;
            SET i = i + 1;
        END IF;
    END WHILE;
END$$
DELIMITER;
