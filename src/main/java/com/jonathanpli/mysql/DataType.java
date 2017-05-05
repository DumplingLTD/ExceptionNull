package com.jonathanpli.mysql;

/**
 * A representation of the datatype available in MySQL.
 * @link https://www.techonthenet.com/mysql/datatypes.php
 */
public enum DataType {
	// Strings
	CHAR(1, true),
	VARCHAR(1, true),
	BINARY(1, true),
	VARBINARY(1, true),

	TINYTEXT(1, false),
	TEXT(1, false),
	MEDIUMTEXT(1, false),
	LONGTEXT(1, false),

	// Numeric
	BIT(0, false),
	TINYINT(1, false),
	SMALLINT(1, false),
	MEDIUMINT(1, false),
	/** Synonymous to INTEGER. */
	INT(1, false),
	BIGINT(1, false),

	/** Synonymous to DEC, NUMERIC, and FIXED */
	DECIMAL(2, false),
	FLOAT(2, true),
	/** Synonymous to DOUBLE PRECISION, and REAL */
	DOUBLE(2, true),

	// Date and time
	DATE(0, false),
	DATETIME(0, false),
	TIMESTAMP(0, false),
	TIME(0, false),
	YEAR(1, false),

	// Large object
	TINYBLOB(0, false),
	BLOB(1, false),
	MEDIUMBLOB(0, false),
	LONGBLOB(0, false)
	;

	private int parameterCount;
	private boolean isParameterRequired;
	/**
	 * @param parameterCount For example, a BLOB has no length specification, whereas VARCHAR
	 * one, the max length of the VARCHAR, whereas NUMERIC has two, the digits before the decimal,
	 * and the digits after the decimal.
	 * @param isParameterRequired If the length specification parameter is required for the
	 * datatype.
	 */
	private DataType(int parameterCount, boolean isParameterRequired) {
		this.parameterCount = parameterCount;
		this.isParameterRequired = isParameterRequired;
	}

	/**
	 * For example, a BLOB has no length specification, whereas VARCHAR
	 * one, the max length of the VARCHAR, whereas NUMERIC has two, the digits before the decimal,
	 * and the digits after the decimal.
	 * @return Returns the number of parameters the datatype expects.
	 */
	public int getParameterCount() {
		return parameterCount;
	}

	/**
	 * Returns if the length specification is required for this datatype.
	 */
	public boolean isParameterRequired() {
		return isParameterRequired;
	}
}
