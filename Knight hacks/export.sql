-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: sports_cars
-- ------------------------------------------------------
-- Server version	8.1.0

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
-- Table structure for table `cars`
--

DROP TABLE IF EXISTS `cars`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cars` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `make` varchar(30) DEFAULT NULL,
  `model` varchar(30) DEFAULT NULL,
  `color` varchar(30) DEFAULT NULL,
  `makeyear` int DEFAULT NULL,
  `cost` int DEFAULT NULL,
  `miles` int DEFAULT NULL,
  `transmission` varchar(30) DEFAULT NULL,
  `engine` varchar(4) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=82 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cars`
--

LOCK TABLES `cars` WRITE;
/*!40000 ALTER TABLE `cars` DISABLE KEYS */;
INSERT INTO `cars` VALUES (34,'Ford','Mustang','Black',2006,12000,75000,'Automatic','V8'),(36,'BMW','M5','Jet Black',2020,90000,2000,'Automatic','V10'),(37,'Chevrolet','Corvette','Orange',2015,35000,50000,'Manual','V8'),(38,'Chevrolet','Corvette','Black',2019,75000,40000,'Manual','V8'),(39,'Porsche','911','Cherry Red',2023,100000,50,'Manual','F6'),(40,'Porsche','911','White',2022,100000,100,'Manual','F6'),(41,'Porsche','911','Cherry Red',2023,100000,75,'Manual','F6'),(42,'BMW','M5','Blue',2022,92000,15000,'Automatic','V10'),(45,'Audi','TT','Yellow',2023,50000,3000,'Automatic','i4'),(49,'Audi','R8','Black',2023,150000,40,'Automatic','V8'),(50,'Audi','R8','Red',2023,150000,3000,'Automatic','V8'),(51,'Chevrolet','Camaro','Red',2011,15000,150000,'Automatic','V8'),(52,'Chevrolet','Camaro','White',2024,100000,0,'Manual','V8'),(53,'Chevrolet','Camaro','Gray',1997,2500,200000,'Manual','V8'),(54,'Toyota','Supra','Jet Black',2020,55000,5000,'Manual','i6'),(55,'Toyota','Supra','Jet Black',2020,55000,5000,'Manual','i6'),(56,'Toyota','Supra','Gray',2024,55000,0,'Manual','i6'),(57,'Toyota','Supra','Orange',2024,55000,0,'Manual','i6'),(58,'Toyota','Supra','Red',2024,55000,0,'Manual','i6'),(59,'Toyota','Supra','Blue',2024,55000,0,'Manual','i6'),(60,'Ford','Mustang','Black',2001,35000,2000,'Automatic','V8'),(61,'Madza','Miata','Red',2004,20000,50000,'Manual','i4'),(62,'BMW','M5','Green',2024,90000,0,'Automatic','V10'),(63,'Chevrolet','Corvette','Orange',2015,35000,50000,'Manual','V8'),(64,'Chevrolet','Corvette','Black',2019,75000,40000,'Manual','V8'),(65,'Porsche','911','Jet Black',2023,100000,50,'Manual','F6'),(66,'Porsche','911','White',2022,100000,100,'Manual','F6'),(69,'Ford','GT','Black',1995,75000,5000,'Automatic','V8'),(70,'Madza','Miata','Red',1994,25000,1000,'Manual','i4'),(71,'Porsche','911','Sky Blue',2023,100000,75,'Manual','F6'),(72,'BMW','M5','Blue',2022,92000,15000,'Automatic','V10'),(73,'Ford','Mustang','Black',2006,12000,75000,'Automatic','V8'),(74,'Madza','Miata','Red',1994,25000,1000,'Manual','i4'),(75,'BMW','M5','Jet Black',2020,90000,2000,'Automatic','V10'),(76,'Chevrolet','Corvette','Orange',2015,35000,50000,'Manual','V8'),(77,'Chevrolet','Corvette','Black',2019,75000,40000,'Manual','V8'),(78,'Porsche','911','Cherry Red',2023,100000,50,'Manual','F6'),(79,'Porsche','911','White',2022,100000,100,'Manual','F6'),(80,'Porsche','911','Cherry Red',2023,100000,75,'Manual','F6'),(81,'BMW','M5','Blue',2022,92000,15000,'Automatic','V10');
/*!40000 ALTER TABLE `cars` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-10-08 10:46:58
