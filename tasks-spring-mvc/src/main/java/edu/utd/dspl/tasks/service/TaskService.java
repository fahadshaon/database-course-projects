package edu.utd.dspl.tasks.service;

import edu.utd.dspl.tasks.domain.Item;
import edu.utd.dspl.tasks.domain.Task;
import edu.utd.dspl.tasks.repository.ItemRepository;
import edu.utd.dspl.tasks.repository.TaskRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class TaskService {

    private static Logger log = LoggerFactory.getLogger(TaskService.class);

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private ItemRepository itemRepository;

    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    public Task findOne(Long id) {
        return taskRepository.findById(id).orElse(null);
    }

    public Task findOrFail(Long id) {

        Task task = findOne(id);

        if (task == null) {
            throw new EntityNotFoundException("Task with id " + id + " not found.");
        }

        return task;
    }

    public <S extends Task> S save(S entity) {
        return taskRepository.save(entity);
    }

    @Transactional
    public void deleteTaskWithItems(Long taskId) {
        // Another alternate is to cascade the delete, has to ensure tables are created that way.

        log.info("Deleting task: " + taskId);

        Task task = taskRepository.getOne(taskId);
        for (Item item : task.getItems()) {
            itemRepository.delete(item);
        }

        taskRepository.delete(task);
    }
}
