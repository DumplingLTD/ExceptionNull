-- Stores the various user types that each user is
CREATE TABLE `user_user_type` (
  `user_user_type_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `user_type_id` int(11) NOT NULL,
  PRIMARY KEY (`user_user_type_id`),
  KEY `user_id_idx` (`user_id`),
  KEY `user_type_id_idx` (`user_type_id`),
  CONSTRAINT `fk_user_user_type_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_user_user_type_user_type` FOREIGN KEY (`user_type_id`) REFERENCES `user_type` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

