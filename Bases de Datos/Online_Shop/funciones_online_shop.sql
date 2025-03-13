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
            DELETE FROM shopping_cart WHERE customer_id = var_customer_id AND product_id = var_product_id ;
            SET i = i + 1;   
        END IF;
    END WHILE;
	SELECT * FROM order_view;
END$$
DELIMITER ;