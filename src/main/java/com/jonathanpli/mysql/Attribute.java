package com.jonathanpli.mysql;

/**
 * A representation of attributes that can be applied to columns in MySQL.
 */
public enum Attribute {
	/**
	 * Denotes the column is numeric and non-negative.
	 */
	UNSIGNED,

	/**
	 * @link http://stackoverflow.com/questions/5256469/what-is-the-benefit-of-zerofill-in-mysql
	 */
	ZEROFILL,

	/**
	 * Denotes the column is automatically populated by the table's next available id value on new
	 * row insert.
	 */
	AUTO_INCREMENT,

	/**
	 * Denotes that the column is indexed in the table, but not necessarily that it's
	 * independently indexed.
	 */
	INDEXED,

	/**
	 * Denotes that the column is a primary key in the table, but not necessarily that it's the
	 * sole primary key.
	 */
	PRIMARY_KEY,

	/**
	 * Denotes that the column holds a reference to a foreign key.
	 */
	FOREIGN_KEY,

	/**
	 * Denotes that the column is either unique in itself, or part of a unique key set.
	 */
	UNIQUE,

	/**
	 * Denotes that the column must have a value.
	 */
	NOT_NULL
}
