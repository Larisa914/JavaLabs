package com.company.dla.trainings.topic4.generic;

public class BoxNumber<T extends Number> {
    private T value;

    public double sum(T arg){
        return arg.doubleValue() + value.doubleValue();
    }

    public BoxNumber(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}