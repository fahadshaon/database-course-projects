package edu.utd.dspl.tasks;

import edu.utd.dspl.tasks.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityNotFoundException;

@Configuration
@EnableTransactionManagement
@SpringBootApplication(scanBasePackages = "edu.utd.dspl.tasks")
public class Application implements CommandLineRunner {

    @Autowired
    private TaskService taskService;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("-------------");

        Long taskId = 1L;
        try {
            taskService.printTaskDetail(taskId);

        } catch (EntityNotFoundException e) {
            System.out.println("Task with id " + taskId + " not found.");
        }

        System.out.println("-------------");
    }
}
