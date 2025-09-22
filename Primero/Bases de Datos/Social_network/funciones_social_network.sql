CREATE PROCEDURE generate_posts()
BEGIN
    DECLARE var_post_id INT;
    DECLARE var_user_id INT;
    DECLARE var_post_content VARCHAR(255);

    DECLARE i INT DEFAULT 0;
    DECLARE attempts INT DEFAULT 0;
    DECLARE max_attempts INT DEFAULT 100;


    



