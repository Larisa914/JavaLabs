package com.company.dla.trainings.topic4.generic;

public class GenClass<T> {
    T ob; // объявление объекта типа T

    // Передать конструктору ссылку на объект типа T
    GenClass(T o) {
        ob = o;
    }

    // Вернуть ob
    T getob() {
        return ob;
    }

    // Показать тип T
    void showType() {
//        System.out.println("Тип T: " + T.class.getName());
        System.out.println("Тип T: " + ob.getClass().getName());
    }
}
