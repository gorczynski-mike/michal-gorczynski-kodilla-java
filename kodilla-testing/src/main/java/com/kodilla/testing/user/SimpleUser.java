package com.kodilla.testing.user;

public class SimpleUser {

    private String userName;
    private String realName;

    public SimpleUser(String userName, String realName) {
        this.userName = userName;
        this.realName = realName;
    }

    public String getUserName() {
        return this.userName;
    }

    public String getRealName() {
        return this.realName;
    }

}
