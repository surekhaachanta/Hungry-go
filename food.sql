
create database userCrud;
use userCrud;
CREATE TABLE `menu` (
  `id` int(11) NOT NULL,
  `title` varchar(75) DEFAULT NULL,
  `link` varchar(100) DEFAULT NULL,
  `price` int(11) NOT NULL,
  PRIMARY KEY (`id`)
);

INSERT INTO `menu` (`id`, `title`, `link`, `price`) VALUES (1,'Burger','/resources/images/Food11',8);
INSERT INTO `menu` (`id`, `title`, `link`, `price`) VALUES (2,'Fries','/resources/images/Food12',5);
INSERT INTO `menu` (`id`, `title`, `link`, `price`) VALUES (3,'Taco','/resources/images/Food13',10);
