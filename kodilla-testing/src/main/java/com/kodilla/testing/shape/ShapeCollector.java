package com.kodilla.testing.shape;

import java.util.ArrayList;
import java.util.StringJoiner;

public class ShapeCollector {

    private ArrayList<Shape> shapes = new ArrayList<>();

    public boolean addFigure(Shape shape){
        if(shape == null) {
            return false;
        } else {
            return shapes.add(shape);
        }
    }

    public boolean removeFigure(Shape shape){
        if(shapes.contains(shape)) {
            return shapes.remove(shape);
        } else {
            return false;
        }
    }

    public Shape getFigure(int n){
        if(n >= 0 && n < shapes.size()) {
            return shapes.get(n);
        } else {
            return null;
        }
    }

    public String showFigures() {
        if(shapes.size() == 0) {
            return "Figures: no figures";
        } else {
            StringJoiner sj = new StringJoiner(", ");
            for(Shape shape: shapes) {
                sj.add(shape.getShapeName());
            }
            return "Figures: " + sj.toString();
        }
    }

    public int getFiguresQuantity() {
        return shapes.size();
    }



}
