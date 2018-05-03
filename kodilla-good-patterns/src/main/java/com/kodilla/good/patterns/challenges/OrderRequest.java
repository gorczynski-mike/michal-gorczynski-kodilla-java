package com.kodilla.good.patterns.challenges;

public class OrderRequest {

    private final User user;
    private final Product product;
    private final int quantity;

    public OrderRequest(User user, Product product, int quantity) {
        this.user = user;
        this.product = product;
        this.quantity = quantity;
    }

    public User getUser() {
        return user;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return "OrderRequest{" +
                "user=" + user +
                ", product=" + product +
                ", quantity=" + quantity +
                '}';
    }
}
