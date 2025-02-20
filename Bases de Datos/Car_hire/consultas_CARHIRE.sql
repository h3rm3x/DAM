-- total days and price for each reservation
SELECT id_reservation, id_client, car_id, DATEDIFF(final_date,initial_date)+1 AS total_days, DATEDIFF(final_date,initial_date)*price_per_day AS total_price
 FROM `reservation`
ORDER BY id_client ASC;
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
    INNER JOIN clients AS Cu ON Cu.id_client = R.id_client
    INNER JOIN cars AS Ca ON Ca.car_id = R.car_id;
-- invoices for all reservations w/ Forename in uppercase
    SELECT Cu.name , UCASE(Cu.surname), Cu.nif, R.*, Ca.brand, Ca.model 
    FROM reservations AS R 
    INNER JOIN clients AS Cu ON Cu.id_client = R.id_client 
    INNER JOIN cars AS Ca ON Ca.car_id = R.car_id;
-- invoices for all reservations w/ Forename in uppercase and total price
    SELECT Cu.name , UCASE(Cu.surname), Cu.nif, R.*, Ca.brand, Ca.model, DATEDIFF(R.final_date,R.initial_date)*R.price_per_day AS total_price
    FROM reservations AS R 
    INNER JOIN clients AS Cu ON Cu.id_client = R.id_client 
    INNER JOIN cars AS Ca ON Ca.car_id = R.car_id;
-- invoice view
    DROP VIEW IF EXISTS invoice_view;
    CREATE VIEW invoice_view AS
    SELECT Cu.name , Cu.surname, Cu.nif, R.*, Ca.brand, Ca.model 
    FROM reservation AS R 
    INNER JOIN client AS Cu ON Cu.id_client = R.id_client 
    INNER JOIN car AS Ca ON Ca.car_id = R.car_id;
--  reservation view
    DROP VIEW IF EXISTS reservation_view;
    CREATE VIEW reservation_view AS
    SELECT Cu.name , Cu.surname, Cu.nif ,DATEDIFF(R.final_date,R.initial_date) AS total_days, subtotal(DATEDIFF(R.final_date,R.initial_date), R.price_per_day) AS subtotal, Ca.brand, Ca.model
    FROM reservation AS R
    INNER JOIN client AS Cu ON Cu.id_client = R.id_client
    INNER JOIN car AS Ca ON Ca.car_id = R.car_id;
-- total income per customer
    SELECT Cu.name, Cu.surname, SUM(subtotal) AS total_income
    FROM reservation_view AS R
    INNER JOIN client AS Cu ON Cu.id_client = R.id_client
    GROUP BY Cu.name, Cu.surname
    HAVING total_income > 100;
-- avaliable car per class in a given date span
    SELECT c.car_id, r.id_client
    FROM car_2 C 
    LEFT JOIN reservation R ON c.car_id = r.car_id
    WHERE r.date_in<= var_date_out AND r.date_out>= var_date_in AND r.id_client IS NULL
-- avaliable car per class in a given date span
    SELECT car_class, COUNT(car_id) AS Number_of_cars
    FROM car_2
    WHERE car_id NOT IN (SELECT car_id FROM reservation WHERE date_in<= var_date_out AND date_out >= var_date_in)
    GROUP BY car_class

        
