package com.kodilla.patterns.factory;

public class Circle implements Shape {

    private final String name;
    private final double radius;

    public Circle(String name, double radius) {
        this.name = name;
        this.radius = radius;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double getCircumference() {
        return 2.0 * Math.PI * radius;
    }
}
