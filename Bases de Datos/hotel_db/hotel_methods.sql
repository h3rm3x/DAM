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
        SET var_check_out = (SELECT DATE_ADD(var_check_in, INTERVAL FLOOR(1+RAND() * 7) DAY));
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

-- Swap the room of a reservation
CREATE PROCEDURE swap_room(IN var_reservation_id INT, IN var_room_number INT)
BEGIN
    DECLARE var_check_in DATE;
    DECLARE var_check_out DATE;
    DECLARE var_price_per_night INT;
    DECLARE var_number_of_guests INT;
    
    -- Get the details of the reservation
    SELECT check_in, check_out, price_per_night, number_of_guests INTO var_check_in, var_check_out, var_price_per_night, var_number_of_guests FROM reservation WHERE reservation_id = reservation_id;
    -- Check if the new room is available
    IF (SELECT COUNT(*)  FROM reservation WHERE room_number = var_room_number AND check_in <=  var_check_out AND check_out >= var_check_in ) IS NULL THEN
        -- Update the reservation with the new room number
        UPDATE reservation SET room_number = var_room_number, price_per_night = var_price_per_night, number_of_guests = var_number_of_guests WHERE reservation_id = var_reservation_id;
    ELSE 
        DECLARE var_new_room_number INT;
        SELECT room_number INTO var_new_room_number FROM room WHERE room_number != var_room_number ORDER BY RAND() LIMIT 1;

    END IF;


END;
-- procedure that iterates the elements of the extras
CREATE PROCEDURE iterate_extras(IN var_reservation_id INT)
BEGIN
    DECLARE var_service_category VARCHAR(255);
    DECLARE var_service_name VARCHAR(255);
    DECLARE var_service_date DATE;
    DECLARE var_service_price DECIMAL(8,2);
    DECLARE var_subtotal DECIMAL(10,2);
    DECLARE elements INT;
    DECLARE counter INT DEFAULT 0;

    -- Get the number of elements in the JSON array
    SET elements = IFNULL(JSON_LENGTH((SELECT extras_json FROM reservations WHERE reservation_id = var_reservation_id)), 0);
    IF elements > 0 THEN
        CREATE TEMPORARY TABLE IF NOT EXISTS temp_extras (
        service_category VARCHAR(255),
        `service_name` VARCHAR(255),
        service_date DATE,
        service_price DECIMAL(8,2)
    );
    END IF;
    

    -- Iterate through the JSON array
    WHILE counter < elements DO
        SET var_service_category = JSON_UNQUOTE(JSON_EXTRACT((SELECT extras_json FROM reservations WHERE reservation_id = var_reservation_id), CONCAT('$[', counter, '].service_category')));
        SET var_service_name = JSON_UNQUOTE(JSON_EXTRACT((SELECT extras_json FROM reservations WHERE reservation_id = var_reservation_id), CONCAT('$[', counter, '].service_name')));
        SET var_service_date = JSON_UNQUOTE(JSON_EXTRACT((SELECT extras_json FROM reservations WHERE reservation_id = var_reservation_id), CONCAT('$[', counter, '].service_date')));
        SET var_service_price = JSON_UNQUOTE(JSON_EXTRACT((SELECT extras_json FROM reservations WHERE reservation_id = var_reservation_id), CONCAT('$[', counter, '].service_price')));
        SET var_subtotal = var_subtotal + var_service_price;
        
        INSERT INTO temp_extras (service_category, service_name, service_date, service_price) VALUES (var_service_category, var_service_name, var_service_date, var_service_price);

        

        SET counter = counter + 1;
    END WHILE;
    -- Return the subtotal
    SELECT service_category, SUM(service_price)
    FROM temp_extras
    GROUP BY service_category;
END;

--
UPDATE reservations
SET extras_json = SELECT extras_json FROM reservations WHERE reservation_id = var_reservation_id
WHERE reservation_id = var_reservation_id;

