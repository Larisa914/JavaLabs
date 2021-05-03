package com.company.dla.trainings.topic3.hash;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class HashMapExample {

    public static void main(String[] args) {
        /* This is how to declare HashMap */
        Map<Integer, String> hmap = new HashMap<>();
//        Map<Integer, String> hmap = new LinkedHashMap<>();

//        Map<Integer, String> hmap = new TreeMap<>();

        /*Adding elements to HashMap*/
        hmap.put(12, "Chaitanya");
        hmap.putIfAbsent(13, "Denis2");
        hmap.put(13, "Denis");
        hmap.put(2, "Rahul");
        hmap.put(7, "Singh");
        hmap.put(49, "Ajeet");
        hmap.put(3, "Anuj");

        /* Display content using Iterator*/
        printMap(hmap);
        System.out.println();
        printValueWithKeyTwo(hmap);
        System.out.println();

        /* Remove values based on key*/
        hmap.remove(3);
        System.out.println("Map key and values after removal:");
        printMap(hmap);
    }

    private static String printValueWithKeyTwo(Map<Integer, String> hmap) {
        /* Get values based on key*/
        String var = hmap.get(2);
        System.out.println("Value at key 2 is: "+var);
        return var;
    }

    private static void printMap(Map<Integer, String> map) {
        for (Map.Entry entry : map.entrySet()) {
            System.out.print("Key is: " + entry.getKey() + " & Value is: ");
            System.out.println(entry.getValue());
        }
    }
}
