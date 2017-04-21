-- Transaction tracks all the transactions that have been made on the platform
CREATE TABLE `transaction` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `type_id` int(11) NOT NULL,
  `sender_user_id` int(11) DEFAULT NULL,
  `amount` decimal(15,2) NOT NULL,
  `date` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `idx_type_id` (`type_id`),
  KEY `idx_sender_user_id` (`sender_user_id`),
  CONSTRAINT `fk_transaction_transaction_type` FOREIGN KEY (`type_id`) REFERENCES `transaction_type` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_transaction_user_id` FOREIGN KEY (`sender_user_id`) REFERENCES `user` (`id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

