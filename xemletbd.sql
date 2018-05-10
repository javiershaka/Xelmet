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
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES (1,'Francisco Reyes','6222277534','Guaymas monte',1),(17,'Javier Peña','6222277534','Periferico 81 las colinas',5),(18,'Jose Luis Cota','6451564654','Las plazas no 31',1),(19,'Diego Mexia','6222345678','La cantera ',10),(20,'Jaime Escobar','6221503570','Guaymas monte norte a1',5),(21,'Blanca Ramirez','6221588984','Las palmas no 31',1),(22,'Luis Manuel Godoy','6552277534','colonia popular',8),(23,'Cristian Leyva','6111155478','La cantera',9);
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
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `factura`
--

LOCK TABLES `factura` WRITE;
/*!40000 ALTER TABLE `factura` DISABLE KEYS */;
INSERT INTO `factura` VALUES (10,1,'paco2awdadaa','Marzo/2016',16,0,1,1.00,15.00,16.00),(11,1,'Francisco Reyes','Febrero/2018',8,3,4,600.00,0.00,600.00),(12,1,'Francisco Reyes','Marzo/2018',52,3,14,600.00,4.00,604.00),(13,19,'Diego Mexia','Abril/2018',20,0,4,200.00,5.00,205.00),(14,20,'Jaime Escobar','Abril/2018',8,0,2,200.00,0.00,200.00);
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
  KEY `FK_llamadas_idx` (`idReferencial`)
) ENGINE=InnoDB AUTO_INCREMENT=86 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `llamada`
--

LOCK TABLES `llamada` WRITE;
/*!40000 ALTER TABLE `llamada` DISABLE KEYS */;
INSERT INTO `llamada` VALUES (34,'622222222','MOVIL','16','3/Marzo/2016',1),(35,'622227534','MOVIL','4','3/Abril/2016',17),(36,'6222277534','MOVIL','14','3/Febrero/2016',17),(37,'6222277555','MOVIL','4','3/Marzo/2018',1),(38,'6222277888','MOVIL','6','4/Marzo/2018',1),(39,'6222277897','MOVIL','4','4/Marzo/2018',1),(40,'6222277897','MOVIL','4','4/Marzo/2018',1),(41,'6222277897','MOVIL','4','4/Marzo/2018',1),(42,'6222977897','MOVIL','8','4/Febrero/2018',1),(43,'6222288897','MOVIL','2','4/Marzo/2018',1),(44,'6222277897','MOVIL','6','4/Marzo/2018',1),(45,'6211277897','MOVIL','9','4/Marzo/2018',1),(46,'6211277897','MOVIL','4','4/Marzo/2018',1),(47,'6211177897','MOVIL','5','4/Marzo/2018',1),(48,'6222277897','MOVIL','4','4/Marzo/2018',17),(49,'6222977897','MOVIL','8','4/Febrero/2018',17),(50,'6222288897','MOVIL','2','4/Febrero/2018',17),(51,'6222277897','MOVIL','6','4/Febrero/2018',17),(52,'6211277897','MOVIL','9','4/Marzo/2018',17),(53,'6211277897','MOVIL','4','4/Marzo/2018',1),(54,'6211177897','MOVIL','5','4/Marzo/2018',17),(55,'222277897','FIJA','4','4/Marzo/2018',1),(56,'222977897','FIJA','8','4/Febrero/2018',1),(57,'222288897','FIJA','2','4/Febrero/2018',1),(58,'222277897','FIJA','6','4/Febrero/2018',1),(59,'211277897','FIJA','9','4/Marzo/2018',1),(60,'211277897','FIJA','4','4/Marzo/2018',1),(61,'211177897','MOVIL','5','4/Marzo/2018',17),(62,'222277897','FIJA','4','4/Marzo/2018',17),(63,'222977897','FIJA','8','4/Febrero/2018',17),(64,'222288897','FIJA','2','4/Febrero/2018',17),(65,'222277897','FIJA','6','4/Febrero/2018',17),(66,'211277897','FIJA','9','4/Marzo/2018',17),(67,'211277897','FIJA','4','4/Marzo/2018',17),(68,'211177897','MOVIL','5','4/Marzo/2018',17),(69,'222277897','FIJA','4','4/Marzo/2018',18),(70,'222977897','FIJA','8','4/Febrero/2018',18),(71,'222288897','FIJA','2','4/Febrero/2018',18),(72,'222277897','FIJA','6','4/Febrero/2018',18),(73,'211277897','FIJA','9','4/Marzo/2018',18),(74,'211277897','FIJA','4','4/Marzo/2018',18),(75,'211177897','MOVIL','5','4/Marzo/2018',18),(76,'6822277897','MOVIL','4','4/Abril/2018',19),(77,'6822977897','MOVIL','8','4/Abril/2018',19),(78,'6822288897','MOVIL','2','4/Abril/2018',19),(79,'6822277897','MOVIL','6','4/Abril/2018',19),(80,'6281277897','MOVIL','9','4/Marzo/2018',19),(81,'6811277897','MOVIL','4','4/Marzo/2018',19),(82,'211177897','MOVIL','5','4/Marzo/2018',19),(83,'22222244','FIJA','5','2/Abril/2016',19),(84,'6221113092','MOVIL','5','9/Abril/2018',20),(85,'6224567834','MOVIL','3','3/Abril/2018',20);
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
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `paquete`
--

LOCK TABLES `paquete` WRITE;
/*!40000 ALTER TABLE `paquete` DISABLE KEYS */;
INSERT INTO `paquete` VALUES (1,'Paquete Sin limites',50,10,600.00,15,2),(5,'Paquete Codo',30,5,200.00,10,1),(8,'Paquete malaleño',150,15,800.00,32,3),(9,'Paquete sinamigos',20,5,150.00,5,1),(10,'Paquete solo amigos',15,15,200.00,25,1);
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

-- Dump completed on 2018-05-09 18:37:24
