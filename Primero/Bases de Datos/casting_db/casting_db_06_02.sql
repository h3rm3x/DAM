-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 06, 2025 at 06:56 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `casting_db`
--

DELIMITER $$
--
-- Procedures
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `casting` (IN `var_character_id` INT, IN `var_movie_id` INT)   BEGIN
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
    AND a.gender = var_gender;
    
    -- Printing results on screen
	SELECT *
	FROM casting
	WHERE casting_date = var_casting_date;



    
END$$

--
-- Functions
--
CREATE DEFINER=`root`@`localhost` FUNCTION `actor_skill` (`var_actor_id` INT) RETURNS INT(11) DETERMINISTIC BEGIN
DECLARE number_of_skills INT;
SELECT COUNT(ASK.skill_id)  INTO number_of_skills
FROM actor_skill ASK INNER JOIN character_skill CSK on ASK.skill_id  = CSK.skill_id WHERE actor_id = var_actor_id AND C.character_id = CSK.character_id ;
RETURN number_of_skills;
END$$

CREATE DEFINER=`root`@`localhost` FUNCTION `character_skills` (`var_character_id` INT) RETURNS INT(11) DETERMINISTIC BEGIN
DECLARE number_of_skills INT;
SELECT count(CSK.skill_id) INTO number_of_skills
FROM character_skill CSK 
WHERE character_id = var_character_id;
RETURN number_of_skills;
END$$

CREATE DEFINER=`root`@`localhost` FUNCTION `skill_compatibility` (`var_actor_id` INT, `var_character_id` INT, `var_movie_id` INT) RETURNS INT(11) DETERMINISTIC BEGIN
DECLARE skill_percentage INT;
SET skill_percentage = ROUND(actor_skill(var_actor_id)/character_skill(var_charcater_id, var_movie_id)*100,0)  ;

RETURN skill_percentage;
END$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `acting`
--

CREATE TABLE `acting` (
  `movie_id` int(11) NOT NULL,
  `character_id` int(11) NOT NULL,
  `actor_id` int(11) DEFAULT NULL,
  `agreed_salary` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `actors`
--

CREATE TABLE `actors` (
  `actor_id` int(11) NOT NULL,
  `actor_name` varchar(45) DEFAULT NULL,
  `birthdate` date DEFAULT NULL,
  `height` int(45) DEFAULT NULL,
  `weight` int(45) DEFAULT NULL,
  `race` varchar(45) DEFAULT NULL,
  `gender` set('male','female','non-binary') DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `actors`
--

INSERT INTO `actors` (`actor_id`, `actor_name`, `birthdate`, `height`, `weight`, `race`, `gender`) VALUES
(1, 'Leonardo DiCaprio', '1974-11-11', 183, 75, 'Caucasian', 'male'),
(2, 'Brad Pitt', '1963-12-18', 180, 78, 'Caucasian', 'male'),
(3, 'Angelina Jolie', '1975-06-04', 169, 55, 'Caucasian', 'female'),
(4, 'Tom Cruise', '1962-07-03', 170, 68, 'Caucasian', 'male'),
(5, 'Scarlett Johansson', '1984-11-22', 160, 57, 'Caucasian', 'female'),
(6, 'Robert Downey Jr.', '1965-04-04', 174, 78, 'Caucasian', 'male'),
(7, 'Chris Hemsworth', '1983-08-11', 190, 91, 'Caucasian', 'male'),
(8, 'Jennifer Lawrence', '1990-08-15', 175, 63, 'Caucasian', 'female'),
(9, 'Johnny Depp', '1963-06-09', 178, 72, 'Caucasian', 'male'),
(10, 'Natalie Portman', '1981-06-09', 160, 52, 'Caucasian', 'male'),
(11, 'Ryan Reynolds', '1976-10-23', 188, 84, 'Caucasian', 'male'),
(12, 'Emma Watson', '1990-04-15', 165, 50, 'Caucasian', 'male'),
(13, 'Dwayne Johnson', '1972-05-02', 196, 118, 'Mixed', 'male'),
(14, 'Keanu Reeves', '1964-09-02', 186, 79, 'Mixed', 'male'),
(15, 'Tom Hanks', '1956-07-09', 183, 82, 'Caucasian', 'male'),
(16, 'Margot Robbie', '1990-07-02', 168, 57, 'Caucasian', 'female'),
(17, 'Will Smith', '1968-09-25', 188, 82, 'African American', 'male'),
(18, 'Gal Gadot', '1985-04-30', 178, 58, 'Middle Eastern', 'female'),
(19, 'Benedict Cumberbatch', '1976-07-19', 183, 78, 'Caucasian', 'male'),
(20, 'Anne Hathaway', '1982-11-12', 173, 56, 'Caucasian', 'female'),
(21, 'Keanu Reeves', '1964-09-02', 186, 79, 'Mixed', 'male'),
(22, 'Russell Crowe', '1964-04-07', 182, 85, 'Caucasian', 'male'),
(23, 'Elijah Wood', '1981-01-28', 168, 64, 'Caucasian', 'male'),
(24, 'Viggo Mortensen', '1958-10-20', 180, 77, 'Caucasian', 'male'),
(25, 'Orlando Bloom', '1977-01-13', 180, 77, 'Caucasian', 'male'),
(26, 'Hugo Weaving', '1960-04-04', 188, 82, 'Caucasian', 'male'),
(27, 'Liv Tyler', '1977-07-01', 178, 57, 'Caucasian', 'female'),
(28, 'Cate Blanchett', '1969-05-14', 174, 56, 'Caucasian', 'female');

-- --------------------------------------------------------

--
-- Table structure for table `actor_language`
--

CREATE TABLE `actor_language` (
  `actor_id` int(11) NOT NULL,
  `language_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `actor_skill`
--

CREATE TABLE `actor_skill` (
  `actor_id` int(11) NOT NULL,
  `skill_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `actor_skill`
--

INSERT INTO `actor_skill` (`actor_id`, `skill_id`) VALUES
(1, 4),
(1, 13),
(1, 20),
(2, 2),
(2, 7),
(2, 13),
(4, 1),
(4, 2),
(4, 5),
(4, 6),
(5, 2),
(5, 3),
(5, 4),
(7, 2),
(7, 11),
(7, 13),
(8, 2),
(8, 8),
(8, 10),
(12, 3),
(12, 4),
(12, 13),
(13, 2),
(13, 5),
(13, 7),
(13, 9),
(21, 2),
(21, 7),
(22, 2),
(22, 5),
(23, 8),
(23, 9),
(24, 2),
(24, 11),
(25, 11),
(25, 13),
(26, 2),
(26, 7),
(27, 4),
(27, 13),
(28, 4),
(28, 13);

-- --------------------------------------------------------

--
-- Table structure for table `casting`
--

CREATE TABLE `casting` (
  `movie_id` int(11) NOT NULL,
  `actor_id` int(11) NOT NULL,
  `character_id` int(11) NOT NULL,
  `casting_date` datetime DEFAULT NULL,
  `mark_comment` varchar(45) DEFAULT NULL,
  `casting_position` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `casting`
--

INSERT INTO `casting` (`movie_id`, `actor_id`, `character_id`, `casting_date`, `mark_comment`, `casting_position`) VALUES
(12, 3, 5, '2025-02-05 20:36:01', NULL, NULL),
(12, 5, 5, '2025-02-05 20:36:01', NULL, NULL),
(12, 16, 5, '2025-02-05 20:36:01', NULL, NULL);

-- --------------------------------------------------------

--
-- Stand-in structure for view `casting_view`
-- (See below for the actual view)
--
CREATE TABLE `casting_view` (
`movie_id` int(11)
,`movie_name` varchar(45)
,`character_id` int(11)
,`character_name` varchar(45)
,`actor_id` int(11)
,`actor_name` varchar(45)
,`casting_date` datetime
,`mark_comment` varchar(45)
,`casting_position` varchar(45)
,`actor_skills` int(11)
,`character_skills` int(11)
,`skill_compatibility` int(11)
);

-- --------------------------------------------------------

--
-- Table structure for table `characters`
--

CREATE TABLE `characters` (
  `character_id` int(11) NOT NULL,
  `character_name` varchar(45) DEFAULT NULL,
  `movie_id` int(11) NOT NULL,
  `height` int(11) DEFAULT NULL,
  `race` varchar(45) DEFAULT NULL,
  `role` set('Leading','Supporting','Extra') DEFAULT NULL,
  `gender` set('Male','Female','Non-binary') DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `weight` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `characters`
--

INSERT INTO `characters` (`character_id`, `character_name`, `movie_id`, `height`, `race`, `role`, `gender`, `age`, `weight`) VALUES
(1, 'Dom Cobb', 2, 183, 'Caucasian', 'Leading', 'Male', 35, 75),
(2, 'The Joker', 10, 178, 'Caucasian', 'Leading', 'Male', 34, 70),
(3, 'Tony Stark / Iron Man', 9, 174, 'Caucasian', 'Leading', 'Male', 48, 78),
(4, 'Mark Zuckerberg', 11, 170, 'Caucasian', 'Leading', 'Male', 26, 68),
(5, 'Mia Dolan', 12, 165, 'Caucasian', 'Leading', 'Female', 28, 55),
(6, 'T\'Challa / Black Panther', 13, 183, 'African', 'Leading', 'Male', 32, 82),
(7, 'Jordan Belfort', 14, 180, 'Caucasian', 'Leading', 'Male', 31, 78),
(8, 'Cooper', 15, 183, 'Caucasian', 'Leading', 'Male', 40, 82),
(9, 'Imperator Furiosa', 16, 175, 'Caucasian', 'Leading', 'Female', 35, 60),
(10, 'Harvey Dent / Two-Face', 11, 183, 'Caucasian', 'Supporting', 'Male', 40, 75),
(11, 'Neo', 17, 186, 'Mixed', 'Leading', 'Male', 35, 79),
(12, 'Maximus', 18, 182, 'Caucasian', 'Leading', 'Male', 40, 85),
(13, 'Frodo Baggins', 19, 168, 'Caucasian', 'Leading', 'Male', 33, 64),
(14, 'Aragorn', 20, 180, 'Caucasian', 'Leading', 'Male', 87, 77),
(15, 'Legolas', 20, 180, 'Caucasian', 'Supporting', 'Male', 2931, 77),
(16, 'Elrond', 19, 188, 'Caucasian', 'Supporting', 'Male', 6000, 82),
(17, 'Arwen', 19, 178, 'Caucasian', 'Supporting', 'Female', 2778, 57),
(18, 'Galadriel', 19, 174, 'Caucasian', 'Supporting', 'Female', 8372, 56);

-- --------------------------------------------------------

--
-- Table structure for table `character_language`
--

CREATE TABLE `character_language` (
  `character_id` int(11) NOT NULL,
  `language_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `character_skill`
--

CREATE TABLE `character_skill` (
  `character_id` int(11) NOT NULL,
  `skill_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `character_skill`
--

INSERT INTO `character_skill` (`character_id`, `skill_id`) VALUES
(1, 5),
(1, 9),
(2, 2),
(2, 6),
(2, 7),
(3, 4),
(3, 7),
(3, 10),
(4, 10),
(5, 3),
(5, 4),
(5, 7),
(6, 2),
(6, 5),
(6, 11),
(7, 20),
(8, 1),
(8, 4),
(8, 14),
(9, 4),
(9, 6),
(9, 7),
(11, 2),
(11, 7),
(12, 2),
(12, 5),
(13, 8),
(13, 9),
(14, 2),
(14, 11),
(15, 11),
(15, 13),
(16, 2),
(16, 7),
(17, 4),
(17, 13),
(18, 4),
(18, 13);

-- --------------------------------------------------------

--
-- Table structure for table `genres`
--

CREATE TABLE `genres` (
  `genre_id` int(11) NOT NULL,
  `genre_name` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `genres`
--

INSERT INTO `genres` (`genre_id`, `genre_name`) VALUES
(1, 'Action'),
(2, 'Comedy'),
(3, 'Sci-fi'),
(4, 'Fantasy'),
(5, 'Drama'),
(6, 'Thriller'),
(7, 'Horror'),
(8, 'Western'),
(9, 'Musical'),
(10, 'Documentary'),
(11, 'Adventure'),
(12, 'Romance'),
(13, 'RomCom'),
(14, 'War'),
(15, 'BioPic');

-- --------------------------------------------------------

--
-- Table structure for table `languages`
--

CREATE TABLE `languages` (
  `language_id` int(11) NOT NULL,
  `language_name` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `languages`
--

INSERT INTO `languages` (`language_id`, `language_name`) VALUES
(1, 'English'),
(2, 'Spanish'),
(3, 'German'),
(4, 'Italian'),
(5, 'Portuguese'),
(6, 'French');

-- --------------------------------------------------------

--
-- Table structure for table `movie`
--

CREATE TABLE `movie` (
  `movie_id` int(11) NOT NULL,
  `movie_name` varchar(45) DEFAULT NULL,
  `director` varchar(45) DEFAULT NULL,
  `release_date` date DEFAULT NULL,
  `studio` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `movie`
--

INSERT INTO `movie` (`movie_id`, `movie_name`, `director`, `release_date`, `studio`) VALUES
(1, 'Tenet', 'Christopher', '2020-08-26', 'Warner Bros'),
(2, 'Inception', 'Christopher Nolan', '2010-07-09', 'Warner Bros'),
(3, 'Tenet', 'Christopher', '2020-08-26', 'Warner Bros'),
(4, 'Everything Everywhere All at Once', 'Daniel Kwan & Daniel Scheinert', '2022-03-11', 'A24'),
(5, 'Uncut Gems', 'John & Benny Safdie', '2019-12-25', 'A24'),
(6, 'Django Unchained', 'Quentin Tarantino', '2015-12-25', 'Columbia Pictures'),
(7, 'The Lord of the Rings: The Fellowship of the ', 'Peter Jackson', '2001-12-10', 'New Line Cinema'),
(8, 'The Dark Knight', 'Christopher Nolan', '2008-07-18', 'Warner Bros.'),
(9, 'Avengers: Endgame', 'Anthony Russo, Joe Russo', '2019-04-26', 'Marvel Studios'),
(10, 'Joker', 'Todd Phillips', '2019-10-04', 'Warner Bros.'),
(11, 'The Social Network', 'David Fincher', '2010-10-01', 'Columbia Pictures'),
(12, 'La La Land', 'Damien Chazelle', '2016-12-09', 'Summit Entertainment'),
(13, 'Black Panther', 'Ryan Coogler', '2018-02-16', 'Marvel Studios'),
(14, 'The Wolf of Wall Street', 'Martin Scorsese', '2013-12-25', 'Paramount Pictures'),
(15, 'Interstellar', 'Christopher Nolan', '2014-11-07', 'Paramount Pictures'),
(16, 'Mad Max: Fury Road', 'George Miller', '2015-05-15', 'Warner Bros.'),
(17, 'The Matrix', 'Lana Wachowski, Lilly Wachowski', '1999-03-31', 'Warner Bros.'),
(18, 'Gladiator', 'Ridley Scott', '2000-05-05', 'DreamWorks Pictures'),
(19, 'The Lord of the Rings: The Two Towers', 'Peter Jackson', '2002-12-18', 'New Line Cinema'),
(20, 'The Lord of the Rings: The Return of the King', 'Peter Jackson', '2003-12-17', 'New Line Cinema');

-- --------------------------------------------------------

--
-- Table structure for table `movie_genre`
--

CREATE TABLE `movie_genre` (
  `movie_id` int(11) NOT NULL,
  `genre_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `movie_genre`
--

INSERT INTO `movie_genre` (`movie_id`, `genre_id`) VALUES
(6, 1),
(6, 5),
(9, 1),
(9, 3);

-- --------------------------------------------------------

--
-- Table structure for table `skills`
--

CREATE TABLE `skills` (
  `skill_id` int(11) NOT NULL,
  `skill_name` varchar(45) DEFAULT NULL,
  `description` varchar(200) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `skills`
--

INSERT INTO `skills` (`skill_id`, `skill_name`, `description`) VALUES
(1, 'Skydiving', 'Ability to jump from an airplane and manage the parachute safely'),
(2, 'Martial Arts', 'Training in hand-to-hand combat techniques'),
(3, 'Singing', 'Ability to perform vocally in musical settings'),
(4, 'Dancing', 'Skill in various dance styles'),
(5, 'Stunt Performance', 'Performing dangerous scenes safely'),
(6, 'Mototrbike Riding', 'Ability to ride a motorbike properly'),
(7, 'Combat', 'Ability to handle firearms properly'),
(8, 'Swim', 'ability to swim for extended periods of time'),
(9, 'Basketball', 'Able to shoot a basketball properly and score in a consistent level'),
(10, 'Archery', 'Ability to manage a bow and arch and shoot with it on target'),
(11, 'Sword Fighting', 'Proficiency in handling swords and melee weapons'),
(12, 'Acrobatics', 'Ability to perform complex gymnastic movements'),
(13, 'Horse Riding', 'Skilled in mounting and riding horses'),
(14, 'Car Racing', 'Professional level driving skills'),
(15, 'Parkour', 'Urban movement and obstacle navigation'),
(16, 'Quick Draw', 'Fast and accurate weapon drawing'),
(17, 'Piano Playing', 'Ability to play piano professionally'),
(18, 'Military Tactics', 'Understanding of military strategy and combat'),
(19, 'Wall Climbing', 'Ability to scale walls and climb efficiently'),
(20, 'public speaking', 'Ability to give very convincing speeches and or presentations in public');

-- --------------------------------------------------------

--
-- Structure for view `casting_view`
--
DROP TABLE IF EXISTS `casting_view`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `casting_view`  AS SELECT `c`.`movie_id` AS `movie_id`, `m`.`movie_name` AS `movie_name`, `c`.`character_id` AS `character_id`, `ch`.`character_name` AS `character_name`, `c`.`actor_id` AS `actor_id`, `a`.`actor_name` AS `actor_name`, `c`.`casting_date` AS `casting_date`, `c`.`mark_comment` AS `mark_comment`, `c`.`casting_position` AS `casting_position`, `ACTOR_SKILL`(`c`.`actor_id`) AS `actor_skills`, `CHARACTER_SKILLS`(`c`.`character_id`,`c`.`movie_id`) AS `character_skills`, `SKILL_COMPATIBILITY`(`c`.`actor_id`,`c`.`character_id`,`c`.`movie_id`) AS `skill_compatibility` FROM (((`casting` `c` join `movie` `m` on(`m`.`movie_id` = `c`.`movie_id`)) join `actors` `a` on(`a`.`actor_id` = `c`.`actor_id`)) join `characters` `ch` on(`ch`.`character_id` = `c`.`character_id`)) ;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `acting`
--
ALTER TABLE `acting`
  ADD PRIMARY KEY (`movie_id`,`character_id`),
  ADD KEY `actor_id` (`actor_id`);

--
-- Indexes for table `actors`
--
ALTER TABLE `actors`
  ADD PRIMARY KEY (`actor_id`);

--
-- Indexes for table `actor_language`
--
ALTER TABLE `actor_language`
  ADD PRIMARY KEY (`actor_id`,`language_id`),
  ADD KEY `language_fk` (`language_id`);

--
-- Indexes for table `actor_skill`
--
ALTER TABLE `actor_skill`
  ADD PRIMARY KEY (`actor_id`,`skill_id`),
  ADD KEY `skill_fk` (`skill_id`);

--
-- Indexes for table `casting`
--
ALTER TABLE `casting`
  ADD PRIMARY KEY (`movie_id`,`actor_id`,`character_id`),
  ADD KEY `character_id` (`character_id`),
  ADD KEY `actor_id` (`actor_id`);

--
-- Indexes for table `characters`
--
ALTER TABLE `characters`
  ADD PRIMARY KEY (`character_id`),
  ADD KEY `movie_id` (`movie_id`);

--
-- Indexes for table `character_language`
--
ALTER TABLE `character_language`
  ADD PRIMARY KEY (`character_id`,`language_id`),
  ADD KEY `language_fk2` (`language_id`);

--
-- Indexes for table `character_skill`
--
ALTER TABLE `character_skill`
  ADD PRIMARY KEY (`character_id`,`skill_id`),
  ADD KEY `skill_fk2` (`skill_id`);

--
-- Indexes for table `genres`
--
ALTER TABLE `genres`
  ADD PRIMARY KEY (`genre_id`);

--
-- Indexes for table `languages`
--
ALTER TABLE `languages`
  ADD PRIMARY KEY (`language_id`);

--
-- Indexes for table `movie`
--
ALTER TABLE `movie`
  ADD PRIMARY KEY (`movie_id`);

--
-- Indexes for table `movie_genre`
--
ALTER TABLE `movie_genre`
  ADD PRIMARY KEY (`movie_id`,`genre_id`),
  ADD KEY `movie_genre_fk_2` (`genre_id`);

--
-- Indexes for table `skills`
--
ALTER TABLE `skills`
  ADD PRIMARY KEY (`skill_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `actors`
--
ALTER TABLE `actors`
  MODIFY `actor_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=29;

--
-- AUTO_INCREMENT for table `characters`
--
ALTER TABLE `characters`
  MODIFY `character_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- AUTO_INCREMENT for table `genres`
--
ALTER TABLE `genres`
  MODIFY `genre_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT for table `movie`
--
ALTER TABLE `movie`
  MODIFY `movie_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=103;

--
-- AUTO_INCREMENT for table `skills`
--
ALTER TABLE `skills`
  MODIFY `skill_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `acting`
--
ALTER TABLE `acting`
  ADD CONSTRAINT `acting_ibfk_1` FOREIGN KEY (`actor_id`) REFERENCES `actors` (`actor_id`);

--
-- Constraints for table `actor_language`
--
ALTER TABLE `actor_language`
  ADD CONSTRAINT `actor_language_fk` FOREIGN KEY (`actor_id`) REFERENCES `actors` (`actor_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `language_fk` FOREIGN KEY (`language_id`) REFERENCES `languages` (`language_id`);

--
-- Constraints for table `actor_skill`
--
ALTER TABLE `actor_skill`
  ADD CONSTRAINT `actor_fk` FOREIGN KEY (`actor_id`) REFERENCES `actors` (`actor_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `skill_fk` FOREIGN KEY (`skill_id`) REFERENCES `skills` (`skill_id`);

--
-- Constraints for table `casting`
--
ALTER TABLE `casting`
  ADD CONSTRAINT `casting_ibfk_1` FOREIGN KEY (`character_id`) REFERENCES `characters` (`character_id`),
  ADD CONSTRAINT `casting_ibfk_2` FOREIGN KEY (`movie_id`) REFERENCES `movie` (`movie_id`),
  ADD CONSTRAINT `casting_ibfk_3` FOREIGN KEY (`actor_id`) REFERENCES `actors` (`actor_id`);

--
-- Constraints for table `characters`
--
ALTER TABLE `characters`
  ADD CONSTRAINT `characters_ibfk_1` FOREIGN KEY (`movie_id`) REFERENCES `movie` (`movie_id`);

--
-- Constraints for table `character_language`
--
ALTER TABLE `character_language`
  ADD CONSTRAINT `char_character_foreign_key` FOREIGN KEY (`character_id`) REFERENCES `characters` (`character_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `language_fk2` FOREIGN KEY (`language_id`) REFERENCES `languages` (`language_id`);

--
-- Constraints for table `character_skill`
--
ALTER TABLE `character_skill`
  ADD CONSTRAINT `character_fk` FOREIGN KEY (`character_id`) REFERENCES `characters` (`character_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `character_id_fk_2` FOREIGN KEY (`character_id`) REFERENCES `characters` (`character_id`),
  ADD CONSTRAINT `skill_fk2` FOREIGN KEY (`skill_id`) REFERENCES `skills` (`skill_id`);

--
-- Constraints for table `movie_genre`
--
ALTER TABLE `movie_genre`
  ADD CONSTRAINT `movie_genre_fk_1` FOREIGN KEY (`movie_id`) REFERENCES `movie` (`movie_id`),
  ADD CONSTRAINT `movie_genre_fk_2` FOREIGN KEY (`genre_id`) REFERENCES `genres` (`genre_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
