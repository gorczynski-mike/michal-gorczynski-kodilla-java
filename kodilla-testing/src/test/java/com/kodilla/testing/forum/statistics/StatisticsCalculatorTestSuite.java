package com.kodilla.testing.forum.statistics;

import org.junit.*;
import org.junit.rules.TestName;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

public class StatisticsCalculatorTestSuite {

    private static int testCount = 0;
    private String statisticsString;

    @Rule
    public TestName name = new TestName();

    @BeforeClass
    public static void beforeAllTests() {
        System.out.println("StatisticsCalculator Test Suite: begin");
    }

    @AfterClass
    public static void afterAllTests() {
        System.out.println("StatisticsCalculator Test Suite: end");
    }

    @Before
    public void beforeTest() {
        testCount++;
        System.out.println();
        System.out.println("Test #" + testCount + " : " + name.getMethodName() + " : begin");
    }

    @After
    public void afterTest() {
        System.out.println(statisticsString);
        System.out.println("Test #" + testCount + " : " + name.getMethodName() + " : end");
        System.out.println();
    }

    @Test
    public void testCalculateAdvStatisticsZeroPosts() {
        //Given
        Statistics statistics = Mockito.mock(Statistics.class);
        List<String> userNames = generateUsersList(20);
        Mockito.when(statistics.userNames()).thenReturn(userNames);
        Mockito.when(statistics.postsCount()).thenReturn(0);
        Mockito.when(statistics.commentsCount()).thenReturn(100);

        StatisticsCalculator statisticsCalculator = new StatisticsCalculator();

        //When
        statisticsCalculator.calculateAdvStatistics(statistics);
        statisticsString = statisticsCalculator.getStatistics();

        //Then
        Assert.assertTrue(Math.abs(statisticsCalculator.getAveragePostsPerUser()) < 0.00001 );
        Assert.assertTrue(Math.abs(statisticsCalculator.getAverageCommentsPerUser() - 5) < 0.00001);
        Assert.assertTrue(Double.isInfinite(statisticsCalculator.getAverageCommentsPerPost()));
    }

    @Test
    public void testCalculateAdvStatisticsThousandPosts() {
        //Given
        Statistics statistics = Mockito.mock(Statistics.class);
        List<String> userNames = generateUsersList(20);
        Mockito.when(statistics.userNames()).thenReturn(userNames);
        Mockito.when(statistics.postsCount()).thenReturn(1000);
        Mockito.when(statistics.commentsCount()).thenReturn(100);

        StatisticsCalculator statisticsCalculator = new StatisticsCalculator();

        //When
        statisticsCalculator.calculateAdvStatistics(statistics);
        statisticsString = statisticsCalculator.getStatistics();

        //Then
        Assert.assertTrue(Math.abs(statisticsCalculator.getAveragePostsPerUser() - 50) < 0.00001 );
        Assert.assertTrue(Math.abs(statisticsCalculator.getAverageCommentsPerUser() - 5) < 0.00001);
        Assert.assertTrue(Math.abs(statisticsCalculator.getAverageCommentsPerPost() - 0.1) < 0.00001);
    }

    @Test
    public void testCalculateAdvStatisticsZeroComments() {
        //Given
        Statistics statistics = Mockito.mock(Statistics.class);
        List<String> userNames = generateUsersList(20);
        Mockito.when(statistics.userNames()).thenReturn(userNames);
        Mockito.when(statistics.postsCount()).thenReturn(1000);
        Mockito.when(statistics.commentsCount()).thenReturn(0);

        StatisticsCalculator statisticsCalculator = new StatisticsCalculator();

        //When
        statisticsCalculator.calculateAdvStatistics(statistics);
        statisticsString = statisticsCalculator.getStatistics();

        //Then
        Assert.assertTrue(Math.abs(statisticsCalculator.getAveragePostsPerUser() - 50) < 0.00001 );
        Assert.assertTrue(Math.abs(statisticsCalculator.getAverageCommentsPerUser()) < 0.00001);
        Assert.assertTrue(Math.abs(statisticsCalculator.getAverageCommentsPerPost()) < 0.00001);
    }

    @Test
    public void testCalculateAdvStatisticsLessCommentsThanPosts() {
        //Given
        Statistics statistics = Mockito.mock(Statistics.class);
        Mockito.when(statistics.postsCount()).thenReturn(100);
        Mockito.when(statistics.commentsCount()).thenReturn(20);

        StatisticsCalculator statisticsCalculator = new StatisticsCalculator();

        //When
        statisticsCalculator.calculateAdvStatistics(statistics);
        statisticsString = statisticsCalculator.getStatistics();

        //Then
        Assert.assertTrue(statisticsCalculator.getAverageCommentsPerPost() < 1);
    }

    @Test
    public void testCalculateAdvStatisticsMoreCommentsThanPosts() {
        //Given
        Statistics statistics = Mockito.mock(Statistics.class);
        Mockito.when(statistics.postsCount()).thenReturn(20);
        Mockito.when(statistics.commentsCount()).thenReturn(100);

        StatisticsCalculator statisticsCalculator = new StatisticsCalculator();

        //When
        statisticsCalculator.calculateAdvStatistics(statistics);
        statisticsString = statisticsCalculator.getStatistics();

        //Then
        Assert.assertTrue(statisticsCalculator.getAverageCommentsPerPost() > 1);
    }

    @Test
    public void testCalculateAdvStatisticsZeroUsers() {
        //Given
        Statistics statistics = Mockito.mock(Statistics.class);
        List<String> userNames = generateUsersList(0);
        Mockito.when(statistics.userNames()).thenReturn(userNames);
        Mockito.when(statistics.postsCount()).thenReturn(1000);
        Mockito.when(statistics.commentsCount()).thenReturn(100);

        StatisticsCalculator statisticsCalculator = new StatisticsCalculator();

        //When
        statisticsCalculator.calculateAdvStatistics(statistics);
        statisticsString = statisticsCalculator.getStatistics();

        //Then
        Assert.assertTrue(Double.isInfinite(statisticsCalculator.getAveragePostsPerUser()));
        Assert.assertTrue(Double.isInfinite(statisticsCalculator.getAverageCommentsPerUser()));
    }

    @Test
    public void testCalculateAdvStatisticsHundredUsers() {
        //Given
        Statistics statistics = Mockito.mock(Statistics.class);
        List<String> userNames = generateUsersList(100);
        Mockito.when(statistics.userNames()).thenReturn(userNames);
        Mockito.when(statistics.postsCount()).thenReturn(1000);
        Mockito.when(statistics.commentsCount()).thenReturn(100);

        StatisticsCalculator statisticsCalculator = new StatisticsCalculator();

        //When
        statisticsCalculator.calculateAdvStatistics(statistics);
        statisticsString = statisticsCalculator.getStatistics();

        //Then
        Assert.assertTrue(Math.abs(statisticsCalculator.getAveragePostsPerUser() - 10) < 0.00001);
        Assert.assertTrue(Math.abs(statisticsCalculator.getAverageCommentsPerUser() - 1) < 0.00001);
    }

    @Test
    public void testCalculateAdvStatisticsEverythingZero() {
        //Given
        Statistics statistics = Mockito.mock(Statistics.class);

        StatisticsCalculator statisticsCalculator = new StatisticsCalculator();

        //When
        statisticsCalculator.calculateAdvStatistics(statistics);
        statisticsString = statisticsCalculator.getStatistics();

        //Then
        Assert.assertTrue(Double.isNaN(statisticsCalculator.getAveragePostsPerUser()));
        Assert.assertTrue(Double.isNaN(statisticsCalculator.getAverageCommentsPerPost()));
        Assert.assertTrue(Double.isNaN(statisticsCalculator.getAverageCommentsPerUser()));
    }


    private List<String> generateUsersList(int numberOfUsers) {
        List<String> usersList = new ArrayList<>();
        for(int i=0; i<numberOfUsers; i++) {
            usersList.add(String.valueOf(i));
        }
        return usersList;
    }

}
