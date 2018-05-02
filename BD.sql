-- MySQL dump 10.13  Distrib 5.6.24, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: xelmetbd
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
  `idcliente` int(11) NOT NULL AUTO_INCREMENT,
  `numeroTelefonico` varchar(15) DEFAULT NULL,
  `nombre` varchar(150) DEFAULT NULL,
  `domicilio` varchar(150) DEFAULT NULL,
  `idpaquete` int(11) DEFAULT NULL,
  `idllamada` int(11) DEFAULT NULL,
  PRIMARY KEY (`idcliente`),
  KEY `FK_idpaquete_idx` (`idpaquete`),
  KEY `FK_idllamada_idx` (`idllamada`),
  CONSTRAINT `FK_idllamada` FOREIGN KEY (`idllamada`) REFERENCES `llamada` (`idllamada`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_idpaquete` FOREIGN KEY (`idpaquete`) REFERENCES `paquete` (`idpaquete`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `llamada`
--

DROP TABLE IF EXISTS `llamada`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `llamada` (
  `idllamada` int(11) NOT NULL AUTO_INCREMENT,
  `receptor` varchar(45) DEFAULT NULL,
  `tipoLlamada` int(11) DEFAULT NULL,
  `duracion` int(11) DEFAULT NULL,
  `fecha` varchar(45) DEFAULT NULL,
  `costo` decimal(4,2) DEFAULT NULL,
  PRIMARY KEY (`idllamada`),
  KEY `FK_tipollamada_idx` (`tipoLlamada`),
  CONSTRAINT `FK_tipollamada` FOREIGN KEY (`tipoLlamada`) REFERENCES `tipollamada` (`idtipollamada`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `llamada`
--

LOCK TABLES `llamada` WRITE;
/*!40000 ALTER TABLE `llamada` DISABLE KEYS */;
/*!40000 ALTER TABLE `llamada` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `paquete`
--

DROP TABLE IF EXISTS `paquete`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `paquete` (
  `idpaquete` int(11) NOT NULL AUTO_INCREMENT,
  `minutosCelular` int(11) DEFAULT NULL,
  `precio` decimal(4,2) DEFAULT NULL,
  `llamadasFijas` int(11) DEFAULT NULL,
  PRIMARY KEY (`idpaquete`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `paquete`
--

LOCK TABLES `paquete` WRITE;
/*!40000 ALTER TABLE `paquete` DISABLE KEYS */;
/*!40000 ALTER TABLE `paquete` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `relacioncliente`
--

DROP TABLE IF EXISTS `relacioncliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `relacioncliente` (
  `idcliente` int(11) DEFAULT NULL,
  `idpaquete` int(11) DEFAULT NULL,
  KEY `FK_Relacion_cliente_idx` (`idcliente`),
  KEY `FK_Relacion_paquete_idx` (`idpaquete`),
  CONSTRAINT `FK_Relacion_cliente` FOREIGN KEY (`idcliente`) REFERENCES `cliente` (`idcliente`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_Relacion_paquete` FOREIGN KEY (`idpaquete`) REFERENCES `paquete` (`idpaquete`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `relacioncliente`
--

LOCK TABLES `relacioncliente` WRITE;
/*!40000 ALTER TABLE `relacioncliente` DISABLE KEYS */;
/*!40000 ALTER TABLE `relacioncliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `relacionllamada`
--

DROP TABLE IF EXISTS `relacionllamada`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `relacionllamada` (
  `idLlamada` int(11) DEFAULT NULL,
  `idCliente` int(11) DEFAULT NULL,
  KEY `FK_rela_llamada_idx` (`idLlamada`),
  KEY `FK_rela_cliente_idx` (`idCliente`),
  CONSTRAINT `FK_rela_cliente` FOREIGN KEY (`idCliente`) REFERENCES `cliente` (`idcliente`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_rela_llamada` FOREIGN KEY (`idLlamada`) REFERENCES `llamada` (`idllamada`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `relacionllamada`
--

LOCK TABLES `relacionllamada` WRITE;
/*!40000 ALTER TABLE `relacionllamada` DISABLE KEYS */;
/*!40000 ALTER TABLE `relacionllamada` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipollamada`
--

DROP TABLE IF EXISTS `tipollamada`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipollamada` (
  `idtipollamada` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`idtipollamada`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipollamada`
--

LOCK TABLES `tipollamada` WRITE;
/*!40000 ALTER TABLE `tipollamada` DISABLE KEYS */;
/*!40000 ALTER TABLE `tipollamada` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'xelmetbd'
--

--
-- Dumping routines for database 'xelmetbd'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-05-02  1:12:45
