package com.kodilla.stream.beautifier;

public class PoemBeautifier {

    public void beautify(String textToBeautify, PoemDecorator poemDecorator){
        System.out.println("Text before beautification: " + textToBeautify);
        System.out.println("Text after beautification: " + poemDecorator.decorate(textToBeautify));
    }

}
