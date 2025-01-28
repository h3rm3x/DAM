-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 28, 2025 at 07:43 PM
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
  `idActors` int(11) NOT NULL,
  `Name` varchar(45) DEFAULT NULL,
  `birthdate` date DEFAULT NULL,
  `height` varchar(45) DEFAULT NULL,
  `weight` varchar(45) DEFAULT NULL,
  `race` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `actors`
--

INSERT INTO `actors` (`idActors`, `Name`, `birthdate`, `height`, `weight`, `race`) VALUES
(1, 'Leonardo DiCaprio', '1974-11-11', '183 cm', '75 kg', 'Caucasian'),
(2, 'Brad Pitt', '1963-12-18', '180 cm', '78 kg', 'Caucasian'),
(3, 'Angelina Jolie', '1975-06-04', '169 cm', '55 kg', 'Caucasian'),
(4, 'Tom Cruise', '1962-07-03', '170 cm', '68 kg', 'Caucasian'),
(5, 'Scarlett Johansson', '1984-11-22', '160 cm', '57 kg', 'Caucasian'),
(6, 'Robert Downey Jr.', '1965-04-04', '174 cm', '78 kg', 'Caucasian'),
(7, 'Chris Hemsworth', '1983-08-11', '190 cm', '91 kg', 'Caucasian'),
(8, 'Jennifer Lawrence', '1990-08-15', '175 cm', '63 kg', 'Caucasian'),
(9, 'Johnny Depp', '1963-06-09', '178 cm', '72 kg', 'Caucasian'),
(10, 'Natalie Portman', '1981-06-09', '160 cm', '52 kg', 'Caucasian'),
(11, 'Ryan Reynolds', '1976-10-23', '188 cm', '84 kg', 'Caucasian'),
(12, 'Emma Watson', '1990-04-15', '165 cm', '50 kg', 'Caucasian'),
(13, 'Dwayne Johnson', '1972-05-02', '196 cm', '118 kg', 'Mixed'),
(14, 'Keanu Reeves', '1964-09-02', '186 cm', '79 kg', 'Mixed'),
(15, 'Tom Hanks', '1956-07-09', '183 cm', '82 kg', 'Caucasian'),
(16, 'Margot Robbie', '1990-07-02', '168 cm', '57 kg', 'Caucasian'),
(17, 'Will Smith', '1968-09-25', '188 cm', '82 kg', 'African American'),
(18, 'Gal Gadot', '1985-04-30', '178 cm', '58 kg', 'Middle Eastern'),
(19, 'Benedict Cumberbatch', '1976-07-19', '183 cm', '78 kg', 'Caucasian'),
(20, 'Anne Hathaway', '1982-11-12', '173 cm', '56 kg', 'Caucasian');

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
(3, 'Avengers Endgame', 'Anthony & Joe Russo', '2019-04-26', 'Marvel Studios'),
(4, 'Tenet', 'Christopher', '2020-08-26', 'Warner Bros'),
(5, 'Inception', 'Christopher Nolan', '2010-07-09', 'Warner Bros'),
(6, 'Avengers Endgame', 'Anthony & Joe Russo', '2019-04-26', 'Marvel'),
(7, 'Everything Everywhere All at Once', 'Daniel Kwan & Daniel Scheinert', '2022-03-11', 'A24'),
(8, 'Uncut Gems', 'John & Benny Safdie', '2019-12-25', 'A24'),
(9, 'Django Unchained', 'Quentin Tarantino', '2015-12-25', 'Columbia Pictures'),
(10, 'The Lord of the Rings: The Fellowship of the ', 'Peter Jackson', '2001-12-10', 'New Line Cinema');

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
(10, 'Archery', 'Ability to manage a bow and arch and shoot with it on target');

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
  ADD PRIMARY KEY (`idActors`);

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
  MODIFY `idActors` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT for table `characters`
--
ALTER TABLE `characters`
  MODIFY `character_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `genres`
--
ALTER TABLE `genres`
  MODIFY `genre_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `movie`
--
ALTER TABLE `movie`
  MODIFY `movie_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `skills`
--
ALTER TABLE `skills`
  MODIFY `skill_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `acting`
--
ALTER TABLE `acting`
  ADD CONSTRAINT `acting_ibfk_1` FOREIGN KEY (`actor_id`) REFERENCES `actors` (`idActors`);

--
-- Constraints for table `actor_language`
--
ALTER TABLE `actor_language`
  ADD CONSTRAINT `actor_language_fk` FOREIGN KEY (`actor_id`) REFERENCES `actors` (`idActors`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `language_fk` FOREIGN KEY (`language_id`) REFERENCES `languages` (`language_id`);

--
-- Constraints for table `actor_skill`
--
ALTER TABLE `actor_skill`
  ADD CONSTRAINT `actor_fk` FOREIGN KEY (`actor_id`) REFERENCES `actors` (`idActors`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `skill_fk` FOREIGN KEY (`skill_id`) REFERENCES `skills` (`skill_id`);

--
-- Constraints for table `casting`
--
ALTER TABLE `casting`
  ADD CONSTRAINT `casting_ibfk_1` FOREIGN KEY (`character_id`) REFERENCES `characters` (`character_id`),
  ADD CONSTRAINT `casting_ibfk_2` FOREIGN KEY (`movie_id`) REFERENCES `movie` (`movie_id`),
  ADD CONSTRAINT `casting_ibfk_3` FOREIGN KEY (`actor_id`) REFERENCES `actors` (`idActors`);

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
  ADD CONSTRAINT `skill_fk2` FOREIGN KEY (`skill_id`) REFERENCES `skills` (`skill_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
