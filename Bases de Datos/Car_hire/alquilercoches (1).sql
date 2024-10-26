-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 07-10-2024 a las 16:13:49
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `alquilercoches`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

CREATE TABLE `cliente` (
  `id_cliente` int(11) NOT NULL,
  `nombre` text NOT NULL,
  `apellido` text NOT NULL,
  `nif` varchar(9) NOT NULL,
  `num_carnet_conducir` varchar(20) NOT NULL,
  `direccion` varchar(100) NOT NULL,
  `email` varchar(50) NOT NULL,
  `telefono` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `cliente`
--

INSERT INTO `cliente` (`id_cliente`, `nombre`, `apellido`, `nif`, `num_carnet_conducir`, `direccion`, `email`, `telefono`) VALUES
(1, 'John ', 'Doe', '1234567J', '456789123', 'Avda Falsa 123 2A', 'fakeadress@fakemail.com', '61234567'),
(2, 'Jane', 'Doe', '7654321J', '123456789', 'Avda Imaginaria 23', 'fakename@fakemail.com', '687654321'),
(3, 'Alan ', 'Rabinerson', '01650614J', '753951462', 'Gran Via 6 ', 'fakename1@fakemail.com', '645689741'),
(4, 'Juan', 'Perez', '1237567A', 'B1234567', '	Calle Mayor 1, Madrid', 'juanperez@example.com', '600123456'),
(5, 'Maria', 'Lopez', '7654321B', 'C7654321	', 'Avenida Sol 45, Valencia	', 'marialopez@fakemail.com', '650987654'),
(6, 'Carlos', 'Gomez', '3456789C', 'D2345678', 'Plaza Luna 12, Sevilla', 'carlosgomez@fakemail.com', '622345678'),
(7, 'Laura', 'Sanchez', '4567890D', 'E8765432	', 'Paseo del Prado 18, Madrid	', 'laura.sanchez@example.com	', '610234567'),
(8, 'Pedro', 'Garcia', '56789012E', 'F6543210', 'Calle Sol 9, Barcelona', 'pedro.garcia@fakemail.com', '670345678'),
(9, 'Ana ', 'Fernandez', '67890123F', 'G8765431', 'Avenida Central 33, Bilbao', 'anafernandez@fakemail.com', '680456789');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `coche`
--

CREATE TABLE `coche` (
  `car_id` int(11) NOT NULL,
  `marca` varchar(100) NOT NULL,
  `modelo` varchar(100) NOT NULL,
  `color` varchar(100) NOT NULL,
  `matricula` int(10) NOT NULL,
  `asientos` int(11) NOT NULL,
  `puertas` int(11) NOT NULL,
  `combustible` varchar(50) NOT NULL,
  `localizacion` varchar(50) NOT NULL,
  `itv` tinyint(1) NOT NULL,
  `estado` varchar(50) NOT NULL,
  `precio_por_dia` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `reservas`
--

CREATE TABLE `reservas` (
  `id_reserva` int(11) NOT NULL,
  `nif_cliente` varchar(50) NOT NULL,
  `matricula_coche` varchar(10) NOT NULL,
  `fecha_entrega` date NOT NULL,
  `fecha_devolucion` date NOT NULL,
  `precio_por_dia` int(11) NOT NULL,
  `id_cliente` int(11) NOT NULL,
  `id_coche` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`id_cliente`),
  ADD UNIQUE KEY `nif` (`nif`);

--
-- Indices de la tabla `coche`
--
ALTER TABLE `coche`
  ADD PRIMARY KEY (`car_id`),
  ADD UNIQUE KEY `matricula` (`matricula`);

--
-- Indices de la tabla `reservas`
--
ALTER TABLE `reservas`
  ADD PRIMARY KEY (`id_reserva`),
  ADD UNIQUE KEY `nif_cliente` (`nif_cliente`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `cliente`
--
ALTER TABLE `cliente`
  MODIFY `id_cliente` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT de la tabla `coche`
--
ALTER TABLE `coche`
  MODIFY `car_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `reservas`
--
ALTER TABLE `reservas`
  MODIFY `id_reserva` int(11) NOT NULL AUTO_INCREMENT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
