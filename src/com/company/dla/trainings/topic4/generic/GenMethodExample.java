package com.company.dla.trainings.topic4.generic;

public class GenMethodExample {

    public static void main(String[] args) {
        Object object = getAnimalObjFormExternalSource();

        Duck duck = getValue(object);
        Animal animal = getValue(object);

        Animal duck2 = getValue(object, Animal.class);

//        String s2 = getValue(object, String.class);

//        String s = getValue(object);

    }

    private static Object getAnimalObjFormExternalSource() {
        return new Duck();
    }

    public static <T extends Animal> T getValue(Object obj, Class<T> tClass) {
        System.out.println(tClass.getName());
        System.out.println(obj.getClass().getName());
        return (T) obj;
    }

    public static <T> T getValue(Object obj) {
        return (T) obj;
    }



}

class Animal{}
class Duck extends Animal{}
class Cat extends Animal{}
