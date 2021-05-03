package com.company.dla.trainings.topic4.annotation;

public abstract class SizedBox extends Box {
    @Override
    protected void addToBox(Object value) {
        Class thisClass = this.getClass();
        BoxSize boxSize = (BoxSize) thisClass.getAnnotation(BoxSize.class);
        if (boxSize != null && super.values.size() == boxSize.size()) {
            System.out.println("I am full!");
            return;
        }

        super.addToBox(value);
    }
}