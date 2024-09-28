CREATE DATABASE  IF NOT EXISTS `furniture-cart` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `furniture-cart`;
-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: localhost    Database: furniture-cart
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
-- Table structure for table `cart`
--

DROP TABLE IF EXISTS `cart`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cart` (
  `id` int NOT NULL AUTO_INCREMENT,
  `quantity` int NOT NULL,
  `product_id` int DEFAULT NULL,
  `user_userid` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK3d704slv66tw6x5hmbm6p2x3u` (`product_id`),
  KEY `FK1kuttc1wgd8sm3ewq3qbxoaif` (`user_userid`),
  CONSTRAINT `FK1kuttc1wgd8sm3ewq3qbxoaif` FOREIGN KEY (`user_userid`) REFERENCES `user` (`userid`),
  CONSTRAINT `FK3d704slv66tw6x5hmbm6p2x3u` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cart`
--

LOCK TABLES `cart` WRITE;
/*!40000 ALTER TABLE `cart` DISABLE KEYS */;
INSERT INTO `cart` VALUES (2,1,2,2);
/*!40000 ALTER TABLE `cart` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_address`
--

DROP TABLE IF EXISTS `order_address`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order_address` (
  `id` int NOT NULL AUTO_INCREMENT,
  `address` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `firstname` varchar(255) DEFAULT NULL,
  `lastname` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_address`
--

LOCK TABLES `order_address` WRITE;
/*!40000 ALTER TABLE `order_address` DISABLE KEYS */;
INSERT INTO `order_address` VALUES (1,'','','','','');
/*!40000 ALTER TABLE `order_address` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product` (
  `id` int NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `price` double NOT NULL,
  `product_image` varchar(255) DEFAULT NULL,
  `user_userid` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKh4p6x3ywso820jd4l85unu9a9` (`user_userid`),
  CONSTRAINT `FKh4p6x3ywso820jd4l85unu9a9` FOREIGN KEY (`user_userid`) REFERENCES `user` (`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (1,'This stylish accent chair features a petal-shaped design and plush velvet upholstery in a soft pink hue. The gold-finished metal legs add a touch of glamour and sophistication. Perfect for adding a touch of luxury to any room.','Petal Pink Velvet Accent Chair',2350,'http://res.cloudinary.com/doxjowamc/image/upload/c_fill,h_300,w_300/a77d2398-8251-487a-9f5d-d41a36b40bdb',1),(2,'This eye-catching accent chair boasts a bold yellow hue and a curved design for added comfort. The matching cushion provides a cozy spot to relax, while the wooden legs add a touch of warmth. Perfect for adding a pop of color to any room.','Vibrant Accent Chair',3000,'http://res.cloudinary.com/doxjowamc/image/upload/c_fill,h_300,w_300/bb9e304a-3c56-4a8a-8770-73e3674efb0d',1),(3,'Relax in style with this cozy and inviting rocking chair featuring plush velvet upholstery and button tufting.',' Tufted Velvet Rocking Chair',2500,'http://res.cloudinary.com/doxjowamc/image/upload/c_fill,h_300,w_300/571915c7-edd0-406c-a653-2109a822d89d',1),(4,' Add a touch of elegance and color to your living space with this stunning petal-shaped sofa upholstered in luxurious velvet.','Petal-Shaped Velvet Sofa',2700,'http://res.cloudinary.com/doxjowamc/image/upload/c_fill,h_300,w_300/8f4f5598-ae01-48f5-a4f8-02984236dadc',1),(5,'This eye-catching accent chair boasts a bold yellow hue and a curved design for added comfort. The matching cushion provides a cozy spot to relax, while the wooden legs add a touch of warmth. Perfect for adding a pop of color to any room.','Vibrant Accent Chair',3000,'http://res.cloudinary.com/doxjowamc/image/upload/c_fill,h_300,w_300/fedc8c93-b7c9-4e65-adde-799755973d19',1),(6,'This eye-catching accent chair boasts a bold yellow hue and a curved design for added comfort. The matching cushion provides a cozy spot to relax, while the wooden legs add a touch of warmth. Perfect for adding a pop of color to any room.','Vibrant Accent Chair',3000,'http://res.cloudinary.com/doxjowamc/image/upload/c_fill,h_300,w_300/3b05a0c2-f896-4d62-92c5-9d067d3809bc',1),(7,'Create a warm and inviting dining space with this stylish and durable dining set made from solid wood.','Furniture Solid Wood Dining Set',5000,'http://res.cloudinary.com/doxjowamc/image/upload/c_fill,h_300,w_300/8ac5740e-a002-4f29-936e-2da712d12e58',1);
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_order`
--

DROP TABLE IF EXISTS `product_order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product_order` (
  `id` int NOT NULL AUTO_INCREMENT,
  `order_date` varchar(255) DEFAULT NULL,
  `order_id` varchar(255) DEFAULT NULL,
  `payment_mode` varchar(255) DEFAULT NULL,
  `price` double NOT NULL,
  `quantity` int NOT NULL,
  `status` varchar(255) DEFAULT NULL,
  `order_address_id` int DEFAULT NULL,
  `product_id` int DEFAULT NULL,
  `user_userid` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_qcdbxaeuc7c5gahwh0dutg04r` (`order_address_id`),
  KEY `FKh73acsd9s5wp6l0e55td6jr1m` (`product_id`),
  KEY `FKg1uldfejhs1ekgbab52vnwqwl` (`user_userid`),
  CONSTRAINT `FK8frxalwc79tpxo7hgqp3hsjck` FOREIGN KEY (`order_address_id`) REFERENCES `order_address` (`id`),
  CONSTRAINT `FKg1uldfejhs1ekgbab52vnwqwl` FOREIGN KEY (`user_userid`) REFERENCES `user` (`userid`),
  CONSTRAINT `FKh73acsd9s5wp6l0e55td6jr1m` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_order`
--

LOCK TABLES `product_order` WRITE;
/*!40000 ALTER TABLE `product_order` DISABLE KEYS */;
INSERT INTO `product_order` VALUES (1,'09-03-2024','9ef31cf5-01c1-4501-90b3-6dad900baa7f','COD',2350,1,' in progress',1,1,2);
/*!40000 ALTER TABLE `product_order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `roles`
--

DROP TABLE IF EXISTS `roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `roles` (
  `id` int NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roles`
--

LOCK TABLES `roles` WRITE;
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
INSERT INTO `roles` VALUES (501,'ROLE_ADMIN'),(502,'ROLE_USER');
/*!40000 ALTER TABLE `roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `userid` int NOT NULL AUTO_INCREMENT,
  `about` varchar(1000) NOT NULL,
  `email` varchar(255) NOT NULL,
  `emailverified` bit(1) NOT NULL,
  `password` varchar(255) NOT NULL,
  `phonenumber` varchar(255) DEFAULT NULL,
  `phoneverified` bit(1) NOT NULL,
  `profilepic` varchar(255) DEFAULT NULL,
  `provider` enum('SELF','GOOGLE','GITHUB') DEFAULT NULL,
  `provider_user_id` varchar(255) DEFAULT NULL,
  `username` varchar(255) NOT NULL,
  PRIMARY KEY (`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'this account only for admin use..','admin@gmail.com',_binary '','$2a$10$tXTxHbyn7aYkS4T53WJ01eUl/G3gwsCB4q8XozGIknkNRu5cPOmdC','1231231231',_binary '','https://www.google.com/url?sa=i&url=https%3A%2F%2Fen.m.wikipedia.org%2Fwiki%2FFile%3ADefault_pfp.svg&psig=AOvVaw28VcDklYcHi_KPECHdyFhq&ust=1717472793921000&source=images&cd=vfe&opi=89978449&ved=0CBEQjRxqFwoTCNCPtfHCvoYDFQAAAAAdAAAAABAE','SELF',NULL,'admin'),(2,'This account is created using google.','meetvaghasiya3229@gmail.com',_binary '','$2a$10$RVmnTiFNE7qXmbxDdpshfetVeFsGTJvfK7D7PJeeIwao4S/Wlr5sC',NULL,_binary '','https://lh3.googleusercontent.com/a/ACg8ocKbdMCOR2lOMhY3o3EFzMMifPMG5InPBNyyxg3mNxqp0VZB5rC6=s96-c','GOOGLE','109403254883080419303','MEET VAGHASIYA');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_role`
--

DROP TABLE IF EXISTS `user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_role` (
  `user` int NOT NULL,
  `role` int NOT NULL,
  PRIMARY KEY (`user`,`role`),
  KEY `FKfhq23r1o3cqe0n8jdi4vyv4s8` (`role`),
  CONSTRAINT `FKfhq23r1o3cqe0n8jdi4vyv4s8` FOREIGN KEY (`role`) REFERENCES `roles` (`id`),
  CONSTRAINT `FKmow7bmkl6wduuutk26ypkgmm1` FOREIGN KEY (`user`) REFERENCES `user` (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_role`
--

LOCK TABLES `user_role` WRITE;
/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
INSERT INTO `user_role` VALUES (1,501),(2,502);
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-09-03  2:48:39
