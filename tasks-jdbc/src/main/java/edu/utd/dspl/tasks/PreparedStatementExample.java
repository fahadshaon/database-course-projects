package edu.utd.dspl.tasks;

import java.sql.*;
import java.util.Scanner;

/**
 * @author Fahad Shaon
 */
public class PreparedStatementExample {

    public static final String QUERY_SELECT_TASKS = "SELECT * FROM task";
    public static final String QUERY_SELECT_TASK_BY_ID = "SELECT * FROM task WHERE task_id = ?";
    public static final String QUERY_SELECT_ITEMS_OF_TASK = "SELECT * FROM item WHERE task_id = ?";

    public static void listTasks(Statement statement) throws SQLException {

        ResultSet resultSet = statement.executeQuery(QUERY_SELECT_TASKS);

        System.out.println("Id \t Task title");
        while (resultSet.next()) {
            int taskId = resultSet.getInt("task_id");
            String taskTitle = resultSet.getString("title");
            System.out.println("" + taskId + "\t" + taskTitle);
        }
    }

    public static void printTaskDetails(PreparedStatement taskDetailPS, PreparedStatement itemsOfTaskPS, int taskId)
            throws SQLException {

        taskDetailPS.setInt(1, taskId);    // setting proper values
        ResultSet taskRS = taskDetailPS.executeQuery();

        if (!taskRS.next()) {
            System.out.println("No task found");
            return;
        }

        System.out.println();
        System.out.println("Task Id: " + taskRS.getString("task_id"));
        System.out.println("Task Title: " + taskRS.getString("title"));
        System.out.println("Associated Items: ");

        itemsOfTaskPS.setInt(1, taskId);
        ResultSet itemsOfTaskRS = itemsOfTaskPS.executeQuery();

        while (itemsOfTaskRS.next()) {
            System.out.println(" - " + itemsOfTaskRS.getString("title"));
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Connection conn = null;
        try {
            conn = ConnectionUtils.getConnection();
            Statement statement = conn.createStatement();
            listTasks(statement);

            // Created only once
            PreparedStatement taskDetailPS = conn.prepareStatement(QUERY_SELECT_TASK_BY_ID);
            PreparedStatement itemsOfTaskPS = conn.prepareStatement(QUERY_SELECT_ITEMS_OF_TASK);

            Scanner scanner = new Scanner(System.in);

            while (true) {
                System.out.print("Enter Task ID [Ctrl + D to exit]: ");

                if (scanner.hasNextInt()) {

                    int taskId = scanner.nextInt();
                    printTaskDetails(taskDetailPS, itemsOfTaskPS, taskId);  // Use multiple times

                } else {
                    break;
                }
            }

        } catch (SQLException e) {
            System.err.println("SQL Exception with message: " + e.getMessage());
            e.printStackTrace();
        } finally {
            ConnectionUtils.closeConnection(conn);
        }
    }
}
