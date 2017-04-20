CREATE TABLE `languages` (
  `languages_id` int(11) NOT NULL AUTO_INCREMENT,
  `language_name` varchar(45) NOT NULL,
  PRIMARY KEY (`languages_id`),
  UNIQUE KEY `languages_id_UNIQUE` (`languages_id`),
  UNIQUE KEY `language_name_UNIQUE` (`language_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

