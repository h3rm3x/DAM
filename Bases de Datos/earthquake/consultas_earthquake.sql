-- day of week where the highest maginutude earthquakes happened
SELECT occurred_on, DAYOFWEEK(occurred_on), magnitude
 FROM `earthquake_details` 
 WHERE magnitude = (SELECT MAX(magnitude) FROM earthquake_details)