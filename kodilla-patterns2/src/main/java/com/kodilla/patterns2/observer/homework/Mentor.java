package com.kodilla.patterns2.observer.homework;

public class Mentor implements Observer {

    private final String name;
    private int updateCount;

    public Mentor(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getUpdateCount() {
        return updateCount;
    }

    @Override
    public void update(HomeworkTaskQueue homeworkTaskQueue) {
        System.out.println("Mentor: " + this.name + " has been notified about new homework submitted by: " +
                homeworkTaskQueue.getUserName() + ". Total homeworks in the queue for this user: " +
                homeworkTaskQueue.getTasks().size());
        updateCount++;
    }
}
