package com.javawebtesting.entity;

public class Comment {
    private long id;
    private long id_user;
    private long id_product;
    private String content;

    public Comment() {
        super();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId_user() {
        return id_user;
    }

    public void setId_user(long id_user) {
        this.id_user = id_user;
    }

    public long getId_product(long id_product) {
        return this.id_product;
    }

    public void setId_product(long id_product) {
        this.id_product = id_product;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
