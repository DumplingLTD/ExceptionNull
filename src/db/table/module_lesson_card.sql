# Represents the content within a module_lesson. This can be the form of titles, code snippets,
# paragraph text, code input, etc.
CREATE TABLE `module_lesson_card` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `module_lesson_id` int(11) NOT NULL,
  `order` int(11) NOT NULL,
  `card_template_class` varchar(512) CHARACTER SET utf8mb4 NOT NULL,
  `is_completable` tinyint(1) NOT NULL,
  `content` mediumtext NOT NULL,

  PRIMARY KEY (`id`),
  UNIQUE KEY `uq_module_lesson_id_order` (`module_lesson_id`,`order`),
  KEY `fk_module_lesson_card_module_lesson_idx` (`module_lesson_id`),

  CONSTRAINT `fk_module_lesson_card_module_lesson_idx`
  FOREIGN KEY (`module_lesson_id`)
  REFERENCES `module_lesson` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4
