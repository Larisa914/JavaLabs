package com.company.dla.trainings.topic4.generic;

public class GenDemo {
    public static void main(String args[]) {
        // Создать ссылку на объект типа GenClass<Integer>
        GenClass<Integer> iOb;

        // Создать объект типа GenClass<Integer> и присвоить ссылку на
        // него переменной iOb. Обратите внимание на автоупаковку при
        // инкапсуляции значения 88 в объекте типа Integer.

        iOb = new GenClass<>(88); //Соpдание экэемпnяра типа GenClass<Integer>
        // Отобразить тип данных, используемых в объекте iOb
        iOb.showType();

        // Получить значения из объекта iOb. Обратите внимание
        //на то, что приведение типов здесь не требуется.
        int v = iOb.getob();
        System.out.println("знaчeниe: " + v);
        System.out.println();

        // Создать объект типа GenClass для строк
        GenClass<String> strOb = new GenClass<>("Tecтиpoвaниe");
        GenClass<Integer> integerGenClass = new GenClass<>(12);

        GenClass<GenClass<String>> genClass = new GenClass<>(strOb);


        // Отобразить тип данных, используемых в объекте strOb
        strOb.showType();

        // Получить значение из объекта strOb.
        // Заметьте, что приведение типов эдесь также не требуется.
        String str = strOb.getob();
        System.out.println("знaчeниe: " + str);
    }
}
