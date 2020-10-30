-- MySQL dump 10.13  Distrib 8.0.22, for macos10.15 (x86_64)
--
-- Host: localhost    Database: ceivi
-- ------------------------------------------------------
-- Server version	8.0.22

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
-- Table structure for table `area_de_negocio`
--

DROP TABLE IF EXISTS `area_de_negocio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `area_de_negocio` (
  `id` bigint NOT NULL,
  `criado_em` datetime(6) DEFAULT NULL,
  `modificado_em` datetime(6) DEFAULT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `usuario_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKoxdbvuat01a318mhd0x0ddjwc` (`usuario_id`),
  CONSTRAINT `FKoxdbvuat01a318mhd0x0ddjwc` FOREIGN KEY (`usuario_id`) REFERENCES `usuario` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `area_de_negocio`
--

LOCK TABLES `area_de_negocio` WRITE;
/*!40000 ALTER TABLE `area_de_negocio` DISABLE KEYS */;
/*!40000 ALTER TABLE `area_de_negocio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `meta`
--

DROP TABLE IF EXISTS `meta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `meta` (
  `id` bigint NOT NULL,
  `criado_em` datetime(6) DEFAULT NULL,
  `modificado_em` datetime(6) DEFAULT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `area_de_negocio_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKf4s7usray0d0651n6egoef64d` (`area_de_negocio_id`),
  CONSTRAINT `FKf4s7usray0d0651n6egoef64d` FOREIGN KEY (`area_de_negocio_id`) REFERENCES `area_de_negocio` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `meta`
--

LOCK TABLES `meta` WRITE;
/*!40000 ALTER TABLE `meta` DISABLE KEYS */;
/*!40000 ALTER TABLE `meta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `plano_de_acao`
--

DROP TABLE IF EXISTS `plano_de_acao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `plano_de_acao` (
  `id` bigint NOT NULL,
  `criado_em` datetime(6) DEFAULT NULL,
  `data_entrega` date DEFAULT NULL,
  `modificado_em` datetime(6) DEFAULT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `meta_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK752m6uodmnqjd1jmwh1ta3fdj` (`meta_id`),
  CONSTRAINT `FK752m6uodmnqjd1jmwh1ta3fdj` FOREIGN KEY (`meta_id`) REFERENCES `meta` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `plano_de_acao`
--

LOCK TABLES `plano_de_acao` WRITE;
/*!40000 ALTER TABLE `plano_de_acao` DISABLE KEYS */;
/*!40000 ALTER TABLE `plano_de_acao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `admin` bit(1) NOT NULL,
  `criado_em` datetime(6) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `modificado_em` datetime(6) DEFAULT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `senha` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-10-30 16:11:02
