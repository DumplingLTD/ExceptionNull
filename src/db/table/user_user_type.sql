CREATE TABLE `user_user_type` (
  `user_user_type_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `user_type_id` int(11) NOT NULL,
  PRIMARY KEY (`user_user_type_id`),
  UNIQUE KEY `user_user_type_id_UNIQUE` (`user_user_type_id`),
  KEY `user_id_idx` (`user_id`),
  KEY `user_type_id_idx` (`user_type_id`),
  CONSTRAINT `user_user_type_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE CASCADE ON UPDATE NO ACTION,
  CONSTRAINT `user_user_type_user_type` FOREIGN KEY (`user_type_id`) REFERENCES `user_type` (`user_type_id`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

