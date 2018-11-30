create database food_truck;
use food_truck;
CREATE TABLE `menu` (
  `id` int(11) NOT NULL,
  `title` varchar(75) DEFAULT NULL,
  `price` DOUBLE(10,2) NOT NULL,
  `category` varchar(100)  NOT NULL,
  PRIMARY KEY (`id`)
);
CREATE TABLE crew(
name varchar(100),
role varchar(20),
email varchar(35),
truck varchar(20),
PRIMARY KEY (name)
);

CREATE TABLE `order_details` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `order_Info` varchar(200) default null,
  `total` DOUBLE(10,2) Default 0,
  `user_name` varchar(20) DEFAULT NULL,
  `email` varchar(35) DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL, 
  `city` varchar(50) Default Null,
  `status` varchar(50) DEFAULT NULL,
  `truck` varchar(20) DEFAULT NULL,
   `time` timestamp,
  PRIMARY KEY (`id`)
) ;
CREATE TABLE `user` (
  `user_Name` varchar(20) NOT NULL,
  `email` varchar(30) NOT NULL,
  `password` varchar(20) NOT NULL,
  PRIMARY KEY (`user_Name`)
) ;

INSERT INTO crew values('Veeresh','chef','veereshkanduri@gmail.com','pomona truck');
INSERT INTO crew values('Sony','chef','chidrisony34@gmail.com','pomona truck');
INSERT INTO crew values('Ragina','delivery boy','codevelopers3@gmail.com','pomona truck');
INSERT INTO crew values('Laila','delivery boy','codevelopers3@gmail.com','pomona truck');
INSERT INTO crew values('Surekha','chef','achantasurekha@gmail.com','brea truck');
INSERT INTO crew values('Sun','chef','sachanta@cpp.edu','brea truck');
INSERT INTO crew values('Naina','delivery boy','codevelopers3@gmail.com','brea truck');
INSERT INTO crew values('Thomas','delivery boy','codevelopers3@gmail.com','brea truck');
INSERT INTO crew values('Edward','chef','codevelopers3@gmail.com','diamond bar truck');
INSERT INTO crew values('Alex','chef','codevelopers3@gmail.com','diamond bar truck');
INSERT INTO crew values('Aurav','delivery boy','codevelopers3@gmail.com','diamond bar truck');
INSERT INTO crew values('Steve','delivery boy','codevelopers3@gmail.com','diamond bar truck');
INSERT INTO crew values('Ricks','delivery boy','codevelopers3@gmail.com','diamond bar truck');

INSERT INTO `menu` (`id`, `title`, `price`,`category`) VALUES (1,'Chicken',8.5, 'Burger');
INSERT INTO `menu` (`id`, `title`,  `price`,`category`) VALUES (2,'Veggie',6, 'Burger');
INSERT INTO `menu` (`id`, `title`,  `price`,`category`) VALUES (3,'Beef',8.5, 'Burger');
INSERT INTO `menu` (`id`, `title`,  `price`,`category`) VALUES (4,'Portobello Mushroom',6.5, 'Burger');
INSERT INTO `menu` (`id`, `title`,  `price`,`category`) VALUES (5,'Turkey',9, 'Burger');

INSERT INTO `menu` (`id`, `title`,  `price`,`category`) VALUES (6,'Fries',3.5, 'Fries');
INSERT INTO `menu` (`id`, `title`,  `price`,`category`) VALUES (7,'Curly',4, 'Fries');
INSERT INTO `menu` (`id`, `title`,  `price`,`category`) VALUES (8,'Waffle',4, 'Fries');
INSERT INTO `menu` (`id`, `title`,  `price`,`category`) VALUES (9,'Chili Cheese',4.5, 'Fries');

INSERT INTO `menu` (`id`, `title`,  `price`,`category`) VALUES (10,'Vegetal',6.5, 'Tacos');
INSERT INTO `menu` (`id`, `title`,  `price`,`category`) VALUES (11,'Carnitas',6.5, 'Tacos');
INSERT INTO `menu` (`id`, `title`,  `price`,`category`) VALUES (12,'Lengua',7.5, 'Tacos');
INSERT INTO `menu` (`id`, `title`,  `price`,`category`) VALUES (13,'Asada',7.5, 'Tacos');
INSERT INTO `menu` (`id`, `title`,  `price`,`category`) VALUES (14,'Barbacoa',7.5, 'Tacos');

INSERT INTO `menu` (`id`, `title`,  `price`,`category`) VALUES (15,'Soda',2.5, 'Beverages');
INSERT INTO `menu` (`id`, `title`,  `price`,`category`) VALUES (16,'Coke',3, 'Beverages');
INSERT INTO `menu` (`id`, `title`,  `price`,`category`) VALUES (17,'Orange Juice',3.5, 'Beverages');
