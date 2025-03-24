-- total days and price for each reservation
SELECT id_reservation, client_id, car_id, DATEDIFF(final_date,initial_date)+1 AS total_days, DATEDIFF(final_date,initial_date)*price_per_day AS total_price
 FROM `reservation`
ORDER BY client_id ASC;
--- avaliable cars for a given period 
SELECT * 
FROM `car` 
WHERE car_id NOT IN (
    SELECT car_id 
    FROM reservation 
    WHERE (initial_date<='2024-10-31' AND final_date>='2024-10-24')
);
-- AVERAGE PRICE FOR RESEVATIONS IN AUGUST
 SELECT AVG(price_per_day)
 FROM reservation
 WHERE MONTH(initial_date) = 8;
 -- cars that have bbeen booked in the last 3 months
 SELECT *
 FROM car
 WHERE car_id IN (
     SELECT car_id
     FROM reservation
     WHERE initial_date >=  DATE_SUB(CURDATE(), INTERVAL 3 MONTH) AND final_date <= CURDATE()
 );

 -- invoices for all resrvations
    SELECT Cu.name , Cu.surname, Cu.nif, R.*, Ca.brand, Ca.model
    FROM reservations AS R
    INNER JOIN clients AS Cu ON Cu.client_id = R.client_id
    INNER JOIN cars AS Ca ON Ca.car_id = R.car_id;
-- invoices for all reservations w/ Forename in uppercase
    SELECT Cu.name , UCASE(Cu.surname), Cu.nif, R.*, Ca.brand, Ca.model 
    FROM reservations AS R 
    INNER JOIN clients AS Cu ON Cu.client_id = R.client_id 
    INNER JOIN cars AS Ca ON Ca.car_id = R.car_id;
-- invoices for all reservations w/ Forename in uppercase and total price
    SELECT Cu.name , UCASE(Cu.surname) AS surname, Cu.nif, R.*, Ca.brand, Ca.model, R.initial_date, R.final_date, DATEDIFF(R.final_date,R.initial_date)*R.price_per_day AS total_price
    FROM reservations AS R 
    INNER JOIN clients AS Cu ON Cu.client_id = R.client_id 
    INNER JOIN cars AS Ca ON Ca.car_id = R.car_id;
-- invoice view
    DROP VIEW IF EXISTS invoice_view;
    CREATE VIEW invoice_view AS
    SELECT Cu.name , Cu.surname, Cu.nif, R.*, Ca.brand, Ca.model 
    FROM reservation AS R 
    INNER JOIN client AS Cu ON Cu.client_id = R.client_id 
    INNER JOIN car AS Ca ON Ca.car_id = R.car_id;
-- total income per customer
    SELECT Cu.name, Cu.surname, SUM(subtotal) AS total_income
    FROM reservation_view AS R
    INNER JOIN client AS Cu ON Cu.client_id = R.client_id
    GROUP BY Cu.name, Cu.surname
    HAVING total_income > 100;
-- avaliable car per class in a given date span
    SELECT c.car_id, r.client_id
    FROM car_2 C 
    LEFT JOIN reservation R ON c.car_id = r.car_id
    WHERE r.date_in<= var_date_out AND r.date_out>= var_date_in AND r.client_id IS NULL
-- avaliable car per class in a given date span
    SELECT car_class, COUNT(car_id) AS Number_of_cars
    FROM car_2
    WHERE car_id NOT IN (SELECT car_id FROM reservation WHERE date_in<= var_date_out AND date_out >= var_date_in)
    GROUP BY car_class

-- Total income per year
    CREATE VIEW total_income_per_year AS
    SELECT YEAR(initial_date) AS year, SUM(DATEDIFF(final_date,initial_date)*price_per_day) AS total_income
    FROM reservation
    GROUP BY YEAR(initial_date)
    ORDER BY year ASC;
-- total income per quarter
    CREATE VIEW total_income_per_quarter AS
    SELECT CONCAT('Q', QUARTER(initial_date), YEAR(initial_date)) AS quarter, SUM(DATEDIFF(final_date,initial_date)*price_per_day) AS total_income
    FROM reservation
    GROUP BY YEAR(initial_date), QUARTER(initial_date)
    ORDER BY year ASC, quarter ASC;
-- total income per month
    CREATE VIEW total_income_per_month AS
    SELECT YEAR(initial_date) AS year, MONTHNAME(initial_date) AS month, SUM(DATEDIFF(final_date,initial_date)*price_per_day) AS total_income
    FROM reservation
    GROUP BY YEAR(initial_date), MONTHNAME(initial_date)
    ORDER BY year ASC, MONTH(initial_date) ASC;
-- total income per car
    CREATE VIEW total_income_per_car AS
    SELECT car_id, brand, model, SUM(DATEDIFF(final_date,initial_date)*price_per_day) AS total_income
    FROM reservation    
    GROUP BY car_id
    ORDER BY total_income DESC;
-- total days rented per car
    CREATE VIEW total_days_rented_per_car AS
    SELECT car_id, brand, model, SUM(DATEDIFF(final_date,initial_date)+1) AS total_days_rented
    FROM reservation
    GROUP BY car_id
    ORDER BY total_days_rented DESC;
