package com.kodilla.patterns2.observer.forum;

public class ForumUser implements Observer {

    private final String name;
    private int updateCount;

    public ForumUser(String name) {
        this.name = name;
        this.updateCount = 0;
    }

    public String getName() {
        return name;
    }

    public int getUpdateCount() {
        return updateCount;
    }

    @Override
    public void update(ForumTopic forumTopic) {
        System.out.println("User: " + this.name + ": new message in topic: " +forumTopic.getName() +
                "(total: " + forumTopic.getMessages().size() +" messages)");
        updateCount++;
    }
}
