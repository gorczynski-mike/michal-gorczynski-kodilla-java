package com.kodilla.patterns2.observer.homework;

import org.junit.Test;

import static org.junit.Assert.*;

public class HomeworkTaskQueueTestSuite {

    @Test
    public void testHomeworkObservers() {
        //Given
        HomeworkTaskQueue adamsTasks = new HomeworkTaskQueue("Adam");
        HomeworkTaskQueue charliesTasks = new HomeworkTaskQueue("Charlie");
        Mentor damian = new Mentor("Damian");
        Mentor eric = new Mentor("Eric");
        Mentor greg = new Mentor("Greg");
        adamsTasks.addObserver(damian);
        adamsTasks.addObserver(greg);
        charliesTasks.addObserver(eric);
        charliesTasks.addObserver(greg);
        //When
        adamsTasks.addHomeworkTask(new HomeworkTask("Description 1"));
        adamsTasks.addHomeworkTask(new HomeworkTask("Description 2"));
        adamsTasks.addHomeworkTask(new HomeworkTask("Description 3"));
        charliesTasks.addHomeworkTask(new HomeworkTask("Description 4"));
        charliesTasks.addHomeworkTask(new HomeworkTask("Description 5"));
        //Then
        assertEquals(3,damian.getUpdateCount());
        assertEquals(2,eric.getUpdateCount());
        assertEquals(5,greg.getUpdateCount());
    }

}