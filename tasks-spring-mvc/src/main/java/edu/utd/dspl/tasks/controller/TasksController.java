package edu.utd.dspl.tasks.controller;

import edu.utd.dspl.tasks.dao.TaskDao;
import edu.utd.dspl.tasks.domain.Task;
import edu.utd.dspl.tasks.utils.TaskValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author Fahad Shaon
 */
@Controller
@RequestMapping("/task")
public class TasksController {

    @Autowired
    private TaskDao taskDao;

    @RequestMapping(method = RequestMethod.GET)
    public String list(ModelMap model) {
        model.addAttribute("tasks", taskDao.getTasks());
        return "tasks_list";
    }

    @RequestMapping(value = "/save", method = RequestMethod.GET)
    public String save(@RequestParam(value = "task_id", defaultValue = "") Integer taskId, ModelMap model) {

        Task task;
        if (taskId == null) {
            task = new Task();
        } else {
            task = taskDao.getTaskById(taskId);
        }

        model.addAttribute("task", task);

        return "task_save";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String edit(@Valid @ModelAttribute("task") Task task,
                       BindingResult bindingResult, ModelMap model) {

        if (bindingResult.hasErrors()) {
            return "task_save";
        }

        if (task.getTaskId() == null) {
            taskDao.insert(task);
        } else {
            taskDao.update(task);
        }

        return "redirect:/t/task/detail?task_id=" + task.getTaskId();
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String delete(@RequestParam(value = "task_id") Integer taskId, ModelMap model) {

        Task task = taskDao.getTaskById(taskId);
        model.addAttribute("task", task);

        return "task_delete";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String delete(@ModelAttribute("task") Task task,
                         @RequestParam(value = "confirm_delete") Integer confirmDelete) {

        if (confirmDelete != null && confirmDelete == 1) {
            taskDao.deleteWithItems(task.getTaskId());
            return "redirect:/t/task/";
        }

        return "redirect:/t/task/delete?task_id=" + task.getTaskId();
    }

    @Autowired
    private TaskValidator taskValidator;

    @InitBinder("task")
    protected void initBinder(WebDataBinder binder) {
        binder.setValidator(taskValidator);
    }
}
