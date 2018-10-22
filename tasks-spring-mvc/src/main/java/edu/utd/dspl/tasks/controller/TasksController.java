package edu.utd.dspl.tasks.controller;

import edu.utd.dspl.tasks.domain.Task;
import edu.utd.dspl.tasks.repository.TaskRepository;
import edu.utd.dspl.tasks.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author Fahad Shaon
 */
@Controller
@RequestMapping("/task")
public class TasksController {

    @Autowired
    private TaskService taskService;

    @GetMapping({"/", ""})
    public String list(ModelMap model) {
        model.addAttribute("tasks", taskService.findAll());

        return "task/list";
    }

    @GetMapping(value = "/save")
    public String save(@RequestParam(value = "task_id", defaultValue = "") Long taskId, ModelMap model) {

        Task task;

        if (taskId == null) {
            task = new Task();
        } else {
            task = taskService.findOrFail(taskId);
        }

        model.addAttribute("task", task);

        return "task/save";
    }

    @PostMapping(value = "/save")
    public String edit(@Valid @ModelAttribute("task") Task task, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "task/save";
        }

        task = taskService.save(task);
        return "redirect:/task/detail?task_id=" + task.getId();
    }

    @GetMapping(value = "/delete")
    public String delete(@RequestParam(value = "task_id") Long taskId, ModelMap model) {

        Task task = taskService.findOrFail(taskId);
        model.addAttribute("task", task);

        return "task/delete";
    }

    @PostMapping(value = "/delete")
    public String delete(
            @RequestParam(value = "task_id") Long taskId,
            @RequestParam(value = "confirm_delete") Integer confirmDelete
    ) {

        if (confirmDelete != null && confirmDelete == 1) {
            taskService.deleteTaskWithItems(taskId);
        }

        return "redirect:/task/";
    }
}
