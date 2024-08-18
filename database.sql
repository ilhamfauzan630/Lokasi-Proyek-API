-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: lokasi_proyek
-- ------------------------------------------------------
-- Server version	8.0.36

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
-- Table structure for table `lokasi`
--

DROP TABLE IF EXISTS `lokasi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `lokasi` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nama_lokasi` varchar(100) NOT NULL,
  `negara` varchar(100) NOT NULL,
  `provinsi` varchar(100) NOT NULL,
  `kota` varchar(100) NOT NULL,
  `created_at` timestamp NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lokasi`
--

LOCK TABLES `lokasi` WRITE;
/*!40000 ALTER TABLE `lokasi` DISABLE KEYS */;
INSERT INTO `lokasi` VALUES (10,'sukabumi','indonesia','jawa barat','Yogyakarta','2024-08-17 16:28:06'),(13,'kaliurang','indonesia','jawa barat','Yogyakarta','2024-08-18 11:55:04'),(15,'cianjur','indonesia','jawa barat','cianjur','2024-08-18 11:55:30'),(16,'cianjur','indonesia','jawa barat','cianjur','2024-08-18 12:02:21'),(18,'test2','test2','test2','test2','2024-08-18 09:13:56'),(19,'cianjur','indonesia','jawa barat','cianjur','2024-08-18 15:10:44'),(20,'cianjur','indonesia','jawa barat','cianjur','2024-08-18 15:15:43');
/*!40000 ALTER TABLE `lokasi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `proyek`
--

DROP TABLE IF EXISTS `proyek`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `proyek` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nama_proyek` varchar(100) NOT NULL,
  `client` varchar(100) NOT NULL,
  `tgl_mulai` datetime NOT NULL,
  `tgl_selesai` datetime NOT NULL,
  `pimpinan_proyek` varchar(100) NOT NULL,
  `keterangan` text NOT NULL,
  `created_at` timestamp NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `proyek`
--

LOCK TABLES `proyek` WRITE;
/*!40000 ALTER TABLE `proyek` DISABLE KEYS */;
INSERT INTO `proyek` VALUES (1,'Proyek x','Client 1','2024-08-01 10:00:00','2024-12-31 18:00:00','Pimpinan y','Proyek pembangunan','2024-08-17 09:58:19'),(3,'Proyek A','Client XYZ','2024-08-18 00:00:00','2024-08-29 00:00:00','John Doe','Proyek untuk pengembangan sistem','2024-08-17 14:32:48'),(5,'Proyek A','Client XYZ','2024-08-01 10:00:00','2024-12-31 17:00:00','John Doe','Proyek untuk pengembangan sistem','2024-08-17 15:10:30'),(7,'Proyek A','Client XYZ','2024-08-01 10:00:00','2024-12-31 17:00:00','John Doe','Proyek untuk pengembangan sistem','2024-08-17 16:54:28'),(11,'Proyek B','Client XYZ','2024-08-01 10:00:00','2024-12-31 17:00:00','John Doe','Proyek untuk pengembangan sistem','2024-08-18 07:30:23'),(14,'test2','test2','2024-08-18 00:00:00','2024-08-21 00:00:00','test','test','2024-08-18 09:14:26'),(15,'Proyek B','Client XYZ','2024-08-01 10:00:00','2024-12-31 17:00:00','John Doe','Proyek untuk pengembangan sistem','2024-08-18 15:18:32');
/*!40000 ALTER TABLE `proyek` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `proyek_lokasi`
--

DROP TABLE IF EXISTS `proyek_lokasi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `proyek_lokasi` (
  `id` int NOT NULL AUTO_INCREMENT,
  `proyek_id` int DEFAULT NULL,
  `lokasi_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `proyek_id_idx` (`proyek_id`),
  KEY `lokasi_id_idx` (`lokasi_id`),
  CONSTRAINT `lokasi_id` FOREIGN KEY (`lokasi_id`) REFERENCES `lokasi` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `proyek_id` FOREIGN KEY (`proyek_id`) REFERENCES `proyek` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `proyek_lokasi`
--

LOCK TABLES `proyek_lokasi` WRITE;
/*!40000 ALTER TABLE `proyek_lokasi` DISABLE KEYS */;
INSERT INTO `proyek_lokasi` VALUES (17,3,15),(19,14,15),(20,3,15),(21,3,15);
/*!40000 ALTER TABLE `proyek_lokasi` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-08-18 23:04:08
