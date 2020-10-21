DROP SCHEMA IF EXISTS `my-ecomm`;

CREATE SCHEMA `my-ecomm`;

use `my-ecomm`;

SET FOREIGN_KEY_CHECKS = 0;

DROP TABLE IF EXISTS `category`;

CREATE TABLE `category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `category_name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `product`;

CREATE TABLE `product` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(128) DEFAULT NULL,
  `price` int(11) DEFAULT null,
  `size` varchar(128) DEFAULT NULL,
  `category_id` int(11) DEFAULT NULL,
  
  PRIMARY KEY (`id`),
  UNIQUE KEY `name_UNIQUE` (`name`),
  KEY `FK_category_idx` (`category_id`),
  
  CONSTRAINT `FK_category` 
  FOREIGN KEY (`category_id`) 
  REFERENCES `category` (`id`) 
  
  ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;


SET FOREIGN_KEY_CHECKS = 1;
