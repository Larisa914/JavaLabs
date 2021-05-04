package com.company.dla.trainings.topic4.generic;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Tmp {

    static <T extends Comparable<T>> T min(T a, T b) {
        return a.compareTo(b) < 0 ? a : b;
    }

//    public static <T> T cast(Object a) {
//        return (T)a;
//    }

    interface MyStringMap<K extends String, V> extends Map<K, V>{

    }

    public static void main(String[] args) {
        MyStringMap<String, MyStringMap<String, Integer>> myMap = null;

        Map<String, MyStringMap<String, Integer>> map = myMap;

        System.out.println(min("AAAA", "BB"));
        System.out.println(min(112.6, 13.0));

//        String s1 = cast(new Object());
//        String s2 = cast(1);
//        List i2 = cast(myMap);

    }
}
