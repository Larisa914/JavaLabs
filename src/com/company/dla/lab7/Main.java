package com.company.dla.lab7;

public class Main {
    public static void main(String[] args) {
        // write your code here
        System.out.println("Hello, Lab7!");
        MyArrayList<String> list = new MyArrayList<>();
        Init.addTwelveElementsTo(list);

        System.out.println("размер 12, длина 16");
        System.out.println(list.get(10));
        System.out.println(list.size());
        System.out.println(list.length());

        Init.addFourElementsWithSuffixTo(list, "y");
        System.out.println("добавили 4 элемента, размер 16, длина увеличилась до 32");
        System.out.println(list.size());
        System.out.println(list.length());

        list.remove(10);
        list.remove(5);
        list.remove(5);
        list.remove(5);
        list.remove(5);
        list.remove(5);
        list.remove(5);
        list.remove(5);
        System.out.println("удалили 8 элементов, размер 8, длина 32");
        System.out.println(list.get(5));
        System.out.println(list.size());
        System.out.println(list.length());
        list.remove(5);
        System.out.println("удалили еще 1 элемент, размер 7, длина уменьшилась до 16");
        System.out.println(list.size());
        System.out.println(list.length());

        Init.addFourElementsWithSuffixTo(list, "r");
        Init.addFourElementsWithSuffixTo(list, "u");
        System.out.println("добавили 8 элементов, размер 15, длина 16");
        System.out.println(list.size());
        System.out.println(list.length());

        System.out.println("добавили 1, размер 16, длина массива должна увеличиться до 32");
        list.add("еще один");
        System.out.println(list.size());
        System.out.println(list.length());
    }
}
