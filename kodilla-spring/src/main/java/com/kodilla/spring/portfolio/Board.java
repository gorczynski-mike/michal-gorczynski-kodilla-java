package com.kodilla.spring.portfolio;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Board {

    private final TaskList toDoList;
    private final TaskList inProgressList;
    private final TaskList doneList;

    public Board(TaskList toDoList, TaskList inProgressList, TaskList doneList) {
        this.toDoList = toDoList;
        this.inProgressList = inProgressList;
        this.doneList = doneList;
    }

    public void addToDoTask(String toDoTask) {
        this.toDoList.addTask(toDoTask);
    }

    public void addInProgressTask(String inProgressTask) {
        this.inProgressList.addTask(inProgressTask);
    }

    public void addDoneTask(String doneTask) {
        this.doneList.addTask(doneTask);
    }

    public List<String> getToDoTasks() {
        return toDoList.getTasks();
    }

    public List<String> getInProgressTasks() {
        return inProgressList.getTasks();
    }

    public List<String> getDoneTasks() {
        return doneList.getTasks();
    }
}
