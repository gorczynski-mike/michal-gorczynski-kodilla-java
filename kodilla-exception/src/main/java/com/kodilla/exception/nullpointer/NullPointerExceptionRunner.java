package com.kodilla.exception.nullpointer;

public class NullPointerExceptionRunner {

    public static void main(String[] args){

        User user = null;

        MessageSender messageSender = new MessageSender();
        try {
            messageSender.sendMessageTo(user, "Hello!");
        } catch (MessageNotSentException e) {
            System.out.println(e.getClass().getSimpleName() + " : " + e.getMessage());
            System.out.println("Message is not sent but my program is running very well.");
        }

        System.out.println("Processing other logic.");

    }

}
