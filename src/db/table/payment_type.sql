CREATE TABLE `payment_type` (
  `payment_type_id` int(11) NOT NULL AUTO_INCREMENT,
  `payment_type_name` varchar(25) NOT NULL,
  PRIMARY KEY (`payment_type_id`),
  UNIQUE KEY `payment_type_id_UNIQUE` (`payment_type_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

