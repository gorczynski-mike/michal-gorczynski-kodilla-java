package com.kodilla.good.patterns.challenges;

public class User {

    private final String name;
    private final int customerId;

    public User(String name, int customerId) {
        this.name = name;
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public int getCustomerId() {
        return customerId;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", customerId=" + customerId +
                '}';
    }
}
