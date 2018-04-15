package com.kodilla.testing.shape;

import java.util.Objects;

public class Triangle implements Shape{

    private final String name = "Triangle";
    private double base;
    private double height;

    public Triangle(double base, double height){
        this.base = base;
        this.height = height;
    }

    @Override
    public String getShapeName() {
        return this.name;
    }

    @Override
    public double getField() {
        return 0.5 * base * height;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Triangle triangle = (Triangle) o;
        return Double.compare(triangle.base, base) == 0 &&
                Double.compare(triangle.height, height) == 0 &&
                Objects.equals(name, triangle.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, base, height);
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "name='" + name + '\'' +
                ", base=" + base +
                ", height=" + height +
                '}';
    }
}
