package br.com.cyberlinkrv.conector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conectorMySQL {

    private static final String URL_ENV = "DB_URL";
    private static final String USER_ENV = "DB_USER";
    private static final String PASSWORD_ENV = "DB_PASSWORD";

    private static String requiredEnvironmentVariable(String name) throws SQLException {
        String value = System.getenv(name);
        if (value == null || value.trim().isEmpty()) {
            throw new SQLException("Required database configuration is missing: " + name);
        }
        return value;
    }

    public static Connection obterConexao() throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new SQLException("MySQL JDBC driver is not available", e);
        }

        String url = requiredEnvironmentVariable(URL_ENV);
        String user = requiredEnvironmentVariable(USER_ENV);
        String password = requiredEnvironmentVariable(PASSWORD_ENV);
        return DriverManager.getConnection(url, user, password);
    }
}
