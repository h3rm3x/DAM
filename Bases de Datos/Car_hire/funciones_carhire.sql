-- automatically adding reservations to the database
DELIMITER $$
CREATE PROCEDURE add_reservation()
BEGIN 
    DECLARE var_reservation_id INT;
    DECLARE var_car_id INT;
    DECLARE var_customer_id INT;
    DECLARE var_initial_date DATE;
    DECLARE var_final_date DATE;
    DECLARE var_price_per_day INT;

    DECLARE i INT DEFAULT 0;
    DECLARE attempts INT DEFAULT 0;
    DECLARE max_attempts INT DEFAULT 100;

    WHILE (i < 10 AND attempts < max_attempts) DO
        SET attempts = attempts + 1;
        SET var_car_id = (SELECT car_id FROM car ORDER BY RAND() LIMIT 1);
        SET var_customer_id = (SELECT client_id FROM client ORDER BY RAND() LIMIT 1);
        SET var_initial_date = DATE_ADD('2024-01-01', 
                                INTERVAL FLOOR(RAND() * DATEDIFF('2026-12-31', '2024-01-01')) DAY);
        SET var_final_date = (SELECT DATE_ADD(var_initial_date, INTERVAL FLOOR(RAND() * 7) DAY));
        SET var_price_per_day = (SELECT class_price FROM car_class WHERE car_id = var_car_id);
        
        

        IF car_avaliability(var_car_id, var_initial_date, var_final_date) THEN
            INSERT INTO reservation (car_id, client_id, initial_date, final_date, price_per_day) VALUES (var_car_id, var_customer_id, var_initial_date, var_final_date, var_price_per_day);
            SET i = i + 1;
        END IF;
    END WHILE;
END$$
DELIMITER ;


-- function to check the availability of a car in a given period
DELIMITER $$
CREATE FUNCTION check_availability (var_car_id INT, var_date_in DATE, var_date_out DATE)
RETURNS BOOLEAN DETERMINISTIC
BEGIN
    DECLARE var_availability BOOLEAN;
    SET var_availability = TRUE;
    IF (SELECT COUNT(*) FROM reservation WHERE car_id = var_car_id AND date_in <= var_date_out AND date_out >=  var_date_in) > 0 THEN
        SET var_availability = FALSE;
    END IF;
    RETURN var_availability;
END$$
DELIMITER ;

-- procedure that returns the openings in the avaliability for a given car
DELIMITER $$
CREATE PROCEDURE showCarsFreeDates ()
BEGIN
    DECLARE var_car_id INT;
    DECLARE var_initial_date DATE;
    DECLARE var_final_date DATE;

    DECLARE i INT DEFAULT 0;
    DECLARE attempts INT DEFAULT 0;
    DECLARE max_attempts INT DEFAULT 100;

    WHILE (i < 10 AND attempts < max_attempts) DO
        SET attempts = attempts + 1;
        SET var_car_id = (SELECT car_id FROM car ORDER BY RAND() LIMIT 1);
        SET var_initial_date = DATE_ADD('2024-01-01', INTERVAL FLOOR(RAND() * DATEDIFF('2026-12-31', '2024-01-01')) DAY);
        SET var_final_date = (SELECT DATE_ADD(var_initial_date, INTERVAL FLOOR(RAND() * 7) DAY));
        
        IF car_avaliability(var_car_id, var_initial_date, var_final_date) THEN
            SELECT var_car_id, var_initial_date, var_final_date;
            SET i = i + 1;
        END IF;
    END WHILE;


END$$

-- function to dsiconunt the price of a car depending on the days until the reservation
DELIMITER $$
CREATE FUNCTION apply_discount (var_days_until_free_date_in INT, var_car_price_per_day INT)
RETURNS INT DETERMINISTIC
BEGIN
    IF var_days_until_free_date_in <= 3 THEN
        SET var_car_price_per_day = var_car_price_per_day * 0.5;
    ELSEIF var_days_until_free_date_in <= 7 THEN
        SET var_car_price_per_day = var_car_price_per_day * 0.6;
    ELSEIF var_days_until_free_date_in <= 10 THEN
        SET var_car_price_per_day = var_car_price_per_day * 0.7;
    ELSEIF var_days_until_free_date_in <= 30 THEN
        SET var_car_price_per_day = var_car_price_per_day * 0.9;
    END IF;
    RETURN var_car_price_per_day;
END$$
DELIMITER ;

-- function to add the discount to the reservation
DELIMITER $$
CREATE FUNCTION add_discount (var_days_until_free_date_in INT)
RETURNS VARCHAR(10) DETERMINISTIC
BEGIN
    DECLARE var_discount VARCHAR(10);
    IF var_days_until_free_date_in <= 3 THEN
        SET var_discount = '50%';
    ELSEIF var_days_until_free_date_in <= 7 THEN
        SET var_discount = '40%';
    ELSEIF var_days_until_free_date_in <= 15 THEN
        SET var_discount = '30%';
    ELSEIF var_days_until_free_date_in <= 30 THEN
        SET var_discount = '10%';
    ELSE
        SET var_discount = '0%';
    END IF;
    RETURN var_discount;
END$$
DELIMITER ;
                                             
    