package com.company.dla.trainings.topic3.list;

import java.util.Arrays;
import java.util.List;

public class ListExample {
    public static void main(String[] args) {
        // use type inference for ArrayList
        List<Integer> list = Arrays.asList(3,2,1,4,5,6,6);
//        List<Integer> list2 = List.of(3,2,1,4,5,6,6);

        List<List<Integer>> listOfList=
                Arrays.asList(
                        Arrays.asList(3,2,1),
                        Arrays.asList(4,5,6,6)
                );

        // alternative you can declare the list via:
        // List<Integer> list = new ArrayList<>();
        // and use list.add(element); to add elements
        for (Integer integer : list) {
            System.out.println(integer);
        }
    }
}
