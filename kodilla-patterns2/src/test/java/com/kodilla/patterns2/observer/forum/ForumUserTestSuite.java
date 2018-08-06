package com.kodilla.patterns2.observer.forum;

import org.junit.Test;

import static org.junit.Assert.*;

public class ForumUserTestSuite {

    @Test
    public void testUpdate() {
        //Given
        ForumTopic javaHelpTopic = new JavaHelpForumTopic();
        ForumTopic javaToolsTopic = new JavaToolsForumTopic();
        ForumUser adam = new ForumUser("Adam");
        ForumUser bernie = new ForumUser("Bernie");
        ForumUser charlie = new ForumUser("Charlie");
        javaHelpTopic.registerObserver(adam);
        javaHelpTopic.registerObserver(charlie);
        javaToolsTopic.registerObserver(bernie);
        javaToolsTopic.registerObserver(charlie);
        //When
        javaHelpTopic.addPost("Java help post 1");
        javaHelpTopic.addPost("Java help post 2");
        javaHelpTopic.addPost("Java help post 3");
        javaHelpTopic.addPost("Java help post 4");
        javaToolsTopic.addPost("Java tools post 1");
        javaToolsTopic.addPost("Java tools post 2");
        javaToolsTopic.addPost("Java tools post 3");
        //Then
        assertEquals(4, adam.getUpdateCount());
        assertEquals(3, bernie.getUpdateCount());
        assertEquals(7, charlie.getUpdateCount());
    }
}