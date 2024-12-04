drop table if exists reservation;
drop table if exists client;
drop table if exists car;

CREATE TABLE `car` (
  `car_id` int(11) NOT NULL PRIMARY KEY AUTO_INCREMNENT,
  `brand` varchar(100) NOT NULL,
  `model` varchar(100) NOT NULL,
  `colour` varchar(100) NOT NULL,
  `plate` varchar(10) NOT NULL,
  `seats` int(11) NOT NULL,
  `doors` int(11) NOT NULL,
  `fuel` varchar(50) NOT NULL,
  `location` varchar(50) NOT NULL,
  `itv` tinyint(1) NOT NULL,
  `state` varchar(50) NOT NULL,
  `price_per_day` varchar(50) NOT NULL
) ;

--
-- Dumping data for table `car`
--

INSERT INTO `car` (`car_id`, `brand`, `model`, `colour`, `plate`, `seats`, `doors`, `fuel`, `location`, `itv`, `state`, `price_per_day`) VALUES
(1, 'toyota', 'corolla', 'blanco', '1234BCD', 5, 4, 'gasolina', 'Aeropuerto', 1, 'Disponible', '80'),
(2, 'ford ', 'fiesta', 'black', '4567DWP', 5, 4, 'Diesel', 'Airport', 1, 'Availiable', '75'),
(3, 'BMW', 'X5', 'blue', '7897GHL', 4, 5, 'Gaoil', 'Hotel', 0, 'Maintenence', '95'),
(4, 'Audi', 'A3', 'Grey', '2358LMP', 4, 5, 'Diesel', 'Airport', 1, 'Availiable', '80'),
(5, 'Volkswagen', 'Golf', 'Red', '8527KKK', 5, 5, 'Gasoil', 'Airport', 1, 'Availiable', '68'),
(6, 'Mercedes', 'C-Class', 'Silver', '4569KKL', 4, 5, 'Gasoil', 'Airport', 1, 'Availiable', '87'),
(7, 'Renault', 'Clio', 'green', '9657LLC', 4, 5, 'Diesel', 'Office', 0, 'Maintenance', '64'),
(8, 'Seat', 'Leon', 'Orange', '3141PYP', 5, 5, 'diesel', 'Airport', 1, 'Availiable', '59'),
(9, 'Peugeot', '308', 'white', '24101RLP', 4, 5, 'Diesel', 'Office', 1, 'Availiable', '67'),
(10, 'Tesla', 'Model 3', 'Black', '6421GGW', 5, 5, 'Electrical', 'Airport', 1, 'Availiable', '91');

-- --------------------------------------------------------

--
-- Table structure for table `client`
--

CREATE TABLE `client` (
  `id_client` int(11) NOT NULL PRIMARY KEY AUTO_INCREMNENT,
  `name` text NOT NULL,
  `surname` text NOT NULL,
  `nif` varchar(9) NOT NULL,
  `driver_liscense_num` varchar(20) NOT NULL,
  `adress` varchar(100) NOT NULL,
  `email` varchar(50) NOT NULL,
  `phone_number` varchar(11) NOT NULL
);

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
-- Table structure for table `reservation`
--

CREATE TABLE `reservation` (
  `id_reservation` int(11) NOT NULL PRIMARY KEY,
  `initial_date` date NOT NULL,
  `final_date` date NOT NULL,
  `price_per_day` int(11) NOT NULL,
  `id_client` int(11) NOT NULL,
  `car_id` int(11) NOT NULL,
  FOREIGN KEY (`id_client`) REFERENCES `client`(`id_client`),
  FOREIGN KEY (`car_id`) REFERENCES `car`(`car_id`)
) ;

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
