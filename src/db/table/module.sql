# Contains metadata for user generated modules.
CREATE TABLE `module` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `language_id` int(11) NOT NULL,
  `owner_user_id` int(11) NOT NULL,
  `title` varchar(128) CHARACTER SET utf8mb4 NOT NULL,
  `description` varchar(1024) CHARACTER SET utf8mb4 DEFAULT NULL,
  `date_created` datetime NOT NULL,
  `image_thumbnail_url` varchar(2048) CHARACTER SET utf8mb4 DEFAULT NULL,
  `image_banner_url` varchar(2048) CHARACTER SET utf8mb4 DEFAULT NULL,
  `is_author_hidden` tinyint(1) NOT NULL DEFAULT '0',
  `is_published` tinyint(1) NOT NULL,
  `is_premium` tinyint(1) NOT NULL,

  PRIMARY KEY (`id`),
  UNIQUE KEY `uq_language_title` (`language_id`,`title`),
  KEY `fk_module_user_owner_idx` (`owner_user_id`),
  KEY `fk_module_language_idx` (`language_id`),
  KEY `ix_title` (`title`),

  CONSTRAINT `fk_module_language`
  FOREIGN KEY (`language_id`)
  REFERENCES `language` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,

  CONSTRAINT `fk_module_user_owner`
  FOREIGN KEY (`owner_user_id`)
  REFERENCES `user` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4
