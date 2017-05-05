package com.jonathanpli.exceptionnull.model;

import com.jonathanpli.mysql.annotation.Column;
import com.jonathanpli.mysql.annotation.Table;

import static com.jonathanpli.mysql.Attribute.AUTO_INCREMENT;
import static com.jonathanpli.mysql.Attribute.FOREIGN_KEY;
import static com.jonathanpli.mysql.Attribute.INDEXED;
import static com.jonathanpli.mysql.Attribute.NOT_NULL;
import static com.jonathanpli.mysql.Attribute.PRIMARY_KEY;
import static com.jonathanpli.mysql.Attribute.UNIQUE;
import static com.jonathanpli.mysql.DataType.INT;
import static com.jonathanpli.mysql.DataType.VARCHAR;

/**
 * The metadata associated to a lesson. A lesson contains multiple {@link ModuleLessonCard}s in order to
 * portray a concept to the user. This model reflects the fields within the module_lesson table.
 * Keep up-to-date with table/module_lesson.sql.
 */
@Table(name = "module_lesson")
public class ModuleLesson {
	@Column(name = "id",
			dataType = INT,
			datatypeParams = { 11 },
			attributes = { PRIMARY_KEY, AUTO_INCREMENT, NOT_NULL })
	public int id;

	@Column(name = "module_id",
			dataType = INT,
			datatypeParams = { 11 },
			attributes = { FOREIGN_KEY, INDEXED, UNIQUE, NOT_NULL })
	public int moduleId;

	@Column(name = "order",
			dataType = INT,
			datatypeParams = { 11 },
			attributes = { UNIQUE, NOT_NULL })
	public int order;

	@Column(name = "title",
			dataType = VARCHAR,
			datatypeParams = { 256 },
			attributes = { NOT_NULL })
	public String title;

	@Column(name = "description", dataType = VARCHAR, datatypeParams = { 1024 })
	public String description;
}
