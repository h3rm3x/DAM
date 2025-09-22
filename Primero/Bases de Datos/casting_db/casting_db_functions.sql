-- casting procedure
DELIMITER $$
CREATE PROCEDURE casting(IN var_movie_id INT, IN var_character_id INT)
BEGIN
    DECLARE var_height INT;
    DECLARE var_race VARCHAR(45);
    DECLARE var_weight INT;
    DECLARE var_gender VARCHAR(45);
    DECLARE var_casting_date DATETIME;
    SET var_casting_date = NOW();
    
    -- Get character's physical traits
    SELECT height, weight, race, gender INTO var_height, var_weight, var_race, var_gender
    FROM characters
    WHERE character_id = var_character_id;

    -- Insert into casting table
    INSERT INTO casting (movie_id, character_id, actor_id, casting_date)
    SELECT 
        var_movie_id,
        var_character_id,
        a.actor_id,
        var_casting_date
    FROM actors a
    WHERE a.height BETWEEN var_height-5 AND var_height+5 
    AND a.weight BETWEEN var_weight-10 AND var_weight+10
    AND a.race = var_race 
    AND a.gender = var_gender
    AND skill_compatibility(a.actor_id,var_character_id, var_movie_id) >= 75 ;
    
    -- Printing results on screen
	SELECT *
	FROM casting_view
	WHERE casting_date = var_casting_date;
END$$
DELIMITER ;

-- get actor's skill compatibility with character 
DELIMITER $$
CREATE FUNCTION skill_compatibility(actor_id INT, character_id INT, movie_id INT) RETURNS INT
BEGIN
    DECLARE number_of_skills INT;
    SELECT COUNT(ASK.skill_id) INTO number_of_skills
    FROM actor_skill ASK 
    INNER JOIN character_skill CSK ON ASK.skill_id = CSK.skill_id 
    WHERE actor_id = var_actor_id AND var_character_id = CSK.character_id;
    RETURN number_of_skills;
END$$
DELIMITER ;
-- get the amount of skills that the actor has in common with the character
DELIMITER $$
CREATE FUNCTION skill_compatibility(actor_id INT, character_id INT, movie_id INT) RETURNS INT
BEGIN
    DECLARE number_of_skills INT;
    SELECT COUNT(ASK.skill_id) INTO number_of_skills
    FROM actor_skill ASK 
    INNER JOIN character_skill CSK ON ASK.skill_id = CSK.skill_id 
    WHERE actor_id = var_actor_id AND var_character_id = CSK.character_id;
    RETURN number_of_skills;
END$$
DELIMITER ;
-- get the amount of skills that the character has
DELIMITER $$
CREATE FUNCTION get_character_skills(var_character_id INT, var_movie_id INT) RETURNS INT
BEGIN
DECLARE number_of_skills INT;
SELECT count(CSK.skill_id) INTO number_of_skills
FROM character_skill CSK
JOIN characters C on CSK.character_id = C.character_id
WHERE CSK.character_id = var_character_id AND C.movie_id = var_movie_id;
RETURN number_of_skills;
END$$
DELIMITER ;
