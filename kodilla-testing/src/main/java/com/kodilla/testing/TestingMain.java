package com.kodilla.testing;

import com.kodilla.testing.calculator.Calculator;
import com.kodilla.testing.user.SimpleUser;

public class TestingMain {

    public static void main(String[] args){
        SimpleUser simpleUser = new SimpleUser("theForumUser");
        String result = simpleUser.getUserName();

        if(result.equals("theForumUser")) {
            System.out.println("SimpleUser test OK");
        } else {
            System.err.println("SimpleUser test Error");
        }

        // com.kodilla.testing.calculator.Calculator tests
        Calculator calculator = new Calculator();

        // Test 1 Calculator.add()
        int calculatorAddTestResult = calculator.add(4,7);
        if(calculatorAddTestResult == 11) {
            System.out.println("Calculator.add() test OK");
        } else {
            System.err.println("Calculator.add() test ERROR");
        }

        // Test 2 Calculator.subtract()
        int calculatorSubtractTestResult = calculator.subtract(4,7);
        if(calculatorSubtractTestResult == -3) {
            System.out.println("Calculator.subtract() test OK");
        } else {
            System.err.println("Calculator.subtract() test ERROR");
        }
    }

}
