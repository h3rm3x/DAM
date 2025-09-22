SELECT C.*,
(SELECT COUNT(skill_id) FROM actor_skill ASK INNER JOIN character_skill CSK on ASK.skill_id  = CSK.skill_id WHERE actor_id = C.actor_id ) AS actor_skills, 
(SELECT count(skill_id) FROM actor_skill WHERE character_id = C.character_id) AS character_skills,
ROUND((actor_skills/character_skills)*100, 0)