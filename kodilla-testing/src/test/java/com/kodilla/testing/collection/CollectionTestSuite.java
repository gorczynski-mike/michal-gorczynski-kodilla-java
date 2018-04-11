package com.kodilla.testing.collection;

import org.junit.*;
import org.junit.rules.TestName;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class CollectionTestSuite {

    @Rule public TestName name = new TestName();

    @Before
    public void before() {
        System.out.printf("OddNumberExterminator test: %s: begin%n", name.getMethodName());
    }

    @After
    public void after() {
        System.out.printf("OddNumberExterminator test: %s: end%n", name.getMethodName());
    }

    @Test
    public void testOddNumbersExterminatorEmptyList() {
        //Given
        OddNumbersExterminator exterminator = new OddNumbersExterminator();
        ArrayList<Integer> emptyList = new ArrayList<>();
        //When
        ArrayList<Integer> result = exterminator.exterminate(emptyList);
        //Then
        Assert.assertEquals("Testing exterminator on empty input list", 0, result.size());
    }

    @Test
    public void testOddNumberExterminatoNormalList() {
        //Given
        OddNumbersExterminator exterminator = new OddNumbersExterminator();
        ArrayList<Integer> normalList = new ArrayList<>();
        normalList.addAll(Arrays.asList(new Integer[]{1,2,3,4,5,6,7,8,9,10}));
        //When
        ArrayList<Integer> result = exterminator.exterminate(normalList);
        Collections.sort(result);
        //Then
        Assert.assertArrayEquals("Testing exterminator on small normal input list", new Integer[]{2,4,6,8,10},
                result.toArray());
    }

}
