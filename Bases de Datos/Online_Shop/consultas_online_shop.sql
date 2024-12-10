CREATE VIEW order_view AS
SELECT O.order_id, O.customer_id, C.first_name, C.last_name, O.product_id, P.name, O.quantity, O.order_date, P.price, (P.price * O.quantity) AS total_price,CONCAT_WS( ', ',A.street AS , A.city, A.province, A.zip_code), PM.method_name
FROM `order` O
INNER JOIN `customer` C ON O.customer_id = C.customer_id
INNER JOIN `product` P ON O.product_id = P.product_id
INNER JOIN `adress` A ON O.adress_id = A.adress_id
INNER JOIN `payment_method` PM ON O.method_id = PM.method_id;

CREATE VIEW product_view AS 
SELECT P.product_id, P.product_name, P.price, P.stock, C.name AS category
FROM `product` P
INNER JOIN `product_category` PC ON P.product_id = PC.product_id
INNER JOIN `category` C ON PC.category_id = C.category_id;

CREATE VIEW shopping_cart_view AS
SELECT SC.shopping_cart_id, SC.customer_id, C.first_name, C.last_name, SC.product_id, P.product_name, SC.quantity, P.price, (P.price * SC.quantity) AS total_price