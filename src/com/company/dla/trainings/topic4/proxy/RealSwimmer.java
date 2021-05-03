package com.company.dla.trainings.topic4.proxy;

public class RealSwimmer implements Swimmer {
    @Override
    public void swim(String swimType) {
        System.out.printf("I am real swimmer with type {%s}%n", swimType);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void superSwim() {
        System.out.println("REAL super swim!!!");
    }
}