CREATE DATABASE  IF NOT EXISTS `padaria-java` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `padaria-java`;
-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: padaria-java
-- ------------------------------------------------------
-- Server version	5.7.21-log

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
-- Table structure for table `fornecedor`
--

DROP TABLE IF EXISTS `fornecedor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `fornecedor` (
  `Fornecedor_Id` int(11) NOT NULL AUTO_INCREMENT,
  `CNPJ` varchar(255) DEFAULT NULL,
  `TELEFONE` varchar(255) DEFAULT NULL,
  `ENDERECO` varchar(255) DEFAULT NULL,
  `NOMEFANTASIA` varchar(255) DEFAULT NULL,
  `RAZAOSOCIAL` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`Fornecedor_Id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fornecedor`
--

LOCK TABLES `fornecedor` WRITE;
/*!40000 ALTER TABLE `fornecedor` DISABLE KEYS */;
INSERT INTO `fornecedor` VALUES (2,'32.036.089/0001-32','(11)2323-2323','Rua São José 3241','Cemil','Leites SA'),(3,'82.546.857/0001-76','(27)1212-2322','Av. Gov. Valadares 200','Farinha Boa','Farinha SA'),(5,'80.644.510/0001-30','(37)9898-9899','Rua Joaquim da Silva 4539','Granja Avivar','Granja SA'),(6,'31.394.978/0001-09','(11)1111-1111','Estrada 345 Km 664','Vilma','Vilma SA');
/*!40000 ALTER TABLE `fornecedor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `funcionario`
--

DROP TABLE IF EXISTS `funcionario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `funcionario` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `TIPO` varchar(31) DEFAULT NULL,
  `IDADE` int(11) DEFAULT NULL,
  `NOME` varchar(255) DEFAULT NULL,
  `LOGIN` varchar(255) DEFAULT NULL,
  `SENHA` varchar(255) DEFAULT NULL,
  `DATAADMISSÃO` date DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `funcionario`
--

LOCK TABLES `funcionario` WRITE;
/*!40000 ALTER TABLE `funcionario` DISABLE KEYS */;
INSERT INTO `funcionario` VALUES (1,'Adm',29,'Vitor','vitor','123',NULL),(2,'Vendedor',30,'Carlos','carlos','123','2018-01-05'),(3,'Vendedor',20,'Joao','jao','1234','2018-05-08'),(4,'Vendedor',20,'Pedro','Pedroza','123456','2018-05-08'),(6,'Vendedor',35,'Joaquim','quin','1234','2018-05-13'),(7,'Adm',25,'Maria','mariazoia','Paodebatata',NULL),(8,'Adm',60,'Dono Da porra ','joseph','GOD',NULL);
/*!40000 ALTER TABLE `funcionario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `materia_prima`
--

DROP TABLE IF EXISTS `materia_prima`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `materia_prima` (
  `Materia_Id` int(11) NOT NULL AUTO_INCREMENT,
  `ESTOQUE` float DEFAULT NULL,
  `ESTOQUE_MIN` float DEFAULT NULL,
  `NOME` varchar(255) DEFAULT NULL,
  `PRECO` float DEFAULT NULL,
  `codFornecedor` int(11) DEFAULT NULL,
  PRIMARY KEY (`Materia_Id`),
  KEY `FK_MATERIA_PRIMA_codFornecedor` (`codFornecedor`),
  CONSTRAINT `FK_MATERIA_PRIMA_codFornecedor` FOREIGN KEY (`codFornecedor`) REFERENCES `fornecedor` (`Fornecedor_Id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `materia_prima`
--

LOCK TABLES `materia_prima` WRITE;
/*!40000 ALTER TABLE `materia_prima` DISABLE KEYS */;
INSERT INTO `materia_prima` VALUES (1,100,200,'Leite Desnatado Cemil',2.69,2),(3,260,200,'Farinha Muito Da Boa',3.54,3),(4,1200,120,'Ovos',3.99,5),(5,500,120,'Massa de Bolo Pronta - Abacaxi',1.6,6);
/*!40000 ALTER TABLE `materia_prima` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `produto`
--

DROP TABLE IF EXISTS `produto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `produto` (
  `Prod_id` int(11) NOT NULL AUTO_INCREMENT,
  `TIPO` varchar(31) NOT NULL,
  `NOME` varchar(255) NOT NULL,
  `PRECOCUSTO` float NOT NULL,
  `PRECOVENDA` float NOT NULL,
  `ESTOQUE` int(11) NOT NULL,
  `ESTOQUEMIN` int(11) DEFAULT NULL,
  PRIMARY KEY (`Prod_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `produto`
--

LOCK TABLES `produto` WRITE;
/*!40000 ALTER TABLE `produto` DISABLE KEYS */;
INSERT INTO `produto` VALUES (1,'Produtos_Terceiros','Coca-Cola',5,7,500,50),(2,'Produtos_Terceiros','Bala Fini',3.5,6.98,50,10),(3,'Produtos_Produzidos','Bolo de Abacaxi',123,123,123,123);
/*!40000 ALTER TABLE `produto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `produto_materia_prima`
--

DROP TABLE IF EXISTS `produto_materia_prima`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `produto_materia_prima` (
  `ProdutosProduzidos_Prod_id` int(11) NOT NULL,
  `materiaisUsados_Materia_Id` int(11) NOT NULL,
  PRIMARY KEY (`ProdutosProduzidos_Prod_id`,`materiaisUsados_Materia_Id`),
  KEY `PRODUTO_MATERIA_PRIMA_materiaisUsados_Materia_Id` (`materiaisUsados_Materia_Id`),
  CONSTRAINT `PRODUTO_MATERIA_PRIMA_ProdutosProduzidos_Prod_id` FOREIGN KEY (`ProdutosProduzidos_Prod_id`) REFERENCES `produto` (`Prod_id`),
  CONSTRAINT `PRODUTO_MATERIA_PRIMA_materiaisUsados_Materia_Id` FOREIGN KEY (`materiaisUsados_Materia_Id`) REFERENCES `materia_prima` (`Materia_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `produto_materia_prima`
--

LOCK TABLES `produto_materia_prima` WRITE;
/*!40000 ALTER TABLE `produto_materia_prima` DISABLE KEYS */;
INSERT INTO `produto_materia_prima` VALUES (3,1),(3,4),(3,5);
/*!40000 ALTER TABLE `produto_materia_prima` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `venda`
--

DROP TABLE IF EXISTS `venda`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `venda` (
  `Venda_Id` int(11) NOT NULL AUTO_INCREMENT,
  `DATAVENDA` date DEFAULT NULL,
  `PRECOVENDA` float DEFAULT NULL,
  `codVendedor` int(11) DEFAULT NULL,
  PRIMARY KEY (`Venda_Id`),
  KEY `FK_VENDA_codVendedor` (`codVendedor`),
  CONSTRAINT `FK_VENDA_codVendedor` FOREIGN KEY (`codVendedor`) REFERENCES `funcionario` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `venda`
--

LOCK TABLES `venda` WRITE;
/*!40000 ALTER TABLE `venda` DISABLE KEYS */;
/*!40000 ALTER TABLE `venda` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vendaproduto`
--

DROP TABLE IF EXISTS `vendaproduto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `vendaproduto` (
  `CODIGO` int(11) NOT NULL AUTO_INCREMENT,
  `QTDE` int(11) NOT NULL,
  `VALOR` float DEFAULT NULL,
  `codProduto` int(11) DEFAULT NULL,
  `codVenda` int(11) DEFAULT NULL,
  PRIMARY KEY (`CODIGO`),
  KEY `FK_VENDAPRODUTO_codVenda` (`codVenda`),
  KEY `FK_VENDAPRODUTO_codProduto` (`codProduto`),
  CONSTRAINT `FK_VENDAPRODUTO_codProduto` FOREIGN KEY (`codProduto`) REFERENCES `produto` (`Prod_id`),
  CONSTRAINT `FK_VENDAPRODUTO_codVenda` FOREIGN KEY (`codVenda`) REFERENCES `venda` (`Venda_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vendaproduto`
--

LOCK TABLES `vendaproduto` WRITE;
/*!40000 ALTER TABLE `vendaproduto` DISABLE KEYS */;
/*!40000 ALTER TABLE `vendaproduto` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-05-15  8:14:39
