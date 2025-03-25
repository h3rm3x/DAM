-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 25, 2025 at 07:50 PM
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
-- Database: `car_hire`
--

DELIMITER $$
--
-- Procedures
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `addReservations` ()   BEGIN 
    DECLARE var_reservation_id INT;
    DECLARE var_car_id INT;
    DECLARE var_customer_id INT;
    DECLARE var_date_in DATE;
    DECLARE var_date_out DATE;
    DECLARE var_price_per_day INT;

    DECLARE i INT DEFAULT 0;
    DECLARE attempts INT DEFAULT 0;
    DECLARE max_attempts INT DEFAULT 100;

    WHILE (i < 10 AND attempts < max_attempts) DO
        SET attempts = attempts + 1;
        SET var_car_id = (SELECT car_id FROM car ORDER BY RAND() LIMIT 1);
        SET var_customer_id = (SELECT client_id FROM client ORDER BY RAND() LIMIT 1);
        SET var_date_in = DATE_ADD('2024-01-01', 
                                INTERVAL FLOOR(RAND() * DATEDIFF('2026-12-31', '2024-01-01')) DAY);
        SET var_date_out = (SELECT DATE_ADD(var_date_in, INTERVAL FLOOR(RAND() * 7) DAY));
        SET var_price_per_day = (SELECT class_price_per_day FROM car_class WHERE car_id = var_car_id);
        
        

        IF car_avaliability(var_car_id, var_date_in, var_date_out) THEN
            INSERT INTO reservation (car_id, client_id, date_in, date_out, price_per_day) VALUES (var_car_id, var_customer_id, var_date_in, var_date_out, var_price_per_day);
            SET i = i + 1;
        END IF;
    END WHILE;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `avaliable_cars_per_class` (IN `var_date_in` DATE, IN `var_date_out` DATE)   SELECT car_class, COUNT(car_id) AS Number_of_cars
FROM car_2
WHERE car_id NOT IN (SELECT car_id FROM reservation WHERE date_in<= var_date_out AND date_out >= var_date_in)
GROUP BY car_class$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `showCarsFreeDates` ()   BEGIN
    DECLARE var_car_id INT;
    DECLARE var_date_in DATE;
    DECLARE var_date_out DATE;
    DECLARE var_price_per_day INT;

    DECLARE i INT DEFAULT 0;
    DECLARE attempts INT DEFAULT 0;
    DECLARE max_attempts INT DEFAULT 100;

    WHILE (i < 10 AND attempts < max_attempts) DO
        SET attempts = attempts + 1;
        SET var_car_id = (SELECT car_id FROM car ORDER BY RAND() LIMIT 1);
        SET var_date_in = DATE_ADD('2024-01-01', 
                                INTERVAL FLOOR(RAND() * DATEDIFF('2026-12-31', '2024-01-01')) DAY);
        SET var_date_out = (SELECT DATE_ADD(var_date_in, INTERVAL FLOOR(RAND() * 7) DAY));
        SET var_price_per_day = (SELECT class_price_per_day FROM car_class WHERE car_id = var_car_id);
        
        IF car_avaliability(var_car_id, var_date_in, var_date_out) THEN
            SELECT var_car_id, var_date_in, var_date_out;
            SET i = i + 1;
        END IF;
    END WHILE;


END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `update_reservation_dates` ()   BEGIN
    DECLARE done INT DEFAULT FALSE;
    DECLARE var_reservation_id INT;
    DECLARE var_date_in DATE;
    DECLARE var_date_out DATE;
    DECLARE duration INT;
    
    -- Cursor para recorrer todas las reservas
    DECLARE cur CURSOR FOR 
        SELECT reservation_id FROM reservation;
    
    -- Handler para cuando no hay más reservas
    DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = TRUE;
    
    -- Abrir el cursor
    OPEN cur;
    
    -- Recorrer todas las reservas
    read_loop: LOOP
        FETCH cur INTO var_reservation_id;
        
        IF done THEN
            LEAVE read_loop;
        END IF;
        
        -- Generar una fecha inicial aleatoria entre 2024-01-01 y 2025-12-31
        SET var_date_in = DATE_ADD('2024-01-01', 
                                INTERVAL FLOOR(RAND() * DATEDIFF('2026-12-31', '2024-01-01')) DAY);
        
        -- Obtener la duración actual de la reserva
        SELECT DATEDIFF(date_out, date_in) INTO duration 
        FROM reservation 
        WHERE reservation_id = var_reservation_id;
        
        -- Asegurar que la duración sea al menos 1 día
        IF duration < 1 THEN
            SET duration = 1;
        END IF;
        
        -- Calcular la fecha final basada en la duración original
        SET var_date_out = DATE_ADD(var_date_in, INTERVAL duration DAY);
        
        -- Actualizar la reserva con las nuevas fechas
        UPDATE reservation 
        SET date_in = var_date_in,
            date_out = var_date_out
        WHERE reservation_id = var_reservation_id;
    END LOOP;
    
    -- Cerrar el cursor
    CLOSE cur;
    
    SELECT CONCAT('Se actualizaron las fechas de ', (SELECT COUNT(*) FROM reservation), ' reservas') AS result;
END$$

--
-- Functions
--
CREATE DEFINER=`root`@`localhost` FUNCTION `car_avaliability` (`var_car_id` INT, `var_date_in` DATE, `var_date_out` DATE) RETURNS TINYINT(1) DETERMINISTIC BEGIN
    DECLARE var_availability BOOLEAN;
    SET var_availability = TRUE;
    IF (SELECT COUNT(*) FROM reservation WHERE car_id = var_car_id AND date_in <= var_date_out AND date_out >= var_date_in) > 0 THEN
        SET var_availability = FALSE;
    END IF;
    RETURN var_availability;
END$$

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
  `class_name` enum('business','economy','luxury','superlux') DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `car_class`
--

INSERT INTO `car_class` (`car_id`, `class_name`) VALUES
(1, 'economy'),
(2, 'economy'),
(3, 'business'),
(4, 'business'),
(5, 'economy'),
(6, 'business'),
(7, 'economy'),
(8, 'economy'),
(9, 'economy'),
(10, 'luxury');

-- --------------------------------------------------------

--
-- Table structure for table `class`
--

CREATE TABLE `class` (
  `class_name` varchar(50) NOT NULL,
  `class_price` decimal(8,2) NOT NULL,
  `start_date` date NOT NULL,
  `end_date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `class`
--

INSERT INTO `class` (`class_name`, `class_price`, `start_date`, `end_date`) VALUES
('economy', 60.00, '2025-05-01', '2025-10-31'),
('business', 80.00, '2025-05-01', '2025-10-31'),
('luxury', 100.00, '2025-05-01', '2025-10-31'),
('economy', 40.00, '2025-05-01', '2025-10-31'),
('business', 60.00, '2025-05-01', '2025-10-31'),
('luxury', 80.00, '2025-05-01', '2025-10-31');

-- --------------------------------------------------------

--
-- Table structure for table `client`
--

CREATE TABLE `client` (
  `client_id` int(11) NOT NULL,
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

INSERT INTO `client` (`client_id`, `name`, `surname`, `nif`, `driver_liscense_num`, `adress`, `email`, `phone_number`) VALUES
(1, 'John ', 'Doe', '1234567J', '456789123', 'Avda Falsa 123 2A', 'fakeadress@fakemail.com', '61234567'),
(2, 'Jane', 'Doe', '7654321J', '123456789', 'Avda Imaginaria 23', 'fakename@fakemail.com', '687654321'),
(3, 'Alan ', 'Rabinerson', '01650614J', '753951462', 'Gran Via 6 ', 'fakename1@fakemail.com', '645689741'),
(4, 'Juan', 'Perez', '1237567A', 'B1234567', '	Calle Mayor 1, Madrid', 'juanperez@example.com', '600123456'),
(5, 'Maria', 'Lopez', '7654321B', 'C7654321	', 'Avenida Sol 45, Valencia	', 'marialopez@fakemail.com', '650987654'),
(6, 'Carlos', 'Gomez', '3456789C', 'D2345678', 'Plaza Luna 12, Sevilla', 'carlosgomez@fakemail.com', '622345678'),
(7, 'Laura', 'Sanchez', '4567890D', 'E8765432	', 'Paseo del Prado 18, Madrid	', 'laura.sanchez@example.com	', '610234567'),
(8, 'Pedro', 'Garcia', '56789012E', 'F6543210', 'Calle Sol 9, Barcelona', 'pedro.garcia@fakemail.com', '670345678'),
(9, 'Ana ', 'Fernandez', '67890123F', 'G8765431', 'Avenida Central 33, Bilbao', 'anafernandez@fakemail.com', '680456789'),
(10, 'Luis ', 'Martinez', '78901234G', 'H1234567', 'Calle Norte 22, Málaga	', 'luismartinez@fakemail.com', '690567890'),
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
-- Table structure for table `reservation`
--

CREATE TABLE `reservation` (
  `reservation_id` int(11) NOT NULL,
  `date_in` date NOT NULL,
  `date_out` date NOT NULL,
  `price_per_day` int(11) NOT NULL,
  `client_id` int(11) NOT NULL,
  `car_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `reservation`
--

INSERT INTO `reservation` (`reservation_id`, `date_in`, `date_out`, `price_per_day`, `client_id`, `car_id`) VALUES
(1, '2025-12-21', '2025-12-28', 65, 6, 7),
(2, '2024-09-22', '2024-09-29', 80, 1, 8),
(3, '2025-01-30', '2025-02-06', 64, 2, 4),
(4, '2024-03-25', '2024-04-04', 73, 2, 1),
(5, '2026-05-06', '2026-05-22', 80, 7, 9),
(6, '2025-12-11', '2025-12-18', 57, 6, 3),
(7, '2026-09-30', '2026-10-07', 84, 1, 10),
(8, '2025-07-14', '2025-07-24', 81, 3, 3),
(9, '2024-04-07', '2024-04-08', 88, 10, 10),
(10, '2025-03-20', '2025-03-22', 73, 7, 1),
(11, '2024-02-11', '2024-02-14', 60, 9, 8),
(12, '2024-11-07', '2024-11-09', 60, 6, 9),
(13, '2024-09-07', '2024-09-10', 80, 9, 6),
(14, '2024-03-22', '2024-03-24', 60, 5, 9),
(15, '2024-12-01', '2024-12-07', 80, 7, 6),
(16, '2026-05-25', '2026-05-31', 60, 9, 1),
(17, '2025-11-04', '2025-11-05', 60, 2, 7),
(18, '2026-01-29', '2026-01-30', 100, 4, 10),
(19, '2026-06-12', '2026-06-14', 80, 6, 4),
(20, '2025-07-23', '2025-07-25', 60, 10, 9),
(21, '2026-05-01', '2026-05-04', 60, 4, 1),
(22, '2025-02-16', '2025-02-22', 60, 3, 9),
(23, '2026-07-22', '2026-07-25', 60, 9, 5),
(24, '2024-09-25', '2024-09-26', 60, 7, 2),
(25, '2026-01-14', '2026-01-18', 60, 4, 2),
(26, '2024-06-29', '2024-07-05', 60, 5, 5),
(27, '2024-04-23', '2024-04-27', 60, 9, 7),
(28, '2025-12-29', '2025-12-30', 60, 6, 2),
(29, '2024-10-20', '2024-10-21', 60, 8, 5),
(30, '2024-11-07', '2024-11-08', 60, 5, 2),
(31, '2025-04-11', '2025-04-13', 60, 2, 2),
(32, '2025-05-21', '2025-05-26', 60, 7, 8),
(33, '2025-06-21', '2025-06-23', 60, 9, 1),
(34, '2026-07-15', '2026-07-21', 80, 1, 6),
(35, '2026-12-26', '2026-12-30', 80, 1, 4),
(36, '2024-11-01', '2024-11-02', 60, 10, 2),
(37, '2024-05-05', '2024-05-09', 60, 8, 2),
(38, '2026-01-03', '2026-01-04', 60, 10, 7),
(39, '2025-08-06', '2025-08-09', 80, 1, 4),
(40, '2026-03-18', '2026-03-19', 60, 5, 2),
(41, '2024-12-06', '2024-12-08', 80, 9, 6),
(42, '2025-11-02', '2025-11-08', 80, 7, 3),
(43, '2024-02-12', '2024-02-17', 60, 1, 7),
(44, '2024-07-20', '2024-07-21', 60, 7, 7),
(45, '2025-08-05', '2025-08-10', 80, 10, 3),
(46, '2026-01-11', '2026-01-12', 80, 2, 4),
(47, '2026-05-31', '2026-06-05', 60, 9, 7),
(48, '2026-05-09', '2026-05-14', 80, 10, 4),
(49, '2024-08-07', '2024-08-13', 100, 9, 10),
(50, '2026-06-16', '2026-06-18', 80, 6, 3),
(51, '2025-07-03', '2025-07-06', 80, 7, 3),
(52, '2024-02-26', '2024-02-27', 80, 4, 3),
(53, '2024-01-18', '2024-01-21', 80, 6, 6),
(54, '2026-09-06', '2026-09-08', 80, 8, 4),
(55, '2024-05-14', '2024-05-19', 60, 4, 1),
(56, '2026-04-01', '2026-04-05', 80, 10, 3),
(57, '2026-07-15', '2026-07-17', 60, 8, 5),
(58, '2026-10-05', '2026-10-10', 100, 1, 10),
(59, '2024-01-04', '2024-01-05', 100, 9, 10),
(60, '2024-08-05', '2024-08-07', 60, 1, 8),
(61, '2024-06-03', '2024-06-04', 60, 2, 1),
(62, '2025-01-12', '2025-01-14', 60, 4, 2),
(63, '2025-10-26', '2025-10-30', 60, 2, 8),
(64, '2024-05-06', '2024-05-07', 80, 10, 4),
(65, '2025-04-24', '2025-04-25', 60, 3, 8),
(66, '2025-10-17', '2025-10-18', 80, 5, 3),
(67, '2024-10-07', '2024-10-08', 100, 4, 10),
(68, '2024-10-20', '2024-10-23', 100, 9, 10),
(69, '2025-01-01', '2025-01-02', 60, 9, 1),
(70, '2025-04-10', '2025-04-15', 60, 4, 5),
(71, '2025-06-03', '2025-06-06', 60, 1, 7),
(72, '2024-06-12', '2024-06-13', 80, 6, 6),
(73, '2024-12-21', '2024-12-27', 60, 9, 9),
(74, '2025-07-13', '2025-07-14', 60, 2, 2),
(75, '2025-06-22', '2025-06-24', 60, 3, 9),
(76, '2026-02-01', '2026-02-02', 80, 9, 6),
(77, '2026-03-22', '2026-03-24', 80, 7, 3),
(78, '2025-10-05', '2025-10-06', 60, 5, 5),
(79, '2024-02-07', '2024-02-08', 80, 10, 6),
(80, '2025-09-18', '2025-09-19', 100, 4, 10),
(81, '2024-10-03', '2024-10-04', 60, 3, 1),
(82, '2024-03-03', '2024-03-04', 100, 6, 10),
(83, '2025-12-25', '2025-12-26', 60, 3, 5),
(84, '2025-09-13', '2025-09-14', 100, 9, 10),
(85, '2026-11-12', '2026-11-17', 60, 9, 7),
(86, '2025-01-25', '2025-01-31', 60, 9, 7),
(87, '2024-10-08', '2024-10-14', 60, 7, 1),
(88, '2025-07-22', '2025-07-24', 60, 8, 2),
(89, '2026-01-02', '2026-01-07', 100, 3, 10),
(90, '2026-09-08', '2026-09-12', 80, 6, 4),
(91, '2024-05-28', '2024-05-29', 80, 6, 4),
(92, '2025-12-03', '2025-12-08', 100, 4, 10),
(93, '2025-08-02', '2025-08-03', 60, 6, 1),
(94, '2025-02-07', '2025-02-08', 60, 5, 8),
(95, '2026-08-14', '2026-08-17', 60, 2, 1),
(96, '2025-06-14', '2025-06-16', 60, 4, 9),
(97, '2024-08-06', '2024-08-10', 100, 2, 10),
(98, '2025-08-02', '2025-08-05', 60, 7, 8),
(99, '2024-03-11', '2024-03-13', 60, 3, 2),
(100, '2025-08-14', '2025-08-17', 60, 1, 8),
(101, '2026-05-04', '2026-05-10', 60, 4, 1),
(102, '2026-09-21', '2026-09-25', 80, 6, 3),
(103, '2024-04-02', '2024-04-06', 80, 10, 6),
(104, '2025-08-20', '2025-08-22', 60, 4, 5),
(105, '2024-03-20', '2024-03-21', 100, 4, 10),
(106, '2026-12-17', '2026-12-18', 80, 9, 4),
(107, '2026-11-04', '2026-11-05', 60, 8, 9),
(108, '2024-12-13', '2024-12-15', 80, 9, 6),
(109, '2024-11-03', '2024-11-07', 60, 9, 1),
(110, '2024-12-15', '2024-12-21', 80, 8, 3),
(111, '2024-03-11', '2024-03-12', 60, 3, 1),
(112, '2024-12-30', '2025-01-04', 80, 9, 6),
(113, '2026-09-26', '2026-10-01', 60, 9, 7),
(114, '2024-05-06', '2024-05-10', 60, 10, 8),
(115, '2026-11-10', '2026-11-13', 60, 10, 8),
(116, '2024-11-11', '2024-11-16', 60, 3, 9),
(117, '2025-10-12', '2025-10-15', 60, 10, 9),
(118, '2026-04-17', '2026-04-22', 60, 2, 2),
(119, '2025-08-03', '2025-08-05', 80, 5, 4),
(120, '2024-04-25', '2024-04-28', 60, 2, 9),
(121, '2026-08-10', '2026-08-12', 80, 9, 3),
(122, '2026-02-17', '2026-02-21', 80, 2, 6),
(123, '2025-04-08', '2025-04-10', 60, 5, 8),
(124, '2025-06-28', '2025-06-30', 60, 3, 7),
(125, '2026-01-25', '2026-01-31', 80, 3, 4),
(126, '2026-07-28', '2026-08-02', 80, 9, 4),
(127, '2024-10-05', '2024-10-09', 60, 2, 8),
(128, '2025-06-07', '2025-06-08', 60, 10, 1),
(129, '2024-08-04', '2024-08-05', 60, 1, 1),
(130, '2026-03-23', '2026-03-27', 60, 8, 5),
(131, '2024-03-21', '2024-03-26', 60, 5, 5),
(132, '2025-03-07', '2025-03-08', 80, 9, 3),
(133, '2025-01-29', '2025-01-31', 80, 5, 3),
(134, '2026-03-28', '2026-03-31', 60, 4, 7),
(135, '2025-11-08', '2025-11-09', 80, 5, 3),
(136, '2024-01-02', '2024-01-03', 60, 1, 8),
(137, '2024-09-22', '2024-09-23', 60, 7, 7),
(138, '2025-11-20', '2025-11-21', 60, 8, 2),
(139, '2024-06-06', '2024-06-09', 60, 1, 5),
(140, '2025-08-30', '2025-09-05', 60, 2, 1),
(141, '2026-07-26', '2026-07-30', 60, 10, 2),
(142, '2024-09-25', '2024-09-26', 60, 3, 8),
(143, '2025-09-03', '2025-09-08', 80, 8, 6),
(144, '2024-08-30', '2024-09-02', 60, 5, 8),
(145, '2024-01-14', '2024-01-19', 80, 7, 3),
(146, '2024-07-18', '2024-07-23', 60, 5, 1),
(147, '2025-06-28', '2025-07-01', 60, 1, 5),
(148, '2024-08-30', '2024-09-04', 80, 5, 4),
(149, '2025-02-12', '2025-02-13', 60, 10, 8),
(150, '2024-08-14', '2024-08-15', 80, 4, 3),
(151, '2025-03-03', '2025-03-04', 60, 5, 2),
(152, '2026-04-18', '2026-04-19', 100, 7, 10),
(153, '2024-02-28', '2024-02-29', 60, 3, 5),
(154, '2026-11-29', '2026-12-01', 60, 10, 7),
(155, '2025-02-23', '2025-02-28', 60, 2, 2),
(156, '2026-04-30', '2026-05-01', 60, 10, 5),
(157, '2026-03-27', '2026-03-28', 60, 4, 9),
(158, '2026-03-27', '2026-04-01', 60, 4, 2),
(159, '2024-05-19', '2024-05-20', 60, 2, 7),
(160, '2025-08-04', '2025-08-05', 80, 1, 4),
(161, '2026-12-21', '2026-12-22', 80, 9, 4),
(162, '2026-03-01', '2026-03-02', 60, 3, 5),
(163, '2025-09-23', '2025-09-24', 60, 3, 2),
(164, '2024-11-01', '2024-11-06', 60, 5, 5),
(165, '2025-10-28', '2025-10-29', 100, 6, 10),
(166, '2026-12-26', '2026-12-28', 80, 8, 3),
(167, '2026-03-04', '2026-03-08', 60, 6, 7),
(168, '2026-03-30', '2026-04-02', 100, 7, 10),
(169, '2025-02-04', '2025-02-07', 80, 2, 4),
(170, '2025-03-29', '2025-04-02', 60, 9, 9),
(171, '2026-09-29', '2026-10-05', 100, 9, 10),
(172, '2024-08-05', '2024-08-08', 60, 2, 8),
(173, '2026-08-16', '2026-08-17', 60, 1, 8),
(174, '2026-06-29', '2026-06-30', 60, 9, 9),
(175, '2026-08-16', '2026-08-20', 60, 4, 9),
(176, '2024-05-29', '2024-06-04', 100, 7, 10),
(177, '2024-10-25', '2024-10-25', 60, 7, 2),
(178, '2026-07-24', '2026-07-27', 80, 6, 6),
(179, '2024-08-15', '2024-08-20', 60, 9, 9),
(180, '2024-01-18', '2024-01-21', 60, 7, 8),
(181, '2024-04-23', '2024-04-23', 100, 5, 10),
(182, '2026-12-08', '2026-12-11', 60, 5, 7),
(183, '2025-02-10', '2025-02-12', 80, 3, 4),
(184, '2024-01-09', '2024-01-12', 60, 9, 2),
(185, '2025-05-20', '2025-05-22', 60, 10, 9),
(186, '2025-05-11', '2025-05-15', 60, 6, 9),
(187, '2024-05-14', '2024-05-14', 60, 2, 9),
(188, '2024-12-08', '2024-12-10', 80, 3, 4),
(189, '2025-01-10', '2025-01-10', 80, 2, 4),
(190, '2024-04-16', '2024-04-22', 60, 10, 7),
(191, '2026-03-24', '2026-03-28', 80, 5, 6),
(192, '2025-10-20', '2025-10-25', 80, 3, 4),
(193, '2026-08-15', '2026-08-17', 60, 5, 2),
(194, '2025-03-04', '2025-03-08', 60, 8, 5),
(195, '2024-01-12', '2024-01-16', 100, 4, 10),
(196, '2025-07-15', '2025-07-20', 100, 8, 10),
(197, '2026-07-13', '2026-07-19', 60, 6, 9),
(198, '2026-04-05', '2026-04-08', 100, 9, 10),
(199, '2026-04-17', '2026-04-22', 80, 5, 4),
(200, '2024-01-21', '2024-01-25', 60, 9, 5),
(201, '2026-06-29', '2026-06-29', 60, 10, 8),
(202, '2026-10-07', '2026-10-08', 60, 5, 5),
(203, '2026-02-05', '2026-02-10', 60, 7, 7),
(204, '2024-12-28', '2024-12-29', 100, 9, 10),
(205, '2025-09-06', '2025-09-11', 80, 10, 3),
(206, '2026-01-11', '2026-01-16', 60, 8, 1),
(207, '2026-06-16', '2026-06-18', 60, 6, 5),
(208, '2026-10-21', '2026-10-24', 80, 10, 6),
(209, '2024-10-26', '2024-10-29', 80, 8, 6),
(210, '2025-12-02', '2025-12-08', 80, 10, 3),
(211, '2026-04-16', '2026-04-19', 80, 1, 6),
(212, '2024-12-25', '2024-12-31', 60, 2, 8),
(213, '2024-05-23', '2024-05-28', 80, 9, 3),
(214, '2025-03-19', '2025-03-24', 60, 5, 2),
(215, '2025-04-26', '2025-05-01', 60, 1, 8),
(216, '2026-08-27', '2026-09-01', 80, 8, 4),
(217, '2025-01-04', '2025-01-07', 60, 3, 9),
(218, '2026-03-06', '2026-03-07', 100, 5, 10),
(219, '2025-12-09', '2025-12-15', 60, 7, 2),
(220, '2026-04-21', '2026-04-24', 80, 10, 6),
(221, '2024-05-13', '2024-05-18', 80, 10, 6),
(222, '2024-07-24', '2024-07-25', 60, 6, 5),
(223, '2026-07-20', '2026-07-24', 80, 4, 4),
(224, '2026-12-21', '2026-12-27', 100, 2, 10),
(225, '2024-11-19', '2024-11-21', 60, 6, 2),
(226, '2024-01-27', '2024-01-30', 60, 6, 7),
(227, '2026-11-24', '2026-11-28', 100, 10, 10),
(228, '2024-08-23', '2024-08-29', 60, 3, 2),
(229, '2025-02-21', '2025-02-21', 60, 8, 7),
(230, '2024-02-03', '2024-02-07', 60, 4, 1),
(231, '2025-05-13', '2025-05-18', 100, 8, 10),
(232, '2025-03-02', '2025-03-04', 80, 7, 3),
(233, '2025-05-10', '2025-05-11', 60, 7, 2),
(234, '2026-04-28', '2026-05-04', 100, 3, 10),

-- --------------------------------------------------------

--
-- Stand-in structure for view `reservation_view`
-- (See below for the actual view)
--
CREATE TABLE `reservation_view` (
`name` text
,`surname` mediumtext
,`nif` varchar(9)
,`reservation_id` int(11)
,`date_in` date
,`date_out` date
,`price_per_day` int(11)
,`client_id` int(11)
,`car_id` int(11)
,`brand` varchar(100)
,`model` varchar(100)
,`total_price` bigint(17)
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `reservation_view_specialoffer`
-- (See below for the actual view)
--
CREATE TABLE `reservation_view_specialoffer` (
`car_id` int(11)
,`free_date_in` date
,`free_date_out` date
,`days_until_free_date_in` int(7)
,`car_price_per_day` int(11)
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `total_days_rented_per_car`
-- (See below for the actual view)
--
CREATE TABLE `total_days_rented_per_car` (
`car_id` int(11)
,`brand` varchar(100)
,`model` varchar(100)
,`total_days_rented` decimal(29,0)
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `total_income_per_car`
-- (See below for the actual view)
--
CREATE TABLE `total_income_per_car` (
`car_id` int(11)
,`brand` varchar(100)
,`model` varchar(100)
,`total_income` decimal(38,0)
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `total_income_per_month`
-- (See below for the actual view)
--
CREATE TABLE `total_income_per_month` (
`year` int(4)
,`month` varchar(9)
,`total_income` decimal(38,0)
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `total_income_per_quarter`
-- (See below for the actual view)
--
CREATE TABLE `total_income_per_quarter` (
`QUARTER` varchar(7)
,`total_income` decimal(38,0)
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `total_income_per_year`
-- (See below for the actual view)
--
CREATE TABLE `total_income_per_year` (
`year` int(4)
,`total_income` decimal(38,0)
);

-- --------------------------------------------------------

--
-- Structure for view `reservation_view`
--
DROP TABLE IF EXISTS `reservation_view`;

CREATE ALGORITHM=UNDEFINED DEFINER=`Alan`@`localhost` SQL SECURITY DEFINER VIEW `reservation_view`  AS SELECT `cu`.`name` AS `name`, ucase(`cu`.`surname`) AS `surname`, `cu`.`nif` AS `nif`, `r`.`reservation_id` AS `reservation_id`, `r`.`date_in` AS `date_in`, `r`.`date_out` AS `date_out`, `r`.`price_per_day` AS `price_per_day`, `r`.`client_id` AS `client_id`, `r`.`car_id` AS `car_id`, `ca`.`brand` AS `brand`, `ca`.`model` AS `model`, (to_days(`r`.`date_out`) - to_days(`r`.`date_in`)) * `r`.`price_per_day` AS `total_price` FROM ((`reservation` `r` join `client` `cu` on(`cu`.`client_id` = `r`.`client_id`)) join `car` `ca` on(`ca`.`car_id` = `r`.`car_id`)) ;

-- --------------------------------------------------------

--
-- Structure for view `reservation_view_specialoffer`
--
DROP TABLE IF EXISTS `reservation_view_specialoffer`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `reservation_view_specialoffer`  AS SELECT `r`.`car_id` AS `car_id`, `r`.`date_out`+ interval 1 day AS `free_date_in`, (select `re`.`date_in` from `reservation` `re` where `re`.`car_id` = `r`.`car_id` and `re`.`date_in` > `r`.`date_out` order by `re`.`date_in` limit 1) - interval 1 day AS `free_date_out`, to_days(`r`.`date_out`) - to_days(curdate()) AS `days_until_free_date_in`, (select `r`.`price_per_day` from (`class` `c` join `car_class` `cc` on(`c`.`class_name` = `cc`.`class_name`)) where `cc`.`car_id` = `r`.`car_id` order by curdate() limit 1) AS `car_price_per_day` FROM `reservation` AS `r` WHERE `r`.`date_out` > curdate() AND (select `re`.`date_in` from `reservation` `re` where `re`.`car_id` = `r`.`car_id` AND `re`.`date_in` > `r`.`date_out` order by `re`.`date_in` limit 1) is not null ;

-- --------------------------------------------------------

--
-- Structure for view `total_days_rented_per_car`
--
DROP TABLE IF EXISTS `total_days_rented_per_car`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `total_days_rented_per_car`  AS SELECT `reservation_view`.`car_id` AS `car_id`, `reservation_view`.`brand` AS `brand`, `reservation_view`.`model` AS `model`, sum(to_days(`reservation_view`.`date_out`) - to_days(`reservation_view`.`date_in`) + 1) AS `total_days_rented` FROM `reservation_view` GROUP BY `reservation_view`.`car_id` ORDER BY sum(to_days(`reservation_view`.`date_out`) - to_days(`reservation_view`.`date_in`) + 1) DESC ;

-- --------------------------------------------------------

--
-- Structure for view `total_income_per_car`
--
DROP TABLE IF EXISTS `total_income_per_car`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `total_income_per_car`  AS SELECT `reservation_view`.`car_id` AS `car_id`, `reservation_view`.`brand` AS `brand`, `reservation_view`.`model` AS `model`, sum((to_days(`reservation_view`.`date_out`) - to_days(`reservation_view`.`date_in`)) * `reservation_view`.`price_per_day`) AS `total_income` FROM `reservation_view` GROUP BY `reservation_view`.`car_id` ORDER BY sum((to_days(`reservation_view`.`date_out`) - to_days(`reservation_view`.`date_in`)) * `reservation_view`.`price_per_day`) DESC ;

-- --------------------------------------------------------

--
-- Structure for view `total_income_per_month`
--
DROP TABLE IF EXISTS `total_income_per_month`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `total_income_per_month`  AS SELECT year(`reservation`.`date_in`) AS `year`, monthname(`reservation`.`date_in`) AS `month`, sum((to_days(`reservation`.`date_out`) - to_days(`reservation`.`date_in`)) * `reservation`.`price_per_day`) AS `total_income` FROM `reservation` GROUP BY year(`reservation`.`date_in`), monthname(`reservation`.`date_in`) ORDER BY year(`reservation`.`date_in`) ASC, month(`reservation`.`date_in`) ASC ;

-- --------------------------------------------------------

--
-- Structure for view `total_income_per_quarter`
--
DROP TABLE IF EXISTS `total_income_per_quarter`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `total_income_per_quarter`  AS SELECT concat('Q',quarter(`reservation`.`date_in`),' ',year(`reservation`.`date_in`)) AS `QUARTER`, sum((to_days(`reservation`.`date_out`) - to_days(`reservation`.`date_in`)) * `reservation`.`price_per_day`) AS `total_income` FROM `reservation` GROUP BY year(`reservation`.`date_in`), quarter(`reservation`.`date_in`) ;

-- --------------------------------------------------------

--
-- Structure for view `total_income_per_year`
--
DROP TABLE IF EXISTS `total_income_per_year`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `total_income_per_year`  AS SELECT year(`reservation`.`date_in`) AS `year`, sum((to_days(`reservation`.`date_out`) - to_days(`reservation`.`date_in`)) * `reservation`.`price_per_day`) AS `total_income` FROM `reservation` GROUP BY year(`reservation`.`date_in`) ORDER BY year(`reservation`.`date_in`) ASC ;

DELIMITER $$
--
-- Events
--
CREATE DEFINER=`root`@`localhost` EVENT `rentacarEvent` ON SCHEDULE EVERY 3 DAY STARTS '2025-03-18 17:28:01' ENDS '2025-03-21 09:00:00' ON COMPLETION PRESERVE DISABLE DO CALL addReservations()$$

DELIMITER ;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
