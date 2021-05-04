package com.company.dla.trainings.topic4.reflection.getinfo;

public class Parent {
    public String name;
    protected int age;
    private boolean isSecret;

    public Parent(String name, int age, boolean isSecret) {
        this.name = name;
        this.age = age;
        this.isSecret = isSecret;
    }

    public Parent() {
    }

    private String getName() {
        return name;
    }

    protected void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    private void setAge(int age) {
        this.age = age;
    }

    protected boolean isSecret() {
        return isSecret;
    }

    public void setSecret(boolean secret) {
        isSecret = secret;
    }
}