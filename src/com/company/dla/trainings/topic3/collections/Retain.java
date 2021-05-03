package com.company.dla.trainings.topic3.collections;

import java.util.ArrayList;
import java.util.List;

public class Retain {
    public static void main(String[] args) {
        List<String> list = newList();
        List<String> list2 = newSecondList();

        System.out.println(list);
        System.out.println(list2);
        System.out.println();

        list.retainAll(list2);
        System.out.println(list);
        list = newList();
        list2.retainAll(list);
        System.out.println(list2);
        System.out.println();
        list2 = newSecondList();

        list = newList();
        list.add("10");
        list.retainAll(list2);
        System.out.println(list);
        System.out.println();


        list = newList();
        list.removeAll(list2);
        System.out.println(list);
        System.out.println();

        list = newList();
        list.retainAll(new ArrayList<>());
        System.out.println(list);
        System.out.println();

        list = newList();
        list.removeAll(new ArrayList<>());
        System.out.println(list);
        System.out.println();

    }


    private static List<String> newList() {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("3");
        list.add("3");
        list.add("4");
        list.add("3");
        list.add("5");
        list.add("7");
        return list;
    }

    private static List<String> newSecondList() {
        List<String> list2 = new ArrayList<>();
        list2.add("7");
        list2.add("3");
        list2.add("10");
        return list2;
    }
}
