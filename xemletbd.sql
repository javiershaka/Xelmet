CREATE DATABASE  IF NOT EXISTS `xemletbd` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `xemletbd`;
-- MySQL dump 10.13  Distrib 5.6.24, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: xemletbd
-- ------------------------------------------------------
-- Server version	5.6.26-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cliente` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) DEFAULT NULL,
  `numeroTelefonico` varchar(45) DEFAULT NULL,
  `domicilio` varchar(45) DEFAULT NULL,
  `paquete` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_cliente_to_paquete_idx` (`paquete`),
  CONSTRAINT `FK_cliente_paquete` FOREIGN KEY (`paquete`) REFERENCES `paquete` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES (1,'Juanca','6222277534','Periferico 81',1),(15,'9','9','9',1);
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `factura`
--

DROP TABLE IF EXISTS `factura`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `factura` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idCliente` int(11) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `fecha` varchar(45) DEFAULT NULL,
  `llamadasMovil` int(11) DEFAULT NULL,
  `llamadasFijas` int(11) DEFAULT NULL,
  `llamadasRealizadas` int(11) NOT NULL,
  `costoPaquete` decimal(6,2) NOT NULL,
  `cargosAdicionales` decimal(6,2) DEFAULT NULL,
  `total` decimal(6,2) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_factura_cliente_idx` (`idCliente`),
  CONSTRAINT `FK_factura_cliente` FOREIGN KEY (`idCliente`) REFERENCES `cliente` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `factura`
--

LOCK TABLES `factura` WRITE;
/*!40000 ALTER TABLE `factura` DISABLE KEYS */;
INSERT INTO `factura` VALUES (1,1,'1','1',1,1,1,1.00,1.00,1.00),(5,15,'9','Febrero/2016',62,1,4,1.00,61.00,62.00),(6,15,'9','Febrero/2016',62,1,4,1.00,61.00,62.00),(7,15,'9','Febrero/2016',62,1,4,1.00,61.00,62.00);
/*!40000 ALTER TABLE `factura` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `llamada`
--

DROP TABLE IF EXISTS `llamada`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `llamada` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `receptor` varchar(45) DEFAULT NULL,
  `tipoLlamada` varchar(45) DEFAULT NULL,
  `duracionMinutos` varchar(45) DEFAULT NULL,
  `fecha` varchar(45) DEFAULT NULL,
  `idReferencial` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_llamadas_idx` (`idReferencial`),
  CONSTRAINT `FK_llamadas` FOREIGN KEY (`idReferencial`) REFERENCES `cliente` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `llamada`
--

LOCK TABLES `llamada` WRITE;
/*!40000 ALTER TABLE `llamada` DISABLE KEYS */;
INSERT INTO `llamada` VALUES (29,'6222277534','MOVIL','14','4/Febrero/2016',15),(30,'62264564','FIJA','4','3/Febrero/2016',15),(31,'6222277534','MOVIL','16','3/Febrero/2016',15),(32,'622222222','MOVIL','32','3/Febrero/2016',15);
/*!40000 ALTER TABLE `llamada` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `paquete`
--

DROP TABLE IF EXISTS `paquete`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `paquete` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) DEFAULT NULL,
  `minutosACelular` int(11) DEFAULT NULL,
  `llamadasFijas` int(11) DEFAULT NULL,
  `precio` decimal(6,2) DEFAULT NULL,
  `costoAdicionalPorLlamada` int(11) DEFAULT NULL,
  `costoAdicionalPorMinitos` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `paquete`
--

LOCK TABLES `paquete` WRITE;
/*!40000 ALTER TABLE `paquete` DISABLE KEYS */;
INSERT INTO `paquete` VALUES (1,'Paquete Sin limites',1,1,1.00,1,1),(5,'8',8,8,8.00,8,8),(6,'PaqueteAlcance',4,123,123.00,21312,12),(7,'9',9,9,9.00,9,9);
/*!40000 ALTER TABLE `paquete` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'xemletbd'
--

--
-- Dumping routines for database 'xemletbd'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-05-08 16:52:59
