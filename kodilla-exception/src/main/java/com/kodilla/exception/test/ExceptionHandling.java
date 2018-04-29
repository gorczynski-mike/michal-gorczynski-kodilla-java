package com.kodilla.exception.test;

public class ExceptionHandling {

    public static void main(String[] args) {

        SecondChallenge secondChallenge = new SecondChallenge();

        String s1 = null;
        try {
            s1 = secondChallenge.probablyIWillThrowException(1.6, 2.0);
        } catch (Exception e) {
            System.out.println("Exception occurred: " + e.getClass().getSimpleName());
            e.printStackTrace();
        } finally {
            System.out.println(s1);
        }

        String s2 = null;
        try {
            s2 = secondChallenge.probablyIWillThrowException(1.3, 1.5);
        } catch (Exception e) {
            System.out.println("Exception occurred: " + e.getClass().getSimpleName());
            e.printStackTrace();
        } finally {
            System.out.println(s2);
        }

        String s3 = null;
        try {
            s3 = secondChallenge.probablyIWillThrowException(0.2, 10.0);
        } catch (Exception e) {
            System.out.println("Exception occurred: " + e.getClass().getSimpleName());
            e.printStackTrace();
        } finally {
            System.out.println(s3);
        }


    }

}
