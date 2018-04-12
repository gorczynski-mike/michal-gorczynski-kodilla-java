package com.kodilla.testing.forum.statistics;

public class StatisticsCalculator {

    private int usersQuantity;
    private int postsQuantity;
    private int commentsQuantity;
    private double averagePostsPerUser;
    private double averageCommentsPerUser;
    private double averageCommentsPerPost;


    public void calculateAdvStatistics(Statistics statistics) {
        usersQuantity = statistics.userNames().size();
        postsQuantity = statistics.postsCount();
        commentsQuantity = statistics.commentsCount();
        averagePostsPerUser = usersQuantity != 0 ? (double) postsQuantity / usersQuantity :
                (postsQuantity == 0 ? Double.NaN : Double.POSITIVE_INFINITY);
        averageCommentsPerUser = usersQuantity != 0 ? (double) commentsQuantity / usersQuantity :
                (commentsQuantity == 0 ? Double.NaN : Double.POSITIVE_INFINITY);
        averageCommentsPerPost = postsQuantity != 0 ? (double) commentsQuantity / postsQuantity :
                (commentsQuantity == 0 ? Double.NaN : Double.POSITIVE_INFINITY);

    }

    public void showStatistics() {
        System.out.println(getStatistics());
    }

    public String getStatistics(){
        return String.format("Users: %s, posts: %s, comments: %s, avg posts/user: %s, avg comments/user: %s, " +
                "avg comments/post: %s", usersQuantity, postsQuantity, commentsQuantity, averagePostsPerUser,
                averageCommentsPerUser, averageCommentsPerPost);
    }

    public int getUsersQuantity() {
        return usersQuantity;
    }

    public int getPostsQuantity() {
        return postsQuantity;
    }

    public int getCommentsQuantity() {
        return commentsQuantity;
    }

    public double getAveragePostsPerUser() {
        return averagePostsPerUser;
    }

    public double getAverageCommentsPerUser() {
        return averageCommentsPerUser;
    }

    public double getAverageCommentsPerPost() {
        return averageCommentsPerPost;
    }
}
