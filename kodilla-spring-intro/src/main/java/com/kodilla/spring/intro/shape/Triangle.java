package com.kodilla.spring.intro.shape;

public class Triangle implements Shape {

    @Override
    public String draw() {
        String message = "This is a triangle";
        System.out.println(message);
        return message;
    }

//    @Override
//    public void draw() {
//        System.out.println("This is a triangle");
//    }

}
