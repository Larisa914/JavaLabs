package com.company.dla.trainings.topic3.hw.hashmap;

public class Lab8Runner {

    public static void main(String[] args) {

        HashMapImpl hashMap = new HashMapImpl();
        Entry e1 = new Entry();
        e1.setKey(10);
        e1.setVal("Grapes");

        Entry e2 = new Entry();
        e2.setKey(10);
        e2.setVal("Grapes");

        System.out.println("e1 is equal e2: "+ e1.equals(e2));
        System.out.println("e1 is equal e2: "+ (e1.getKey()==e2.getKey()));
        System.out.println("e1 hashcode: "+ e1.hashCode());

        /*hashMap.put(10, "Apple");
        hashMap.put(1, "Orange");
        hashMap.put(79, "Grape");
        hashMap.put(null, "Pear");
        System.out.println("");
        System.out.println("Val at 10 "+hashMap.get(10));
        System.out.println("Val at 1 "+hashMap.get(1));
        System.out.println("Val at 79 "+hashMap.get(79));
        System.out.println("Val at null "+hashMap.get(null));
        System.out.println("Val at 2 "+hashMap.get(2));
        System.out.println("");
        System.out.println("Hashmap has key at null:"+hashMap.containsKey(null));
        System.out.println("Hashmap has value at null:"+hashMap.containsValue("Pear"));
        System.out.println("");
        System.out.println("Size of Map:"+hashMap.size());
*/

    }

}
