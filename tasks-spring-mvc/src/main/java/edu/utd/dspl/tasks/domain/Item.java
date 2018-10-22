package edu.utd.dspl.tasks.domain;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "item")
public class Item {

    public static final int ITEM_TYPE_TODO = 0;
    public static final int ITEM_TYPE_DONE = 1;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id")
    private Long id;

    @NotNull
    @NotEmpty
    @Column(name = "title")
    private String title;

    @Column(name = "item_type")
    private Integer itemType;

    @Column(name = "`order`")
    private Integer order;

    @Column(name = "task_id")
    private Long taskId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getItemType() {
        return itemType;
    }

    public void setItemType(Integer itemType) {
        this.itemType = itemType;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    public boolean isTodo() {
        return this.itemType == ITEM_TYPE_TODO;
    }

    public boolean isDone() {
        return this.itemType == ITEM_TYPE_DONE;
    }
}
