package com.kodilla.testing.forum;

import java.util.Objects;

public class ForumPost {

    private String postBody;
    private String postAuthor;

    public ForumPost(String postBody, String postAuthor) {
        this.postBody = postBody;
        this.postAuthor = postAuthor;
    }

    public String getPostBody() {
        return postBody;
    }

    public String getPostAuthor() {
        return postAuthor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ForumPost forumPost = (ForumPost) o;
        return Objects.equals(postBody, forumPost.postBody) &&
                Objects.equals(postAuthor, forumPost.postAuthor);
    }

    @Override
    public int hashCode() {

        return Objects.hash(postBody, postAuthor);
    }
}
