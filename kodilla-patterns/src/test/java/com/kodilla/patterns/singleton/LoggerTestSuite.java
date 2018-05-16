package com.kodilla.patterns.singleton;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class LoggerTestSuite {

    static Logger logger;

    @BeforeClass
    public static void beforeClass() {
        logger = Logger.getInstance();
    }

    @Test
    public void getLastLogTest() {
        //Given
        logger.log("msg1");
        logger.log("msg2");
        logger.log("msg3");
        //When
        String lastLog = logger.getLastLog();
        //Then
        Assert.assertEquals("msg3", lastLog);
    }

}
