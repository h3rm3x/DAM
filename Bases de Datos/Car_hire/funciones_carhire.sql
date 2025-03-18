-- automatically adding reservations to the database
DELIMITER $$
CREATE PROCEDURE add_reservation ()
BEGIN 
    DECLARE var_reservation_id INT;
    DECLARE var_car_id INT;
    DECLARE var_customer_id INT;
    DECLARE var_start_date DATE;
    DECLARE var_end_date DATE;
    DECLARE var_price_per_day INT;

    DECLARE i INT DEFAULT 0;

    WHILE(i<10)
        SET var_car_id = (SELECT car_id FROM car ORDER BY RAND() LIMIT 1);
        SET var_customer_id = (SELECT customer_id FROM customer ORDER BY RAND() LIMIT 1);
        SET var_start_date = (SELECT DATE_ADD(CURDATE(), INTERVAL FLOOR(RAND() * 30) DAY));
        SET var_end_date = (SELECT DATE_ADD(var_start_date, INTERVAL FLOOR(RAND() * 7) DAY));
        SET var_price_per_day = (SELECT class_price_per_day FROM car_class WHERE car_id = var_car_id);

        IF check_availability(var_car_id, var_start_date, var_end_date) THEN
            INSERT INTO reservation (car_id, customer_id, start_date, end_date, price_per_day) VALUES (var_car_id, var_customer_id, var_start_date, var_end_date, var_price_per_day);
            SET i = i + 1;
        END IF;
    END WHILE;

END$$
DELIMITER ;


-- function to check the availability of a car in a given period
DELIMITER $$
CREATE FUNCTION check_availability (var_car_id INT, var_start_date DATE, var_end_date DATE)
RETURNS BOOLEAN DETERMINISTIC
BEGIN
    DECLARE var_availability BOOLEAN;
    SET var_availability = TRUE;
    IF (SELECT COUNT(*) FROM reservation WHERE car_id = var_car_id AND start_date <= var_end_date AND end_date >= var_start_date) > 0 THEN
        SET var_availability = FALSE;
    END IF;
    RETURN var_availability;
END$$
DELIMITER ;


    