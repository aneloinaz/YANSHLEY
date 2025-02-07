-- MySQL dump 10.13  Distrib 8.0.41, for Win64 (x86_64)
--
-- Host: localhost    Database: ususrbiltex_db
-- ------------------------------------------------------
-- Server version	8.0.40

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `pedido`
--

DROP TABLE IF EXISTS `pedido`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pedido` (
  `ID_pedido` int NOT NULL,
  `fecha_pedido` date DEFAULT NULL,
  `monto_total` float DEFAULT NULL,
  `estado` varchar(100) DEFAULT NULL,
  `ID_usuario` int DEFAULT NULL,
  PRIMARY KEY (`ID_pedido`),
  KEY `Pedido` (`ID_usuario`),
  CONSTRAINT `pedido_ibfk_1` FOREIGN KEY (`ID_usuario`) REFERENCES `usuario` (`ID_usuario`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pedido`
--

LOCK TABLES `pedido` WRITE;
/*!40000 ALTER TABLE `pedido` DISABLE KEYS */;
INSERT INTO `pedido` VALUES (1,'2025-01-31',89.97,'Completado',1),(2,'2025-02-01',44.98,'Pendiente',2),(3,'2025-02-02',29.99,'Enviado',3),(4,'2025-02-03',99.99,'Completado',4),(5,'2025-02-04',149.99,'Enviado',5),(6,'2025-02-05',79.99,'Pendiente',6),(7,'2025-02-06',109.99,'Completado',7),(8,'2025-02-07',59.99,'Enviado',8),(9,'2025-02-08',89.97,'Pendiente',9),(10,'2025-02-09',74.99,'Completado',10),(11,'2025-02-06',109.99,'Completado',7),(12,'2025-02-07',59.99,'Enviado',8),(13,'2025-01-08',89.97,'Pendiente',9),(14,'2025-01-09',74.99,'Completado',10),(15,'2025-01-10',520.95,'Completado',1),(16,'2025-01-11',610.75,'Enviado',3),(17,'2024-12-12',545.5,'Pendiente',5),(18,'2024-12-14',399.99,'Completado',1),(19,'2025-02-15',270.5,'Pendiente',1),(20,'2024-12-16',130,'Enviado',1),(21,'2024-07-31',215.5,'Completado',1),(22,'2024-08-04',123.99,'Enviado',2),(23,'2024-08-09',345.75,'Pendiente',3),(24,'2024-08-31',530,'Completado',4),(25,'2024-09-14',118.5,'Enviado',5),(26,'2024-10-01',402.99,'Pendiente',6),(27,'2024-10-11',150,'Completado',7),(28,'2024-10-31',328,'Completado',8),(29,'2024-11-09',220.45,'Enviado',9),(30,'2024-11-30',499.9,'Pendiente',10);
/*!40000 ALTER TABLE `pedido` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-02-07 13:19:57
