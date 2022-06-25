-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 26-06-2022 a las 01:40:07
-- Versión del servidor: 10.4.24-MariaDB
-- Versión de PHP: 7.4.29

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `ciat`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ubicacion animales`
--

CREATE TABLE `ubicacion animales` (
  `latitud` decimal(10,0) NOT NULL,
  `longitud` decimal(10,0) NOT NULL,
  `propietario` varchar(50) COLLATE utf8_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `zonas de deforestacion`
--

CREATE TABLE `zonas de deforestacion` (
  `latitud` decimal(10,0) NOT NULL,
  `longitud` decimal(10,0) NOT NULL,
  `area de deforestacion` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `ubicacion animales`
--
ALTER TABLE `ubicacion animales`
  ADD PRIMARY KEY (`latitud`);

--
-- Indices de la tabla `zonas de deforestacion`
--
ALTER TABLE `zonas de deforestacion`
  ADD PRIMARY KEY (`latitud`);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `ubicacion animales`
--
ALTER TABLE `ubicacion animales`
  ADD CONSTRAINT `ubicacion animales_ibfk_1` FOREIGN KEY (`latitud`) REFERENCES `zonas de deforestacion` (`latitud`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `zonas de deforestacion`
--
ALTER TABLE `zonas de deforestacion`
  ADD CONSTRAINT `zonas de deforestacion_ibfk_1` FOREIGN KEY (`latitud`) REFERENCES `ubicacion animales` (`latitud`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
