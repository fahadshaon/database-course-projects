package edu.utd.dspl;

import java.sql.*;

/**
 * This is a complete example of using JDBC to fetch data from a database.
 * However, this naive approach has several disadvantages and should NOT be used
 * in any production implementation.
 *
 * @author Fahad Shaon
 */
public class InitialExample {

    public static void main(String[] args) {

        String dbUrl = "jdbc:mysql://localhost/test_db?useSSL=false&serverTimezone=America/Chicago";
        String dbClass = "com.mysql.cj.jdbc.Driver";
        String username = "test_user";
        String password = "";   // Add the password here

        String query = "select * from item";

        Connection connection = null;
        try {
            // Load proper classes
            Class.forName(dbClass);

            // Connect to database
            connection = DriverManager.getConnection(dbUrl, username, password);

            // Create a statement from the connection
            Statement statement = connection.createStatement();

            // execute the query get the result set
            ResultSet resultSet = statement.executeQuery(query);

            // Iterate the result set, Number of iteration will be equal to
            // number of rows returned
            System.out.println("Item Id\tTitle");
            while (resultSet.next()) {

                // In each iteration result set will represent a row,
                // get proper column values
                int itemId = resultSet.getInt(1);
                String itemTitle = resultSet.getString(2);
                System.out.println("" + itemId + "\t" + itemTitle);
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

            // Close the connection explicitly
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
