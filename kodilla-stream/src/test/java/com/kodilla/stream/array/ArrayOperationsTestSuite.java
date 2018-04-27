package com.kodilla.stream.array;

import org.junit.Assert;
import org.junit.Test;

public class ArrayOperationsTestSuite {

    @Test
    public void testGetAverage(){
        //Given
        int[] intArray1 = new int[]{1,2,3,4,5};
        int[] intArray2 = new int[0];
        int[] intArray3 = new int[]{10,5,2};

        //When
        double result1 = ArrayOperations.getAverage(intArray1);
        double result2 = ArrayOperations.getAverage(intArray2);
        double result3 = ArrayOperations.getAverage(intArray3);

        //Then
        Assert.assertEquals(3.0000, result1, 0.0001);
        Assert.assertTrue(Double.isNaN(result2));
        Assert.assertEquals(5.6666, result3, 0.0001);
    }

}
