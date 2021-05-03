package com.company.dla.trainings.topic3.collections;

import java.util.ArrayList;
import java.util.Collection;

public class PrimitiveCollection {
    public static void main(String[] args) {
        Collection<Integer> collection = new ArrayList<>();

        collection.add(5);

        Byte byVal = (byte) 5;
        Character chVal = 'a';
        Character chVal2 = Character.valueOf('a');
        chVal2.charValue();

        Integer integer = 10;
        Integer integer2 = Integer.valueOf(10);
        Number num = integer;


        integer = integer + 2;
        integer = Integer.valueOf(integer.intValue() + 2);

        collection.add(integer);

        int sum = sum(1, 3);
        System.out.println(sum);

    }

    static Integer sum(Integer a, Integer b) {
        return a + b;
    }
}
