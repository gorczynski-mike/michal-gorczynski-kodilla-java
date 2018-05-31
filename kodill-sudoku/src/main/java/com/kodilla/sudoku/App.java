package com.kodilla.sudoku;

import com.kodilla.sudoku.simple.SimpleSudokuBoard;
import com.kodilla.sudoku.userinterface.ConsoleUserInterface;
import com.kodilla.sudoku.userinterface.UserChoiceHandler;
import com.kodilla.sudoku.userinterface.UserInterface;

public class App {

    public static void main(String[] args) {

        UserInterface userInterface = new ConsoleUserInterface();
        UserChoiceHandler userChoiceHandler = new UserChoiceHandler();

        boolean keepPlaying = true;
        while (keepPlaying) {
            SimpleSudokuBoard simpleSudokuBoard = new SimpleSudokuBoard();
            boolean endThisGame = false;
            while (!endThisGame) {
                simpleSudokuBoard.printBoard();
                String userInput = userInterface.getUserInput();
                endThisGame = userChoiceHandler.handleUserInput(userInput, simpleSudokuBoard);
            }
            keepPlaying = userInterface.getNewGameDecision();
        }
    }
}
