package edu.utd.dspl.tasks.controller;

import edu.utd.dspl.tasks.domain.Item;
import edu.utd.dspl.tasks.domain.Task;
import edu.utd.dspl.tasks.service.ItemService;
import edu.utd.dspl.tasks.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/task")
public class TaskItemsController {

    @Autowired
    private TaskService taskService;

    @Autowired
    private ItemService itemService;

    @GetMapping(value = "/detail")
    public String detail(@RequestParam("task_id") Long taskId, ModelMap model) {

        Task task = taskService.findOrFail(taskId);
        model.addAttribute("item", new Item());
        model.addAttribute("task", task);

        return "task/detail";
    }

    @PostMapping(value = "/item/save")
    public String edit(
            @RequestParam("task_id") Long taskId,
            @Valid @ModelAttribute("item") Item item,
            BindingResult bindingResult
    ) {

        if (bindingResult.hasErrors()) {
            return "task/detail";
        }

        itemService.save(item, taskId);
        return "redirect:/task/detail?task_id=" + taskId;
    }

    @PostMapping(value = "/item/state")
    public String changeState(
            @RequestParam("task_id") Long taskId,
            @RequestParam("item_id") Long itemId,
            @RequestParam("new_state") Integer newState
    ) {

        itemService.changeState(itemId, newState);
        return "redirect:/task/detail?task_id=" + taskId;
    }
}
