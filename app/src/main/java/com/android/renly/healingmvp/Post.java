package com.android.renly.healingmvp;

import java.util.List;

public class Post {
    private long id;
    private String tile;
    private String body;
    private long user_id;
    private long last_user_id;
    private String created_at;
    private String updated_at;
    private String categories;
    private int comments_total;
    private User user;
    private User last_user;
    private List<Comment> commentList;

    public Post() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTile() {
        return tile;
    }

    public void setTile(String tile) {
        this.tile = tile;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public long getLast_user_id() {
        return last_user_id;
    }

    public void setLast_user_id(long last_user_id) {
        this.last_user_id = last_user_id;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public String getCategories() {
        return categories;
    }

    public void setCategories(String categories) {
        this.categories = categories;
    }

    public int getComments_total() {
        return comments_total;
    }

    public void setComments_total(int comments_total) {
        this.comments_total = comments_total;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getLast_user() {
        return last_user;
    }

    public void setLast_user(User last_user) {
        this.last_user = last_user;
    }

    public List<Comment> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<Comment> commentList) {
        this.commentList = commentList;
    }
}
