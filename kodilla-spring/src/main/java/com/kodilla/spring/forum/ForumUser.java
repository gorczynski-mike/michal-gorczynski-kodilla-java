package com.kodilla.spring.forum;

import org.springframework.stereotype.Component;

@Component
public class ForumUser {

    private final String userName;

    {
        userName = "John Smith";
    }

    public String getUserName() {
        return this.userName;
    }

}
