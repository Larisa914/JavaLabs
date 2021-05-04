package com.company.dla.trainings.topic4.generic;

public class BoxGeneric<T> {
    private T value;
//    private static T staticValue;

    public BoxGeneric(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }


//    public T createNewT() {
//        return new T();
//    }


    public void setValue(T value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BoxGeneric<?> that = (BoxGeneric<?>) o;

        return value.equals(that.value);
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
}
