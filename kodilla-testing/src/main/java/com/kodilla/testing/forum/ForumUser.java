package com.kodilla.testing.forum;

import java.util.ArrayList;
import java.util.LinkedList;

public class ForumUser {

    private String name;
    private String realName;
    private ArrayList<ForumPost> posts = new ArrayList<>();
    private LinkedList<ForumComment> comments = new LinkedList<>();

    public ForumUser(String name, String realName) {
        this.name = name;
        this.realName = realName;
    }

    public void addPost(String author, String postBody){
        posts.add(new ForumPost(postBody, author));
    }

    public void addComment(ForumPost thePost, String author, String comment){
        comments.add(new ForumComment(thePost, comment, author));
    }

    public int getPostsQuantity(){
        return posts.size();
    }

    public int getCommentQuantity(){
        return comments.size();
    }

    public ForumPost getPost(int postNumber){
        if(postNumber >= 0 && postNumber < posts.size()) {
            return posts.get(postNumber);
        } else {
            return null;
        }
    }

    public ForumComment getComment(int commentNumber){
        if(commentNumber >= 0 && commentNumber < comments.size()) {
            return comments.get(commentNumber);
        } else {
            return null;
        }
    }

    public boolean removePost(ForumPost thePost){
        if(posts.contains(thePost)) {
            posts.remove(thePost);
            return true;
        } else {
            return false;
        }
    }

    public boolean removeComment(ForumComment theComment){
        if(comments.contains(theComment)){
            comments.remove(theComment);
            return true;
        } else {
            return false;
        }
    }

    public String getName() {
        return name;
    }

    public String getRealName() {
        return realName;
    }
}
