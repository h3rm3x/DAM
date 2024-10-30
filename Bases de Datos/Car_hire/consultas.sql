-- total days and price for each reservation
SELECT id_reservation, id_client, car_id, DATEDIFF(final_date,initial_date) AS total_days, DATEDIFF(final_date,initial_date)*price_per_day AS total_price
 FROM `reservation`;
 