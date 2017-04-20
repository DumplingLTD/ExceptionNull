# Represents a logical group of ideas for a module. Modules may have one or more lessons.
CREATE TABLE `module_lesson` (
   `id` int(11) NOT NULL AUTO_INCREMENT,
   `module_id` int(11) NOT NULL,
   `order` int(11) NOT NULL,
   `title` varchar(256) NOT NULL,
   `description` varchar(1024) DEFAULT NULL,

   PRIMARY KEY (`id`),
   UNIQUE KEY `uq_module_id_order` (`module_id`,`order`),
   KEY `fk_module_lesson_module_idx` (`module_id`),

   CONSTRAINT `fk_module_lesson_module`
    FOREIGN KEY (`module_id`)
    REFERENCES `module` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE
 ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4
