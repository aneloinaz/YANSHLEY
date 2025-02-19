-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 19-02-2025 a las 11:30:56
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
-- Base de datos: `usurbiltex`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `categoria`
--

CREATE TABLE `categoria` (
  `ID_categoria` int(11) NOT NULL,
  `nombre` varchar(100) DEFAULT NULL,
  `descripcion` varchar(250) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `categoria`
--

INSERT INTO `categoria` (`ID_categoria`, `nombre`, `descripcion`) VALUES
(1, 'Pantalones', 'Variedad de pantalones para todas las ocasiones'),
(2, 'Sudaderas', 'Sudaderas cómodas y con estilo'),
(3, 'Camisetas', 'Camisetas de diferentes colores y estilos'),
(4, 'Camisas', 'Camisas formales e informales'),
(5, 'Chaquetas', 'Chaquetas para todas las estaciones');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detalle_pedido`
--

CREATE TABLE `detalle_pedido` (
  `ID_detalle` int(11) NOT NULL,
  `ID_producto` int(11) DEFAULT NULL,
  `ID_pedido` int(11) DEFAULT NULL,
  `precio` decimal(10,2) DEFAULT NULL,
  `cantidad` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pedido`
--

CREATE TABLE `pedido` (
  `ID_pedido` int(11) NOT NULL,
  `fecha_pedido` date DEFAULT NULL,
  `monto_total` decimal(10,2) DEFAULT NULL,
  `estado` varchar(100) DEFAULT NULL,
  `ID_usuario` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `pedido`
--

INSERT INTO `pedido` (`ID_pedido`, `fecha_pedido`, `monto_total`, `estado`, `ID_usuario`) VALUES
(1, '2025-01-31', 89.97, 'Completado', 1),
(2, '2025-02-01', 44.98, 'Pendiente', 2),
(3, '2025-02-02', 29.99, 'Enviado', 3),
(4, '2025-02-03', 99.99, 'Completado', 4),
(5, '2025-02-04', 149.99, 'Enviado', 5),
(6, '2025-02-05', 79.99, 'Pendiente', 6),
(7, '2025-02-06', 109.99, 'Completado', 7),
(8, '2025-02-07', 59.99, 'Enviado', 8),
(9, '2025-02-08', 89.97, 'Pendiente', 9),
(10, '2025-02-09', 74.99, 'Completado', 10),
(11, '2025-02-06', 109.99, 'Completado', 7),
(12, '2025-02-07', 59.99, 'Enviado', 8),
(13, '2025-01-08', 89.97, 'Pendiente', 9),
(14, '2025-01-09', 74.99, 'Completado', 10),
(15, '2025-01-10', 520.95, 'Completado', 1),
(16, '2025-01-11', 610.75, 'Enviado', 3),
(17, '2024-12-12', 545.50, 'Pendiente', 5),
(18, '2024-12-14', 399.99, 'Completado', 1),
(19, '2025-02-15', 270.50, 'Pendiente', 1),
(20, '2024-12-16', 130.00, 'Enviado', 1),
(21, '2024-07-31', 215.50, 'Completado', 1),
(22, '2024-08-04', 123.99, 'Enviado', 2),
(23, '2024-08-09', 345.75, 'Pendiente', 3),
(24, '2024-08-31', 530.00, 'Completado', 4),
(25, '2024-09-14', 118.50, 'Enviado', 5),
(26, '2024-10-01', 402.99, 'Pendiente', 6),
(27, '2024-10-11', 150.00, 'Completado', 7),
(28, '2024-10-31', 328.00, 'Completado', 8),
(29, '2024-11-09', 220.45, 'Enviado', 9),
(30, '2024-11-30', 499.90, 'Pendiente', 10);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `producto`
--

CREATE TABLE `producto` (
  `ID_producto` int(11) NOT NULL,
  `nombre` varchar(100) DEFAULT NULL,
  `descripcion` varchar(250) DEFAULT NULL,
  `precio` decimal(10,2) DEFAULT NULL,
  `stock` int(11) DEFAULT NULL,
  `fecha_creacion` date DEFAULT NULL,
  `imagen` varchar(80) DEFAULT NULL,
  `ID_categoria` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `producto`
--

INSERT INTO `producto` (`ID_producto`, `nombre`, `descripcion`, `precio`, `stock`, `fecha_creacion`, `imagen`, `ID_categoria`) VALUES
(26, 'Pnacjan', 'adad', 1.00, 2, '2025-02-19', 'sds', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `ID_usuario` int(11) NOT NULL,
  `DNI` varchar(10) DEFAULT NULL,
  `nombre_usuario` varchar(100) DEFAULT NULL,
  `correo_electronico` varchar(150) NOT NULL,
  `pass` varchar(255) NOT NULL,
  `telf` int(11) DEFAULT NULL,
  `direccion` varchar(150) DEFAULT NULL,
  `nombre_completo` varchar(100) DEFAULT NULL,
  `fecha_registro` date DEFAULT NULL,
  `rol` enum('usuario','admin','','') NOT NULL DEFAULT 'usuario'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`ID_usuario`, `DNI`, `nombre_usuario`, `correo_electronico`, `pass`, `telf`, `direccion`, `nombre_completo`, `fecha_registro`, `rol`) VALUES
(1, '78451236K', 'ikerb', 'ikerb@email.com', '14e1b600b1fd579f47433b88e8d85291', 123456789, 'Kale Nagusia 123', 'Iker Bengoetxea', '2025-02-02', 'usuario'),
(2, '98653274p', 'aintza', 'aintza@email.com', '14e1b600b1fd579f47433b88e8d85291', 987654321, 'Euskal Herria 45', 'Aintzane Zubiri', '2025-02-02', 'usuario'),
(3, '54213687p', 'gorkaa', 'gorkaa@email.com', '14e1b600b1fd579f47433b88e8d85291', 654321987, 'Aldapa 12', 'Gorka Aldaz', '2025-02-02', 'usuario'),
(4, '85214795t', 'maialenl', 'maialenl@email.com', '14e1b600b1fd579f47433b88e8d85291', 111223344, 'Urumea Etorbidea 78', 'Maialen Larrañaga', '2025-02-02', 'usuario'),
(5, '96321457w', 'unaiog', 'unaiog@email.com', '14e1b600b1fd579f47433b88e8d85291', 222334455, 'Donosti Kalea 56', 'Unai Oiarzabal', '2025-02-02', 'usuario'),
(6, '98655487b', 'aneet', 'aneet@email.com', '14e1b600b1fd579f47433b88e8d85291', 333445566, 'Mikel Zarate Plaza 7', 'Ane Etxebarria', '2025-02-02', 'usuario'),
(7, '12457864a', 'anderu', 'anderu@email.com', '14e1b600b1fd579f47433b88e8d85291', 444556677, 'Jauregi Bidea 9', 'Ander Ugalde', '2025-02-02', 'usuario'),
(8, '32549865K', 'itziah', 'itziah@email.com', '14e1b600b1fd579f47433b88e8d85291', 555667788, 'Goikoa Kalea 3', 'Itziar Agirre', '2025-02-02', 'usuario'),
(9, '21545878M', 'jonpa', 'jonpa@email.com', '14e1b600b1fd579f47433b88e8d85291', 666778899, 'Ondarreta Pasealekua 23', 'Jon Patxi', '2025-02-02', 'usuario'),
(10, '72548146J', 'nereai', 'nereai@email.com', '14e1b600b1fd579f47433b88e8d85291', 777889900, 'Hondarribia Kalea 34', 'Nerea Irigoien', '2025-02-02', 'usuario'),
(11, 'DNIEjemplo', 'NombreFalso', 'CorreoFalso', 'PassFalsa', 12345678, 'Direccion falsa', 'Nombre completo', '2025-02-10', 'usuario'),
(12, 'DNIEjemplo', 'NombreFalso', 'CorreoFalso', 'PassFalsa', 12345678, 'Direccion falsa', 'Nombre completo', '2025-02-11', 'usuario'),
(13, '1234578', 'admin', 'admin@gmail.com', 'admin', 12345678, 'direccion del admin', 'admin', NULL, 'usuario');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `categoria`
--
ALTER TABLE `categoria`
  ADD PRIMARY KEY (`ID_categoria`);

--
-- Indices de la tabla `detalle_pedido`
--
ALTER TABLE `detalle_pedido`
  ADD PRIMARY KEY (`ID_detalle`),
  ADD KEY `ID_producto` (`ID_producto`),
  ADD KEY `ID_pedido` (`ID_pedido`);

--
-- Indices de la tabla `pedido`
--
ALTER TABLE `pedido`
  ADD PRIMARY KEY (`ID_pedido`),
  ADD KEY `ID_usuario` (`ID_usuario`);

--
-- Indices de la tabla `producto`
--
ALTER TABLE `producto`
  ADD PRIMARY KEY (`ID_producto`),
  ADD KEY `ID_categoria` (`ID_categoria`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`ID_usuario`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `categoria`
--
ALTER TABLE `categoria`
  MODIFY `ID_categoria` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `detalle_pedido`
--
ALTER TABLE `detalle_pedido`
  MODIFY `ID_detalle` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=65;

--
-- AUTO_INCREMENT de la tabla `pedido`
--
ALTER TABLE `pedido`
  MODIFY `ID_pedido` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=31;

--
-- AUTO_INCREMENT de la tabla `producto`
--
ALTER TABLE `producto`
  MODIFY `ID_producto` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=27;

--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `ID_usuario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `detalle_pedido`
--
ALTER TABLE `detalle_pedido`
  ADD CONSTRAINT `detalle_pedido_ibfk_1` FOREIGN KEY (`ID_producto`) REFERENCES `producto` (`ID_producto`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `detalle_pedido_ibfk_2` FOREIGN KEY (`ID_pedido`) REFERENCES `pedido` (`ID_pedido`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `pedido`
--
ALTER TABLE `pedido`
  ADD CONSTRAINT `pedido_ibfk_1` FOREIGN KEY (`ID_usuario`) REFERENCES `usuario` (`ID_usuario`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `producto`
--
ALTER TABLE `producto`
  ADD CONSTRAINT `producto_ibfk_1` FOREIGN KEY (`ID_categoria`) REFERENCES `categoria` (`ID_categoria`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
