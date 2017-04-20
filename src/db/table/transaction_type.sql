CREATE TABLE `transaction_type` (
  `transaction_type_id` int(11) NOT NULL AUTO_INCREMENT,
  `transaction_type_name` varchar(45) NOT NULL,
  PRIMARY KEY (`transaction_type_id`),
  UNIQUE KEY `transaction_type_id_UNIQUE` (`transaction_type_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

