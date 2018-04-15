package com.kodilla.testing.shape;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Square square = (Square) o;
        return Double.compare(square.side, side) == 0 &&
                Objects.equals(name, square.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, side);
    }

    @Override
    public String toString() {
        return "Square{" +
                "name='" + name + '\'' +
                ", side=" + side +
                '}';
    }
}
