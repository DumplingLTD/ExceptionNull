-- Payment types represent the supported payment methods
CREATE TABLE `payment_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uq_name` varchar(25) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `idx_payment_type` (`uq_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

