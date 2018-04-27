package com.kodilla.stream.forumUser;

import java.time.LocalDate;

public class ForumUser {

    private final int userId;
    private final String userName;
    private final char userSex;
    private final LocalDate userDateOfBirth;
    private int userPostsQuantity;

    public ForumUser(final int userId, final String userName, final char userSex, final LocalDate userDateOfBirth, int
                     userPostsQuantity) {
        this.userId = userId;
        this.userName = userName;
        this.userSex = userSex;
        this.userDateOfBirth = userDateOfBirth;
        this.userPostsQuantity = userPostsQuantity;
    }

    public int getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public char getUserSex() {
        return userSex;
    }

    public LocalDate getUserDateOfBirth() {
        return userDateOfBirth;
    }

    public int getUserPostsQuantity() {
        return userPostsQuantity;
    }

    @Override
    public String toString() {
        return "ForumUser{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userSex=" + userSex +
                ", userDateOfBirth=" + userDateOfBirth +
                ", userPostsQuantity=" + userPostsQuantity +
                '}';
    }
}
