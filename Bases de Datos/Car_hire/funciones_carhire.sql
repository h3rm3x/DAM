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
        SET var_price_per_day = (SELECT class_price_per_day FROM car_class WHERE car_id = var_car_id);
        
        

        IF car_avaliability(var_car_id, var_initial_date, var_final_date) THEN
            INSERT INTO reservation (car_id, client_id, initial_date, final_date, price_per_day) VALUES (var_car_id, var_customer_id, var_initial_date, var_final_date, var_price_per_day);
            SET i = i + 1;
        END IF;
    END WHILE;
END$$
DELIMITER ;


-- function to check the availability of a car in a given period
DELIMITER $$
CREATE FUNCTION check_availability (var_car_id INT, var_initial_date DATE, var_final_date DATE)
RETURNS BOOLEAN DETERMINISTIC
BEGIN
    DECLARE var_availability BOOLEAN;
    SET var_availability = TRUE;
    IF (SELECT COUNT(*) FROM reservation WHERE car_id = var_car_id AND initial_date <= var_final_date AND final_date >= var_initial_date) > 0 THEN
        SET var_availability = FALSE;
    END IF;
    RETURN var_availability;
END$$DELIMITER ;

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

    