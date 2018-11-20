
create database food_truck;


use food_truck;
CREATE TABLE `menu` (
  `id` int(11) NOT NULL,
  `title` varchar(75) DEFAULT NULL,
  `link` varchar(100) DEFAULT NULL,
  `price` DOUBLE(10,2) NOT NULL,
  `category` varchar(100)  NOT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `order_Details` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(75) DEFAULT NULL,
  `qty` int(4) Default Null,
   `category` varchar(100) DEFAULT NULL,
  `total` DOUBLE(10,2) Default 0,
  `user_name` varchar(20) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `address` varchar(50) DEFAULT NULL,
  `status` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ;

CREATE TABLE `user` (
  `user_Name` varchar(20) NOT NULL,
  `email` varchar(30) NOT NULL,
  `password` varchar(20) NOT NULL,
  PRIMARY KEY (`user_Name`)
) ;

INSERT INTO `menu` (`id`, `title`, `link`, `price`,`category`) VALUES (1,'Chicken','/resources/images/Food11',8.5, 'Burger');
INSERT INTO `menu` (`id`, `title`, `link`, `price`,`category`) VALUES (2,'Veggie','/resources/images/Food11',6, 'Burger');
INSERT INTO `menu` (`id`, `title`, `link`, `price`,`category`) VALUES (3,'Beef','/resources/images/Food11',8.5, 'Burger');
INSERT INTO `menu` (`id`, `title`, `link`, `price`,`category`) VALUES (4,'Portobello Mushroom','/resources/images/Food11',6.5, 'Burger');
INSERT INTO `menu` (`id`, `title`, `link`, `price`,`category`) VALUES (5,'Turkey','/resources/images/Food11',9, 'Burger');

INSERT INTO `menu` (`id`, `title`, `link`, `price`,`category`) VALUES (6,'Fries','/resources/images/Food12',3.5, 'Fries');
INSERT INTO `menu` (`id`, `title`, `link`, `price`,`category`) VALUES (7,'Curly fries','/resources/images/Food13',4, 'Fries');
INSERT INTO `menu` (`id`, `title`, `link`, `price`,`category`) VALUES (8,'Waffle fries','/resources/images/Food13',4, 'Fries');
INSERT INTO `menu` (`id`, `title`, `link`, `price`,`category`) VALUES (9,'Chili cheese fries','/resources/images/Food13',4.5, 'Fries');

INSERT INTO `menu` (`id`, `title`, `link`, `price`,`category`) VALUES (10,'Vegetal','/resources/images/Food13',6.5, 'Tacos');
INSERT INTO `menu` (`id`, `title`, `link`, `price`,`category`) VALUES (11,'Carnitas','/resources/images/Food13',6.5, 'Tacos');
INSERT INTO `menu` (`id`, `title`, `link`, `price`,`category`) VALUES (12,'Lengua','/resources/images/Food13',7.5, 'Tacos');
INSERT INTO `menu` (`id`, `title`, `link`, `price`,`category`) VALUES (13,'Asada','/resources/images/Food13',7.5, 'Tacos');
INSERT INTO `menu` (`id`, `title`, `link`, `price`,`category`) VALUES (14,'Barbacoa','/resources/images/Food13',7.5, 'Tacos');

INSERT INTO `menu` (`id`, `title`, `link`, `price`,`category`) VALUES (15,'Soda','/resources/images/Food13',2.5, 'Beverages');
INSERT INTO `menu` (`id`, `title`, `link`, `price`,`category`) VALUES (16,'Coke','/resources/images/Food13',3, 'Beverages');
INSERT INTO `menu` (`id`, `title`, `link`, `price`,`category`) VALUES (17,'Orange Juice','/resources/images/Food13',3.5, 'Beverages');
