package com.kodilla.hibernate.tasklist.dao;

import com.kodilla.hibernate.task.Task;
import com.kodilla.hibernate.task.TaskFinancialDetails;
import com.kodilla.hibernate.tasklist.TaskList;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskListDaoTestSuite {

    @Autowired
    private TaskListDao taskListDao;
    private static final String LIST_NAME = "List Name";

    @Test
    @Transactional
    public void testFindByListName() {

        //Given
        TaskList taskList = new TaskList("list1", "descirption1");
        taskListDao.save(taskList);

        //When
        TaskList resultTaskLists = taskListDao.findByListName("list1");

        //Then
        Assert.assertNotNull(resultTaskLists);
        Assert.assertTrue(resultTaskLists.equals(taskList));
    }

    @Test
    @Transactional
    public void testTaskListDaoSaveWithTasks() {
        //Given
        Task task = new Task("Test: Learn Hibernate", 14);
        Task task2 = new Task("Test: Write some entities", 3);
        TaskFinancialDetails tfd = new TaskFinancialDetails(new BigDecimal(20), false);
        TaskFinancialDetails tfd2 = new TaskFinancialDetails(new BigDecimal(10), false);
        task.setTaskFinancialDetails(tfd);
        task2.setTaskFinancialDetails(tfd2);
        TaskList taskList = new TaskList(LIST_NAME, "ToDo tasks");
        taskList.getTasksList().add(task);
        taskList.getTasksList().add(task2);
        task.setTaskList(taskList);
        task2.setTaskList(taskList);

        //When
        taskListDao.save(taskList);
        int id = taskList.getId();

        //Then
        Assert.assertNotEquals(0, id);
    }

}
