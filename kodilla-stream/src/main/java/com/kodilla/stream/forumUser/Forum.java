package com.kodilla.stream.forumUser;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Forum {

    private final List<ForumUser> forumUsers = new ArrayList<>();

    public Forum(){
        forumUsers.add(new ForumUser(1, "name1", 'M', LocalDate.of(1970,1,1),20));
        forumUsers.add(new ForumUser(2, "name2", 'M', LocalDate.of(2012,1,1),0));
        forumUsers.add(new ForumUser(3, "name3", 'M', LocalDate.of(1990,1,1),2000));
        forumUsers.add(new ForumUser(4, "name4", 'W', LocalDate.of(1999,1,1),2));
        forumUsers.add(new ForumUser(5, "name5", 'M', LocalDate.of(2000,1,1),145));
        forumUsers.add(new ForumUser(6, "name6", 'M', LocalDate.of(1980,1,1),0));
        forumUsers.add(new ForumUser(7, "name7", 'M', LocalDate.of(2001,1,1),301));
        forumUsers.add(new ForumUser(8, "name8", 'W', LocalDate.of(1987,1,1),0));
    }

    public List<ForumUser> getForumUsers() {
        return new ArrayList<>(forumUsers);
    }
}
