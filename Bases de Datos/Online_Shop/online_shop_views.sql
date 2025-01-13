DROP VIEW IF EXISTS order_view;
CREATE VIEW order_view AS
SELECT O.order_number, O.customer_id, C.first_name, C.last_name, O.product_id, P.name, O.quantity, O.order_date, P.price, (P.price * O.quantity) AS total_price, CONCAT_WS( ', ',A.street , A.city, A.province, A.zip_code) AS delivery_adress, PM.method_name
FROM `order` O
INNER JOIN `customer` C ON O.customer_id = C.customer_id
INNER JOIN `product` P ON O.product_id = P.product_id
INNER JOIN `adress` A ON O.adress_id = A.adress_id
INNER JOIN `payment_method` PM ON O.method_id = PM.method_id;

DROP VIEW IF EXISTS product_view;
CREATE VIEW product_view AS 
SELECT P.product_id, P.name, P.price, P.stock, C.name AS category
FROM `product_category` PC
INNER JOIN `product` P ON PC.product_id = P.product_id
INNER JOIN `category` C ON PC.category_id = C.category_id;

DROP VIEW IF EXISTS shopping_cart_view;
CREATE VIEW shopping_cart_view AS
SELECT SC.shopping_cart_id, SC.customer_id, C.first_name, C.last_name, SC.product_id, P.name, SC.quantity, P.price, (P.price * SC.quantity) AS total_price
FROM `shopping_cart` SC
INNER JOIN `customer` C ON SC.customer_id = C.customer_id
INNER JOIN `product` P ON SC.product_id = P.product_id;

DROP VIEW IF EXISTS	total_income_per_month; -- (also taking in account the year)
CREATE VIEW total_income_per_month AS
SELECT  SUM(total_price) AS total_income, MONTH(order_date) as MONTH, YEAR(order_date) as YEAR
FROM order_view
GROUP BY YEAR(order_date), MONTH(order_date)
ORDER BY 2,3 asc;
