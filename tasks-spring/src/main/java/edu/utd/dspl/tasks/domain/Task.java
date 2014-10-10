package edu.utd.dspl.tasks.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Fahad Shaon
 */
public class Task {
    private Integer taskId;
    private String title;
    private Date createdAt;
    private List<Item> itemList;

    public Integer getTaskId() {
        return taskId;
    }

    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public List<Item> getItemList() {
        return itemList;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }

    public List<Item> getTodoItemList() {
        List<Item> todoItems = new ArrayList<Item>();

        for (Item item : itemList) {
            if (item.isTodo()) {
                todoItems.add(item);
            }
        }

        return todoItems;
    }

    public List<Item> getDoneItemList() {
        List<Item> doneItems = new ArrayList<Item>();

        for (Item item : itemList) {
            if (item.isDone()) {
                doneItems.add(item);
            }
        }

        return doneItems;
    }

    @Override
    public String toString() {
        return "Task{" +
                "taskId=" + taskId +
                ", title='" + title + '\'' +
                ", createdAt=" + createdAt +
                ", itemList=" + itemList +
                '}';
    }
}
