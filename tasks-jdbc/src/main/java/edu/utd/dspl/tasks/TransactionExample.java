package edu.utd.dspl.tasks;

import java.sql.*;
import java.util.Scanner;

/**
 * @author Fahad Shaon
 */
public class TransactionExample {
    public static final String QUERY_INSERT_TASK = "INSERT INTO task (title) VALUES (?)";
    public static final String QUERY_INSERT_ITEM = "INSERT INTO item (title, item_type, task_id) VALUES (?, ?, ?)";

    public static int insertTask(PreparedStatement taskInsertPS, String taskTitle) throws SQLException {

        taskInsertPS.setString(1, taskTitle);
        return insertRow(taskInsertPS);
    }

    public static int insertItem(PreparedStatement itemInsertPS, int taskId, String itemTitle) throws SQLException {

        itemInsertPS.setString(1, itemTitle);
        itemInsertPS.setInt(2, 0);
        itemInsertPS.setInt(3, taskId);

        return insertRow(itemInsertPS);
    }

    /**
     * Method for inserting into table and get the auto generated key output.
     *
     * @param insertPS Prepared statement for insertion
     * @return Auto generated key
     * @throws SQLException when number of inserted row is not exactly 1, can't read generated key, or
     *                      have trouble executing query.
     */
    private static int insertRow(PreparedStatement insertPS) throws SQLException {
        int rows = insertPS.executeUpdate();

        if (rows != 1) {
            throw new SQLException("Insertion should create one row. However number of rows changed returned value is " + rows);
        }

        ResultSet rs = insertPS.getGeneratedKeys();

        if (rs.next()) {
            return rs.getInt(1);
        } else {
            throw new SQLException("No generated keys found.");
        }
    }

    public static void main(String[] args) {

        Connection conn = null;
        try {
            conn = ConnectionUtils.getConnection();
            conn.setAutoCommit(false); //starting the transaction

            PreparedStatement taskInsertPS = conn.prepareStatement(QUERY_INSERT_TASK, Statement.RETURN_GENERATED_KEYS);
            PreparedStatement itemInsertPS = conn.prepareStatement(QUERY_INSERT_ITEM, Statement.RETURN_GENERATED_KEYS);

            Scanner scanner = new Scanner(System.in);

            while (true) {
                System.out.print("Enter task title [Ctrl + D to stop]: ");
                if (scanner.hasNext()) {
                    String taskTitle = scanner.nextLine().trim();
                    int taskId = insertTask(taskInsertPS, taskTitle);
                    System.out.println("Inserted task with id " + taskId);

                    while (true) {

                        System.out.print("Enter item title [-1 to stop]: ");
                        if (scanner.hasNext()) {

                            String itemTitle = scanner.nextLine();
                            if (itemTitle.equals("-1")) {
                                break;
                            }

                            int itemId = insertItem(itemInsertPS, taskId, itemTitle);
                            System.out.println("Added item with id " + itemId);

                        } else {
                            break;
                        }
                    }

                    System.out.println();
                } else {
                    break;
                }

                conn.commit();  // Commit after insertion of each task data
            }

        } catch (Exception e) {
            // For any type of exception we are going to do rollback, ideally should have different catch blocks
            e.printStackTrace();

            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException e1) {
                    System.err.println("Error while rollback!");
                    e.printStackTrace();
                }
            }
        } finally {
            ConnectionUtils.closeConnection(conn);
        }
    }
}
