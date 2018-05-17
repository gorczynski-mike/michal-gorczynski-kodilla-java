package com.kodilla.patterns.builder.checkers;

import java.util.List;

public class Figure {

    public static final String WHITE = "WHITE";
    public static final String BLACK = "BLACK";
    final private String color;

    public Figure(String color) {
        if(color.equalsIgnoreCase(WHITE) || color.equalsIgnoreCase(BLACK)) {
            this.color = color;
        } else {
            throw new IllegalArgumentException("Only black or white colors are valid.");
        }
    }

    public String getColor() {
        return color;
    }
}
