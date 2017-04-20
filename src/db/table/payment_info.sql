CREATE TABLE `payment_info` (
  `payment_info_id` int(11) NOT NULL AUTO_INCREMENT,
  `payment_info_name` varchar(25) NOT NULL,
  PRIMARY KEY (`payment_info_id`),
  UNIQUE KEY `payments_infocol_UNIQUE` (`payment_info_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

