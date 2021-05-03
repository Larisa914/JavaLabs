package com.company.dla.trainings.topic3.list;


import java.util.Iterator;
import java.util.LinkedList;

public class LinkedListExample {
    public static void main(String args[]){

        LinkedList<String> list= new LinkedList<>();

        //Adding elements to the Linked list
        list.add("Steve");
        list.add("Carl");
        list.add("Raj");

        //Adding an element to the first position
        list.addFirst("Negan");

        //Adding an element to the last position
        list.addLast("Rick");

        //Adding an element to the 3rd position
        list.add(2, "Glenn");

        //Iterating LinkedList
        for (String s : list) {
            System.out.println(s);
        }
    }
}
