package com.kodilla.hibernate.tasklist.dao;

import com.kodilla.hibernate.tasklist.TaskList;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskListDaoTestSuite {

    @Autowired
    private TaskListDao taskListDao;

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

}
