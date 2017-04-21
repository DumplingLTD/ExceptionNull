-- Transaction tracks all the transactions that have been made on the platform
CREATE TABLE `transaction` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `type_id` int(11) NOT NULL,
  `sender_user_id` int(11) DEFAULT NULL,
  `amount` decimal(15,2) NOT NULL,
  `date` datetime NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `transaction_transaction_type` FOREIGN KEY (`id`) REFERENCES `transaction_type` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

