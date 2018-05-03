package com.kodilla.good.patterns.challenges;

public interface InformationService {

    boolean orderConfirmed(User user, Product product, int quantity);

    boolean orderRejected(User user, Product product, int quantity);

}
