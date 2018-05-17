package com.kodilla.patterns.builder.bigmac;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Bigmac {

    private Bun bun;
    private int burgers;
    private Sauce sauce;
    private final List<Ingredient> ingredients = new ArrayList<>();
    private static final List<Integer> VALID_NUMBERS_OF_BURGERS = Arrays.asList(0,1,2,3);

    public enum Bun{
        ORDINARY, SESAME;
    }

    public enum Sauce{
        HOT, MILD, BBQ;
    }

    public enum Ingredient{
        TOMATO, ONION, MUSHROOM, PICKLE, LETTUCE, CHEESE;
    }

    public static class BigmacBuilder {
        private final Bun bun;
        private int burgers;
        private final Sauce sauce;
        private final List<Ingredient> ingredients;

        public BigmacBuilder(Bun bun, Sauce sauce){
            this.bun = bun;
            this.burgers = 0;
            this.sauce = sauce;
            this.ingredients = new ArrayList<>();
        }

        public BigmacBuilder burgers(int burgers) {
            this.burgers = burgers;
            return this;
        }

        public BigmacBuilder ingredient(Ingredient ingredient) {
            this.ingredients.add(ingredient);
            return this;
        }

        public Bigmac build() {
            if(!VALID_NUMBERS_OF_BURGERS.contains(this.burgers)) {
                throw new IllegalStateException("Invalid number of burgers.");
            }
            if(this.bun == null || this.sauce == null) {
                throw new IllegalStateException("Bun or sauce missing");
            }
            return new Bigmac(this.bun, this.burgers, this.sauce, this.ingredients);
        }
    }

    private Bigmac(Bun bun, int burgers, Sauce sauce, List<Ingredient> ingredients) {
        this.bun = bun;
        this.burgers = burgers;
        this.sauce = sauce;
        ingredients.forEach(ingredient -> this.ingredients.add(ingredient));
    }

    @Override
    public String toString() {
        return "Bigmac{" +
                "bun=" + bun +
                ", burgers=" + burgers +
                ", sauce=" + sauce +
                ", ingredients=" + ingredients +
                '}';
    }
}
