package com.kodilla.stream;

import com.kodilla.stream.beautifier.PoemBeautifier;
import com.kodilla.stream.iterate.NumbersGenerator;
import com.kodilla.stream.lambda.*;
import com.kodilla.stream.reference.FunctionalCalculator;

public class StreamMain {

    public static void main(String[] args){

//        System.out.println("Welcome to module 7 - Stream");
//
//        SaySomething saySomething = new SaySomething();
//        saySomething.say();

//        Processor processor = new Processor();
//        processor.execute(new ExecuteSaySomething());
//
//        Executor codeToExecute = () -> {
//            System.out.println("This is an example text in lambda");
//        };
//        processor.execute(codeToExecute);


//        ExpressionExecutor expressionExecutor = new ExpressionExecutor();
//        expressionExecutor.executeExpression(10,5, (a,b) -> a + b);
//        expressionExecutor.executeExpression(10,5, (a,b) -> a - b);
//        expressionExecutor.executeExpression(10,5, (a,b) -> a * b);
//        expressionExecutor.executeExpression(10,5, (a,b) -> a / b);
//
//        expressionExecutor.executeExpression(3,4, FunctionalCalculator::addAToB);
//        expressionExecutor.executeExpression(3,4, FunctionalCalculator::subBFromA);
//        expressionExecutor.executeExpression(3,4, FunctionalCalculator::multiplyAByB);
//        expressionExecutor.executeExpression(3,4, FunctionalCalculator::divideAByB);

        PoemBeautifier poemBeautifier = new PoemBeautifier();
        String textToBeautify = "This is an example text that will be beautified";
        poemBeautifier.beautify(textToBeautify, (text) -> "ABC " + text + " ABC");
        poemBeautifier.beautify(textToBeautify, (text) -> text.toUpperCase());
        poemBeautifier.beautify(textToBeautify, (text) -> {
            text = text.replaceAll("[iI]", "1");
            text = text.replaceAll("[eE]", "3");
            text = text.replaceAll("[aA]", "4");
            text = text.replaceAll("w", "vv");
            return text;
        });
        poemBeautifier.beautify(textToBeautify, (text) -> {
            StringBuilder sb = new StringBuilder();
            int counter = 0;
            for(char c : text.toCharArray()) {
                if(counter%2 == 0){
                    sb.append(Character.toLowerCase(c));
                } else {
                    sb.append(Character.toUpperCase(c));
                }
                counter++;
            }
            return sb.toString();
        });

        System.out.println();
        System.out.println("Using Stream to generate even numbers from 1 to 20");
        NumbersGenerator.generateEven(20);

    }
}
