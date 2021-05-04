package com.company.dla.trainings.topic4.enumpack.oldstyle;

public class User {
    private String name;
    private int role = Roles.REGULAR_USER;

    public User(String name) {
        this.name = name;
    }

    public User(String name, int role) {
        this.name = name;
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public int getRole() {
        return role;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", role=" + role +
                '}';
    }
}
