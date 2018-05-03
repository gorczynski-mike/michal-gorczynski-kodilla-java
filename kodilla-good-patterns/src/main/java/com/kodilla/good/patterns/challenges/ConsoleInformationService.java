package com.kodilla.good.patterns.challenges;

public class ConsoleInformationService implements InformationService {

    private static final String ORDER_CONFIRMED_MESSAGE = "Hello user %s your request: %d of %s was processed successfully.%n";
    private static final String ORDER_REJECTED_MESSAGE = "Hello user %s your request: %d of %s was rejected.%n";

    @Override
    public boolean orderConfirmed(User user, Product product, int quantity) {
        return informViaConsole(user, product, quantity, ORDER_CONFIRMED_MESSAGE);
    }

    @Override
    public boolean orderRejected(User user, Product product, int quantity) {
        return informViaConsole(user, product, quantity, ORDER_REJECTED_MESSAGE);
    }

    private boolean informViaConsole(User user, Product product, int quantity, String message) {
        System.out.printf(message,user, quantity, product);
        return true;
    }
}
