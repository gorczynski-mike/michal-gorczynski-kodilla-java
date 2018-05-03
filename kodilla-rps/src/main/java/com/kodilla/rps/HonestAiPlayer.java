package com.kodilla.rps;

import java.util.Random;

public class HonestAiPlayer extends Player{

    Random random = new Random();
    private final String name = "Honest AI player";

    @Override
    public ValidPlay play() {
        int generatedNumber = random.nextInt(3);
        return ValidPlay.values()[generatedNumber];
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "HonestAiPlayer{" +
                "name='" + name + '\'' +
                '}';
    }
}
