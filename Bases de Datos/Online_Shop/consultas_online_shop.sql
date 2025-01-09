SELECT *
FROM product_view;
--  total price per customer of those who have >100e in the shopping cart
SELECT customer_id, first_name, last_name, SUM(total_price) AS total_price
FROM shopping_cart_view
GROUP BY customer_id, first_name, last_name
HAVING total_price >= 100;
-- total number of items per customer.
SELECT customer_id, first_name, last_name, SUM(quantity) AS total_qty
FROM shopping_cart_view
GROUP BY customer_id, first_name, last_name;
-- Average number of items put in the shopping cart
SELECT customer_id, first_name, last_name, ROUND(avg(quantity), 1) AS average_items
FROM shopping_cart_view
GROUP BY customer_id, first_name, last_name;
-- total sales per year
SELECT  COUNT(*), YEAR(order_date) as YEAR
FROM order_view
GROUP BY YEAR(order_date);
-- total sales per quarter
SELECT  COUNT(*), QUARTER(order_date) as QUARTER
FROM order_view
GROUP BY QUARTER(order_date);
-- top 10 customers
SELECT sum(total_price) AS total_money_spent, customer_id
FROM order_view
GROUP BY customer_id
ORDER BY 1 DESC
LIMIT 10;
-- TOP 10 highest grossing product
SELECT sum(total_price) AS total_revenue, product_id
FROM order_view
GROUP BY product_id
ORDER BY 1 DESC
LIMIT 10;
-- top 10 highest sold products
SELECT sum(quantity) AS total_units_sold, product_id
FROM order_view
GROUP BY product_id
ORDER BY 1 DESC
LIMIT 10;
-- total revenue per month
SELECT  SUM(total_price), MONTHNAME(order_date) as MONTH
FROM order_view
GROUP BY MONTH(order_date);
-- total revenue per day
