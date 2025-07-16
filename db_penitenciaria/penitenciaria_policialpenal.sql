-- MySQL dump 10.13  Distrib 8.0.41, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: penitenciaria
-- ------------------------------------------------------
-- Server version	9.2.0

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
-- Table structure for table `policialpenal`
--

DROP TABLE IF EXISTS `policialpenal`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `policialpenal` (
  `idpolicialPenal` int NOT NULL AUTO_INCREMENT,
  `pp_nome` varchar(90) NOT NULL,
  `pp_cpf` varchar(45) NOT NULL,
  `pp_turno_entrada` varchar(45) NOT NULL,
  `pp_turno_saida` varchar(45) NOT NULL,
  `status` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`idpolicialPenal`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `policialpenal`
--

LOCK TABLES `policialpenal` WRITE;
/*!40000 ALTER TABLE `policialpenal` DISABLE KEYS */;
INSERT INTO `policialpenal` VALUES (1,'Capitão nascimento','123.456.789-10','06:00','17;00',0),(2,'Braga','987.654.321-00','18:00','07:00',0),(6,'Felipe Domingues','121.212.212-12','77777','88888',0),(7,'Felipe Ferreira','121.111.222-99','55555','22333',0),(8,'Andre Domingues Matias','999.999.999-99','99999','99999',1),(9,'domingues','333.333.333-33','22222','33333',1),(10,'0','0','0','0',0),(11,'leonardo','000.000.000-00','11111','22222',0),(12,'irineu domingues','222.222.222-22','22336','11223',1),(13,'arnaldo domingues','212.121.212-12','77441','88775',1),(14,'beraldo Domingues','888.888.888-88','99556','99665',1);
/*!40000 ALTER TABLE `policialpenal` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-07-16  7:27:39
