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
-- Table structure for table `detalle_pedido`
--

DROP TABLE IF EXISTS `detalle_pedido`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `detalle_pedido` (
  `ID_detalle` int NOT NULL,
  `ID_producto` int DEFAULT NULL,
  `ID_pedido` int DEFAULT NULL,
  `precio` float DEFAULT NULL,
  `cantidad` int DEFAULT NULL,
  PRIMARY KEY (`ID_detalle`),
  KEY `Detalle_pedido` (`ID_producto`),
  KEY `fk_detalle_pedido` (`ID_pedido`),
  CONSTRAINT `detalle_pedido_ibfk_1` FOREIGN KEY (`ID_producto`) REFERENCES `producto` (`ID_producto`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_detalle_pedido` FOREIGN KEY (`ID_pedido`) REFERENCES `pedido` (`ID_pedido`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detalle_pedido`
--

LOCK TABLES `detalle_pedido` WRITE;
/*!40000 ALTER TABLE `detalle_pedido` DISABLE KEYS */;
INSERT INTO `detalle_pedido` VALUES (1,1,1,2,40),(2,1,3,1,15),(3,2,2,1,43),(4,2,4,1,15),(5,3,5,1,30),(6,4,6,2,30),(7,4,7,1,28),(8,5,8,3,20),(9,5,9,2,23),(10,6,10,1,15),(11,6,11,1,28),(12,6,12,1,30),(13,7,1,1,40),(14,7,2,1,43),(15,7,3,1,28),(16,8,4,1,60),(17,9,5,2,40),(18,10,6,1,75),(19,7,1,1,40),(20,7,2,1,43),(21,7,3,1,28),(22,8,4,1,60),(23,9,5,2,40),(24,10,6,1,75),(25,11,1,5,40),(26,11,3,5,35),(27,11,5,2,40),(28,12,6,8,75),(29,12,9,6,20),(30,12,10,4,15),(31,13,11,7,28),(32,13,12,6,30),(33,13,14,5,50),(34,14,3,2,35),(35,14,7,1,30),(36,14,13,3,25),(37,15,5,3,40),(38,15,10,2,20),(39,16,4,1,60),(40,16,6,2,75),(41,17,12,3,20),(42,17,9,2,23),(43,18,1,3,40),(44,18,4,2,60),(45,18,6,1,75),(46,19,7,1,30),(47,19,9,3,20),(48,19,12,2,28),(49,20,2,5,43),(50,20,8,2,35),(51,20,10,1,15),(52,21,1,4,40),(53,21,14,1,50),(54,22,5,3,40),(55,22,3,2,35),(56,23,12,1,15),(57,23,13,2,25),(58,24,8,4,33),(59,24,16,3,45),(60,25,2,2,43),(61,25,6,1,75),(62,25,14,2,50),(63,26,11,2,28),(64,26,10,3,15);
/*!40000 ALTER TABLE `detalle_pedido` ENABLE KEYS */;
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
