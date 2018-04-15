package com.kodilla.testing.shape;

import org.junit.*;
import org.junit.rules.TestName;

import java.util.ArrayList;

public class ShapeCollectorTestSuite {

    @Rule public TestName name = new TestName();
    private static int testCounter = 0;

    @BeforeClass
    public static void beforeAllTests() {
        System.out.println("Shape Collector Test Suite: begin");
    }

    @AfterClass
    public static void afterAllTests() {
        System.out.println("Shape Collector Test Suite: end");
    }

    @Before
    public void beforeTest() {
        testCounter++;
        System.out.println("Test #" + testCounter + " : " + name.getMethodName() + " : start");
    }

    @After
    public void afterTest() {
        System.out.println("Test #" + testCounter + " : " + name.getMethodName() + " : end");
    }

    @Test
    public void testAddNullFigure(){
        //Given
        ShapeCollector shapeCollector = new ShapeCollector();
        //When
        boolean result = shapeCollector.addFigure(null);
        //Then
        Assert.assertEquals(0,shapeCollector.getFiguresQuantity());
        Assert.assertFalse(result);
    }

    @Test
    public void testAddFigure(){
        //Given
        ShapeCollector shapeCollector = new ShapeCollector();
        Shape shape = new Square(4.0);
        //When
        boolean result = shapeCollector.addFigure(shape);
        //Then
        Assert.assertTrue(result);
        Assert.assertEquals(1, shapeCollector.getFiguresQuantity());
        Assert.assertEquals(shape, shapeCollector.getFigure(0));
    }

    @Test
    public void testRemoveNullFigure() {
        //Given
        ShapeCollector shapeCollector = new ShapeCollector();
        Shape shape = new Square(4.0);
        shapeCollector.addFigure(shape);
        //When
        boolean result = shapeCollector.removeFigure(null);
        //Then
        Assert.assertFalse(result);
        Assert.assertEquals(1,shapeCollector.getFiguresQuantity());
        Assert.assertEquals(shape, shapeCollector.getFigure(0));
    }

    @Test
    public void testRemoveFigureNotExisting() {
        //Given
        ShapeCollector shapeCollector = new ShapeCollector();
        Shape square = new Square(4.0);
        //When
        boolean result = shapeCollector.removeFigure(square);
        //Then
        Assert.assertFalse(result);
        Assert.assertEquals(0, shapeCollector.getFiguresQuantity());
    }

    @Test
    public void testRemoveFigure() {
        //Given
        ShapeCollector shapeCollector = new ShapeCollector();
        Shape shape1 = new Square(4.0);
        Shape shape2 = new Circle(4.0);
        Shape shape3 = new Triangle(4.0, 6.0);
        shapeCollector.addFigure(shape1);
        shapeCollector.addFigure(shape2);
        shapeCollector.addFigure(shape3);
        //When
        boolean result = shapeCollector.removeFigure(shape3);
        //Then
        Assert.assertTrue(result);
        Assert.assertEquals(2,shapeCollector.getFiguresQuantity());
        Assert.assertEquals(shape1,shapeCollector.getFigure(0));
        Assert.assertEquals(shape2,shapeCollector.getFigure(1));
    }

    @Test
    public void testGetFigureNotExisting() {
        //Given
        ShapeCollector shapeCollector = new ShapeCollector();
        //When
        Shape result = shapeCollector.getFigure(0);
        //Then
        Assert.assertNull(result);
    }

    @Test
    public void testGetFigure() {
        //Given
        ShapeCollector shapeCollector = new ShapeCollector();
        Shape shape1 = new Square(4.0);
        Shape shape2 = new Circle(4.0);
        Shape shape3 = new Triangle(4.0, 6.0);
        shapeCollector.addFigure(shape1);
        shapeCollector.addFigure(shape2);
        shapeCollector.addFigure(shape3);
        //When
        Shape result = shapeCollector.getFigure(1);
        //Then
        Assert.assertEquals(shape2, result);
    }

    @Test
    public void testShowFiguresNoFigures() {
        //Given
        ShapeCollector shapeCollector = new ShapeCollector();
        //When
        String result = shapeCollector.showFigures();
        //Then
        Assert.assertEquals("Figures: no figures", result);
    }

    @Test
    public void testShowFigures() {
        //Given
        ShapeCollector shapeCollector = new ShapeCollector();
        Shape shape1 = new Square(4.0);
        Shape shape2 = new Circle(4.0);
        Shape shape3 = new Triangle(4.0, 6.0);
        shapeCollector.addFigure(shape1);
        shapeCollector.addFigure(shape2);
        shapeCollector.addFigure(shape3);
        //When
        String result = shapeCollector.showFigures();
        //Then
        Assert.assertEquals("Figures: Square{name='Square', side=4.0}, Circle{name='Circle', radius=4.0}," +
                " Triangle{name='Triangle', base=4.0, height=6.0}", result);
    }

    @Test
    public void testAddFigureAlreadyExisting() {
        //Given
        ShapeCollector shapeCollector = new ShapeCollector();
        Shape square1 = new Square(4.0);
        Shape square2 = new Square(4.0);
        Shape circle1 = new Circle(4.0);
        Shape circle2 = new Circle(4.0);
        Shape triangle1 = new Triangle(4.0, 6.0);
        Shape triangle2 = new Triangle(4.0, 6.0);

        shapeCollector.addFigure(square1);
        shapeCollector.addFigure(circle1);
        shapeCollector.addFigure(triangle1);

        //When
        shapeCollector.addFigure(square2);
        shapeCollector.addFigure(circle2);
        shapeCollector.addFigure(triangle2);

        //Then
        Assert.assertEquals(3,shapeCollector.getFiguresQuantity());
        Assert.assertFalse(shapeCollector.containsFigureReference(square2));
        Assert.assertFalse(shapeCollector.containsFigureReference(circle2));
        Assert.assertFalse(shapeCollector.containsFigureReference(triangle2));
    }

}
