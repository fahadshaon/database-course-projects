package edu.utd.dspl.tasks.service;

import edu.utd.dspl.tasks.domain.Item;
import edu.utd.dspl.tasks.domain.Task;
import edu.utd.dspl.tasks.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Transactional
    public void printTaskDetail(Long id) {

        Optional<Task> task = taskRepository.findById(id);
        printTaskDetails(task.orElse(null));
    }

    private void printTaskDetails(Task task) {

        if (task == null) {
            System.out.println("No task found");
            return;
        }

        System.out.println("Task Id: " + task.getId());
        System.out.println("Task Title: " + task.getTitle());
        System.out.println("Associated Items: ");

        for (Item item : task.getItems()) {
            System.out.println(" - " + item.getTitle());
        }

        System.out.println();
    }
}
