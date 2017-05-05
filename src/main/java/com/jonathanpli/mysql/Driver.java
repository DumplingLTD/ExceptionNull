package com.jonathanpli.mysql;

import com.jonathanpli.exceptionnull.config.Constants;
import com.jonathanpli.mysql.annotation.Column;
import com.jonathanpli.mysql.annotation.Table;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

import java.math.BigDecimal;

import java.sql.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import static com.jonathanpli.mysql.Attribute.AUTO_INCREMENT;

/**
 * Represents the driver for database connections
 */
public class Driver {

    /**
     * returns a database connection
     */
    private Connection getConnection() {
        try (Connection con = DriverManager.getConnection(Constants.JDBC_URL + "ExceptionNull", "java", "password")) {

            return con;

        } catch (SQLException e) {

            System.out.println("The SQL Exception: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("Error Code: " + e.getErrorCode());

            return null;
        }
    }

    /**
     * creates a new entry for the model based off provided parameters
     */
    public SQLException create(Object model, List<Object> values) {
        try (Connection con = DriverManager.getConnection(Constants.JDBC_URL + "ExceptionNull", "java", "password")) {
            List<Column> params = getParams(model, column -> !Arrays.asList(column.attributes()).contains(AUTO_INCREMENT));
            String query = String.format("INSERT INTO %s (%s) VALUES %s"
                    , getTableName(model)
                    , getFormattedParams(getParamNames(params))
                    , getEmptyParams(params.size()));

            PreparedStatement preparedStatement = con.prepareStatement(query);
            SQLException ex = makePayload(preparedStatement, params, values);
            if (ex != null) {
                throw new SQLException(ex);
            }
            int affected = preparedStatement.executeUpdate();
            System.out.println(affected + " rows affected.");
            return null;
        } catch (SQLException e) {
            System.out.println("The SQL Exception: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("Error Code: " + e.getErrorCode());

            return e;
        }
    }

    public Object readById(Object model, List<String> values, String index, Object id) {
        try (Connection con = DriverManager.getConnection(Constants.JDBC_URL + "ExceptionNull", "java", "password")) {
            String query = String.format("SELECT %s FROM %s WHERE %s == %s"
                    , getFormattedParams(values)
                    , getTableName(model)
                    , index
                    , id);
            PreparedStatement preparedStatement = con.prepareStatement(query);
            ResultSet results = preparedStatement.executeQuery();
            if (results.getFetchSize() == 0) {
                throw new SQLException("There were no results found!");
            }

            return results.getArray(0);
        } catch (SQLException e) {
            System.out.println("The SQL Exception: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("Error Code: " + e.getErrorCode());

            return null;
        }
    }

    public ResultSet read(Object model, List<String> values, List<Predicate<Column>> filters) {
        try (Connection con = DriverManager.getConnection(Constants.JDBC_URL + "ExceptionNull", "java", "password")) {
            String query = String.format("SELECT %s FROM %s %s"
                    , getFormattedParams(values)
                    , getTableName(model));
                    // , TODO add WHERE clauses(s)

            PreparedStatement preparedStatement = con.prepareStatement(query);
            //SQLException ex = makePayload(preparedStatement, )
            return null;
        } catch (SQLException e) {
            System.out.println("The SQL Exception: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("Error Code: " + e.getErrorCode());

            return null;
        }
    }

    public SQLException update(Object model, List<Object> params, List<Object> values) {
        try (Connection con = DriverManager.getConnection(Constants.JDBC_URL + "ExceptionNull", "java", "password")) {
            String query = String.format("hello");

            return null;
        } catch (SQLException e) {
            System.out.println("The SQL Exception: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("Error Code: " + e.getErrorCode());

            return e;
        }
    }

    public SQLException delete(Object model, String keyName, String keyValue) {
        try (Connection con = DriverManager.getConnection(Constants.JDBC_URL + "ExceptionNull", "java", "password")) {
            String query = String.format("DELETE FROM %s WHERE %s == %s"
                    , getTableName(model)
                    , keyName
                    , keyValue);

            PreparedStatement preparedStatement = con.prepareStatement(query);
            int affected = preparedStatement.executeUpdate();
            System.out.println(affected + " rows were deleted");

            return null;
        } catch (SQLException e) {
            System.out.println("The SQL Exception: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("Error Code: " + e.getErrorCode());

            return e;
        }
    }

    // HELPERS

    /**
     * gets the table name from the table annotation for the object
     */
    private String getTableName(Object model) {
        Table annotation = model.getClass().getAnnotation(Table.class);
        return annotation.name();
    }

    /**
     * returns the parameters associated with the given model
     */
    private List<Column> getParams(Object model, Predicate<Column> filter) {
        Field[] fields = model.getClass().getFields();
        List<Column> params = new ArrayList<>();
        for (Field f : fields) {
            Annotation[] annotations = f.getDeclaredAnnotations();

            for (Annotation annotation : annotations) {
                if (annotation instanceof Column) {
                    Column column = (Column) annotation;
                    if (filter.test(column)) {
                        params.add(column);
                    }
                }
            }
        }

        return params;
    }

    /**
     * gets the parameter names for the table from the column annotations for the object
     */
    private List<String> getParamNames(List<Column> columns) {
        List<String> paramNames = new ArrayList<>();
        for (Column column : columns) {
            paramNames.add(column.name());
        }

        return paramNames;
    }

    /**
     * returns formatted String representation of parameters for prepared statement query
     */
    private String getFormattedParams(List<String> params) {
        return formatParams(new StringBuilder(params.toString()));
    }

    /**
     * returns String representation of the empty parameter sequence for a prepared statement query (?, ?, ?...)
     */
    private String getEmptyParams(int n) {
        String[] emptyParams = new String[n];
        Arrays.fill(emptyParams, "?");
        return formatParams(new StringBuilder(Arrays.toString(emptyParams)));
    }

    /**
     * formats the string for a SQL query
     */
    private String formatParams(StringBuilder builder) {
        builder.deleteCharAt(builder.length() - 1);
        builder.deleteCharAt(0);
        return builder.toString();
    }

    /**
     * sets the values for the prepared statement and returns a SQL error if present
     */
    private SQLException makePayload(PreparedStatement preparedStatement, List<Column> params, List<Object> values) {
        for (int i = 0, len = params.size(); i < len; ++i) {

            int idx = i + 1;
            Object value = values.get(i);
            DataType dataType = params.get(i).dataType();

            try {
                switch (dataType) {
                    // Strings
                    case CHAR:
                    case VARCHAR:
                        preparedStatement.setString(idx, (String) value);
                        break;
                    case BINARY:
                    case VARBINARY:
                        preparedStatement.setBytes(idx, (byte[]) value);
                        break;
                    case TINYTEXT:
                    case TEXT:
                    case MEDIUMTEXT:
                    case LONGTEXT:
                        preparedStatement.setClob(idx, (Clob) value);
                        break;
                    // Numeric
                    case BIT:
                        preparedStatement.setBoolean(idx, (boolean) value);
                        break;
                    case TINYINT:
                        preparedStatement.setByte(idx, (byte) value);
                        break;
                    case SMALLINT:
                        preparedStatement.setShort(idx, (short) value);
                        break;
                    case MEDIUMINT:
                    case INT:
                    case YEAR:
                        preparedStatement.setInt(idx, (int) value);
                        break;
                    case BIGINT:
                        preparedStatement.setLong(idx, (long) value);
                        break;
                    case DECIMAL:
                        preparedStatement.setBigDecimal(idx, (BigDecimal) value);
                        break;
                    case FLOAT:
                        preparedStatement.setDouble(idx, (double) value);
                        break;
                    case DOUBLE:
                        preparedStatement.setDouble(idx, (double) value);
                        break;
                    // Dates and times
                    case DATE:
                    case DATETIME:
                    case TIMESTAMP:
                    case TIME:
                        preparedStatement.setDate(idx, (Date) value);
                        break;
                    // Large objects
                    case TINYBLOB:
                    case BLOB:
                    case MEDIUMBLOB:
                    case LONGBLOB:
                        preparedStatement.setBlob(idx, (Blob) value);
                        break;
                    default:
                        throw new SQLException("Unsupported data type");
                }

            } catch (SQLException e) {
                System.out.println("The SQL Exception: " + e.getMessage());
                System.out.println("SQLState: " + e.getSQLState());
                System.out.println("Error Code: " + e.getErrorCode());

                return e;
            }
        }

        return null;
    }
}
