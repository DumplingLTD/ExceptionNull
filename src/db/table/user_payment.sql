-- User payment records all users' payments on the platform
CREATE TABLE `user_payment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `payment_type_id` int(11) DEFAULT NULL COMMENT 'Can be null if we decide to stop supporting a payment method',
  `user_id` int(11) DEFAULT NULL,
  `date` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `user_payment_payment_type_idx` (`payment_type_id`),
  KEY `user_payment_user_idx` (`user_id`),
  CONSTRAINT `fk_user_payment_payment_type` FOREIGN KEY (`payment_type_id`) REFERENCES `payment_type` (`id`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `fk_user_payment_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

