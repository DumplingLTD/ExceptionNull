CREATE TABLE `user_type` (
  `user_type_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_type_name` varchar(30) NOT NULL,
  PRIMARY KEY (`user_type_id`),
  UNIQUE KEY `user_type_id_UNIQUE` (`user_type_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

