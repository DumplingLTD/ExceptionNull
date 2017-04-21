-- User stores all the users that exist on the platform
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uq_username` varchar(45) NOT NULL,
  `display_name` varchar(40) NOT NULL,
  `email` varchar(70) NOT NULL,
  `password` binary(60) NOT NULL,
  `creation_date` datetime NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email_UNIQUE` (`email`),
  UNIQUE KEY `uq_username_UNIQUE` (`uq_username`),
  KEY `idx_username` (`uq_username`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4;

