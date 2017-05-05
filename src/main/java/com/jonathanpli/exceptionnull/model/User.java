package com.jonathanpli.exceptionnull.model;

import com.jonathanpli.mysql.annotation.Column;
import com.jonathanpli.mysql.annotation.Table;

import static com.jonathanpli.mysql.Attribute.AUTO_INCREMENT;
import static com.jonathanpli.mysql.Attribute.NOT_NULL;
import static com.jonathanpli.mysql.Attribute.PRIMARY_KEY;
import static com.jonathanpli.mysql.Attribute.INDEXED;
import static com.jonathanpli.mysql.Attribute.UNIQUE;
import static com.jonathanpli.mysql.DataType.INT;
import static com.jonathanpli.mysql.DataType.VARCHAR;
import static com.jonathanpli.mysql.DataType.BINARY;
import static com.jonathanpli.mysql.DataType.DATETIME;

/**
 * Contains metadata associated to a user. A user represents the person interacting with the application
 * Keep up-to-date with table/module.sql
 */
@Table(name = "user")
public class User {
    @Column(name = "id",
            dataType = INT,
            datatypeParams = { 11 },
            attributes = { PRIMARY_KEY, AUTO_INCREMENT, NOT_NULL })
    public int id;

    @Column(name = "username",
            dataType = VARCHAR,
            datatypeParams = { 45 },
            attributes = { INDEXED, UNIQUE, NOT_NULL })
    public String username;

    @Column(name = "display_name",
            dataType = VARCHAR,
            datatypeParams = { 40 },
            attributes = { NOT_NULL })
    public String displayName;

    @Column(name = "email",
            dataType = VARCHAR,
            datatypeParams = { 70 },
            attributes = { INDEXED, NOT_NULL })
    public String email;

    @Column(name = "password",
            dataType = BINARY,
            datatypeParams = { 60 },
            attributes = { NOT_NULL })
    public byte[] password;

    @Column(name = "creation_date",
            dataType = DATETIME,
            attributes = { NOT_NULL })
    public long creationDate;
}
