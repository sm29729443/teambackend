CREATE DATABASE IF NOT EXISTS `foodweb` ;

CREATE TABLE IF NOT EXISTS `store_info` (
  `store_id` int NOT NULL AUTO_INCREMENT,
  `address` varchar(60) NOT NULL,
  `name` varchar(45) NOT NULL,
  `ranking_Ynumber` int NOT NULL DEFAULT '0',
  `location_city` varchar(20) NOT NULL,
  `food_style` varchar(45) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `ranking_Mnumber` int NOT NULL DEFAULT '0',
  `user_like` int DEFAULT '0',
  PRIMARY KEY (`store_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
