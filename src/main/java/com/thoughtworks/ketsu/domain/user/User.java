package com.thoughtworks.ketsu.domain.user;

public class User {
    private long id;
    private String name;

    public User(){}

    public User(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
