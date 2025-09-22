CREATE FUNCTION full_name (first_name VARCHAR(100),last_name VARCHAR (100))
RETURNS VARCHAR(210) DETERMINISTIC
RETURN CONCAT_WS(first_name,last_name);


-- Insert data into the shopping_cart table

CREATE PROCEDURE shopping_cart_data_dump ()
BEGIN

    DECLARE var_customer_id INT;
    DECLARE var_product_id INT;
    DECLARE var_quantity INT;
    DECLARE i INT;

    SET i = 1;

    WHILE i <= 50 DO
        SET var_customer_id = FLOOR(1+RAND()*10);
        SET var_product_id = FLOOR(1+RAND()*10);
        SET var_quantity = FLOOR(1+RAND()*10);
        SET i = i + 1;
        INSERT INTO shopping_cart (customer_id, product_id, quantity)
        VALUES (var_customer_id, var_product_id, var_quantity);  
        ON DUPLICATE KEY UPDATE quantity = var_quantity + quantity  
    END WHILE;
END;


-- Insert data into the order table
CREATE PROCEDURE order_data_dump ()
DELIMITER $$
BEGIN
    DECLARE var_customer_id INT;
	DECLARE var_product_id INT;

    DECLARE i INT;

    SET i = 1;

    WHILE i <= 50 DO
        SET var_customer_id = (SELECT customer_id FROM shopping_cart ORDER BY RAND() LIMIT 1);
        SET var_product_id = (SELECT product_id FROM shopping_cart WHERE customer_id = var_customer_id ORDER BY RAND() LIMIT 1);
        IF var_customer_id IS NOT NULL THEN
            INSERT INTO order_table (customer_id, product_id, quantity, order_date, adress_id, method_id)
            SELECT customer_id, product_id, quantity, NOW(), get_address(var_customer_id), get_payment_method(customer_id)
            FROM shopping_cart
            WHERE customer_id = var_customer_id AND product_id = var_product_id;
            DELETE FROM shopping_cart WHERE customer_id = var_customer_id AND product_id = var_product_id;
            SET i = i + 1;   
        END IF;
    END WHILE;
	SELECT * FROM order_view;
END$$
DELIMITER ;

-- function to get the address of the customer
CREATE FUNCTION get_address (var_customer_id INT)
RETURNS INT DETERMINISTIC
BEGIN
    DECLARE var_address_id INT;
    SET var_address_id = (SELECT address_id FROM customer WHERE customer_id = var_customer_id);
    RETURN var_address_id;
END;

-- function to get the payment method of the customer
CREATE FUNCTION get_payment_method (var_customer_id INT)
RETURNS INT DETERMINISTIC
BEGIN
    DECLARE var_payment_method_id INT;
    SET var_payment_method_id = (SELECT payment_method_id FROM customer WHERE customer_id = var_customer_id);
    RETURN var_payment_method_id;
END;

-- procedure to place orders automatically
CREATE PROCEDURE automaticOrders ()
BEGIN
	DECLARE var_number_of_added_items INT ; 
    DECLARE var_number_of_orders INT;
    
    SET var_number_of_added_items = FLOOR(16*RAND()+5);
    SET var_number_of_orders = FLOOR(5+RAND()*2);
    
    CALL shopping_cart_data_dump(var_number_of_added_items);
    CALL order_data_dump(var_number_of_orders);
END;

-- event to place orders automatically every day
DROP EVENT IF EXISTS `insert_test_data`;
CREATE DEFINER=`root`@`localhost` EVENT `insert_test_data` ON SCHEDULE EVERY 1 DAY STARTS '2025-03-17 15:45:48' ENDS '2025-06-20 15:42:48' 
ON COMPLETION PRESERVE ENABLE DO CALL automatic_orders()

-- procedure to change order dates to random dates throughout the year 2024
CREATE PROCEDURE change_order_dates ()
BEGIN
    DECLARE var_order_id INT;
    DECLARE var_new_date DATE;
    DECLARE i INT;

    SET i = 1;

    WHILE i <= 50 DO
        SET var_order_id = (SELECT order_number FROM order_table ORDER BY RAND() LIMIT 1);
        SET var_new_date = (SELECT DATE_ADD('2024-01-01', INTERVAL FLOOR(RAND() * 365) DAY));
        UPDATE order_table SET order_date = var_new_date WHERE order_number = var_order_id;
        SET i = i + 1;
    END WHILE;
END;