-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 27, 2025 at 05:19 PM
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
  `age` int(11) DEFAULT NULL,
  `height` varchar(45) DEFAULT NULL,
  `weight` varchar(45) DEFAULT NULL,
  `race` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

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
-- Table structure for table `language`
--

CREATE TABLE `language` (
  `language_id` int(11) NOT NULL,
  `language_name` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

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

-- --------------------------------------------------------

--
-- Table structure for table `skill`
--

CREATE TABLE `skill` (
  `skill_id` int(11) NOT NULL,
  `skill_name` varchar(45) DEFAULT NULL,
  `description` varchar(200) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

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
-- Indexes for table `language`
--
ALTER TABLE `language`
  ADD PRIMARY KEY (`language_id`);

--
-- Indexes for table `movie`
--
ALTER TABLE `movie`
  ADD PRIMARY KEY (`movie_id`);

--
-- Indexes for table `skill`
--
ALTER TABLE `skill`
  ADD PRIMARY KEY (`skill_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `actors`
--
ALTER TABLE `actors`
  MODIFY `idActors` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `characters`
--
ALTER TABLE `characters`
  MODIFY `character_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `skill`
--
ALTER TABLE `skill`
  MODIFY `skill_id` int(11) NOT NULL AUTO_INCREMENT;

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
  ADD CONSTRAINT `language_fk` FOREIGN KEY (`language_id`) REFERENCES `language` (`language_id`);

--
-- Constraints for table `actor_skill`
--
ALTER TABLE `actor_skill`
  ADD CONSTRAINT `actor_fk` FOREIGN KEY (`actor_id`) REFERENCES `actors` (`idActors`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `skill_fk` FOREIGN KEY (`skill_id`) REFERENCES `skill` (`skill_id`);

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
  ADD CONSTRAINT `language_fk2` FOREIGN KEY (`language_id`) REFERENCES `language` (`language_id`);

--
-- Constraints for table `character_skill`
--
ALTER TABLE `character_skill`
  ADD CONSTRAINT `character_fk` FOREIGN KEY (`character_id`) REFERENCES `characters` (`character_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `skill_fk2` FOREIGN KEY (`skill_id`) REFERENCES `skill` (`skill_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
