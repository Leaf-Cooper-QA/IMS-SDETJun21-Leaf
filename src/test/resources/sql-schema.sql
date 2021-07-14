USE ims;

DROP TABLE IF EXISTS `orders_items`;

DROP TABLE IF EXISTS `orders`;

DROP TABLE IF EXISTS `customers`;

DROP TABLE IF EXISTS `items`;

CREATE TABLE IF NOT EXISTS `customers` (
  `id` int NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) NOT NULL,
  `surname` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS `items` (
  `id` int NOT NULL AUTO_INCREMENT,
  `item_name` varchar(45) NOT NULL UNIQUE,
  `price` decimal(10,2) NOT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS `orders` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_customers` int NOT NULL,
  `total` decimal(10,2) NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `id_customers` FOREIGN KEY (`id_customers`) REFERENCES `customers` (`id`)
);

CREATE TABLE IF NOT EXISTS `orders_items` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_orders` int NOT NULL,
  `id_items` int NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `id_items` FOREIGN KEY (`id_items`) REFERENCES `items` (`id`),
  CONSTRAINT `id_orders` FOREIGN KEY (`id_orders`) REFERENCES `orders` (`id`)
);

