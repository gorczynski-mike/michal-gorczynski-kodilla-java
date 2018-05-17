package com.kodilla.patterns.builder.pizza;

import java.util.ArrayList;
import java.util.List;

public class Pizza {

    private final String bottom;
    private final String sauce;
    private final List<String> ingredients = new ArrayList<>();

    public static class PizzaBuilder {
        private String bottom;
        private String sauce;
        private final List<String> ingredients = new ArrayList<>();

        public PizzaBuilder bottom(String bottom) {
            this.bottom = bottom;
            return this;
        }

        public PizzaBuilder sauce(String sauce) {
            this.sauce = sauce;
            return this;
        }

        public PizzaBuilder ingredient(String ingredient) {
            this.ingredients.add(ingredient);
            return this;
        }

        public Pizza build() {
            return new Pizza(this.bottom, this.sauce, this.ingredients.toArray(new String[0]));
        }
    }


    private Pizza(String bottom, String sauce, String... ingredients) {
        this.bottom = bottom;
        this.sauce = sauce;
        for(String ingredient: ingredients) {
            this.ingredients.add(ingredient);
        }
    }

    public String getBottom() {
        return bottom;
    }

    public String getSauce() {
        return sauce;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "bottom='" + bottom + '\'' +
                ", sauce='" + sauce + '\'' +
                ", ingredients=" + ingredients +
                '}';
    }
}
