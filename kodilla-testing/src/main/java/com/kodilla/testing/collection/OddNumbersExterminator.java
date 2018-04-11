package com.kodilla.testing.collection;

import java.util.ArrayList;

public class OddNumbersExterminator {

    public ArrayList<Integer> exterminate(ArrayList<Integer> numbers) {
        ArrayList<Integer> evenNumbersList = new ArrayList<>();
        for(int i: numbers) {
            if (i%2 == 0) {
                evenNumbersList.add(i);
            }
        }
        return evenNumbersList;
    }

}
