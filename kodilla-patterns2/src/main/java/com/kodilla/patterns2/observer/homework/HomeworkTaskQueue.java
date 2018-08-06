package com.kodilla.patterns2.observer.homework;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class HomeworkTaskQueue implements Observable {

    private final String userName;
    private final Deque<HomeworkTask> tasks;
    private final List<Observer> obseervers;

    public HomeworkTaskQueue(String userName) {
        this.userName = userName;
        this.tasks = new ArrayDeque<>();
        this.obseervers = new ArrayList<>();
    }

    public void addHomeworkTask(HomeworkTask homeworkTask) {
        this.tasks.offerFirst(homeworkTask);
        notifyObservers();
    }

    public String getUserName() {
        return userName;
    }

    public Deque<HomeworkTask> getTasks() {
        return tasks;
    }

    @Override
    public void addObserver(Observer observer) {
        this.obseervers.add(observer);
    }

    @Override
    public void notifyObservers() {
        obseervers.forEach(observer -> observer.update(this));
    }

    @Override
    public void removeObserver(Observer observer) {
        this.obseervers.remove(observer);
    }
}
