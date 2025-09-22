-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 05, 2025 at 08:05 PM
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
CREATE DEFINER=`root`@`localhost` PROCEDURE `casting` (IN `var_movie_id` INT, IN `var_character_id` INT)   BEGIN
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
    INNER JOIN actor_skill ask ON a.actor_id = ask.actor_id
    INNER JOIN character_skill cs ON cs.skill_id = ask.skill_id
    WHERE cs.character_id = var_character_id
    AND a.height BETWEEN var_height-5 AND var_height+5 
    AND a.weight BETWEEN var_weight-5 AND var_weight+5 
    AND a.race = var_race 
    AND a.gender = var_gender;
    
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
  `Name` varchar(45) DEFAULT NULL,
  `birthdate` date DEFAULT NULL,
  `height` int(45) DEFAULT NULL,
  `weight` int(45) DEFAULT NULL,
  `race` varchar(45) DEFAULT NULL,
  `gender` set('male','female','non-binary') DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `actors`
--

INSERT INTO `actors` (`actor_id`, `Name`, `birthdate`, `height`, `weight`, `race`, `gender`) VALUES
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
(21, 2), -- Keanu Reeves: Martial Arts
(21, 7), -- Keanu Reeves: Combat
(22, 2), -- Russell Crowe: Martial Arts
(22, 5), -- Russell Crowe: Stunt Performance
(23, 8), -- Elijah Wood: Swim
(23, 9), -- Elijah Wood: Basketball
(24, 2), -- Viggo Mortensen: Martial Arts
(24, 11), -- Viggo Mortensen: Sword Fighting
(25, 11), -- Orlando Bloom: Sword Fighting
(25, 13), -- Orlando Bloom: Horse Riding
(26, 2), -- Hugo Weaving: Martial Arts
(26, 7), -- Hugo Weaving: Combat
(27, 4), -- Liv Tyler: Dancing
(27, 13), -- Liv Tyler: Horse Riding
(28, 4), -- Cate Blanchett: Dancing
(28, 13); -- Cate Blanchett: Horse Riding

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

-- --------------------------------------------------------

--
-- Table structure for table `characters`
--

CREATE TABLE `characters` (
  `character_id` int(11) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
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

INSERT INTO `characters` (`character_id`, `name`, `movie_id`, `height`, `race`, `role`, `gender`, `age`, `weight`) VALUES
(1, 'Dom Cobb', 2, 183, 'Caucasian', 'Leading', 'Male', 35, 75),
(2, 'The Joker', 10, 178, 'Caucasian', 'Leading', 'Male', 34, 70),
(3, 'Tony Stark / Iron Man', 9, 174, 'Caucasian', 'Leading', 'Male', 48, 78),
(4, 'Mark Zuckerberg', 11, 170, 'Caucasian', 'Leading', 'Male', 26, 68),
(5, 'Mia Dolan', 12, 165, 'Caucasian', 'Leading', 'Female', 28, 55),
(6, 'T\Challa / Black Panther', 13, 183, 'African', 'Leading', 'Male', 32, 82),
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
(11, 2), -- Neo: Martial Arts
(11, 7), -- Neo: Combat
(12, 2), -- Maximus: Martial Arts
(12, 5), -- Maximus: Stunt Performance
(13, 8), -- Frodo Baggins: Swim
(13, 9), -- Frodo Baggins: Basketball
(14, 2), -- Aragorn: Martial Arts
(14, 11), -- Aragorn: Sword Fighting
(15, 11), -- Legolas: Sword Fighting
(15, 13), -- Legolas: Horse Riding
(16, 2), -- Elrond: Martial Arts
(16, 7), -- Elrond: Combat
(17, 4), -- Arwen: Dancing
(17, 13), -- Arwen: Horse Riding
(18, 4), -- Galadriel: Dancing
(18, 13); -- Galadriel: Horse Riding

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
(7, 'Horror');

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
  `name` varchar(45) DEFAULT NULL,
  `director` varchar(45) DEFAULT NULL,
  `release_date` date DEFAULT NULL,
  `studio` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `movie`
--

INSERT INTO `movie` (`movie_id`, `name`, `director`, `release_date`, `studio`) VALUES
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
  MODIFY `genre_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `movie`
--
ALTER TABLE `movie`
  MODIFY `movie_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

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
