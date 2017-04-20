CREATE TABLE `user_payment` (
  `user_payment_id` int(11) NOT NULL AUTO_INCREMENT,
  `payment_type_id` int(11) DEFAULT NULL COMMENT 'Can be null if we decide to stop supporting a payment method',
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`user_payment_id`),
  UNIQUE KEY `user_payment_id_UNIQUE` (`user_payment_id`),
  KEY `payment_type_id_idx` (`payment_type_id`),
  KEY `user_id_idx` (`user_id`),
  CONSTRAINT `user_payment_payment_type` FOREIGN KEY (`payment_type_id`) REFERENCES `payment_type` (`payment_type_id`) ON DELETE SET NULL ON UPDATE NO ACTION,
  CONSTRAINT `user_payment_user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

