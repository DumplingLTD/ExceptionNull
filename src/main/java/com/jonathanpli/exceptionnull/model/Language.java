package com.jonathanpli.exceptionnull.model;

import com.jonathanpli.mysql.annotation.Column;
import com.jonathanpli.mysql.annotation.Table;

import static com.jonathanpli.mysql.Attribute.AUTO_INCREMENT;
import static com.jonathanpli.mysql.Attribute.INDEXED;
import static com.jonathanpli.mysql.Attribute.NOT_NULL;
import static com.jonathanpli.mysql.Attribute.PRIMARY_KEY;
import static com.jonathanpli.mysql.Attribute.UNIQUE;
import static com.jonathanpli.mysql.DataType.INT;
import static com.jonathanpli.mysql.DataType.VARCHAR;

/**
 * Represents the language table in the database, containing the possible languages for a user to
 * select and learn.
 * Keep up-to-date with table/language.sql.
 */
@Table(name = "language")
public class Language {
	@Column(name = "id",
			dataType = INT,
			datatypeParams = { 11 },
			attributes = { PRIMARY_KEY, AUTO_INCREMENT, NOT_NULL })
	public int id;

	@Column(name = "name",
			dataType = VARCHAR,
			datatypeParams = { 45 },
			attributes = { INDEXED, UNIQUE, NOT_NULL })
	public String name;
}
