-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: localhost    Database: quanlyphongtro
-- ------------------------------------------------------
-- Server version	8.0.31

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
-- Table structure for table `evaluate`
--

DROP TABLE IF EXISTS `evaluate`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `evaluate` (
  `id` int NOT NULL AUTO_INCREMENT,
  `comment` varchar(255) DEFAULT NULL,
  `fkevalute_user_id_respondent` int DEFAULT NULL,
  `fkevalute_motel_id` int DEFAULT NULL,
  `fkevalute_evaluate_id` int DEFAULT NULL,
  `fkevalute_evaluate_id_reply` int DEFAULT NULL,
  `created_date` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fkevalute_motelId_idx` (`fkevalute_motel_id`),
  KEY `fkevalute_userIdRespondent_idx` (`fkevalute_user_id_respondent`),
  KEY `fkevalute_evaluateId_idx` (`fkevalute_evaluate_id`),
  KEY `fkevalute_evaluateIdReply_idx` (`fkevalute_evaluate_id_reply`),
  CONSTRAINT `fkevalute_evaluateId` FOREIGN KEY (`fkevalute_evaluate_id`) REFERENCES `evaluate` (`id`),
  CONSTRAINT `fkevalute_evaluateIdReply` FOREIGN KEY (`fkevalute_evaluate_id_reply`) REFERENCES `evaluate` (`id`),
  CONSTRAINT `fkevalute_motelId` FOREIGN KEY (`fkevalute_motel_id`) REFERENCES `motel` (`id`),
  CONSTRAINT `fkevalute_userIdRespondent` FOREIGN KEY (`fkevalute_user_id_respondent`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `evaluate`
--

LOCK TABLES `evaluate` WRITE;
/*!40000 ALTER TABLE `evaluate` DISABLE KEYS */;
INSERT INTO `evaluate` VALUES (11,'??',1,12,NULL,NULL,'2023-09-18'),(16,'Xin chào',1,12,NULL,NULL,'2023-09-18'),(17,'Xin chào xin chào',1,12,16,16,'2023-09-18'),(18,'Thien Xin chào xin chào\r\nThien Xin chào xin chào\r\n',1,12,16,17,'2023-09-18'),(19,'??????????',1,12,16,18,'2023-09-18'),(20,'a',1,12,NULL,NULL,'2023-09-18'),(21,'aa',1,12,16,16,'2023-09-18'),(22,'xin chào tôi mới đến',22,12,NULL,NULL,'2023-09-18'),(33,'Đánh người tìm trọ',21,21,NULL,NULL,'2023-09-29'),(34,'đánh giá chủ trọ',1,21,33,33,'2023-09-29'),(35,'Cho em hỏi...',16,21,33,34,'2023-09-29'),(36,NULL,2,21,NULL,NULL,'2023-10-08'),(37,NULL,2,21,NULL,NULL,'2023-10-08'),(38,'test comment',2,21,NULL,NULL,'2023-10-08'),(39,'a',2,15,NULL,NULL,'2023-10-08'),(40,'b',2,15,NULL,NULL,'2023-10-08'),(41,'c',2,15,39,39,'2023-10-08'),(42,'d',2,15,40,40,'2023-10-08'),(43,'e',2,15,39,41,'2023-10-08'),(44,'test reply motel 15  in comment 40, comment reply 42',2,15,40,42,'2023-10-08'),(45,'test reply motel 15 in comment 40, comment reply 44, user momo123456aaa',22,15,40,42,'2023-10-08'),(46,'test reply motel 15 in comment 40, comment reply 45, user a100',21,15,40,45,'2023-10-08');
/*!40000 ALTER TABLE `evaluate` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `findmotel`
--

DROP TABLE IF EXISTS `findmotel`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `findmotel` (
  `id` int NOT NULL AUTO_INCREMENT,
  `detaileddescription` tinytext,
  `map` longtext,
  `city` varchar(45) DEFAULT NULL,
  `district` varchar(45) DEFAULT NULL,
  `created_date` varchar(45) DEFAULT NULL,
  `fkfindmotel_findmotel_id` int DEFAULT NULL,
  `fkfindmotel_findmotel_id_reply` int DEFAULT NULL,
  `fkfindmotel_user_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fkfindmotel_findmotelId_idx` (`fkfindmotel_findmotel_id`),
  KEY `fkfindmotel_findmotelIdReply_idx` (`fkfindmotel_findmotel_id_reply`),
  KEY `fkfindmotel_userId_idx` (`fkfindmotel_user_id`),
  CONSTRAINT `fkfindmotel_findmotelId` FOREIGN KEY (`fkfindmotel_findmotel_id`) REFERENCES `findmotel` (`id`),
  CONSTRAINT `fkfindmotel_findmotelIdReply` FOREIGN KEY (`fkfindmotel_findmotel_id_reply`) REFERENCES `findmotel` (`id`),
  CONSTRAINT `fkfindmotel_userId` FOREIGN KEY (`fkfindmotel_user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `findmotel`
--

LOCK TABLES `findmotel` WRITE;
/*!40000 ALTER TABLE `findmotel` DISABLE KEYS */;
INSERT INTO `findmotel` VALUES (2,'abc','<iframe src=\"https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d15676.64077106411!2d106.63094606412349!3d10.799040147960433!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x317529ead2e7e219%3A0x39ad1ed1dc81c492!2zVHLGsOG7nW5nIENhbyDEkeG6s25nIFkga2hvYSBQaOG6oW0gTmfhu41jIFRo4bqhY2ggVFAuSENN!5e0!3m2!1svi!2s!4v1695112452859!5m2!1svi!2s\" width=\"600\" height=\"450\" style=\"border:0;\" allowfullscreen=\"\" loading=\"lazy\" referrerpolicy=\"no-referrer-when-downgrade\"></iframe>','Đà Nẵng','Quận Hải Châu','2023-09-19',NULL,NULL,1),(3,'abc','<iframe src=\"https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d15676.64077106411!2d106.63094606412349!3d10.799040147960433!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x317529ead2e7e219%3A0x39ad1ed1dc81c492!2zVHLGsOG7nW5nIENhbyDEkeG6s25nIFkga2hvYSBQaOG6oW0gTmfhu41jIFRo4bqhY2ggVFAuSENN!5e0!3m2!1svi!2s!4v1695112452859!5m2!1svi!2s\" width=\"600\" height=\"450\" style=\"border:0;\" allowfullscreen=\"\" loading=\"lazy\" referrerpolicy=\"no-referrer-when-downgrade\"></iframe>','Đà Nẵng','Quận Hải Châu','2023-09-19',NULL,NULL,1),(4,'abc','','Đắk Lắk','Huyện Krông Pắc','2023-09-19',NULL,NULL,1),(5,'asasfbrararaw','','Đà Nẵng','Quận Liên Chiểu','2023-09-19',NULL,NULL,1),(6,'fnjmtrekyre5','<iframe src=\"https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d15676.64077106411!2d106.63094606412349!3d10.799040147960433!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x317529ead2e7e219%3A0x39ad1ed1dc81c492!2zVHLGsOG7nW5nIENhbyDEkeG6s25nIFkga2hvYSBQaOG6oW0gTmfhu41jIFRo4bqhY2ggVFAuSENN!5e0!3m2!1svi!2s!4v1695112452859!5m2!1svi!2s\" width=\"600\" height=\"450\" style=\"border:0;\" allowfullscreen=\"\" loading=\"lazy\" referrerpolicy=\"no-referrer-when-downgrade\"></iframe>','Hưng Yên','Huyện Kim Động','2023-09-19',NULL,NULL,1),(7,'aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbaaa','<iframe src=\"https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d15676.64077106411!2d106.63094606412349!3d10.799040147960433!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x317529ead2e7e219%3A0x39ad1ed1dc81c492!2zVHLGsOG7nW5nIENhbyDEkeG6s25nIFkga2hvYSBQaOG6oW0gTmfhu41jIFRo4bqhY2ggVFAuSENN!5e0!3m2!1svi!2s!4v1695112452859!5m2!1svi!2s\" width=\"600\" height=\"450\" style=\"border:0;\" allowfullscreen=\"\" loading=\"lazy\" referrerpolicy=\"no-referrer-when-downgrade\"></iframe>','Lào Cai','Huyện Bảo Thắng','2023-09-19',NULL,NULL,1),(8,'rep 5',NULL,NULL,NULL,'2023-09-19',5,5,1),(9,'rep 5 ',NULL,NULL,NULL,'2023-09-19',5,8,3),(10,'rep 5',NULL,NULL,NULL,NULL,5,9,20),(11,'chào bạn',NULL,NULL,NULL,'2023-09-20',7,7,1),(12,'Chào chào chào',NULL,NULL,NULL,'2023-09-20',7,11,1),(13,'chào chào',NULL,NULL,NULL,'2023-09-20',7,12,15),(14,'chỗ này tui biết nè',NULL,NULL,NULL,'2023-09-20',6,6,15),(15,'sgdghwelgnbsldgsdgs','','Đắk Lắk','Huyện Lăk','2023-09-22',NULL,NULL,1),(16,'a','','Cao Bằng','Huyện Thạch An','2023-09-26',NULL,NULL,23),(17,'abc','','Bình Định','Huyện An Lão','2023-09-26',NULL,NULL,23),(18,NULL,NULL,NULL,NULL,'2023-09-26',NULL,NULL,23),(19,'Tôi muốn tìm chỗ ở 4 phòng 2 nhà tắm , 2 giường','<iframe src=\"https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d15676.350294185033!2d106.61734189999999!3d10.8046046!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x31752be27d8b4f4d%3A0x92dcba2950430867!2zVHLGsOG7nW5nIMSQ4bqhaSBo4buNYyBDw7RuZyBUaMawxqFuZyBUUC4gSOG7kyBDaMOtIE1pbmg!5e0!3m2!1svi!2s!4v1695965647517!5m2!1svi!2s\" width=\"600\" height=\"450\" style=\"border:0;\" allowfullscreen=\"\" loading=\"lazy\" referrerpolicy=\"no-referrer-when-downgrade\"></iframe>','Bắc Kạn','Huyện Na Rì','2023-09-29',NULL,NULL,16),(20,'hello',NULL,NULL,NULL,'2023-09-29',19,19,16);
/*!40000 ALTER TABLE `findmotel` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `follower`
--

DROP TABLE IF EXISTS `follower`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `follower` (
  `id` int NOT NULL AUTO_INCREMENT,
  `fkfollower_user_renter_id` int DEFAULT NULL,
  `fkfollower_user_host_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fkfollower_userRenterId_idx` (`fkfollower_user_renter_id`),
  KEY `fkfollower_userHostId_idx` (`fkfollower_user_host_id`),
  CONSTRAINT `fkfollower_userHostId` FOREIGN KEY (`fkfollower_user_host_id`) REFERENCES `user` (`id`),
  CONSTRAINT `fkfollower_userRenterId` FOREIGN KEY (`fkfollower_user_renter_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `follower`
--

LOCK TABLES `follower` WRITE;
/*!40000 ALTER TABLE `follower` DISABLE KEYS */;
INSERT INTO `follower` VALUES (4,15,2),(5,17,1),(6,15,1),(7,1,2);
/*!40000 ALTER TABLE `follower` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `motel`
--

DROP TABLE IF EXISTS `motel`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `motel` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `cityprovince` varchar(45) DEFAULT NULL,
  `district` varchar(45) DEFAULT NULL,
  `map` longtext,
  `phone` varchar(50) DEFAULT NULL,
  `numberofresidents` int DEFAULT NULL,
  `price` decimal(38,0) DEFAULT NULL,
  `fkmotel_user_id` int DEFAULT NULL,
  `title` varchar(100) DEFAULT NULL,
  `description` tinytext,
  `acreage` varchar(10) DEFAULT NULL,
  `created_date` varchar(20) DEFAULT NULL,
  `apply` bit(1) DEFAULT b'0',
  PRIMARY KEY (`id`),
  KEY `fkmotel_userId_idx` (`fkmotel_user_id`),
  CONSTRAINT `fkmotel_userId` FOREIGN KEY (`fkmotel_user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `motel`
--

LOCK TABLES `motel` WRITE;
/*!40000 ALTER TABLE `motel` DISABLE KEYS */;
INSERT INTO `motel` VALUES (9,'Tiêu đề 8','Lê Lai','Thành phố Hồ Chí Minh','Quận Bình Tân','<iframe src=\"https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d15676.350294185033!2d106.61734189999999!3d10.8046046!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x31752b9535b60699%3A0x4737f3be8bd41d5b!2zw4ZPTiBNQUxMIFTDom4gUGjDug!5e0!3m2!1svi!2s!4v1694854022183!5m2!1svi!2s\" width=\"600\" height=\"450\" style=\"border:0;\" allowfullscreen=\"\" loading=\"lazy\" referrerpolicy=\"no-referrer-when-downgrade\"></iframe>','0344142375',4,100000,1,'Tiêu đề 8','Mô tả 8','120','2023-09-15',_binary ''),(11,'thien3 thien3','a','Thành phố Hồ Chí Minh','Quận Bình Tân','<iframe src=\"https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d15676.350294185033!2d106.61734189999999!3d10.8046046!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x31752b9535b60699%3A0x4737f3be8bd41d5b!2zw4ZPTiBNQUxMIFTDom4gUGjDug!5e0!3m2!1svi!2s!4v1694854022183!5m2!1svi!2s\" width=\"600\" height=\"450\" style=\"border:0;\" allowfullscreen=\"\" loading=\"lazy\" referrerpolicy=\"no-referrer-when-downgrade\"></iframe>','0344142375',2,10000000,2,'Cho thuê nhà riêng một trệt 2 lầu làm văn phòng, đào tạo, hộ gia đình thẩm mỹ, hiệu thuốc','Cho thuê nhà riêng một trệt 2 lầu làm văn phòng, đào tạo, hộ gia đình thẩm mỹ, hiệu thuốc','100','2023-09-15',_binary ''),(12,'a a','638 Lê Trọng Tấn','Thành phố Hồ Chí Minh','Quận Bình Tân','<iframe src=\"https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d15676.350294185033!2d106.61734189999999!3d10.8046046!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x31752b9535b60699%3A0x4737f3be8bd41d5b!2zw4ZPTiBNQUxMIFTDom4gUGjDug!5e0!3m2!1svi!2s!4v1694854022183!5m2!1svi!2s\" width=\"600\" height=\"450\" style=\"border:0;\" allowfullscreen=\"\" loading=\"lazy\" referrerpolicy=\"no-referrer-when-downgrade\"></iframe>','0344142375',5,100001,2,'Cho thuê nhà riêng một trệt 2 lầu làm văn phòng, đào tạo, hộ gia đình thẩm mỹ, hiệu thuốc','Cho thuê nhà ta','100','2023-09-15',_binary ''),(14,'aaa','LYT','Bắc Kạn','Huyện Bạch Thông','<iframe src=\"https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d15676.350294185033!2d106.61734189999999!3d10.8046046!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x31752b9535b60699%3A0x4737f3be8bd41d5b!2zw4ZPTiBNQUxMIFTDom4gUGjDug!5e0!3m2!1svi!2s!4v1694854022183!5m2!1svi!2s\" width=\"600\" height=\"450\" style=\"border:0;\" allowfullscreen=\"\" loading=\"lazy\" referrerpolicy=\"no-referrer-when-downgrade\"></iframe>','0344142375',2,1000000000,1,'Cho thuê nhà riêng một trệt 2 lầu làm văn phòng, đào tạo, hộ gia đình thẩm mỹ, hiệu thuốc','aaaa','120','2023-09-19',_binary ''),(15,'Nhà trọ n','Lê Trọng Tấn','Cà Mau','Huyện Cái Nước','<iframe src=\"https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d15676.350294185033!2d106.61734189999999!3d10.8046046!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x31752b9535b60699%3A0x4737f3be8bd41d5b!2zw4ZPTiBNQUxMIFTDom4gUGjDug!5e0!3m2!1svi!2s!4v1694854022183!5m2!1svi!2s\" width=\"600\" height=\"450\" style=\"border:0;\" allowfullscreen=\"\" loading=\"lazy\" referrerpolicy=\"no-referrer-when-downgrade\"></iframe>','0344142375',5,1000000000,2,'Nhà trọ n','aaaaaaaaaaa','120','2023-09-19',_binary ''),(20,'rasnjnarja','Lê Lai','Đắk Nông','Huyện Krông Nô','<iframe src=\"https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d15676.350294185033!2d106.61734189999999!3d10.8046046!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x31752be27d8b4f4d%3A0x92dcba2950430867!2zVHLGsOG7nW5nIMSQ4bqhaSBo4buNYyBDw7RuZyBUaMawxqFuZyBUUC4gSOG7kyBDaMOtIE1pbmg!5e0!3m2!1svi!2s!4v1695720966145!5m2!1svi!2s\" width=\"600\" height=\"450\" style=\"border:0;\" allowfullscreen=\"\" loading=\"lazy\" referrerpolicy=\"no-referrer-when-downgrade\"></iframe>','0344142375',3,1000000,1,'asrnjawera','asjraj','25','2023-09-26',_binary '\0'),(21,'Nhà ở nè','638 Lê Trọng tấn','Hải Phòng','Quận Kiến An','<iframe src=\"https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d15676.350294185033!2d106.61734189999999!3d10.8046046!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x31752b9535b60699%3A0x4737f3be8bd41d5b!2zw4ZPTiBNQUxMIFTDom4gUGjDug!5e0!3m2!1svi!2s!4v1695962695621!5m2!1svi!2s\" width=\"600\" height=\"450\" style=\"border:0;\" allowfullscreen=\"\" loading=\"lazy\" referrerpolicy=\"no-referrer-when-downgrade\"></iframe>','0344142375',2,1000000,1,'Nhà ở nè','Nhà cao cửa rộng , sổ đầy đủ , hợp đồng thuê theo tháng, có ban công ngắm bình minh...','100','2023-09-29',_binary '');
/*!40000 ALTER TABLE `motel` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `motelimage`
--

DROP TABLE IF EXISTS `motelimage`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `motelimage` (
  `id` int NOT NULL AUTO_INCREMENT,
  `image` varchar(255) DEFAULT NULL,
  `fkmotelimage_motel_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fkmotelimage_motelId_idx` (`fkmotelimage_motel_id`),
  CONSTRAINT `fkmotelimage_motelId` FOREIGN KEY (`fkmotelimage_motel_id`) REFERENCES `motel` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=85 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `motelimage`
--

LOCK TABLES `motelimage` WRITE;
/*!40000 ALTER TABLE `motelimage` DISABLE KEYS */;
INSERT INTO `motelimage` VALUES (40,'https://res.cloudinary.com/dicxcmntw/image/upload/v1694764792/rdsnqhjfnzaoyf4agddc.jpg',9),(41,'https://res.cloudinary.com/dicxcmntw/image/upload/v1694764822/bshrfsnm9huo84szhcr6.jpg',9),(42,'https://res.cloudinary.com/dicxcmntw/image/upload/v1694764873/akhcfjc2wpglqoegykx4.jpg',9),(44,'https://res.cloudinary.com/dicxcmntw/image/upload/v1694765301/q7eyaklbbtwmmhumtant.jpg',11),(45,'https://res.cloudinary.com/dicxcmntw/image/upload/v1694765325/llm0eot9l8ofasgmcqbe.jpg',11),(46,'https://res.cloudinary.com/dicxcmntw/image/upload/v1694765345/deieyit6ihiacol8mmcy.jpg',11),(55,'https://res.cloudinary.com/dicxcmntw/image/upload/v1694852635/plylgbxemmi26yojf0re.jpg',12),(56,'https://res.cloudinary.com/dicxcmntw/image/upload/v1694852681/s3wwml4xluzsxqhzs24m.jpg',12),(57,'https://res.cloudinary.com/dicxcmntw/image/upload/v1694852726/me5feavj4frycsg4qnwk.jpg',12),(61,'https://res.cloudinary.com/dicxcmntw/image/upload/v1695101124/epkoobakls28ss4eidox.jpg',14),(62,'https://res.cloudinary.com/dicxcmntw/image/upload/v1695101156/s6ose90xu7venodambbg.jpg',14),(63,'https://res.cloudinary.com/dicxcmntw/image/upload/v1695101189/xafyymdp27qsh1djx8bv.jpg',14),(64,'https://res.cloudinary.com/dicxcmntw/image/upload/v1695101651/fejrd2aquvwrntv518qf.jpg',15),(65,'https://res.cloudinary.com/dicxcmntw/image/upload/v1695101673/rb9qouwcygufp7dsinze.jpg',15),(66,'https://res.cloudinary.com/dicxcmntw/image/upload/v1695101706/bebmmj9xzlcg6mlgk7we.jpg',15),(79,'https://res.cloudinary.com/dicxcmntw/image/upload/v1695721012/vnxuq1frpeogj1apa6gg.jpg',20),(80,'https://res.cloudinary.com/dicxcmntw/image/upload/v1695721043/jplwg2ncgpok9xreilca.jpg',20),(81,'https://res.cloudinary.com/dicxcmntw/image/upload/v1695721076/rys4wan2o4bburlou5u3.jpg',20),(82,'https://res.cloudinary.com/dicxcmntw/image/upload/v1695963098/n0s4laboc7aycjp4oeu0.jpg',21),(83,'https://res.cloudinary.com/dicxcmntw/image/upload/v1695963136/v84uh5mzghswyb6dxpyq.jpg',21),(84,'https://res.cloudinary.com/dicxcmntw/image/upload/v1695963184/t6xoo9rqyvpvklpda3pv.jpg',21);
/*!40000 ALTER TABLE `motelimage` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `roleuser`
--

DROP TABLE IF EXISTS `roleuser`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `roleuser` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roleuser`
--

LOCK TABLES `roleuser` WRITE;
/*!40000 ALTER TABLE `roleuser` DISABLE KEYS */;
INSERT INTO `roleuser` VALUES (1,'ROLE_ADMIN'),(2,'ROLE_HOST'),(3,'ROLE_RENTER');
/*!40000 ALTER TABLE `roleuser` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `image` varchar(255) DEFAULT NULL,
  `firstname` varchar(45) NOT NULL,
  `lastname` varchar(45) NOT NULL,
  `fkuser_roleuser_id` int DEFAULT NULL,
  `created_date` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fkuser_roleuserId_idx` (`fkuser_roleuser_id`),
  CONSTRAINT `fkuser_roleuserId` FOREIGN KEY (`fkuser_roleuser_id`) REFERENCES `roleuser` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'momo123456','$2a$10$q1E1xYZB8r1diieBtcIxtOfeyYUrY4ItbzMFaeJZCwEz3K.hNe0MK','nino07052002@gmail.com','https://res.cloudinary.com/dicxcmntw/image/upload/v1690632388/ixbn7ivt5vyrxq8d4zzx.jpg','Huynh','Thien',1,'2023-09-12'),(2,'thien2','$2a$10$q1E1xYZB8r1diieBtcIxtOfeyYUrY4ItbzMFaeJZCwEz3K.hNe0MK','nino07052002@gmail.com','https://res.cloudinary.com/dicxcmntw/image/upload/v1690632388/ixbn7ivt5vyrxq8d4zzx.jpg','Thien','Huynh',2,'2023-10-12'),(3,'momo1234562','$2a$10$nhtx6m3Cm2k7Zvo.QKTu8.ZWGQc6DiJDZuzpG5QrI0YWRI5Y2gI0C','nino02022002@gmail.com','https://res.cloudinary.com/dicxcmntw/image/upload/v1694344205/m7x2saq2z1jgicnnuzaw.jpg','thien3','thien3',2,'2023-01-12'),(7,'thien5','$2a$10$YCu1dE6dgbpuvh34uvz7yuYUaUyT2dmd5N0QOwCzwaOC19FSiu1VK','nino07052002@gmail.com','https://res.cloudinary.com/dicxcmntw/image/upload/v1694408624/kzbzpruuzk0iqrhgg2jn.jpg','thien5','thien5',3,'2023-05-12'),(8,'thientest1','$2a$10$lPRon0551HKrKJXirXODTu53hSLEjIbpzPWOY9nC.lyMurks8daTO','nino07052002@gmail.com','https://res.cloudinary.com/dicxcmntw/image/upload/v1694501627/loy3nrdnb5kertthvlwd.jpg','thientest','thientest',3,'2023-09-12'),(9,'thientest2','$2a$10$32doulNHl1z3ZnAubQC.LeZ/WMMAsuc/35Qvn/eiejdcw8PfBXUKG','nino07052002@gmail.com','https://res.cloudinary.com/dicxcmntw/image/upload/v1694501962/ke8sx1lmg7xixyp4h95i.jpg','thientest2','thientest2',3,'2023-09-12'),(10,'thientest3','$2a$10$9JpFlhI5JwlliAl9hKQFqeC3Jy0c0UQ4o/6jghGslQw/CASpNIJoq','nino07052002@gmail.com','https://res.cloudinary.com/dicxcmntw/image/upload/v1694503468/o1wivj8pxfqymdfwwguz.jpg','thientest3.1','thientest3.1',3,'2023-05-12'),(11,'thien6','$2a$10$L0ToqZz9f87QFmnufYexNeVKHkIttILQthngxXsTST5QI45C2oUNW','nino07052002@gmail.com','https://res.cloudinary.com/dicxcmntw/image/upload/v1694674841/mzdwhqxg3bqjuzwyn9sk.jpg','thien6','thien6',3,'2023-08-14'),(12,'thien7','$2a$10$ejnCfu0oc/4rFk.j/e0Iqubh.n1mvoK3/Mo05pylr2hD7mSKD1wkK','nino07052002@gmail.com','','thien7','thien7',3,'2023-04-14'),(13,'thien8','$2a$10$0dplz8QDgMShX5EpRdA2m.MwqsFb1U0OxycOH0VxJQ9N2TSRDICZi','nino07052002@gmail.com','https://res.cloudinary.com/dicxcmntw/image/upload/v1694682569/qin7umnw3yphsk2vuwax.jpg','thien8','thien8',3,'2023-09-14'),(14,'thien9','$2a$10$VQOgsi2yWjtzHS9HUphJWOstX5ENzIVAYYZl1llD3YWQetGadiSni','nino07052002@gmail.com','https://res.cloudinary.com/dicxcmntw/image/upload/v1694683377/se0rsnqxvjxjyssvs93c.jpg','thien9','thien8',3,'2023-09-14'),(15,'thien10','$2a$10$OodUpTHot/XVSUU4FJuxAO56ON2viUxYOKfQgkUYuNODRzrG3bLM.','nino07052002@gmail.com','https://res.cloudinary.com/dicxcmntw/image/upload/v1694683471/uozjuhounjluychag6ij.jpg','thien10','thien10',3,'2023-03-14'),(16,'thien888','$2a$10$0dplz8QDgMShX5EpRdA2m.MwqsFb1U0OxycOH0VxJQ9N2TSRDICZi','nino07052002@gmail.com','https://res.cloudinary.com/dicxcmntw/image/upload/v1694682569/qin7umnw3yphsk2vuwax.jpg','thien8','thien8',3,'2023-02-14'),(17,'thien11','$2a$10$k2zQ14MxQg8D95NAlZ5T7OP1.4tREGgg5nuerqM5w4YrPPxs/.Yei','nino07022002@gmail.com','https://res.cloudinary.com/dicxcmntw/image/upload/v1694685014/t7qiczluu5i5wof45b3d.jpg','aaaaaaa','thien11',3,'2022-06-14'),(20,'thien19','$2a$10$sLA0N0JhB97TW5ue3EmPOOYUFeJBmThDpZpBY32T4l6GVnxwbhMfK','nino07052002@gmail.com','https://res.cloudinary.com/dicxcmntw/image/upload/v1694687710/m0bychjlo1uqha7lgxwn.jpg','thien19','thien19',3,'2022-01-14'),(21,'a100','$2a$10$s5OKsqCLVAiqZFLe.CYhiOmEjC6npYEEzXBLVXolXYvkPGftke6Cy','nino07052002@gmail.com','https://res.cloudinary.com/dicxcmntw/image/upload/v1694703260/ambou3wh5ykeaoxhb3oj.jpg','a100','a100',3,'2023-11-14'),(22,'momo123456aaa','$2a$10$x0XjnUVz7KrMERv2wHWkm.GG8x01u0N6W.EFb.qB5z4Zkn/lJQIk6','nino07052002@gmail.com','https://res.cloudinary.com/dicxcmntw/image/upload/v1695030263/lgcvodzl6za1x4yeqqe8.jpg','a','a',3,'2023-12-18'),(23,'momo1234566','$2a$10$HjLZHiUUgRSctSPyq6V6tu4CgUOa9dyMj0ShB3/H2lgWkTL/KT/z2','nino02022002@gmail.com','https://res.cloudinary.com/dicxcmntw/image/upload/v1695710250/uhq2fcnjgyuwckrjijlw.jpg','thien36','thien36',3,'2023-09-26'),(25,'thienhuynh123','$2a$10$90c1zhver5XAOKAiAyNz4uQGRhseoqw5m24EEpGbiMFhjV3YD7liC','nino02022002@gmail.com','https://res.cloudinary.com/dicxcmntw/image/upload/v1698384539/sbqlx1ps2bsd55fkjzse.jpg','adadoiten','aDoirolethanhHost',2,'2023-10-27');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-10-31 14:50:57
