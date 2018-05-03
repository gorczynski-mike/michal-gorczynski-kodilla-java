package com.kodilla.good.patterns.challenges;

public interface WarehouseService {

    boolean stock(Product product, int quantity);

    boolean isInStock(Product product, int quantity);

    boolean removeFromStock(Product product, int quantity);

    boolean sendProducts(User user, Product product, int quantity);

}
