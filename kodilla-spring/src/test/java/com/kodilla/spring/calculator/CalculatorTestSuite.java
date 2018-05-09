package com.kodilla.spring.calculator;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CalculatorTestSuite {

    @Test
    public void testCalculations() {
        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring");
        Calculator calculator = context.getBean(Calculator.class);
        double a = 5.0d;
        double b = 10.0d;
        double b2 = 0.0d;
        //When
        double resultAdd = calculator.add(a,b);
        double resultSub = calculator.sub(a,b);
        double resultMul = calculator.mul(a,b);
        double resultDiv1 = calculator.div(a,b);
        double resultDiv2 = calculator.div(a,b2);
        //Then
        Assert.assertEquals(15.0d, resultAdd, 0.0001d);
        Assert.assertEquals(-5.0d, resultSub, 0.0001d);
        Assert.assertEquals(50.0d, resultMul, 0.0001d);
        Assert.assertEquals(0.5d, resultDiv1, 0.0001d);
        Assert.assertTrue(Double.isInfinite(resultDiv2));
    }

}
