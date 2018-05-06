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
  CONSTRAINT `FK_cliente_to_paquete` FOREIGN KEY (`paquete`) REFERENCES `paquete` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES (1,'Javier','6222277534','Periferico',1),(2,'Luis','6225456456','Las colinas',3),(3,'Gabriel Arce luna','6552277897','Empalme rifa',2),(4,'Fernando Gallego','6452277974','Piedron',1),(5,'Fernanda','8544005446','Marianas',1);
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
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
  `costo` decimal(6,2) DEFAULT NULL,
  `fecha` varchar(45) DEFAULT NULL,
  `idReferencial` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_llamadas_idx` (`idReferencial`),
  CONSTRAINT `FK_llamadas` FOREIGN KEY (`idReferencial`) REFERENCES `cliente` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `llamada`
--

LOCK TABLES `llamada` WRITE;
/*!40000 ALTER TABLE `llamada` DISABLE KEYS */;
INSERT INTO `llamada` VALUES (1,'6222222222','Movil','1',1.00,'25/01/2016',1),(2,'6884644644','Fija','1',1.00,'25/01/2016',1),(3,'6222277894','MOVIL','1',1.00,'25/01/2016',1),(8,'6222277872','movil','50',60.00,'25/01/2016',2),(9,'6222222278','FIJA','40',30.00,'25/01/2016',1),(10,'6789844447','MOVIL','50',40.00,'25/01/2016',2),(11,'6546546546','FIJA','1',10.00,'25/01/2016',3),(13,'6546546588','fija','1',10.00,'20/05/2015',4),(14,'6546546599','movil','3',1.00,'25/01/2016',5),(15,'6546546577','movil','4',1.00,'25/01/2016',5);
/*!40000 ALTER TABLE `llamada` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `paquete`
--

DROP TABLE IF EXISTS `paquete`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `paquete` (
  `id` int(11) NOT NULL,
  `nombre` varchar(45) DEFAULT NULL,
  `minutosACelular` int(11) DEFAULT NULL,
  `llamadasFijas` int(11) DEFAULT NULL,
  `precio` decimal(6,2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `paquete`
--

LOCK TABLES `paquete` WRITE;
/*!40000 ALTER TABLE `paquete` DISABLE KEYS */;
INSERT INTO `paquete` VALUES (1,'Paquete sin limites',100,10,500.00),(2,'Paquetealcance',100,8,400.00),(3,'Paquete paytowin',150,11,600.00);
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

-- Dump completed on 2018-05-05 18:23:41
