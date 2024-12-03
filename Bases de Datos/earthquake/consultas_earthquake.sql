-- day of week where the highest maginutude earthquakes happened
SELECT occurred_on, DAYOFWEEK(occurred_on), magnitude
 FROM `earthquake_details` 
 WHERE magnitude = (SELECT MAX(magnitude) FROM earthquake_details)
 ---  avg earthquakes that happened on every weekday rounded
SELECT ROUND(AVG(magnitude), 2), DAYOFWEEK(occurred_on) 
FROM earthquake_details 
WHERE DAYOFWEEK(occurred_on) = 6 OR DAYOFWEEK(occurred_on)=7 OR DAYOFWEEK(occurred_on)= 5 OR DAYOFWEEK(occurred_on)=4 OR DAYOFWEEK(occurred_on)=3 OR DAYOFWEEK(occurred_on)=2 OR DAYOFWEEK(occurred_on)=1 
GROUP BY DAYOFWEEK(occurred_on);
-- number of earthquakes that happend on every weekday
SELECT 
    DAYNAME(STR_TO_DATE(occurred_on, '%Y-%m-%d %H:%i:%s')) AS day_of_week,
    COUNT(*) AS earthquake_count
FROM 
    earthquake_details
GROUP BY 
    day_of_week
ORDER BY 
    WEEKDAY(STR_TO_DATE(occurred_on, '%Y-%m-%d %H:%i:%s'));