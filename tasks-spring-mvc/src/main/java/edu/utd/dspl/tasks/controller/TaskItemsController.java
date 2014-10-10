package edu.utd.dspl.tasks.controller;

import edu.utd.dspl.tasks.dao.ItemDao;
import edu.utd.dspl.tasks.dao.TaskDao;
import edu.utd.dspl.tasks.domain.Item;
import edu.utd.dspl.tasks.domain.Task;
import edu.utd.dspl.tasks.utils.ItemValidator;
import edu.utd.dspl.tasks.utils.TaskValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
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
public class TaskItemsController {

    @Autowired
    private TaskDao taskDao;

    @Autowired
    private ItemDao itemDao;

    @RequestMapping(value = "/detail", method = RequestMethod.GET)
    public String detail(@RequestParam("task_id") Integer taskId, ModelMap model) {

        Task task = taskDao.getTaskByIdWithItems(taskId);
        model.addAttribute("item", new Item());
        model.addAttribute("task", task);

        return "task_detail";
    }

    @RequestMapping(value = "/detail", method = RequestMethod.POST)
    public String edit(@RequestParam("task_id") Integer taskId,
                       @Valid @ModelAttribute("item") Item item,
                       BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "task_detail";
        }

        item.setItemType(Item.ITEM_TYPE_TODO);
        item.setTaskId(taskId);

        itemDao.insertItem(item);

        System.out.println("Saved item " + item);

        return "redirect:/t/task/detail?task_id=" + taskId;
    }

    @RequestMapping(value = "/item/state", method = RequestMethod.POST)
    public String changeState(
            @RequestParam("task_id") Integer taskId,
            @RequestParam("item_id") Integer itemId,
            @RequestParam("new_state") Integer newState
    ) {
        System.out.println("Changing status of item id " + itemId + " to " + newState);

        if (newState == 0 || newState == 1) {
            itemDao.updateItemType(itemId, taskId, newState);
        }

        return "redirect:/t/task/detail?task_id=" + taskId;
    }

    @Autowired
    private ItemValidator itemValidator;

    @InitBinder("item")
    protected void initBinder(WebDataBinder binder) {
        binder.setValidator(itemValidator);
    }
}
