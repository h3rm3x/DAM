SELECT *
FROM product_view;
--  total price per customer of those who have >100e in the shopping cart
SELECT customer_id, first_name, last_name, SUM(total_price) AS total_price
FROM shopping_cart_view
GROUP BY customer_id
HAVING total_price >= 100;
-- total number of items per customer.
SELECT customer_id, first_name, last_name, SUM(quantity) AS total_qty
FROM shopping_cart_view
GROUP BY customer_id;
-- total sales per year
SELECT  COUNT(*) AS Number_of_Sales, YEAR(order_date) as YEAR
FROM order_view
GROUP BY YEAR(order_date);
-- total sales per quarter
SELECT  COUNT(*) AS Number_of_Sales, QUARTER(order_date) as QUARTER
FROM order_view
GROUP BY QUARTER(order_date);
-- top 10 customers by money spent
SELECT sum(total_price) AS total_money_spent, customer_id, YEAR(order_date) as YEAR
FROM order_view
WHERE YEAR(order_date) = 2024
GROUP BY customer_id
ORDER BY 1 DESC
LIMIT 10;
-- TOP 10 highest grossing product
SELECT sum(total_price) AS total_income, product_id, name
FROM order_view
GROUP BY product_id
ORDER BY 1 DESC
LIMIT 10;
-- top 10 highest sold products
SELECT sum(quantity) AS total_units_sold, product_id, name
FROM order_view
GROUP BY product_id
ORDER BY 1 DESC
LIMIT 10;
-- total income per month
SELECT  SUM(total_price) AS income, MONTH(order_date) as MONTH
FROM order_view
GROUP BY MONTH(order_date)
ORDER BY 2;
-- total income per month taking in account different years
SELECT  SUM(total_price) AS total_income, MONTH(order_date) as MONTH, YEAR(order_date) as YEAR
FROM order_view
GROUP BY YEAR(order_date), MONTH(order_date)
ORDER BY 2,3 asc;
-- full name and age of all the customers
SELECT customer_id, full_name(first_name,last_name) AS full_name, age(birth_date) AS age
FROM customer;

