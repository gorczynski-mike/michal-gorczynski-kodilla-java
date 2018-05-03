package com.kodilla.good.patterns.challenges;

public class EmailInformationService implements InformationService{

    @Override
    public boolean orderConfirmed(User user, Product product, int quantity) {
        return informViaEmail(user, product, quantity);
    }

    @Override
    public boolean orderRejected(User user, Product product, int quantity) {
        return informViaEmail(user, product, quantity);
    }

    private boolean informViaEmail(User user, Product product, int quantity) {
        System.out.println("I can't implement it yet, but let's pretend an email is being sent to the user.");
        return true;
    }

}
