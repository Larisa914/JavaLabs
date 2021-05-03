package com.company.dla.trainings.topic3.hw.bread;

public class Shop {

    public Bread buy(Target target, Money money) {
        if ("Bread".equals(target.getTargetName())) {
            if (money.getAmount() > 100) {
                return new Bread();
            }
        }
        return new DummyBread();
    }
}