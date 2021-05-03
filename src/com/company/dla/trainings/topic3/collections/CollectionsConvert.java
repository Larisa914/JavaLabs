package com.company.dla.trainings.topic3.collections;

import java.util.*;

public class CollectionsConvert {

    public static void main(String[] args) {
        List<String> list = newList();
        show(list);
        SortedSet<String> set = new TreeSet<>(list);
        show(set);
    }

    private static void show(Collection<String> collection) {
        for (String s : collection) {
            System.out.print(s + ' ');
        }
        System.out.println();
    }

    private static List<String> newList() {
        List<String> list = new ArrayList<>();
        list.add("7");
        list.add("1");
        list.add("4");
        list.add("3");
        list.add("3");
        list.add("3");
        list.add("5");
        return list;
    }

}
