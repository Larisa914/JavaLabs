package com.company.dla.trainings.topic4.proxy.proxy_example;

public interface Account {
    void withdraw(int amount);

    void add(int amount);

    @NotLoggable
    int getAmount();
}