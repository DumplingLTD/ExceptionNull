-- User type stores all the possible user types
CREATE TABLE `user_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uq_name` varchar(30) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `idx_user_type` (`uq_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

