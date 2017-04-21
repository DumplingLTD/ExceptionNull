package com.jonathanpli.exceptionnull.model;

import com.jonathanpli.mysql.annotation.Column;
import com.jonathanpli.mysql.annotation.Table;

import static com.jonathanpli.mysql.Attribute.AUTO_INCREMENT;
import static com.jonathanpli.mysql.Attribute.FOREIGN_KEY;
import static com.jonathanpli.mysql.Attribute.INDEXED;
import static com.jonathanpli.mysql.Attribute.NOT_NULL;
import static com.jonathanpli.mysql.Attribute.PRIMARY_KEY;
import static com.jonathanpli.mysql.Attribute.UNIQUE;
import static com.jonathanpli.mysql.Datatype.INT;
import static com.jonathanpli.mysql.Datatype.MEDIUMTEXT;
import static com.jonathanpli.mysql.Datatype.TINYINT;
import static com.jonathanpli.mysql.Datatype.VARCHAR;

/**
 * Card contain user submitted content that comprises a lesson. Cards can take the form of
 * titles, paragraph text, code input fields, etc. This model reflects the fields within the
 * module_lesson_card table.
 * Keep up-to-date with table/module_lesson_card.sql
 */
@Table(name = "module_lesson_card")
public class ModuleLessonCard {
	@Column(name = "id",
			datatype = INT,
			datatypeParams = { 11 },
			attributes = { PRIMARY_KEY, AUTO_INCREMENT, NOT_NULL })
	public int id;

	@Column(name = "module_lesson_id",
			datatype = INT,
			datatypeParams = { 11 },
			attributes = { FOREIGN_KEY, INDEXED, UNIQUE, NOT_NULL })
	public int moduleLessonId;

	@Column(name = "order",
			datatype = INT,
			datatypeParams = { 11 },
			attributes = { UNIQUE, NOT_NULL })
	public int order;

	@Column(name = "card_template_class",
			datatype = VARCHAR,
			datatypeParams = { 512 },
			attributes = { NOT_NULL })
	public String cardTemplateClass;

	@Column(name = "is_completable",
			datatype = TINYINT,
			datatypeParams = { 1 },
			attributes = { NOT_NULL })
	public boolean isCompletable;

	@Column(name = "content", datatype = MEDIUMTEXT, attributes = { NOT_NULL })
	public String content;
}
