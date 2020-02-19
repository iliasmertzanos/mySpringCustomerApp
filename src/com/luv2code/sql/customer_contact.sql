CREATE DATABASE  IF NOT EXISTS `my_first_db` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `my_first_db`;

CREATE TABLE `customer_contact` (
  `customer_id` int(11) NOT NULL,
  `contact_id` int(11) NOT NULL,
  
  PRIMARY KEY (`customer_id`,`contact_id`),
  
  CONSTRAINT `FK_CUSTOMER_05` FOREIGN KEY (`customer_id`) 
  REFERENCES `customer` (`id`) 
  ON DELETE NO ACTION ON UPDATE NO ACTION,
  
  CONSTRAINT `FK_CONTACT` FOREIGN KEY (`contact_id`) 
  REFERENCES `contact` (`id`) 
  ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;