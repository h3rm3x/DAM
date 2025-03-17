-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 17, 2025 at 05:24 PM
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
-- Database: `carhire`
--

DELIMITER $$
--
-- Procedures
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `avaliable_cars_per_class` (IN `var_date_in` DATE, IN `var_date_out` DATE)   SELECT car_class, COUNT(car_id) AS Number_of_cars
FROM car_2
WHERE car_id NOT IN (SELECT car_id FROM reservation WHERE initial_date<= var_date_out AND final_date >= var_date_in)
GROUP BY car_class$$

--
-- Functions
--
CREATE DEFINER=`Alan`@`localhost` FUNCTION `subtotal` (`var_total_days` INT, `var_price_per_day` INT) RETURNS INT(11) DETERMINISTIC BEGIN
RETURN var_total_days*var_price_per_day;
END$$

CREATE DEFINER=`root`@`localhost` FUNCTION `total_days` (`date_in` DATE, `date_out` DATE) RETURNS INT(11)  RETURN DATE_DIFF(date_in, date_out)$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `car`
--

CREATE TABLE `car` (
  `car_id` int(11) NOT NULL,
  `brand` varchar(100) NOT NULL,
  `model` varchar(100) NOT NULL,
  `colour` varchar(100) NOT NULL,
  `plate` varchar(10) NOT NULL,
  `seats` int(11) NOT NULL,
  `doors` int(11) NOT NULL,
  `fuel` varchar(50) NOT NULL,
  `location` varchar(50) NOT NULL,
  `itv` tinyint(1) NOT NULL,
  `state` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `car`
--

INSERT INTO `car` (`car_id`, `brand`, `model`, `colour`, `plate`, `seats`, `doors`, `fuel`, `location`, `itv`, `state`) VALUES
(1, 'toyota', 'corolla', 'blanco', '1234BCD', 5, 4, 'gasolina', 'Aeropuerto', 1, 'Disponible'),
(2, 'ford ', 'fiesta', 'black', '4567DWP', 5, 4, 'Diesel', 'Airport', 1, 'Availiable'),
(3, 'BMW', 'X5', 'blue', '7897GHL', 4, 5, 'Gaoil', 'Hotel', 0, 'Maintenence'),
(4, 'Audi', 'A3', 'Grey', '2358LMP', 4, 5, 'Diesel', 'Airport', 1, 'Availiable'),
(5, 'Volkswagen', 'Golf', 'Red', '8527KKK', 5, 5, 'Gasoil', 'Airport', 1, 'Availiable'),
(6, 'Mercedes', 'C-Class', 'Silver', '4569KKL', 4, 5, 'Gasoil', 'Airport', 1, 'Availiable'),
(7, 'Renault', 'Clio', 'green', '9657LLC', 4, 5, 'Diesel', 'Office', 0, 'Maintenance'),
(8, 'Seat', 'Leon', 'Orange', '3141PYP', 5, 5, 'diesel', 'Airport', 1, 'Availiable'),
(9, 'Peugeot', '308', 'white', '24101RLP', 4, 5, 'Diesel', 'Office', 1, 'Availiable'),
(10, 'Tesla', 'Model 3', 'Black', '6421GGW', 5, 5, 'Electrical', 'Airport', 1, 'Availiable');

-- --------------------------------------------------------

--
-- Table structure for table `car_class`
--

CREATE TABLE `car_class` (
  `car_id` int(11) NOT NULL,
  `class_id` int(11) NOT NULL,
  `class_name` enum('business','economy','luxury','superlux') DEFAULT NULL,
  `class_price_per_day` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `car_class`
--

INSERT INTO `car_class` (`car_id`, `class_id`, `class_name`, `class_price_per_day`) VALUES
(1, 1, 'economy', 60),
(2, 1, 'economy', 60),
(3, 2, 'business', 80),
(4, 2, 'business', 80),
(5, 1, 'economy', 60),
(6, 2, 'business', 80),
(7, 1, 'economy', 60),
(8, 1, 'economy', 60),
(9, 1, 'economy', 60),
(10, 3, 'luxury', 100);

-- --------------------------------------------------------

--
-- Stand-in structure for view `car_view`
-- (See below for the actual view)
--
CREATE TABLE `car_view` (
`car_id` int(11)
,`brand` varchar(100)
,`model` varchar(100)
,`colour` varchar(100)
,`plate` varchar(10)
,`seats` int(11)
,`doors` int(11)
,`fuel` varchar(50)
,`location` varchar(50)
,`itv` tinyint(1)
,`state` varchar(50)
,`class_name` enum('business','economy','luxury','superlux')
,`price_per_day` int(11)
);

-- --------------------------------------------------------

--
-- Table structure for table `class`
--

CREATE TABLE `class` (
  `class_id` int(11) NOT NULL,
  `class_name` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `class`
--

INSERT INTO `class` (`class_id`, `class_name`) VALUES
(1, 'economy'),
(2, 'business'),
(3, 'luxury');

-- --------------------------------------------------------

--
-- Table structure for table `client`
--

CREATE TABLE `client` (
  `id_client` int(11) NOT NULL,
  `name` text NOT NULL,
  `surname` text NOT NULL,
  `nif` varchar(9) NOT NULL,
  `driver_liscense_num` varchar(20) NOT NULL,
  `adress` varchar(100) NOT NULL,
  `email` varchar(50) NOT NULL,
  `phone_number` varchar(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `client`
--

INSERT INTO `client` (`id_client`, `name`, `surname`, `nif`, `driver_liscense_num`, `adress`, `email`, `phone_number`) VALUES
(1, 'John ', 'Doe', '1234567J', '456789123', 'Avda Falsa 123 2A', 'fakeadress@fakemail.com', '61234567'),
(2, 'Jane', 'Doe', '7654321J', '123456789', 'Avda Imaginaria 23', 'fakename@fakemail.com', '687654321'),
(3, 'Alan ', 'Rabinerson', '01650614J', '753951462', 'Gran Via 6 ', 'fakename1@fakemail.com', '645689741'),
(4, 'Juan', 'Perez', '1237567A', 'B1234567', '	Calle Mayor 1, Madrid', 'juanperez@example.com', '600123456'),
(5, 'Maria', 'Lopez', '7654321B', 'C7654321	', 'Avenida Sol 45, Valencia	', 'marialopez@fakemail.com', '650987654'),
(6, 'Carlos', 'Gomez', '3456789C', 'D2345678', 'Plaza Luna 12, Sevilla', 'carlosgomez@fakemail.com', '622345678'),
(7, 'Laura', 'Sanchez', '4567890D', 'E8765432	', 'Paseo del Prado 18, Madrid	', 'laura.sanchez@example.com	', '610234567'),
(8, 'Pedro', 'Garcia', '56789012E', 'F6543210', 'Calle Sol 9, Barcelona', 'pedro.garcia@fakemail.com', '670345678'),
(9, 'Ana ', 'Fernandez', '67890123F', 'G8765431', 'Avenida Central 33, Bilbao', 'anafernandez@fakemail.com', '680456789'),
(10, 'Luis ', 'Martinez', '78901234G', 'H1234567', 'Calle Norte 22, Málaga	', 'luismartinez@fakemail.com', '690567890');

-- --------------------------------------------------------

--
-- Stand-in structure for view `invoice_view`
-- (See below for the actual view)
--
CREATE TABLE `invoice_view` (
`name` text
,`surname` text
,`nif` varchar(9)
,`id_reservation` int(11)
,`initial_date` date
,`final_date` date
,`price_per_day` int(11)
,`id_client` int(11)
,`car_id` int(11)
,`brand` varchar(100)
,`model` varchar(100)
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `long_term_customers`
-- (See below for the actual view)
--
CREATE TABLE `long_term_customers` (
`id_client` int(11)
,`total_days` int(7)
);

-- --------------------------------------------------------

--
-- Table structure for table `reservation`
--

CREATE TABLE `reservation` (
  `id_reservation` int(11) NOT NULL,
  `initial_date` date NOT NULL,
  `final_date` date NOT NULL,
  `price_per_day` int(11) NOT NULL,
  `id_client` int(11) NOT NULL,
  `car_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `reservation`
--

INSERT INTO `reservation` (`id_reservation`, `initial_date`, `final_date`, `price_per_day`, `id_client`, `car_id`) VALUES
(1, '2024-10-24', '2024-10-31', 65, 6, 7),
(2, '2024-10-24', '2024-10-31', 80, 1, 8),
(3, '2024-10-07', '2024-10-14', 64, 2, 4),
(4, '2024-10-07', '2024-10-17', 73, 2, 1),
(5, '2024-10-01', '2024-10-17', 80, 7, 9),
(6, '2024-10-16', '2024-10-23', 57, 6, 3),
(7, '2024-08-01', '2024-08-08', 84, 1, 10),
(8, '2024-09-10', '2024-09-20', 81, 3, 3),
(9, '2024-12-22', '2024-10-31', 88, 10, 10),
(10, '2024-10-31', '2024-11-02', 73, 7, 1);

-- --------------------------------------------------------

--
-- Stand-in structure for view `reservation_view`
-- (See below for the actual view)
--
CREATE TABLE `reservation_view` (
`name` text
,`surname` text
,`nif` varchar(9)
,`id_client` int(11)
,`total_days` int(7)
,`subtotal` int(11)
,`brand` varchar(100)
,`model` varchar(100)
);

-- --------------------------------------------------------

--
-- Structure for view `car_view`
--
DROP TABLE IF EXISTS `car_view`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `car_view`  AS SELECT `c`.`car_id` AS `car_id`, `c`.`brand` AS `brand`, `c`.`model` AS `model`, `c`.`colour` AS `colour`, `c`.`plate` AS `plate`, `c`.`seats` AS `seats`, `c`.`doors` AS `doors`, `c`.`fuel` AS `fuel`, `c`.`location` AS `location`, `c`.`itv` AS `itv`, `c`.`state` AS `state`, `cc`.`class_name` AS `class_name`, `cc`.`class_price_per_day` AS `price_per_day` FROM (`car` `c` join `car_class` `cc`) WHERE `cc`.`car_id` = `c`.`car_id` ;

-- --------------------------------------------------------

--
-- Structure for view `invoice_view`
--
DROP TABLE IF EXISTS `invoice_view`;

CREATE ALGORITHM=UNDEFINED DEFINER=`Alan`@`localhost` SQL SECURITY DEFINER VIEW `invoice_view`  AS SELECT `cu`.`name` AS `name`, `cu`.`surname` AS `surname`, `cu`.`nif` AS `nif`, `r`.`id_reservation` AS `id_reservation`, `r`.`initial_date` AS `initial_date`, `r`.`final_date` AS `final_date`, `r`.`price_per_day` AS `price_per_day`, `r`.`id_client` AS `id_client`, `r`.`car_id` AS `car_id`, `ca`.`brand` AS `brand`, `ca`.`model` AS `model` FROM ((`reservation` `r` join `client` `cu` on(`cu`.`id_client` = `r`.`id_client`)) join `car` `ca` on(`ca`.`car_id` = `r`.`car_id`)) ;

-- --------------------------------------------------------

--
-- Structure for view `long_term_customers`
--
DROP TABLE IF EXISTS `long_term_customers`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `long_term_customers`  AS SELECT DISTINCT `c`.`id_client` AS `id_client`, `r`.`total_days` AS `total_days` FROM (`client` `c` join `reservation_view` `r` on(`r`.`id_client` = `c`.`id_client`)) WHERE `r`.`total_days` > (select ceiling(avg(`reservation_view`.`total_days`)) from `reservation_view`) ORDER BY `r`.`total_days` DESC ;

-- --------------------------------------------------------

--
-- Structure for view `reservation_view`
--
DROP TABLE IF EXISTS `reservation_view`;

CREATE ALGORITHM=UNDEFINED DEFINER=`Alan`@`localhost` SQL SECURITY DEFINER VIEW `reservation_view`  AS SELECT `cu`.`name` AS `name`, `cu`.`surname` AS `surname`, `cu`.`nif` AS `nif`, `r`.`id_client` AS `id_client`, to_days(`r`.`final_date`) - to_days(`r`.`initial_date`) AS `total_days`, `subtotal`(to_days(`r`.`final_date`) - to_days(`r`.`initial_date`),`r`.`price_per_day`) AS `subtotal`, `ca`.`brand` AS `brand`, `ca`.`model` AS `model` FROM ((`reservation` `r` join `client` `cu` on(`cu`.`id_client` = `r`.`id_client`)) join `car` `ca` on(`ca`.`car_id` = `r`.`car_id`)) ;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `car`
--
ALTER TABLE `car`
  ADD PRIMARY KEY (`car_id`);

--
-- Indexes for table `car_class`
--
ALTER TABLE `car_class`
  ADD PRIMARY KEY (`car_id`,`class_id`),
  ADD KEY `class_id` (`class_id`);

--
-- Indexes for table `class`
--
ALTER TABLE `class`
  ADD PRIMARY KEY (`class_id`);

--
-- Indexes for table `client`
--
ALTER TABLE `client`
  ADD PRIMARY KEY (`id_client`);

--
-- Indexes for table `reservation`
--
ALTER TABLE `reservation`
  ADD PRIMARY KEY (`id_reservation`),
  ADD KEY `id_client` (`id_client`),
  ADD KEY `car_id` (`car_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `car`
--
ALTER TABLE `car`
  MODIFY `car_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `class`
--
ALTER TABLE `class`
  MODIFY `class_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `client`
--
ALTER TABLE `client`
  MODIFY `id_client` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `reservation`
--
ALTER TABLE `reservation`
  MODIFY `id_reservation` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `car_class`
--
ALTER TABLE `car_class`
  ADD CONSTRAINT `car_class_FK` FOREIGN KEY (`car_id`) REFERENCES `car` (`car_id`),
  ADD CONSTRAINT `car_class_ibfk_1` FOREIGN KEY (`class_id`) REFERENCES `class` (`class_id`);

--
-- Constraints for table `reservation`
--
ALTER TABLE `reservation`
  ADD CONSTRAINT `reservation_ibfk_1` FOREIGN KEY (`id_client`) REFERENCES `client` (`id_client`),
  ADD CONSTRAINT `reservation_ibfk_2` FOREIGN KEY (`car_id`) REFERENCES `car` (`car_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
