package edu.utd.dspl.tasks;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author Fahad Shaon
 */
public class ConnectionUtils {

    public static Connection getConnection() throws SQLException {


        try {
            Properties properties = new Properties();
            properties.load(ConnectionUtils.class.getClassLoader().getResourceAsStream("jdbc.properties"));

            String dbUrl = properties.getProperty("jdbc.url");
            String dbClass = properties.getProperty("jdbc.driverClassName");
            String username = properties.getProperty("jdbc.username");
            String password = properties.getProperty("jdbc.password");

            Class.forName(dbClass);
            return DriverManager.getConnection(dbUrl, username, password);

        } catch (IOException e) {
            System.err.println("Configuration file not found.");
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            System.err.println("Proper database driver class not found.");
            throw new RuntimeException(e);
        }
    }


    public static void closeConnection(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                System.err.println("Error while closing database connection.");
                e.printStackTrace();
            }
        }
    }
}
