package com.company.dla.trainings.topic3.collections;

import java.util.*;

public class IteratorSample {
    public static void main(String[] args) {

        Collection<String> list = new ArrayList<>();

        list.add("A");
        list.add("A");
        list.add("B");
        list.add("D");
        list.add("C");
        list.add("E");
        list.add("A");

        // IteratorSample to traverse the list
        Iterator<String> iterator = list.iterator();

        System.out.println("List elements : ");

        while (iterator.hasNext()) {
            String element = iterator.next();
            System.out.println(element + " ");
            if ("A".equals(element)) {
                System.out.print(" Removing ...");
//                ConcurrentModificationException
//                list.remove(element);
//                list.add(element + "!");
                iterator.remove();
                System.out.println("Done");
            }
        }

        System.out.println("------------------------");
        for (String str: list) {
            System.out.println(str);
//            ConcurrentModificationException
//            if ("D".equals(str)) {
//                list.remove(str);
//            }
        }

        System.out.println();

        System.out.println("------------------------");
        list.removeIf("D"::equals);
        list.forEach(System.out::println);
    }
}
