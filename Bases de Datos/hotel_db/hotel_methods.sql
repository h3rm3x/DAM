-- automatically add reservations to the database
CREATE PROCEDURE add_reservation()
BEGIN 
    DECLARE var_reservation_id INT;
    DECLARE var_room_number INT;
    DECLARE var_customer_id INT;
    DECLARE var_check_in DATE;
    DECLARE var_check_out DATE;
    DECLARE var_price_per_night INT;
    DECLARE var_number_of_guests INT;
    

    DECLARE i INT DEFAULT 0;
    DECLARE attempts INT DEFAULT 0;
    DECLARE max_attempts INT DEFAULT 100;

    WHILE (i < 10 AND attempts < max_attempts) DO
        SET attempts = attempts + 1;
        SET var_room_number = (SELECT room_number FROM room ORDER BY RAND() LIMIT 1);
        SET var_customer_id = (SELECT customer_id FROM customer ORDER BY RAND() LIMIT 1);
        SET var_check_in = DATE_ADD(CURDATE(), 
                                INTERVAL FLOOR(RAND() * DATEDIFF('2026-12-31', CURDATE())) DAY);
        SET var_check_out = (SELECT DATE_ADD(var_check_in, INTERVAL FLOOR(RAND() * 7) DAY));
        SET var_price_per_night = (SELECT price_per_night FROM category WHERE (SELECT category_id FROM room WHERE room_number = var_room_number) = category_id LIMIT 1);
        IF (SELECT category_id FROM room WHERE room_number = var_room_number) = 1 THEN
            SET var_number_of_guests = FLOOR(2+ RAND()*2);
        ELSE 
            SET var_number_of_guests = FLOOR(2+ RAND()*4);
        END IF;
        
        

        IF check_availability(var_room_number, var_check_in, var_check_out) THEN
            INSERT INTO reservation (room_number, customer_id, check_in, check_out, price_per_night, number_of_guests) VALUES (var_room_number, var_customer_id, var_check_in, var_check_out, var_price_per_night, var_number_of_guests);
            SET i = i + 1;
        END IF;
    END WHILE;
END;

-- function to check the availability of a room in a given period
DELIMITER $$
CREATE FUNCTION check_availability (var_room_number INT, var_check_in DATE, var_check_out DATE)
RETURNS BOOLEAN DETERMINISTIC
BEGIN
    DECLARE var_availability BOOLEAN;
    SET var_availability = TRUE;
    IF (SELECT COUNT(*) FROM reservation WHERE room_number = var_room_number AND check_in <= var_check_out AND check_out >= var_check_in) > 0 THEN
        SET var_availability = FALSE;
    END IF;
    RETURN var_availability;
END$$DELIMITER ;