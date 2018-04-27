package com.kodilla.stream;

import com.kodilla.stream.beautifier.PoemBeautifier;
import com.kodilla.stream.book.Book;
import com.kodilla.stream.book.BookDirectory;
import com.kodilla.stream.forumUser.Forum;
import com.kodilla.stream.forumUser.ForumUser;
import com.kodilla.stream.iterate.NumbersGenerator;
import com.kodilla.stream.lambda.*;
import com.kodilla.stream.person.People;
import com.kodilla.stream.reference.FunctionalCalculator;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

        System.out.println();
        People.getList().stream()
                .forEach(System.out::println);

        System.out.println();
        People.getList().stream()
                .map(s -> s.toUpperCase())
                .forEach(System.out::println);

        System.out.println();
        People.getList().stream()
                .map(String::toUpperCase)
                .filter(s -> s.length() > 11)
                .map(s -> s.substring(0, s.indexOf(' ') + 2) + ".")
                .filter(s -> s.substring(0, 1).equals("M"))
                .forEach(System.out::println);


        System.out.println();
        BookDirectory theBookDirectory = new BookDirectory();
        theBookDirectory.getList().stream()
                .filter(book -> book.getYearOfPublication() > 2005)
                .forEach(System.out::println);

        System.out.println();
        List<Book> theResultListOfBook = theBookDirectory.getList().stream()
                .filter(book -> book.getYearOfPublication() > 2005)
                .collect(Collectors.toList());
        System.out.println("# of elements: " + theResultListOfBook.size());
        theResultListOfBook.stream()
                .forEach(System.out::println);

        Map<String, Book> theResultMapOfBooks = theBookDirectory.getList().stream()
                .filter(book -> book.getYearOfPublication() > 2005)
                .collect(Collectors.toMap(Book::getSignature, book -> book));

        System.out.println();
        System.out.println("# of elements: " + theResultMapOfBooks.size());
        theResultMapOfBooks.entrySet().stream()
                .map(entry -> entry.getKey() + ": " + entry.getValue())
                .forEach(System.out::println);

        String theResultStringOfBooks = theBookDirectory.getList().stream()
                .filter(book -> book.getYearOfPublication() > 2005)
                .map(Book::toString)
                .collect(Collectors.joining(",\n", "<<", ">>"));

        System.out.println();
        System.out.println(theResultStringOfBooks);


        // TASK 7.4
        Forum forum = new Forum();
        Map<Integer, ForumUser> theResultForumUserMap = forum.getForumUsers().stream()
                .filter(user -> user.getUserSex() == 'M')
                .filter(user -> user.getUserDateOfBirth().isBefore(LocalDate.now().minusYears(18)))
                .filter(user -> user.getUserPostsQuantity() > 0)
                .collect(Collectors.toMap(ForumUser::getUserId, user -> user));
        System.out.println();
        theResultForumUserMap.entrySet().stream()
                .forEach(System.out::println);

    }
}
