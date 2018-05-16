package com.kodilla.patterns.factory;

public class Square implements Shape {

    private final String name;
    private final double width;

    public Square(String name, double width) {
        this.name = name;
        this.width = width;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public double getArea() {
        return width * width;
    }

    @Override
    public double getCircumference() {
        return 4.0 * width;
    }
}
