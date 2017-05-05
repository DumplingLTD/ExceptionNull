package com.jonathanpli.exceptionnull.config;

/**
 * Holds the constants that are used for the Exception Null application
 */
public class Constants {
    // Database connections
    private static final String DB_HOST = "localhost";
    private static final String DB_PORT = "3306";
    public static final String JDBC_URL = String.format("jdbc:mariadb://%s:%s/", DB_HOST, DB_PORT);
}
