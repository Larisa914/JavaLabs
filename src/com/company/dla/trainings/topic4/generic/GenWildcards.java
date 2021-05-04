package com.company.dla.trainings.topic4.generic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class GenWildcards {

    public static void main(String[] args) {
        List<?> list = new ArrayList<String>();

//        list.add("");
//        list.add(new Object());
//        list.add(5);
        list.add(null);
        Object o = list.get(0);

//        Number n2 = null;
//        Object obj2 = n2;
//        n2 = (Number) obj2;

        Number[] numbs = new Integer[5];
//        Integer[] integers = new Number[5];

//        ArrayList<Number> numberList = new ArrayList<Integer>();
        List<Number> numberList = new ArrayList<Number>();
        ArrayList<? extends Number> numberList2 = new ArrayList<Integer>();
        Number n = new Integer(12332);
        Number[] nums = new Integer[123];


        List<? extends Number> oneMoreList = new ArrayList<Integer>();
        List<? extends Number> oneMoreList2 = new ArrayList<Double>();

        append(numberList, 3);
        append(numberList, (int) 3.3);
        append(numberList, (int) 's');
        System.out.println(numberList);

        List<Integer> ints = new ArrayList<>(Arrays.asList(3, 5, 6, 2, 22, 3, 4, 23, 1, 3, 0));

        append(ints, 333);
        System.out.println(ints);

        int max = max(ints).intValue();
        System.out.println(max);
        Collections.copy(numberList, ints);
//        Collections.copy(ints, numberList);
    }

//    PECS

    static Number max(List<? extends Number> numbers) {
        Number result = numbers.get(0);

        for (Number number : numbers) {
            if (result.doubleValue() < number.doubleValue()) {
                result = number;
            }
        }
        return result;
    }

    static void append(List<? super Integer> numbers, Integer num) {
        numbers.add(num);
    }

    static String toString(List<?> objects, String delimiter) {
        String s = "";
        for (Object obj : objects) {
            s += obj.toString();
        }
        return s;
    }
}