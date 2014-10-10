package edu.utd.dspl.tasks;

import edu.utd.dspl.tasks.dao.TaskDao;
import edu.utd.dspl.tasks.domain.Item;
import edu.utd.dspl.tasks.domain.Task;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;

/**
 * @author Fahad Shaon
 */
public class Main {

    public static void printTaskDetails(Task task) {

        if (task == null) {
            System.out.println("No task found");
            return;
        }

        System.out.println();
        System.out.println("Task Id: " + task.getTaskId());
        System.out.println("Task Title: " + task.getTitle());
        System.out.println("Associated Items: ");

        for (Item item : task.getItemList()) {
            System.out.println(" - " + item.getTitle());
        }

        System.out.println();
    }

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("tasks.xml");

        TaskDao taskDao = context.getBean("taskDao", TaskDao.class);

        System.out.println("Total tasks in database: " + taskDao.count());

        System.out.println("Id \t Task Title");
        for (Task task : taskDao.getTasks()) {
            System.out.println(task.getTaskId() + "\t" + task.getTitle());
        }

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Enter Task ID [Ctrl + D to exit]: ");

            if (scanner.hasNextInt()) {

                int taskId = scanner.nextInt();
                printTaskDetails(taskDao.getTaskByIdWithItems(taskId));

            } else {
                break;
            }
        }
    }
}
