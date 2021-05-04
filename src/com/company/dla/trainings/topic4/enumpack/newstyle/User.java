package com.company.dla.trainings.topic4.enumpack.newstyle;

public class User {
    private String name;
    private Roles role = Roles.REGULAR_USER;

    public User(String name) {
        this.name = name;
    }

    public User(String name, Roles role) {
        this.name = name;
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public Roles getRole() {
        return role;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", role=" + role + role.getFineNameInBrackets() +
                '}';
    }
}