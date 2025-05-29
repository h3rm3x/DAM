-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 28, 2025 at 09:14 PM
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
-- Database: `public_library`
--

DELIMITER $$
--
-- Functions
--
CREATE DEFINER=`root`@`localhost` FUNCTION `read_time` (`var_number_of_pages` INT) RETURNS INT(11)  BEGIN
    DECLARE var_read_time INT;
    SET var_read_time = var_number_of_pages/30; -- Assuming it takes 1 hour to read 30 pages
    RETURN var_read_time;
END$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `books`
--

CREATE TABLE `books` (
  `ISBN` varchar(255) NOT NULL,
  `title` varchar(255) NOT NULL,
  `author` varchar(255) NOT NULL,
  `editorial` varchar(255) NOT NULL,
  `number_of_pages` int(11) NOT NULL,
  `edition` int(11) NOT NULL,
  `genre` varchar(255) NOT NULL,
  `year_released` int(11) NOT NULL,
  `availiability` set('on_site','off_site','','') NOT NULL,
  `JSON_extra_info` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `books`
--

INSERT INTO `books` (`ISBN`, `title`, `author`, `editorial`, `number_of_pages`, `edition`, `genre`, `year_released`, `availiability`, `JSON_extra_info`) VALUES
('9780345391803', 'The Silence of the Lambs', 'Thomas Harris', 'St. Martin\'s Press', 352, 1, 'Thriller', 1988, 'on_site', NULL),
('9780385265706', 'A Brief History of Time', 'Stephen Hawking', 'Bantam Dell Publishing Group', 256, 1, 'Science', 1988, 'on_site', NULL),
('9780385265751', 'The Firm', 'John Grisham', 'Doubleday', 421, 1, 'Legal Thriller', 1991, 'on_site', NULL),
('9780385265775', 'The Pelican Brief', 'John Grisham', 'Doubleday', 421, 1, 'Legal Thriller', 1992, 'on_site', NULL),
('9780385265782', 'The Client', 'John Grisham', 'Doubleday', 422, 1, 'Legal Thriller', 1993, 'on_site', NULL),
('9780385265799', 'The Chamber', 'John Grisham', 'Doubleday', 676, 1, 'Legal Thriller', 1994, 'on_site', NULL),
('9780385265806', 'The Rainmaker', 'John Grisham', 'Doubleday', 598, 1, 'Legal Thriller', 1995, 'on_site', NULL),
('9780385265813', 'The Runaway Jury', 'John Grisham', 'Doubleday', 355, 1, 'Legal Thriller', 1996, 'on_site', NULL),
('9780385265820', 'The Partner', 'John Grisham', 'Doubleday', 355, 1, 'Legal Thriller', 1997, 'on_site', NULL),
('9780385265837', 'The Street Lawyer', 'John Grisham', 'Doubleday', 355, 1, 'Legal Thriller', 1998, 'on_site', NULL),
('9780385265844', 'The Testament', 'John Grisham', 'Doubleday', 355, 1, 'Legal Thriller', 1999, 'on_site', NULL),
('9780385265851', 'The Brethren', 'John Grisham', 'Doubleday', 366, 1, 'Legal Thriller', 2000, 'on_site', NULL),
('9780385265868', 'A Painted House', 'John Grisham', 'Doubleday', 388, 1, 'Literary Fiction', 2001, 'on_site', NULL),
('9780385265875', 'The Summons', 'John Grisham', 'Doubleday', 355, 1, 'Legal Thriller', 2002, 'on_site', NULL),
('9780385265899', 'Bleachers', 'John Grisham', 'Doubleday', 163, 1, 'Literary Fiction', 2004, 'on_site', NULL),
('9780385265906', 'The Broker', 'John Grisham', 'Doubleday', 357, 1, 'Legal Thriller', 2005, 'on_site', NULL),
('9780385265913', 'Playing for Pizza', 'John Grisham', 'Doubleday', 278, 1, 'Sports Fiction', 2007, 'on_site', NULL),
('9780385265920', 'The Appeal', 'John Grisham', 'Doubleday', 355, 1, 'Legal Thriller', 2008, 'on_site', NULL),
('9780385265937', 'The Associate', 'John Grisham', 'Doubleday', 355, 1, 'Legal Thriller', 2009, 'on_site', NULL),
('9780385265944', 'The Confession', 'John Grisham', 'Doubleday', 418, 1, 'Legal Thriller', 2010, 'on_site', NULL),
('9780385265951', 'The Litigators', 'John Grisham', 'Doubleday', 352, 1, 'Legal Thriller', 2011, 'on_site', NULL),
('9780385265968', 'The Racketeer', 'John Grisham', 'Doubleday', 352, 1, 'Legal Thriller', 2012, 'on_site', NULL),
('9780385265975', 'Sycamore Row', 'John Grisham', 'Doubleday', 418, 1, 'Legal Thriller', 2013, 'on_site', NULL),
('9780385265982', 'Gray Mountain', 'John Grisham', 'Doubleday', 356, 1, 'Legal Thriller', 2014, 'on_site', NULL),
('9780385265999', 'Rogue Lawyer', 'John Grisham', 'Doubleday', 352, 1, 'Legal Thriller', 2015, 'on_site', NULL),
('9780385266006', 'The Whistler', 'John Grisham', 'Doubleday', 352, 1, 'Legal Thriller', 2016, 'on_site', NULL),
('9780385266013', 'The Rooster Bar', 'John Grisham', 'Doubleday', 352, 1, 'Legal Thriller', 2017, 'on_site', NULL),
('9780385266020', 'The Reckoning', 'John Grisham', 'Doubleday', 420, 1, 'Historical Fiction', 2018, 'on_site', NULL),
('9780385266037', 'The Guardians', 'John Grisham', 'Doubleday', 352, 1, 'Legal Thriller', 2019, 'on_site', NULL),
('9780385266044', 'Camino Winds', 'John Grisham', 'Doubleday', 309, 1, 'Mystery', 2020, 'on_site', NULL),
('9780385266051', 'A Time for Mercy', 'John Grisham', 'Doubleday', 480, 1, 'Legal Thriller', 2020, 'on_site', NULL),
('9780385266068', 'The Judge\'s List', 'John Grisham', 'Doubleday', 352, 1, 'Legal Thriller', 2021, 'on_site', NULL),
('9780385266075', 'The Boys from Biloxi', 'John Grisham', 'Doubleday', 448, 1, 'Crime Fiction', 2022, 'on_site', NULL),
('9780385266082', 'Sparring Partners', 'John Grisham', 'Doubleday', 352, 1, 'Legal Thriller', 2022, 'on_site', NULL),
('9780385266099', 'The Exchange', 'John Grisham', 'Doubleday', 352, 1, 'Legal Thriller', 2023, 'on_site', NULL),
('9780385319959', 'The Joy Luck Club', 'Amy Tan', 'G.P. Putnam\'s Sons', 288, 1, 'Literary Fiction', 1989, 'on_site', NULL),
('9780385319966', 'Jurassic Park', 'Michael Crichton', 'Alfred A. Knopf', 399, 1, 'Science Fiction', 1990, 'on_site', NULL),
('9780385319973', 'Rising Sun', 'Michael Crichton', 'Alfred A. Knopf', 385, 1, 'Thriller', 1992, 'on_site', NULL),
('9780385319980', 'Disclosure', 'Michael Crichton', 'Alfred A. Knopf', 597, 1, 'Thriller', 1994, 'on_site', NULL),
('9780385319997', 'The Celestine Prophecy', 'James Redfield', 'Warner Books', 247, 1, 'Spiritual Fiction', 1993, 'on_site', NULL),
('9780385320004', 'The Horse Whisperer', 'Nicholas Evans', 'Delacorte Press', 451, 1, 'Drama', 1995, 'on_site', NULL),
('9780385320011', 'Primary Colors', 'Anonymous', 'Random House', 366, 1, 'Political Satire', 1996, 'on_site', NULL),
('9780385320028', 'Cold Mountain', 'Charles Frazier', 'Atlantic Monthly Press', 356, 1, 'Historical Fiction', 1997, 'on_site', NULL),
('9780385320035', 'Memoirs of a Geisha', 'Arthur Golden', 'Alfred A. Knopf', 503, 1, 'Historical Fiction', 1997, 'on_site', NULL),
('9780385320042', 'Tuesdays with Morrie', 'Mitch Albom', 'Doubleday', 192, 1, 'Memoir', 1997, 'on_site', NULL),
('9780385320059', 'The Beach', 'Alex Garland', 'Viking Press', 436, 1, 'Adventure', 1996, 'on_site', NULL),
('9780385320066', 'The Lovely Bones', 'Alice Sebold', 'Little, Brown and Company', 328, 1, 'Literary Fiction', 2002, 'on_site', NULL),
('9780385320073', 'Life of Pi', 'Yann Martel', 'Knopf Canada', 319, 1, 'Adventure', 2001, 'on_site', NULL),
('9780385320080', 'The Kite Runner', 'Khaled Hosseini', 'Riverhead Books', 371, 1, 'Literary Fiction', 2003, 'on_site', NULL),
('9780385320097', 'The Da Vinci Code', 'Dan Brown', 'Doubleday', 454, 1, 'Mystery Thriller', 2003, 'on_site', NULL),
('9780385320103', 'The Time Traveler\'s Wife', 'Audrey Niffenegger', 'MacAdam/Cage', 518, 1, 'Romance', 2003, 'on_site', NULL),
('9780385320110', 'A Thousand Splendid Suns', 'Khaled Hosseini', 'Riverhead Books', 372, 1, 'Literary Fiction', 2007, 'on_site', NULL),
('9780385320127', 'The Book Thief', 'Markus Zusak', 'Knopf Books for Young Readers', 552, 1, 'Historical Fiction', 2005, 'on_site', NULL),
('9780385320134', 'Water for Elephants', 'Sara Gruen', 'Algonquin Books', 331, 1, 'Historical Fiction', 2006, 'on_site', NULL),
('9780385320141', 'The Girl with the Dragon Tattoo', 'Stieg Larsson', 'Norstedts Förlag', 465, 1, 'Crime Thriller', 2005, 'on_site', NULL),
('9780385320158', 'The Help', 'Kathryn Stockett', 'Amy Einhorn Books', 444, 1, 'Historical Fiction', 2009, 'on_site', NULL),
('9780385320165', 'Gone Girl', 'Gillian Flynn', 'Crown Publishers', 419, 1, 'Psychological Thriller', 2012, 'on_site', NULL),
('9780385320172', 'Fifty Shades of Grey', 'E.L. James', 'Vintage Books', 514, 1, 'Erotic Romance', 2011, 'on_site', NULL),
('9780385320189', 'The Fault in Our Stars', 'John Green', 'Dutton Books', 313, 1, 'Young Adult', 2012, 'on_site', NULL),
('9780385320196', 'The Goldfinch', 'Donna Tartt', 'Little, Brown and Company', 771, 1, 'Literary Fiction', 2013, 'on_site', NULL),
('9780385320202', 'All the Light We Cannot See', 'Anthony Doerr', 'Scribner', 531, 1, 'Historical Fiction', 2014, 'on_site', NULL),
('9780385320219', 'Where the Crawdads Sing', 'Delia Owens', 'G.P. Putnam\'s Sons', 370, 1, 'Mystery', 2018, 'on_site', NULL),
('9780385320226', 'Educated', 'Tara Westover', 'Random House', 334, 1, 'Memoir', 2018, 'on_site', NULL),
('9780385320233', 'Becoming', 'Michelle Obama', 'Crown Publishing', 448, 1, 'Memoir', 2018, 'on_site', NULL),
('9780385320240', 'Little Fires Everywhere', 'Celeste Ng', 'Penguin Press', 338, 1, 'Literary Fiction', 2017, 'on_site', NULL),
('9780385320257', 'The Seven Husbands of Evelyn Hugo', 'Taylor Jenkins Reid', 'Atria Books', 400, 1, 'Historical Fiction', 2017, 'on_site', NULL),
('9780385320264', 'The Midnight Library', 'Matt Haig', 'Canongate Books', 288, 1, 'Literary Fiction', 2020, 'on_site', NULL),
('9780385320271', 'Klara and the Sun', 'Kazuo Ishiguro', 'Knopf', 303, 1, 'Literary Fiction', 2021, 'on_site', NULL),
('9780385320288', 'The Thursday Murder Club', 'Richard Osman', 'Viking', 368, 1, 'Mystery', 2020, 'on_site', NULL),
('9780385320295', 'Project Hail Mary', 'Andy Weir', 'Ballantine Books', 496, 1, 'Science Fiction', 2021, 'on_site', NULL),
('9780385320301', 'It Ends with Us', 'Colleen Hoover', 'Atria Books', 384, 1, 'Romance', 2016, 'on_site', NULL),
('9780385320318', 'The Song of Achilles', 'Madeline Miller', 'Ecco', 352, 1, 'Historical Fiction', 2011, 'on_site', NULL),
('9780385320325', 'Normal People', 'Sally Rooney', 'Faber & Faber', 266, 1, 'Literary Fiction', 2018, 'on_site', NULL),
('9780385320332', 'The Silent Patient', 'Alex Michaelides', 'Celadon Books', 336, 1, 'Psychological Thriller', 2019, 'on_site', NULL),
('9780385320349', 'Circe', 'Madeline Miller', 'Little, Brown and Company', 393, 1, 'Mythology', 2018, 'on_site', NULL),
('9780385320356', 'The Invisible Bridge', 'Julie Orringer', 'Knopf', 602, 1, 'Historical Fiction', 2010, 'on_site', NULL),
('9780385320363', 'The Nightingale', 'Kristin Hannah', 'St. Martin\'s Press', 440, 1, 'Historical Fiction', 2015, 'on_site', NULL),
('9780385320370', 'Eleanor Oliphant Is Completely Fine', 'Gail Honeyman', 'HarperCollins', 327, 1, 'Literary Fiction', 2017, 'on_site', NULL),
('9780385320387', 'Big Little Lies', 'Liane Moriarty', 'Amy Einhorn Books', 460, 1, 'Mystery', 2014, 'on_site', NULL),
('9780385320394', 'The Alchemist', 'Paulo Coelho', 'HarperCollins', 163, 1, 'Philosophical Fiction', 1988, 'on_site', NULL),
('9780385320400', 'The Hunger Games', 'Suzanne Collins', 'Scholastic Press', 374, 1, 'Dystopian Fiction', 2008, 'on_site', NULL),
('9780385320417', 'Catching Fire', 'Suzanne Collins', 'Scholastic Press', 391, 1, 'Dystopian Fiction', 2009, 'on_site', NULL),
('9780385320424', 'Mockingjay', 'Suzanne Collins', 'Scholastic Press', 390, 1, 'Dystopian Fiction', 2010, 'on_site', NULL),
('9780385320431', 'The Girl on the Train', 'Paula Hawkins', 'Riverhead Books', 325, 1, 'Psychological Thriller', 2015, 'on_site', NULL),
('9780385320448', 'Twilight', 'Stephenie Meyer', 'Little, Brown and Company', 498, 1, 'Paranormal Romance', 2005, 'on_site', NULL),
('9780385320455', 'The Martian', 'Andy Weir', 'Crown Publishers', 369, 1, 'Science Fiction', 2011, 'on_site', NULL),
('9780385321000', 'A Short History of Nearly Everything', 'Bill Bryson', 'Broadway Books', 0, 1, 'Science', 2003, 'on_site', '{}'),
('9780385321001', 'Notes from a Small Island', 'Bill Bryson', 'William Morrow', 0, 1, 'Travel', 1995, 'on_site', '{}'),
('9780385321003', 'A Walk in the Woods', 'Bill Bryson', 'Broadway Books', 0, 1, 'Travel Memoir', 1998, 'on_site', '{}'),
('9780385472579', 'The Handmaid\'s Tale', 'Margaret Atwood', 'McClelland & Stewart', 311, 1, 'Dystopian Fiction', 1985, 'on_site', NULL),
('9780439064866', 'Harry Potter and the Chamber of Secrets', 'J.K. Rowling', 'Bloomsbury', 251, 1, 'Fantasy', 1998, 'on_site', NULL),
('9780439136365', 'Harry Potter and the Prisoner of Azkaban', 'J.K. Rowling', 'Bloomsbury', 317, 1, 'Fantasy', 1999, 'on_site', NULL),
('9780439139595', 'Harry Potter and the Philosopher\'s Stone', 'J.K. Rowling', 'Bloomsbury', 223, 1, 'Fantasy', 1997, 'on_site', NULL),
('9780439139601', 'Harry Potter and the Goblet of Fire', 'J.K. Rowling', 'Bloomsbury', 636, 1, 'Fantasy', 2000, 'on_site', NULL),
('9780439358071', 'Harry Potter and the Order of the Phoenix', 'J.K. Rowling', 'Bloomsbury', 766, 1, 'Fantasy', 2003, 'on_site', NULL),
('9780439784542', 'Harry Potter and the Half-Blood Prince', 'J.K. Rowling', 'Bloomsbury', 607, 1, 'Fantasy', 2005, 'on_site', NULL),
('9780446310789', 'It', 'Stephen King', 'Viking Press', 1138, 1, 'Horror', 1986, 'on_site', NULL),
('9780545010221', 'Harry Potter and the Deathly Hallows', 'J.K. Rowling', 'Bloomsbury', 607, 1, 'Fantasy', 2007, 'on_site', NULL),
('9780553283686', 'Beloved', 'Toni Morrison', 'Alfred A. Knopf', 324, 1, 'Historical Fiction', 1987, 'on_site', NULL),
('9780553296983', 'Interview with the Vampire', 'Anne Rice', 'Alfred A. Knopf', 371, 1, 'Gothic Fiction', 1976, 'on_site', NULL),
('9780553574487', 'The Bridges of Madison County', 'Robert James Waller', 'Warner Books', 171, 1, 'Romance', 1992, 'on_site', NULL),
('9780670825240', 'The Bonfire of the Vanities', 'Tom Wolfe', 'Farrar, Straus and Giroux', 659, 1, 'Satire', 1987, 'on_site', NULL),
('9780670835270', 'Goodfellas', 'Nicholas Pileggi', 'Simon & Schuster', 384, 1, 'True Crime', 1985, 'on_site', NULL),
('9780679722766', 'The Secret History', 'Donna Tartt', 'Alfred A. Knopf', 559, 1, 'Literary Fiction', 1992, 'on_site', NULL),
('9780679735774', 'All the Pretty Horses', 'Cormac McCarthy', 'Alfred A. Knopf', 301, 1, 'Western', 1992, 'on_site', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `customers`
--

CREATE TABLE `customers` (
  `forename` varchar(255) NOT NULL,
  `surname` varchar(255) NOT NULL,
  `NIE` varchar(9) NOT NULL,
  `phone_number` varchar(12) NOT NULL,
  `birth_date` date NOT NULL,
  `email` varchar(255) NOT NULL,
  `red_flag` tinyint(1) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `customers`
--

INSERT INTO `customers` (`forename`, `surname`, `NIE`, `phone_number`, `birth_date`, `email`, `red_flag`) VALUES
('Alberto', 'Vega', 'X0123456J', '602345687', '1993-08-09', 'alberto.vega@example.com', 0),
('Laura', 'Gómez', 'X1234567A', '612345678', '1990-05-12', 'laura.gomez@example.com', 0),
('Sofía', 'Blanco', 'X3456789M', '632345690', '1989-07-13', 'sofia.blanco@example.com', 0),
('David', 'López', 'X4567890D', '642345681', '1988-07-25', 'david.lopez@example.com', 0),
('Lucía', 'Romero', 'X7890123G', '672345684', '1997-09-22', 'lucia.romero@example.com', 0),
('Paula', 'Castro', 'Y1234567K', '612345688', '1998-04-16', 'paula.castro@example.com', 0),
('Carlos', 'Fernández', 'Y2345678B', '622345679', '1985-10-03', 'carlos.fernandez@example.com', 0),
('Hugo', 'Gil', 'Y4567890N', '642345691', '1994-05-21', 'hugo.gil@example.com', 0),
('Ana', 'Martínez', 'Y5678901E', '652345682', '1995-01-30', 'ana.martinez@example.com', 0),
('Miguel', 'Ortega', 'Y8901234H', '682345685', '1991-06-05', 'miguel.ortega@example.com', 0),
('Diego', 'Morales', 'Z2345678L', '622345689', '1990-02-02', 'diego.morales@example.com', 0),
('María', 'Ruiz', 'Z3456789C', '632345680', '1992-03-18', 'maria.ruiz@example.com', 0),
('Clara', 'Reyes', 'Z5678901O', '652345692', '1987-11-29', 'clara.reyes@example.com', 1),
('Javier', 'Sánchez', 'Z6789012F', '662345683', '1983-11-11', 'javier.sanchez@example.com', 1),
('Elena', 'Navas', 'Z9012345I', '692345686', '1986-12-14', 'elena.navas@example.com', 1);

-- --------------------------------------------------------

--
-- Table structure for table `reservations`
--

CREATE TABLE `reservations` (
  `reservation_id` int(11) NOT NULL,
  `book_ISBN` varchar(255) NOT NULL,
  `customer_NIE` varchar(255) NOT NULL,
  `date_in` date NOT NULL,
  `date_out` date NOT NULL,
  `returned_late` tinyint(1) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `reservations`
--

INSERT INTO `reservations` (`reservation_id`, `book_ISBN`, `customer_NIE`, `date_in`, `date_out`, `returned_late`) VALUES
(41, '9780385265706', 'X1234567A', '2025-05-01', '2025-05-08', 0),
(42, '9780385265751', 'Y2345678B', '2025-05-02', '2025-05-09', 0),
(43, '9780385265775', 'Z3456789C', '2025-05-03', '2025-05-10', 1),
(44, '9780385265782', 'X4567890D', '2025-05-04', '2025-05-11', 0),
(45, '9780385265799', 'Y5678901E', '2025-05-05', '2025-05-12', 0),
(46, '9780385265806', 'Z6789012F', '2025-05-06', '2025-05-13', 0),
(47, '9780385265813', 'X7890123G', '2025-05-07', '2025-05-14', 1),
(48, '9780385265820', 'Y8901234H', '2025-05-08', '2025-05-15', 0),
(49, '9780385265837', 'Z9012345I', '2025-05-09', '2025-05-16', 0),
(50, '9780385265844', 'X0123456J', '2025-05-10', '2025-05-17', 0),
(51, '9780385265851', 'Y1234567K', '2025-05-11', '2025-05-18', 1),
(52, '9780385265868', 'Z2345678L', '2025-05-12', '2025-05-19', 0),
(53, '9780385265875', 'X3456789M', '2025-05-13', '2025-05-20', 0),
(54, '9780385265899', 'Y4567890N', '2025-05-14', '2025-05-21', 0),
(55, '9780385265906', 'Z5678901O', '2025-05-15', '2025-05-22', 1),
(56, '9780385265913', 'X1234567A', '2025-05-16', '2025-05-23', 0),
(57, '9780385265920', 'Y2345678B', '2025-05-17', '2025-05-24', 0),
(58, '9780385265937', 'Z3456789C', '2025-05-18', '2025-05-25', 0),
(59, '9780385265944', 'X4567890D', '2025-05-19', '2025-05-26', 0),
(60, '9780385265951', 'Y5678901E', '2025-05-20', '2025-05-27', 1);

-- --------------------------------------------------------

--
-- Stand-in structure for view `view_times_borrowed`
-- (See below for the actual view)
--
CREATE TABLE `view_times_borrowed` (
`ISBN` varchar(255)
,`title` varchar(255)
,`author` varchar(255)
,`editorial` varchar(255)
,`number_of_pages` int(11)
,`edition` int(11)
,`genre` varchar(255)
,`year_released` int(11)
,`availiability` set('on_site','off_site','','')
,`JSON_extra_info` longtext
,`times_borrowed` bigint(21)
);

-- --------------------------------------------------------

--
-- Structure for view `view_times_borrowed`
--
DROP TABLE IF EXISTS `view_times_borrowed`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `view_times_borrowed`  AS SELECT `b`.`ISBN` AS `ISBN`, `b`.`title` AS `title`, `b`.`author` AS `author`, `b`.`editorial` AS `editorial`, `b`.`number_of_pages` AS `number_of_pages`, `b`.`edition` AS `edition`, `b`.`genre` AS `genre`, `b`.`year_released` AS `year_released`, `b`.`availiability` AS `availiability`, `b`.`JSON_extra_info` AS `JSON_extra_info`, count(`r`.`reservation_id`) AS `times_borrowed` FROM (`books` `b` join `reservations` `r` on(`r`.`book_ISBN` = `b`.`ISBN`)) GROUP BY `b`.`ISBN` ;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `books`
--
ALTER TABLE `books`
  ADD PRIMARY KEY (`ISBN`);

--
-- Indexes for table `customers`
--
ALTER TABLE `customers`
  ADD PRIMARY KEY (`NIE`);

--
-- Indexes for table `reservations`
--
ALTER TABLE `reservations`
  ADD PRIMARY KEY (`reservation_id`),
  ADD KEY `book_ISBN` (`book_ISBN`),
  ADD KEY `customer_NIE` (`customer_NIE`) USING BTREE;

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `reservations`
--
ALTER TABLE `reservations`
  MODIFY `reservation_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=61;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `reservations`
--
ALTER TABLE `reservations`
  ADD CONSTRAINT `reservations_ibfk_1` FOREIGN KEY (`book_ISBN`) REFERENCES `books` (`ISBN`),
  ADD CONSTRAINT `reservations_ibfk_2` FOREIGN KEY (`customer_NIE`) REFERENCES `customers` (`NIE`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
