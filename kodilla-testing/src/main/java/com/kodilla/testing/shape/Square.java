package com.kodilla.testing.shape;

public class Square implements Shape{

    private final String name = "Square";
    private double side;

    public Square(double side){
        this.side = side;
    }

    @Override
    public String getShapeName() {
        return this.name;
    }

    @Override
    public double getField() {
        return side * side;
    }

}
