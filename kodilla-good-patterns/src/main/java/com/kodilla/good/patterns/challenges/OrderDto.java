package com.kodilla.good.patterns.challenges;

public class OrderDto {

    private final User user;
    private final boolean isSuccessful;

    public OrderDto(User user, boolean isSuccessful) {
        this.user = user;
        this.isSuccessful = isSuccessful;
    }

    public User getUser() {
        return user;
    }

    public boolean isSuccessful() {
        return isSuccessful;
    }

    @Override
    public String toString() {
        return "OrderDto{" +
                "user=" + user +
                ", isSuccessful=" + isSuccessful +
                '}';
    }
}
