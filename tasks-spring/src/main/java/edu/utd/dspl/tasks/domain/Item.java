package edu.utd.dspl.tasks.domain;

/**
 * @author Fahad Shaon
 */
public class Item {

    public static final int ITEM_TYPE_TODO = 0;
    public static final int ITEM_TYPE_DONE = 1;
    private int itemId;
    private String title;
    private int itemType;
    private int order;
    private int taskId;

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getItemType() {
        return itemType;
    }

    public void setItemType(int itemType) {
        this.itemType = itemType;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public boolean isTodo() {
        return this.itemType == ITEM_TYPE_TODO;
    }

    public boolean isDone() {
        return this.itemType == ITEM_TYPE_DONE;
    }

    @Override
    public String toString() {
        return "Item{" +
                "itemId=" + itemId +
                ", title='" + title + '\'' +
                ", itemType=" + itemType +
                ", order=" + order +
                ", taskId=" + taskId +
                '}';
    }
}
