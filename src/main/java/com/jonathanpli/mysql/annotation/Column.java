package com.jonathanpli.mysql.annotation;

import com.jonathanpli.mysql.Attribute;
import com.jonathanpli.mysql.Datatype;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation to provide database context to a class's field.
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Column {

	/**
	 * The name of the column as defined in the database.
	 */
	String name() default "";

	/**
	 * The datatype of the column. For example, VARCHAR, INT, etc.
	 */
	Datatype datatype();

	/**
	 * Parameters that the datatype may have. For example, the length of a VARCHAR, or the
	 * digits to the left and right of a DECIMAL.
	 */
	int[] datatypeParams() default {};

	/**
	 * Attributes associated to the column. For example, AUTO_INCREMENT, or PRIMARY_KEY.
	 */
	Attribute[] attributes() default {};
}
