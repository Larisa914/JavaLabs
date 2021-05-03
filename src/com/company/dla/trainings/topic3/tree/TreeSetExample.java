package com.company.dla.trainings.topic3.tree;

import java.util.TreeSet;

public class TreeSetExample {
    public static void main(String args[]){
        TreeSet<String> set= new TreeSet<>();
        set.add("D");
        set.add("A");
        set.add("C");
        set.add("B");
        set.add("E");
        System.out.println("Initial Set: "+set);

        System.out.println("Reverse Set: "+set.descendingSet());

        System.out.println("Head Set: "+set.headSet("C", true));

        System.out.println("SubSet: "+set.subSet("A", false, "E", true));

        System.out.println("TailSet: "+set.tailSet("C", false));
    }
}