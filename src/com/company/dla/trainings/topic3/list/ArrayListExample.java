package com.company.dla.trainings.topic3.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ArrayListExample {
    public static void main(String[] args) {

        // create a list using the
        List<String> list = Arrays.asList("Lars", "Simon");


        // alternatively
        List<String> anotherList = new ArrayList<>();
        anotherList.add("Lars");
        anotherList.add("Simon");
        anotherList.add("AAAA");


        // print each element to the console using method references
        list.forEach(System.out::println);
        System.out.println("--------------");
        anotherList.forEach(System.out::println);

    }
}
