package com.kodilla.patterns.factory.tasks;

import org.junit.Assert;
import org.junit.Test;

public class TaskFactoryTestSuite {

    @Test
    public void testMakeNonexistingTask() {
        //Given
        TaskFactory taskFactory = new TaskFactory();

        //When
        Task task = taskFactory.makeTask("DancingTask");

        //Then
        Assert.assertNull(task);
    }

    @Test
    public void testMakeTask() {
        //Given
        TaskFactory taskFactory = new TaskFactory();

        //When
        Task taskDriving = taskFactory.makeTask(TaskFactory.DRIVING_TASK);
        String drivingName = taskDriving.getTaskName();
        Task taskShopping = taskFactory.makeTask(TaskFactory.SHOPPING_TASK);
        String shoppingName = taskShopping.getTaskName();
        Task taskPainting = taskFactory.makeTask(TaskFactory.PAINTING_TASK);
        String paintingName = taskPainting.getTaskName();

        //Then
        Assert.assertEquals("DrivingTask", drivingName);
        Assert.assertEquals("ShoppingTask", shoppingName);
        Assert.assertEquals("PaintingTask", paintingName);
    }

}
