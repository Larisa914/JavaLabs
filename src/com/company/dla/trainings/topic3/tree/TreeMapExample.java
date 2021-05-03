package com.company.dla.trainings.topic3.tree;

import java.util.Comparator;
import java.util.SortedMap;
import java.util.TreeMap;

public class TreeMapExample {
    public static void main(String[] args) {
        // Creating a TreeMap with a Custom comparator (Descending order)
        SortedMap<String, String> fileExtensions = new TreeMap<>(
//                new Comparator<String>() {
//           @Override
//            public int compare(String o1, String o2) {
//                return o1.length() - o2.length();
//            }
//        }
        );


//            The above TreeMap with custom Comparator can be simply written as -
//            SortedMap<String, String> fileExtensions = new TreeMap<>(Comparator.reverseOrder());


        // Adding new key-value pairs to a TreeMap
        fileExtensions.put("python", ".py");
        fileExtensions.put("zoooo", ".azz");
        fileExtensions.put("c++", ".cpp");
        fileExtensions.put("kotlin", ".kt");
        fileExtensions.put("golang", ".go");
        fileExtensions.put("java", ".java");
        fileExtensions.put("javR", ".1111");
        fileExtensions.put("J", ".j");

        // Printing the TreeMap (The keys will be sorted based on the supplied comparator)
        System.out.println(fileExtensions);

    }
}