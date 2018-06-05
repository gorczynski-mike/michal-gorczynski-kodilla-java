package com.kodilla.hibernate.tasklist;

import com.kodilla.hibernate.task.Task;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="TASKLISTS")
public class TaskList {

    private int id;
    private String listName;
    private String description;
    private List<Task> tasksList = new ArrayList<>();

    public TaskList() {
        //do nothing
    }

    public TaskList(String listName, String description) {
        this.listName = listName;
        this.description = description;
    }

    @Id
    @GeneratedValue
    @NotNull
    @Column(name="ID")
    public int getId() {
        return id;
    }

    @Column(name="LISTNAME")
    @NotNull
    public String getListName() {
        return listName;
    }

    @Column(name="DESCRIPTION")
    public String getDescription() {
        return description;
    }

    @OneToMany(
            targetEntity = Task.class,
            mappedBy = "taskList",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    public List<Task> getTasksList() {
        return tasksList;
    }

    private void setId(int id) {
        this.id = id;
    }

    private void setListName(String listName) {
        this.listName = listName;
    }

    private void setDescription(String description) {
        this.description = description;
    }

    public void setTasksList(List<Task> tasksList) {
        this.tasksList = tasksList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TaskList taskList = (TaskList) o;
        return id == taskList.id &&
                Objects.equals(listName, taskList.listName) &&
                Objects.equals(description, taskList.description);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, listName, description);
    }
}
