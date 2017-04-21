-- Creates the languages table which stores all the supported programming languages
CREATE TABLE `language` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uq_name` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `idx_language` (`uq_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

