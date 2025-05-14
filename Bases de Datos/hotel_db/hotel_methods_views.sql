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
CREATE PROCEDURE swapRooms (IN var_reservation_id INT)
DELIMITER $$
BEGIN
    DECLARE var_check_in DATE;
    DECLARE var_check_out DATE;
    DECLARE var_price_per_night INT;
    DECLARE var_number_of_guests INT;
    DECLARE var_room_number INT;
    DECLARE var_new_room_number INT;
    DECLARE var_category_id INT;
    DECLARE found_room BOOLEAN DEFAULT FALSE;
    DECLARE room_counter INT DEFAULT 0;

    -- Get the category ID of the current room in the reservation
    SET var_category_id = (SELECT ro.category_id 
                           FROM reservations re 
                           INNER JOIN rooms ro 
                           ON ro.room_number = re.room_number 
                           WHERE re.reservation_id = var_reservation_id);

    -- Get the details of the reservation
    SELECT check_in, check_out, price_per_night, number_of_guests, room_number 
    INTO var_check_in, var_check_out, var_price_per_night, var_number_of_guests, var_room_number 
    FROM reservations 
    WHERE reservation_id = var_reservation_id;

    -- Check if a new room is available
    WHILE NOT found_room AND room_counter < 50 DO
        -- Select a random room in the same category that is not the current room
        SET var_new_room_number = (SELECT room_number 
                                   FROM rooms 
                                   WHERE category_id = var_category_id 
                                   AND room_number != var_room_number 
                                   ORDER BY RAND() 
                                   LIMIT 1);

        -- Check if the new room is not currently checked in
        IF (SELECT COUNT(*) 
            FROM reservations re 
            WHERE re.room_number = var_new_room_number 
            AND re.status = 'check-in') = 0 THEN

            -- Update the reservation with the correct tags (new for room i will be swapped with and current for the room i have been assigned to)
            UPDATE reservations 
            SET tag = 'new'
            WHERE room_number = var_new_room_number;

            UPDATE reservations
            SET tag = 'current'
            WHERE room_number = var_room_number;

            -- Update the room number and price per night in the reservation accordingly
            UPDATE reservations
            SET room_number = var_room_number, 
                price_per_night = (SELECT price_per_night 
                                   FROM rooms 
                                   WHERE room_number = var_room_number) 
            WHERE tag = 'new';

            UPDATE reservations
            SET room_number = var_new_room_number, 
                price_per_night = (SELECT price_per_night 
                                   FROM rooms 
                                   WHERE room_number = var_new_room_number) 
            WHERE tag = 'current';


            SET found_room = TRUE;
        END IF;

        SET room_counter = room_counter + 1;       
    END WHILE;

    UPDATE reservations
    SET tag = NULL
    WHERE tag IN ('new', 'current');
END$$

DELIMITER ;

-- procedure to uograde the room of a reservation
DELIMITER $$

CREATE PROCEDURE upgradeRoom (IN var_reservation_id INT)
BEGIN
    DECLARE var_check_in DATE;
    DECLARE var_check_out DATE;
    DECLARE var_price_per_night INT;
    DECLARE var_number_of_guests INT;
    DECLARE var_room_number INT;
    DECLARE var_new_room_number INT;
    DECLARE var_category_id INT;
    DECLARE var_category_id_new INT;
    DECLARE found_room BOOLEAN DEFAULT FALSE;
    DECLARE room_counter INT DEFAULT 0;

    -- Obtener el ID de categoría de la habitación actual en la reserva
    SET var_category_id = (SELECT ro.category_id 
                           FROM reservations re 
                           INNER JOIN rooms ro 
                           ON ro.room_number = re.room_number 
                           WHERE re.reservation_id = var_reservation_id);

    -- Obtener los detalles de la reserva
    SELECT check_in, check_out, price_per_night, number_of_guests, room_number 
    INTO var_check_in, var_check_out, var_price_per_night, var_number_of_guests, var_room_number 
    FROM reservations 
    WHERE reservation_id = var_reservation_id;

    -- Intentar encontrar una nueva habitación en la misma categoría
    WHILE NOT found_room AND room_counter < 50 DO
        SET var_new_room_number = (SELECT room_number 
                                   FROM rooms 
                                   WHERE category_id = var_category_id 
                                   AND room_number != var_room_number 
                                   ORDER BY RAND() 
                                   LIMIT 1);

        IF check_availability(var_new_room_number, var_check_in, var_check_out) THEN
            -- Actualizar la reserva con la nueva habitación
            UPDATE reservations
            SET room_number = var_new_room_number 
            WHERE reservation_id = var_reservation_id;

            SET found_room = TRUE;
        END IF;

        SET room_counter = room_counter + 1;
    END WHILE;

    -- Si no se encontró una habitación en la misma categoría, intentar en categorías superiores
    IF NOT found_room THEN
        SET var_category_id_new = var_category_id + 1;

        WHILE NOT found_room AND var_category_id_new <= 5 DO
            SET room_counter = 0;

            WHILE NOT found_room AND room_counter < 50 DO
                SET var_new_room_number = (SELECT room_number 
                                           FROM rooms 
                                           WHERE category_id = var_category_id_new 
                                           AND room_number != var_room_number 
                                           ORDER BY RAND() 
                                           LIMIT 1);

                IF check_availability(var_new_room_number, var_check_in, var_check_out) THEN
                    -- Actualizar la reserva con la nueva habitación
                    UPDATE reservations
                    SET room_number = var_new_room_number 
                    WHERE reservation_id = var_reservation_id;

                    SET found_room = TRUE;
                END IF;

                SET room_counter = room_counter + 1;
            END WHILE;

            SET var_category_id_new = var_category_id_new + 1;
        END WHILE;
    END IF;
    SELECT "Room changed to: ", var_new_room_number, "in the category: ", (SELECT category_name FROM categories WHERE category_id= var_category_id_new), " whith the original price per night: ", var_price_per_night
    -- Si no se encontró ninguna habitación, lanzar un error
    IF NOT found_room THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'No available room found for the upgrade.';
    END IF;
END$$

DELIMITER ;

-- procedure to downgrade the room of a reservation
DELIMITER $$
CREATE PROCEDURE downgradeRoom (IN var_reservation_id INT)
BEGIN
    DECLARE var_check_in DATE;
    DECLARE var_check_out DATE;
    DECLARE var_price_per_night INT;
    DECLARE var_number_of_guests INT;
    DECLARE var_room_number INT;
    DECLARE var_new_room_number INT;
    DECLARE var_new_price_per_night INT;
    DECLARE var_category_id INT;
    DECLARE var_category_id_new INT;
    DECLARE found_room BOOLEAN DEFAULT FALSE;
    DECLARE room_counter INT DEFAULT 0;

    -- Obtener el ID de categoría de la habitación actual en la reserva
    SET var_category_id = (SELECT ro.category_id 
                           FROM reservations re 
                           INNER JOIN rooms ro 
                           ON ro.room_number = re.room_number 
                           WHERE re.reservation_id = var_reservation_id);

    -- Obtener los detalles de la reserva
    SELECT check_in, check_out, price_per_night, number_of_guests, room_number 
    INTO var_check_in, var_check_out, var_price_per_night, var_number_of_guests, var_room_number 
    FROM reservations 
    WHERE reservation_id = var_reservation_id;

    -- Intentar encontrar una nueva habitación en la misma categoría
    WHILE NOT found_room AND room_counter < 50 DO
        SET var_new_room_number = (SELECT room_number 
                                   FROM rooms 
                                   WHERE category_id = var_category_id 
                                   AND room_number != var_room_number 
                                   ORDER BY RAND() 
                                   LIMIT 1);

        IF check_availability(var_new_room_number, var_check_in, var_check_out) THEN
            -- Actualizar la reserva con la nueva habitación
            UPDATE reservations
            SET room_number = var_new_room_number 
            WHERE reservation_id = var_reservation_id;

            SET found_room = TRUE;
        END IF;

        SET room_counter = room_counter + 1;
    END WHILE;

    -- Si no se encontró una habitación en la misma categoría, intentar en categorías superiores
    IF NOT found_room THEN
        SET var_category_id_new = var_category_id - 1;

        WHILE NOT found_room AND var_category_id_new <= 5 DO
            SET room_counter = 0;

            WHILE NOT found_room AND room_counter < 50 DO
                SET var_new_room_number = (SELECT room_number 
                                           FROM rooms 
                                           WHERE category_id = var_category_id_new 
                                           AND room_number != var_room_number 
                                           ORDER BY RAND() 
                                           LIMIT 1);
                IF check_availability(var_new_room_number, var_check_in, var_check_out) THEN
                    SET var_new_price_per_night = (SELECT price_per_night 
                                                   FROM categories
                                                   WHERE category_id = var_category_id_new); 
                    -- Actualizar la reserva con la nueva habitación
                    UPDATE reservations
                    SET room_number = var_new_room_number, 
                        price_per_night = var_new_price_per_night 
                    FROM reservations 
                    WHERE reservation_id = var_reservation_id;
                    

                    SET found_room = TRUE;
                END IF;

                SET room_counter = room_counter + 1;
            END WHILE;

            SET var_category_id_new = var_category_id_new + 1;
        END WHILE;
    END IF;
    SELECT "Room changed to: ", var_new_room_number, " with price per night: ", var_new_price_per_night, ". There are ",(var_new_price_per_night-var_price_per_night)*DATEDIFF(var_check_out, var_check_in), "€ to be returned to the customer.";
    -- Si no se encontró ninguna habitación, lanzar un error
    IF NOT found_room THEN
        SELECT "No available room found for the upgrade.";
    END IF;
END$$

DELIMITER ;









-- procedure that iterates the elements of the extras
CREATE PROCEDURE iterate_extras(IN var_reservation_id INT)
BEGIN
    DECLARE var_service_category VARCHAR(255);
    DECLARE var_service_name VARCHAR(255);
    DECLARE var_service_date DATETIME;
    DECLARE var_service_price DECIMAL(8,2);
    DECLARE var_subtotal DECIMAL(10,2) DEFAULT 0;
    DECLARE category_names JSON;
    DECLARE category_name VARCHAR(255);
    DECLARE ticket_count INT;
    DECLARE ticket_index INT DEFAULT 0;
    DECLARE category_index INT DEFAULT 0;
    DECLARE total_categories INT;
    DECLARE subtotal DECIMAL(10,2) DEFAULT 0;

    -- Get the JSON object containing all categories
    SET category_names = (SELECT extras_json FROM reservations WHERE reservation_id = var_reservation_id);

    SET subtotal = 0;

    -- Check if the JSON object is not NULL
    IF category_names IS NOT NULL THEN
        CREATE TEMPORARY TABLE IF NOT EXISTS temp_extras (
            service_category VARCHAR(255),
            service_name VARCHAR(255),
            service_date DATETIME,
            service_price DECIMAL(8,2)
        );

        -- Get the total number of categories
        SET total_categories = JSON_LENGTH(category_names);

        -- Iterate through each category in the JSON
        WHILE category_index < total_categories DO
            -- Extract the category name by index
            SET category_name = JSON_UNQUOTE(JSON_EXTRACT(JSON_KEYS(category_names), CONCAT('$[', category_index, ']')));

            -- Get the number of tickets in the current category
            SET ticket_count = IFNULL(JSON_LENGTH(JSON_EXTRACT(category_names, CONCAT('$."', category_name, '".tickets'))), 0);
            SET ticket_index = 0;
            
            SET subtotal = subtotal + (JSON_UNQUOTE(JSON_EXTRACT(category_names, CONCAT('$."', category_name, '".total'))));

            
            -- Iterate through the tickets in the current category
            WHILE ticket_index < ticket_count DO
                SET var_service_name = JSON_UNQUOTE(JSON_EXTRACT(category_names, CONCAT('$."', category_name, '".tickets[', ticket_index, '].service_name')));
                SET var_service_date = JSON_UNQUOTE(JSON_EXTRACT(category_names, CONCAT('$."', category_name, '".tickets[', ticket_index, '].date')));
                SET var_service_price = JSON_UNQUOTE(JSON_EXTRACT(category_names, CONCAT('$."', category_name, '".tickets[', ticket_index, '].service_price')));


                -- Insert the ticket into the temporary table
                INSERT INTO temp_extras (service_category, service_name, service_date, service_price)
                VALUES (category_name, var_service_name, var_service_date, var_service_price);

                -- Update the subtotal
                SET var_subtotal = var_subtotal + var_service_price;

                SET ticket_index = ticket_index + 1;
            END WHILE;
            
            SET category_index = category_index + 1;
        END WHILE;

        INSERT INTO temp_extras ( service_category, service_name, service_date, service_price) 
        SELECT 'Room', 'Room', check_in, price_per_night*DATEDIFF(check_out, check_in) FROM reservations WHERE reservation_id = var_reservation_id;

        INSERT INTO temp_extras ( service_category, service_name, service_date, service_price)
        VALUES ('Subtotal', 'Subtotal', NULL, subtotal+ (SELECT price_per_night*DATEDIFF(check_out, check_in) FROM reservations WHERE reservation_id = var_reservation_id));
        -- Return the subtotal grouped by category
        SELECT service_category, SUM(service_price) AS total_price
        FROM temp_extras
        GROUP BY service_category;
    END IF;
END;

-- Assign cleaning to a random employee
CREATE PROCEDURE assign_cleaning(IN var_room_id INT)
    BEGIN
        DECLARE var_employee_id INT;
        DECLARE var_cleaning_date DATE;
        DECLARE var_cleaning_time TIME;

        -- Get a random employee ID
        SET var_employee_id = (SELECT employee_id FROM employees WHERE employee_shift = shift(CURDATE()) AND employee_id NOT IN (SELECT DISTINCT(employee_id) FROM cleaning WHERE cleaning_status='in_progress') ORDER BY RAND() LIMIT 1);
        -- Get the current date and time
        SET var_cleaning_date = CURDATE();
        SET var_cleaning_time = CURTIME();
        -- Insert the cleaning assignment into the cleaning table
        INSERT INTO cleaning (employee_id, room_number, cleaning_date, cleaning_time, cleaning_status)
        VALUES (var_employee_id, var_room_id, var_cleaning_date, var_cleaning_time, 'in_progress');
    END;

--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
-- add random extras to the reservation
DELIMITER $$

CREATE PROCEDURE add_extras()
BEGIN
    DECLARE var_reservation_id INT ;
    DECLARE var_service_category VARCHAR(255);
    DECLARE var_service_name VARCHAR(255);
    DECLARE var_service_date DATE;
    DECLARE var_service_price DECIMAL(8,2);
    DECLARE var_subtotal DECIMAL(10,2);
    DECLARE var_check_in DATE;
    DECLARE var_check_out DATE;
    DECLARE number_of_tickets INT;
    DECLARE i INT DEFAULT 0;
    DECLARE time_of_day TIME;
    DECLARE var_service_date_time DATETIME;
    DECLARE var_extras_json JSON;
    DECLARE ticket JSON;

    -- Get the reservation dates
    SELECT check_in, check_out, extras_json INTO var_check_in, var_check_out, var_extras_json
    FROM reservations
    WHERE reservation_id = var_reservation_id;

    -- Generate a random number of tickets (0 to 5)
    SET number_of_tickets = FLOOR(RAND() * 5) ;

    -- Loop to create tickets
    SET i = 0;
    WHILE i < number_of_tickets DO
        -- Select a random service category and name
        SELECT service_category, service_name, price
        INTO var_service_category, var_service_name, var_service_price
        FROM services
        ORDER BY RAND()
        LIMIT 1;

        -- Generar fecha aleatoria entre check-in y check-out
        SET var_service_date = DATE_ADD(var_check_in, INTERVAL FLOOR(RAND() * DATEDIFF(var_check_out, var_check_in)) DAY);

        -- Asignar hora dependiendo de la categoría
        IF var_service_category = 'Spa' THEN
            SET time_of_day = ADDTIME('10:00:00', SEC_TO_TIME(FLOOR(RAND() * 28800)));
        ELSEIF var_service_category = 'Restaurant' THEN
            IF var_service_name LIKE '%breakfast%' THEN
                SET time_of_day = ADDTIME('08:00:00', SEC_TO_TIME(FLOOR(RAND() * 14400)));
            ELSEIF var_service_name LIKE '%lunch%' THEN
                SET time_of_day = ADDTIME('13:00:00', SEC_TO_TIME(FLOOR(RAND() * 14400)));
            ELSEIF var_service_name LIKE '%dinner%' THEN
                SET time_of_day = ADDTIME('20:00:00', SEC_TO_TIME(FLOOR(RAND() * 14400)));
            END IF;
        ELSEIF var_service_category = 'Gym' THEN
            SET time_of_day = ADDTIME('10:00:00', SEC_TO_TIME(FLOOR(RAND() * 75600)));
        ELSEIF var_service_category = 'Bar' THEN
            IF var_service_name LIKE '%cocktail%' THEN
                SET time_of_day = ADDTIME('20:00:00', SEC_TO_TIME(FLOOR(RAND() * 14400)));
            ELSEIF var_service_name LIKE '%snack%' THEN
                SET time_of_day = ADDTIME('10:00:00', SEC_TO_TIME(FLOOR(RAND() * 36000)));
            END IF;
        END IF;

        SET var_service_date_time = CONCAT(var_service_date, ' ', time_of_day);
        SET var_subtotal = var_service_price;

        -- Create ticket JSON object
        SET ticket = JSON_OBJECT(
            'ticket_id', i,
            'service_name', var_service_name,
            'date', var_service_date_time,
            'service_price', var_service_price
        );

        -- Add ticket to the JSON object
        SET var_extras_json = JSON_SET(
            IFNULL(var_extras_json, JSON_OBJECT()),
            CONCAT('$.', var_service_category, '.tickets[', i, ']'),
            ticket
        );

        -- update the total price in the JSON object
        SET var_extras_json = JSON_SET(
            var_extras_json,
            CONCAT('$.', var_service_category, '.total'),
            IFNULL(JSON_EXTRACT(var_extras_json, CONCAT('$.', var_service_category, '.total')), 0) + var_subtotal
        );

        SET i = i + 1;
    END WHILE;

    -- Update JSON in the reservation table
    UPDATE reservations
    SET extras_json = var_extras_json
    WHERE reservation_id = var_reservation_id;
END$$

DELIMITER ;

    -------------------------------------------------------------------------------------------------------------------------
-- procedure to get the total price of a reservation
-- reservation view
CREATE VIEW reservation_view AS
SELECT r.reservation_id, r.room_number, r.customer_id, r.check_in, r.check_out, r.number_of_guests, c.first_name, c.last_name, c.email, c.phone_number, c.address, r.price_per_night*(DATEDIFF(r.check_out,r.check_in)) AS subtotal
FROM reservation r



-- daily check-in 15:00
-- daily check-out 8:00
-- Fill cleaning table for check-outs 8:00
-- Tick cleaning table for check-outs 15:00


