# Tracks a user's completion of module_lesson_components.
CREATE TABLE `user_module_lesson_component_completion` (
  `user_id` int(11) NOT NULL,
  `module_lesson_component_id` int(11) NOT NULL,

  PRIMARY KEY (`user_id`, `module_lesson_component_id`),
  KEY `fk_user_module_lesson_component_completion_module_lesson_co_idx` (`module_lesson_component_id`),

  CONSTRAINT `fk_completion_module_lesson_component`
    FOREIGN KEY (`module_lesson_component_id`)
    REFERENCES `module_lesson_component` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_user_module_lesson_component_completion_user`
    FOREIGN KEY (`user_id`)
    REFERENCES `user` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4
