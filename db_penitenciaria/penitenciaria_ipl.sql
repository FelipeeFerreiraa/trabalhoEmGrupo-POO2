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
-- Table structure for table `ipl`
--

DROP TABLE IF EXISTS `ipl`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ipl` (
  `idipl` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(90) NOT NULL,
  `cpf` varchar(45) NOT NULL,
  `crime` int NOT NULL,
  `parentesco` int NOT NULL,
  `refeicao` int NOT NULL,
  `policial` int NOT NULL,
  PRIMARY KEY (`idipl`),
  KEY `ipl_crimes_idx` (`crime`),
  KEY `ipl_parentesco_idx` (`parentesco`),
  KEY `ipl_refeicao_idx` (`refeicao`),
  KEY `ipl_policial_idx` (`policial`),
  CONSTRAINT `ipl_crimes` FOREIGN KEY (`crime`) REFERENCES `crimes` (`idcrimes`),
  CONSTRAINT `ipl_parentesco` FOREIGN KEY (`parentesco`) REFERENCES `visitas` (`idvisitas`),
  CONSTRAINT `ipl_policial` FOREIGN KEY (`policial`) REFERENCES `policialpenal` (`idpolicialPenal`),
  CONSTRAINT `ipl_refeicao` FOREIGN KEY (`refeicao`) REFERENCES `refeicao` (`idrefeicao`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ipl`
--

LOCK TABLES `ipl` WRITE;
/*!40000 ALTER TABLE `ipl` DISABLE KEYS */;
INSERT INTO `ipl` VALUES (1,'Jack Estripador','111.111.111-11',1,1,1,1),(6,'Beraldo soilva','333.333.333-33',3,3,5,12);
/*!40000 ALTER TABLE `ipl` ENABLE KEYS */;
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
