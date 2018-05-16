package com.kodilla.patterns.factory.tasks;

public final class TaskFactory {

    public final static String DRIVING_TASK = "DrivingTask";
    public final static String PAINTING_TASK = "PaintingTask";
    public final static String SHOPPING_TASK = "ShoppingTask";

    public final Task makeTask(final String taskClass) {
        switch(taskClass) {
            case DRIVING_TASK: return new DrivingTask("DrivingTask", "Gdansk", "Toyota");
            case PAINTING_TASK: return new PaintingTask("PaintingTask", "Red", "Fence");
            case SHOPPING_TASK: return new ShoppingTask("ShoppingTask", "Carrots", 4.0);
            default: return null;
        }
    }

}
