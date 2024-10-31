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