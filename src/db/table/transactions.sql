CREATE TABLE `transactions` (
  `transaction_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `transaction_type_id` int(11) DEFAULT NULL,
  `transaction_amount` decimal(15,2) NOT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`transaction_id`),
  KEY `transactions_user_idx` (`user_id`),
  KEY `transactions_transaction_type_idx` (`transaction_type_id`),
  CONSTRAINT `transactions_transaction_type` FOREIGN KEY (`transaction_type_id`) REFERENCES `transaction_type` (`transaction_type_id`) ON DELETE SET NULL ON UPDATE NO ACTION,
  CONSTRAINT `transactions_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE SET NULL ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

