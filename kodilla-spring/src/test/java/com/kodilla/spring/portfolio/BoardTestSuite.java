package com.kodilla.spring.portfolio;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BoardTestSuite {

    @Test
    public void testTaskAdd() {
        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext(BoardConfig.class);
        Board board = context.getBean(Board.class);
        //When
        board.addToDoTask("to do task 1");
        board.addInProgressTask("in progress task 1");
        board.addDoneTask("done task 1");
        String toDoTask = board.getToDoTasks().get(0);
        String inProgressTask = board.getInProgressTasks().get(0);
        String doneTask = board.getDoneTasks().get(0);
        //Then
        Assert.assertEquals("to do task 1", toDoTask);
        Assert.assertEquals("in progress task 1", inProgressTask);
        Assert.assertEquals("done task 1", doneTask);
    }

}
