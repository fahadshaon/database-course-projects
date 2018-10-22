package edu.utd.dspl.tasks.domain;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "task")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "task_id")
    private Long id;

    @NotNull
    @NotEmpty
    @Column(name = "title")
    private String title;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "taskId", cascade = CascadeType.ALL)
    private List<Item> items;

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

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    @Transient
    public List<Item> getTodoItems() {
        List<Item> todoItems = new ArrayList<>();

        for (Item item : items) {
            if (item.isTodo()) {
                todoItems.add(item);
            }
        }

        return todoItems;
    }

    @Transient
    public List<Item> getDoneItems() {
        List<Item> doneItems = new ArrayList<>();

        for (Item item : items) {
            if (item.isDone()) {
                doneItems.add(item);
            }
        }

        return doneItems;
    }
}
