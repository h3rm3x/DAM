-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 07, 2025 at 05:24 PM
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
-- Database: `hotel_db`
--

DELIMITER $$
--
-- Procedures
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `add_reservation` ()   BEGIN 
    DECLARE var_reservation_id INT;
    DECLARE var_room_number INT;
    DECLARE var_customer_id INT;
    DECLARE var_check_in DATE;
    DECLARE var_check_out DATE;
    DECLARE var_price_per_night INT;
    DECLARE var_number_of_guests INT;
    

    DECLARE i INT DEFAULT 0;
    DECLARE attempts INT DEFAULT 0;
    DECLARE max_attempts INT DEFAULT 100;

    WHILE (i < 10 AND attempts < max_attempts) DO
        SET attempts = attempts + 1;
        SET var_room_number = (SELECT room_number FROM room ORDER BY RAND() LIMIT 1);
        SET var_customer_id = (SELECT customer_id FROM customer ORDER BY RAND() LIMIT 1);
        SET var_check_in = DATE_ADD(CURDATE(), 
                                INTERVAL FLOOR(RAND() * DATEDIFF('2026-12-31', CURDATE())) DAY);
        SET var_check_out = (SELECT DATE_ADD(var_check_in, INTERVAL FLOOR(RAND() * 7) DAY));
        SET var_price_per_night = (SELECT price_per_night FROM category WHERE (SELECT category_id FROM room WHERE room_number = var_room_number) = category_id LIMIT 1);
        IF (SELECT category_id FROM room WHERE room_number = var_room_number) = 1 THEN
            SET var_number_of_guests = FLOOR(2+ RAND()*2);
        ELSE 
            SET var_number_of_guests = FLOOR(2+ RAND()*4);
        END IF;
        
        

        IF check_availability(var_room_number, var_check_in, var_check_out) THEN
            INSERT INTO reservation (room_number, customer_id, check_in, check_out, price_per_night, number_of_guests) VALUES (var_room_number, var_customer_id, var_check_in, var_check_out, var_price_per_night, var_number_of_guests);
            SET i = i + 1;
        END IF;
    END WHILE;
END$$

--
-- Functions
--
CREATE DEFINER=`root`@`localhost` FUNCTION `check_availability` (`var_room_number` INT, `var_check_in` DATE, `var_check_out` DATE) RETURNS TINYINT(1) DETERMINISTIC BEGIN
    DECLARE var_availability BOOLEAN;
    SET var_availability = TRUE;
    IF (SELECT COUNT(*) FROM reservation WHERE room_number = var_room_number AND check_in <= var_check_out AND check_out >= var_check_in) > 0 THEN
        SET var_availability = FALSE;
    END IF;
    RETURN var_availability;
END$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `category`
--

CREATE TABLE `category` (
  `category_id` int(11) NOT NULL,
  `category_name` varchar(50) NOT NULL,
  `price_per_night` decimal(6,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `category`
--

INSERT INTO `category` (`category_id`, `category_name`, `price_per_night`) VALUES
(1, 'studio', 100.00),
(2, 'standard', 120.00),
(3, 'seaview', 140.00),
(4, 'suite', 160.00);

-- --------------------------------------------------------

--
-- Table structure for table `common_areas`
--

CREATE TABLE `common_areas` (
  `name` varchar(50) NOT NULL,
  `common_area_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `common_areas`
--

INSERT INTO `common_areas` (`name`, `common_area_id`) VALUES
('Reception', 1),
('Buffet', 2),
('Employee dining room', 3),
('Pool', 4),
('Bar', 5);

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `customer_id` int(11) NOT NULL,
  `forename` varchar(20) NOT NULL,
  `surname` varchar(50) NOT NULL,
  `birthdate` date NOT NULL,
  `customer_level` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`customer_id`, `forename`, `surname`, `birthdate`, `customer_level`) VALUES
(1, 'John', 'Smith', '1985-06-15', 'Gold'),
(2, 'Maria', 'Garcia', '1990-03-22', 'Silver'),
(3, 'David', 'Chen', '1978-11-05', 'Platinum'),
(4, 'Sophie', 'Dubois', '1992-07-19', 'Gold'),
(5, 'Mohammed', 'Al-Fayez', '1980-02-28', 'Silver'),
(6, 'Emma', 'Johnson', '1995-09-12', 'Standard'),
(7, 'Akira', 'Tanaka', '1975-04-30', 'Platinum'),
(8, 'Isabella', 'Rossi', '1988-12-07', 'Gold'),
(9, 'Lars', 'Andersen', '1982-05-25', 'Standard'),
(10, 'Priya', 'Patel', '1993-10-17', 'Silver'),
(11, 'Carlos', 'Rodriguez', '1976-08-09', 'Gold'),
(12, 'Eva', 'Nowak', '1991-01-23', 'Standard'),
(13, 'Michael', 'Brown', '1983-04-11', 'Platinum'),
(14, 'Ana', 'Silva', '1989-07-29', 'Silver'),
(15, 'Ahmed', 'Hassan', '1979-11-14', 'Gold'),
(16, 'Olivia', 'Wilson', '1994-02-03', 'Standard'),
(17, 'Henrik', 'Svensson', '1986-05-22', 'Silver'),
(18, 'Fatima', 'Zahra', '1981-08-16', 'Gold'),
(19, 'James', 'Taylor', '1977-03-05', 'Platinum'),
(20, 'Elena', 'Petrova', '1990-12-29', 'Standard');

-- --------------------------------------------------------

--
-- Table structure for table `employee`
--

CREATE TABLE `employee` (
  `employee_id` int(11) NOT NULL,
  `position` varchar(50) NOT NULL,
  `birtdate` date NOT NULL,
  `forename` varchar(50) NOT NULL,
  `surname` varchar(50) NOT NULL,
  `direct_superior_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `employee`
--

INSERT INTO `employee` (`employee_id`, `position`, `birtdate`, `forename`, `surname`, `direct_superior_id`) VALUES
(1, 'General Manager', '1975-05-12', 'Robert', 'Anderson', 0),
(2, 'Assistant Manager', '1980-09-23', 'Jennifer', 'Martinez', 1),
(3, 'Front Office Manager', '1982-03-15', 'Michael', 'Chen', 1),
(4, 'Executive Housekeeper', '1978-11-20', 'Sarah', 'Johnson', 1),
(5, 'Food & Beverage Manager', '1976-07-08', 'Thomas', 'Garcia', 1),
(6, 'Front Desk Supervisor', '1985-02-14', 'Emily', 'Wilson', 3),
(7, 'Front Desk Agent', '1990-06-30', 'Daniel', 'Taylor', 6),
(8, 'Front Desk Agent', '1992-04-17', 'Olivia', 'Brown', 6),
(9, 'Front Desk Agent', '1988-08-25', 'David', 'Rodriguez', 6),
(10, 'Night Auditor', '1984-12-10', 'Sophia', 'Lee', 6),
(11, 'Housekeeping Supervisor', '1983-05-05', 'James', 'White', 4),
(12, 'Room Attendant', '1986-09-15', 'Isabella', 'Lopez', 11),
(13, 'Room Attendant', '1989-11-22', 'William', 'Harris', 11),
(14, 'Room Attendant', '1991-02-28', 'Mia', 'Clark', 11),
(15, 'Laundry Attendant', '1987-07-19', 'Alexander', 'Lewis', 11),
(16, 'Restaurant Supervisor', '1979-04-30', 'Emma', 'Walker', 5),
(17, 'Chef', '1977-10-15', 'Lucas', 'Martin', 5),
(18, 'Waiter', '1993-03-12', 'Ava', 'Thompson', 16),
(19, 'Waiter', '1994-08-24', 'Noah', 'Patel', 16),
(20, 'Bartender', '1990-01-05', 'Amelia', 'Nguyen', 16);

-- --------------------------------------------------------

--
-- Table structure for table `reservation`
--

CREATE TABLE `reservation` (
  `customer_id` int(11) NOT NULL,
  `reservation_id` int(11) NOT NULL,
  `room_number` int(11) NOT NULL,
  `check_in` date NOT NULL,
  `check_out` date NOT NULL,
  `price_per_night` int(11) NOT NULL,
  `number_of_guests` int(11) NOT NULL,
  `extras` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `reservation`
--

INSERT INTO `reservation` (`customer_id`, `reservation_id`, `room_number`, `check_in`, `check_out`, `price_per_night`, `number_of_guests`, `extras`) VALUES
(1, 1, 203, '2026-12-14', '2026-12-17', 120, 4, NULL),
(1, 12, 325, '2025-07-09', '2025-07-13', 140, 5, ''),
(1, 25, 201, '2025-12-18', '2025-12-18', 120, 3, NULL),
(1, 26, 320, '2026-02-12', '2026-02-18', 140, 5, NULL),
(3, 20, 105, '2025-04-27', '2025-05-01', 100, 3, ''),
(4, 16, 113, '2026-12-10', '2026-12-11', 100, 2, ''),
(4, 23, 302, '2026-03-14', '2026-03-17', 140, 5, NULL),
(4, 35, 206, '2026-12-06', '2026-12-07', 120, 2, NULL),
(5, 29, 110, '2025-04-10', '2025-04-12', 100, 3, NULL),
(6, 2, 107, '2026-04-27', '2026-05-01', 100, 3, ''),
(6, 33, 223, '2026-08-08', '2026-08-08', 120, 5, NULL),
(7, 31, 237, '2026-03-29', '2026-03-31', 120, 3, NULL),
(8, 27, 109, '2025-07-23', '2025-07-23', 100, 3, NULL),
(8, 40, 235, '2026-05-29', '2026-05-31', 120, 5, NULL),
(9, 3, 240, '2025-05-17', '2025-05-20', 120, 2, ''),
(9, 30, 211, '2026-01-10', '2026-01-16', 120, 2, NULL),
(11, 11, 301, '2026-03-05', '2026-03-05', 140, 5, ''),
(11, 18, 106, '2026-04-28', '2026-04-29', 100, 3, ''),
(12, 4, 227, '2025-04-09', '2025-04-13', 120, 2, ''),
(12, 5, 240, '2026-06-29', '2026-07-03', 120, 3, ''),
(12, 6, 315, '2025-04-22', '2025-04-26', 140, 5, ''),
(12, 37, 213, '2026-10-05', '2026-10-07', 120, 3, NULL),
(13, 15, 316, '2026-07-21', '2026-07-25', 140, 5, ''),
(14, 7, 115, '2025-04-17', '2025-04-17', 100, 3, ''),
(14, 28, 206, '2026-09-20', '2026-09-23', 120, 2, NULL),
(14, 36, 203, '2026-02-26', '2026-02-26', 120, 5, NULL),
(14, 39, 403, '2025-06-21', '2025-06-27', 160, 4, NULL),
(16, 13, 104, '2026-11-05', '2026-11-06', 100, 3, ''),
(16, 32, 309, '2025-07-03', '2025-07-05', 140, 4, NULL),
(16, 38, 316, '2026-05-03', '2026-05-04', 140, 4, NULL),
(17, 24, 323, '2025-11-06', '2025-11-06', 140, 4, NULL),
(18, 9, 317, '2025-06-08', '2025-06-14', 140, 2, ''),
(18, 10, 311, '2025-07-03', '2025-07-09', 140, 3, ''),
(18, 34, 407, '2026-04-28', '2026-05-02', 160, 3, NULL),
(19, 19, 210, '2026-09-22', '2026-09-23', 120, 5, ''),
(20, 8, 229, '2026-01-12', '2026-01-18', 120, 4, ''),
(20, 14, 233, '2026-02-22', '2026-02-25', 120, 5, ''),
(20, 17, 247, '2026-02-02', '2026-02-04', 120, 3, ''),
(20, 21, 242, '2025-09-08', '2025-09-08', 120, 3, NULL),
(20, 22, 321, '2026-04-15', '2026-04-19', 140, 2, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `room`
--

CREATE TABLE `room` (
  `room_number` int(11) NOT NULL,
  `bedrooms` int(11) NOT NULL,
  `category_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `room`
--

INSERT INTO `room` (`room_number`, `bedrooms`, `category_id`) VALUES
(101, 1, 1),
(102, 1, 1),
(103, 1, 1),
(104, 1, 1),
(105, 1, 1),
(106, 1, 1),
(107, 1, 1),
(108, 1, 1),
(109, 1, 1),
(110, 1, 1),
(111, 1, 1),
(112, 1, 1),
(113, 1, 1),
(114, 1, 1),
(115, 1, 1),
(201, 1, 2),
(202, 1, 2),
(203, 1, 2),
(204, 1, 2),
(205, 1, 2),
(206, 1, 2),
(207, 1, 2),
(208, 1, 2),
(209, 1, 2),
(210, 1, 2),
(211, 1, 2),
(212, 1, 2),
(213, 1, 2),
(214, 1, 2),
(215, 1, 2),
(216, 1, 2),
(217, 1, 2),
(218, 1, 2),
(219, 1, 2),
(220, 1, 2),
(221, 2, 2),
(222, 2, 2),
(223, 2, 2),
(224, 2, 2),
(225, 2, 2),
(226, 2, 2),
(227, 2, 2),
(228, 2, 2),
(229, 2, 2),
(230, 2, 2),
(231, 2, 2),
(232, 2, 2),
(233, 2, 2),
(234, 2, 2),
(235, 2, 2),
(236, 2, 2),
(237, 2, 2),
(238, 2, 2),
(239, 2, 2),
(240, 2, 2),
(241, 2, 2),
(242, 2, 2),
(243, 2, 2),
(244, 2, 2),
(245, 2, 2),
(246, 2, 2),
(247, 2, 2),
(248, 2, 2),
(249, 2, 2),
(250, 2, 2),
(301, 2, 3),
(302, 2, 3),
(303, 2, 3),
(304, 2, 3),
(305, 2, 3),
(306, 2, 3),
(307, 2, 3),
(308, 2, 3),
(309, 2, 3),
(310, 2, 3),
(311, 2, 3),
(312, 2, 3),
(313, 2, 3),
(314, 2, 3),
(315, 2, 3),
(316, 2, 3),
(317, 2, 3),
(318, 2, 3),
(319, 2, 3),
(320, 2, 3),
(321, 2, 3),
(322, 2, 3),
(323, 2, 3),
(324, 2, 3),
(325, 2, 3),
(401, 2, 4),
(402, 2, 4),
(403, 2, 4),
(404, 2, 4),
(405, 2, 4),
(406, 3, 4),
(407, 3, 4),
(408, 3, 4),
(409, 3, 4),
(410, 3, 4);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`category_id`);

--
-- Indexes for table `common_areas`
--
ALTER TABLE `common_areas`
  ADD PRIMARY KEY (`common_area_id`);

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`customer_id`);

--
-- Indexes for table `employee`
--
ALTER TABLE `employee`
  ADD PRIMARY KEY (`employee_id`);

--
-- Indexes for table `reservation`
--
ALTER TABLE `reservation`
  ADD PRIMARY KEY (`customer_id`,`reservation_id`,`room_number`),
  ADD UNIQUE KEY `reservation_id` (`reservation_id`),
  ADD KEY `room_number` (`room_number`);

--
-- Indexes for table `room`
--
ALTER TABLE `room`
  ADD PRIMARY KEY (`room_number`),
  ADD KEY `category_id` (`category_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `common_areas`
--
ALTER TABLE `common_areas`
  MODIFY `common_area_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `customer`
--
ALTER TABLE `customer`
  MODIFY `customer_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT for table `reservation`
--
ALTER TABLE `reservation`
  MODIFY `reservation_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=41;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `reservation`
--
ALTER TABLE `reservation`
  ADD CONSTRAINT `reservation_ibfk_1` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`customer_id`),
  ADD CONSTRAINT `reservation_ibfk_2` FOREIGN KEY (`room_number`) REFERENCES `room` (`room_number`);

--
-- Constraints for table `room`
--
ALTER TABLE `room`
  ADD CONSTRAINT `room_ibfk_1` FOREIGN KEY (`category_id`) REFERENCES `category` (`category_id`);

DELIMITER $$
--
-- Events
--
CREATE DEFINER=`root`@`localhost` EVENT `addReservations` ON SCHEDULE EVERY 1 SECOND STARTS '2025-04-07 16:56:15' ENDS '2025-04-07 17:50:15' ON COMPLETION PRESERVE DISABLE DO CALL add_reservation()$$

DELIMITER ;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
