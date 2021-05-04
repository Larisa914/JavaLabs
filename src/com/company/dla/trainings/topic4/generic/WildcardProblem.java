package com.company.dla.trainings.topic4.generic;

import java.util.ArrayList;
import java.util.List;

public class WildcardProblem {
    public static void main(String[] args) {
        Object[] objs = new Object[10];
        Object[][] objs2 = new Object[10][10];
        Object[] ints = new Integer[10];
        Object[] num = new Number[10];
//        Integer[] objs2 = new Object[10];

        List<Number> numbersList = new ArrayList<>();
        numbersList.add(3);
        numbersList.add(5);
        List<Integer> intList = new ArrayList<>();
//        List<Number> intList2 = new ArrayList<Integer>();
        intList.add(10);
        intList.add(20);

        System.out.println(sum(numbersList));
        System.out.println(sum(intList));

        System.out.println("Count: " + addOneAndCount(numbersList, intList));
        System.out.println("Count: " + addOneAndCount(numbersList, intList));

//        Collections.copy();
    }

    static double sum(List<? extends Number> list) {
//        Number number = new Integer(2);
//        list.add(null);
        long res = 0;
        for (Number el : list) {
            res += el.doubleValue();
        }
        return res;
    }

    static int addOneAndCount(List<? super Integer> list1, List<? super Integer> list2) {
        list1.add(1);
        list2.add(1);
        List<Object> objs = new ArrayList<>();
        objs.addAll(list1);
        objs.addAll(list2);
        return objs.size();
    }
}
