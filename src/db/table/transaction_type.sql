-- Transaction type stores the various supported transaction types
CREATE TABLE `transaction_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uq_name` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `idx_transaction_type` (`uq_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

