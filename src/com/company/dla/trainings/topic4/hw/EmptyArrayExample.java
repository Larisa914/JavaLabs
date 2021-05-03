package com.company.dla.trainings.topic4.hw;

public class EmptyArrayExample<T> {
    private final T[] arr;

    public EmptyArrayExample(T[] arr) {
        if (arr == null) {
            throw new IllegalStateException("Массив не должен быть null");
        }
        System.out.println("Created!");
        this.arr = arr;
    }

    public static void main(String[] args) {
        Object[] emptyArray = {};
        Object[] nullArray = null;

        EmptyArrayExample emptyArr = new EmptyArrayExample(emptyArray);
        System.out.println(emptyArray.toString());
        System.out.println(nullArray.toString());
        EmptyArrayExample nullArr = new EmptyArrayExample(nullArray);

    }

}
