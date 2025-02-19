-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 19-02-2025 a las 18:54:57
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

--
-- Volcado de datos para la tabla `detalle_pedido`
--

INSERT INTO `detalle_pedido` (`ID_detalle`, `ID_producto`, `ID_pedido`, `precio`, `cantidad`) VALUES
(1, 1, 1, 39.99, 2),
(2, 3, 1, 14.99, 1),
(3, 2, 2, 42.99, 1),
(4, 4, 2, 14.99, 1),
(5, 5, 3, 29.99, 1),
(6, 6, 4, 29.99, 2),
(7, 7, 4, 27.99, 1),
(8, 8, 5, 19.99, 3),
(9, 9, 5, 22.99, 2),
(10, 10, 6, 14.99, 1),
(11, 11, 6, 27.99, 1),
(12, 12, 6, 29.99, 1),
(13, 1, 7, 39.99, 1),
(14, 2, 7, 42.99, 1),
(15, 3, 7, 27.99, 1),
(16, 4, 8, 59.99, 1),
(17, 5, 9, 39.99, 2),
(18, 6, 10, 74.99, 1),
(19, 1, 7, 39.99, 1),
(20, 2, 7, 42.99, 1),
(21, 3, 7, 27.99, 1),
(22, 4, 8, 59.99, 1),
(23, 5, 9, 39.99, 2),
(24, 6, 10, 74.99, 1),
(25, 1, 11, 39.99, 5),
(26, 3, 11, 34.99, 5),
(27, 5, 11, 39.99, 2),
(28, 6, 12, 74.99, 8),
(29, 9, 12, 19.99, 6),
(30, 10, 12, 14.99, 4),
(31, 11, 13, 27.99, 7),
(32, 12, 13, 29.99, 6),
(33, 14, 13, 49.99, 5),
(34, 3, 14, 34.99, 2),
(35, 7, 14, 29.99, 1),
(36, 13, 14, 24.99, 3),
(37, 5, 15, 39.99, 3),
(38, 10, 15, 19.99, 2),
(39, 4, 16, 59.99, 1),
(40, 6, 16, 74.99, 2),
(41, 12, 17, 19.99, 3),
(42, 9, 17, 22.99, 2),
(43, 1, 18, 39.99, 3),
(44, 4, 18, 59.99, 2),
(45, 6, 18, 74.99, 1),
(46, 7, 19, 29.99, 1),
(47, 9, 19, 19.99, 3),
(48, 12, 19, 27.99, 2),
(49, 2, 20, 42.99, 5),
(50, 8, 20, 34.99, 2),
(51, 10, 20, 14.99, 1),
(52, 1, 21, 39.99, 4),
(53, 14, 21, 49.99, 1),
(54, 5, 22, 39.99, 3),
(55, 3, 22, 34.99, 2),
(56, 12, 23, 14.99, 1),
(57, 13, 23, 24.99, 2),
(58, 8, 24, 32.99, 4),
(59, 16, 24, 44.99, 3),
(60, 2, 25, 42.99, 2),
(61, 6, 25, 74.99, 1),
(62, 14, 25, 49.99, 2),
(63, 11, 26, 27.99, 2),
(64, 10, 26, 14.99, 3);

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
(1, 'Pantalón vaquero', 'Pantalón de mezclilla azul', 39.99, 20, '2025-02-02', 'https://upload.wikimedia.org/wikipedia/commons/9/92/Denimjeans2.JPG', 1),
(2, 'Pantalón cargo', 'Pantalón cómodo con bolsillos adicionales', 42.99, 25, '2025-02-02', 'https://upload.wikimedia.org/wikipedia/commons/c/cd/Cargo_pants_001.jpg', 1),
(3, 'Pantalón deportivo', 'Pantalón ajustado para hacer ejercicio', 34.99, 30, '2025-02-02', 'https://upload.wikimedia.org/wikipedia/commons/8/84/Tracksuit_bottoms.jpg', 1),
(4, 'Pantalón chino', 'Pantalón elegante para ocasiones formales', 44.99, 18, '2025-02-02', 'https://upload.wikimedia.org/wikipedia/commons/3/3e/Chino_pants.jpg', 1),
(5, 'Pantalón de lino', 'Pantalón ligero para el verano', 39.99, 1, '2025-02-02', 'https://upload.wikimedia.org/wikipedia/commons/8/82/Trousers_MET_1978.88.12_F.jp', 1),
(6, 'Sudadera con capucha', 'Sudadera negra con bolsillo delantero', 29.99, 15, '2025-02-02', 'https://upload.wikimedia.org/wikipedia/commons/e/e5/Sudadera_urban.jpg', 2),
(7, 'Sudadera sin capucha', 'Sudadera básica para cualquier ocasión', 27.99, 0, '2025-02-02', 'https://upload.wikimedia.org/wikipedia/commons/e/ea/Jersei-coll-alt.jpg', 2),
(8, 'Sudadera estampada', 'Sudadera con diseño gráfico', 32.99, 10, '2025-02-02', 'hhttps://upload.wikimedia.org/wikipedia/commons/1/16/Dale_of_Norway_sweater.jpg', 2),
(9, 'Sudadera deportiva', 'Sudadera ajustada para entrenar', 34.99, 12, '2025-02-02', 'https://upload.wikimedia.org/wikipedia/commons/6/6d/Windjack_-_Windbreaker.jpg', 2),
(10, 'Camiseta blanca', 'Camiseta de algodón blanco', 14.99, 30, '2025-02-02', 'https://upload.wikimedia.org/wikipedia/commons/c/cd/T-Shirt_Wikipedia_white.jpg', 3),
(11, 'Camiseta negra', 'Camiseta básica de color negro', 14.99, 25, '2025-02-02', 'https://upload.wikimedia.org/wikipedia/commons/3/37/T-Shirt_Wikipedia_black.jpg', 3),
(12, 'Camisa Moderna', 'Camiseta con diseño moderno', 19.99, 2, '2025-02-02', 'https://upload.wikimedia.org/wikipedia/commons/c/c9/New-style-T-shirt-00455657.j', 3),
(13, 'Camiseta de manga larga', 'Camiseta cómoda para clima frío', 22.99, 18, '2025-02-02', 'https://fakestoreapi.com/img/71YXzeOuslL._AC_UY879_.jpg', 3),
(14, 'Camisa de lino', 'Camisa ligera ideal para verano', 24.99, 10, '2025-02-02', 'https://upload.wikimedia.org/wikipedia/commons/6/68/Shirt%2C_man%27s_%28AM_2016.', 4),
(15, 'Camisa a cuadros', 'Camisa de estilo casual', 27.99, 20, '2025-02-02', 'https://upload.wikimedia.org/wikipedia/commons/2/2c/Check_shirt.jpg', 4),
(16, 'Camisa formal', 'Camisa para ocasiones elegantes', 29.99, 18, '2025-02-02', 'https://upload.wikimedia.org/wikipedia/commons/0/09/Shirt%2C_men%27s_%28AM_2015.', 4),
(17, 'Camisa hawaiana', 'Camisa fresca con estampado tropical', 24.99, 14, '2025-02-02', 'https://upload.wikimedia.org/wikipedia/commons/3/3c/Guiness_hilo_hattie_aloha_sh', 4),
(18, 'Chaqueta de cuero', 'Chaqueta de cuero sintético', 59.99, 3, '2025-02-02', 'https://upload.wikimedia.org/wikipedia/commons/b/b8/Leather_Jacket_%285101116208', 5),
(19, 'Chaqueta de mezclilla', 'Chaqueta estilo denim', 49.99, 8, '2025-02-02', 'https://upload.wikimedia.org/wikipedia/commons/1/10/Denim_Jacket_%2851079649933%', 5),
(20, 'Chaqueta acolchada', 'Chaqueta para clima frío', 69.99, 12, '2025-02-02', 'https://upload.wikimedia.org/wikipedia/commons/d/df/MA-1_Jacket_in_petrol.jpg', 5),
(21, 'Chaqueta impermeable', 'Chaqueta para días de lluvia', 74.99, 0, '2025-02-02', 'https://upload.wikimedia.org/wikipedia/commons/4/46/Windbreaker_Jacket%2C_Hood_O', 5);

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
  MODIFY `ID_producto` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;

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
