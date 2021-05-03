package com.company.dla.trainings.topic4.annotation;

public class RestrictedBox extends Box {

    @Override
    protected void addToBox(Object value) {
        Class valueClass = value.getClass();
        boolean accessOk = valueClass.getAnnotation(AccessToRestrictedBox.class) != null;

        if (accessOk) {
            System.out.println("Added!");
            super.addToBox(value);
        } else {
            System.out.println("Access denied!");
        }
    }
}
