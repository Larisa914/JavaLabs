package com.company.dla.trainings.topic3.hw.bread;

public class SomeScenario {

    public static void main(String[] args) {

        Target target = defineTarget();
        Money money = takeMoney();
        Shop shop = findShop();

        Bread bread = shop.buy(target, money);

        bread.eat();
    }

    private static Money takeMoney() {
        return new Money(199);
//        return new Money(99);
    }

    private static Shop findShop() {
        return new Shop();
    }

    private static Target defineTarget() {
        return new Target("Bread");
    }
}
