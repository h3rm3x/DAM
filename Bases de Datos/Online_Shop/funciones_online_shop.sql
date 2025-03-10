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
        IF var_customer_id IS IN (SELECT customer_id FROM shopping_cart WHERE product_id = var_product_id) AND var_product_id IS IN (SELECT product_id FROM shopping_cart WHERE customer_id = var_customer_id) THEN
            UPDATE shopping_cart
            SET quantity = quantity + var_quantity
            WHERE customer_id = var_customer_id AND product_id = var_product_id;
        ELSE
            INSERT INTO shopping_cart (customer_id, product_id, quantity)
            VALUES (var_customer_id, var_product_id, var_quantity);            
        END IF;   
    END WHILE;

    
END;


-- Insert data into the order table
CREATE PROCEDURE order_data_dump ()





