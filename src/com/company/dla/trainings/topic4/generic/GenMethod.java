package com.company.dla.trainings.topic4.generic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.DoubleFunction;
import java.util.function.Function;
import java.util.stream.Collectors;

public class GenMethod {
    public static <T> List<T> fromArrayToList(T[] a) {
        return Arrays.stream(a).collect(Collectors.toList());
    }

    // definition of a generic method
    public static <T, G> List<G> fromArrayToList(T[] a, Function<T, G> mapperFunction) {
        return Arrays.stream(a).map(mapperFunction).collect(Collectors.toList());
    }

    public static List fromArrayToListPure(Object[] a, Function mapperFunction) {
        return (List) Arrays.stream(a).map(mapperFunction).collect(Collectors.toList());
    }

    // example of a generic method that has Number as an upper bound for T
    public static <T extends Number> List<T> fromArrayToListWithUpperBound(T[] a) {
        return Arrays.stream(a).collect(Collectors.toList());
    }



    public static void main(String[] args) {
        // testing the generic method with Integer
        Integer[] intArray = { 1, 2, 3, 4, 5 };
        List<Integer> list = fromArrayToList(intArray);
        list.forEach(element -> System.out.println(element));

        // testing the generic method with String
        String[] stringArray = { "hello1", "hello2", "hello3", "hello4", "hello5" };
        List<String> strList = fromArrayToList(stringArray);
        strList.forEach(element -> System.out.println(element));

        List strList2 = fromArrayToListPure(stringArray, Object::toString);
        strList2.forEach(element -> System.out.println(element));

        Object[] objArr = new Integer[5];
        Integer[] intArr2 = (Integer[]) objArr;

        Object obj = new Integer(10);

        List<Integer> intList = new ArrayList<>(list);
//        List<Number> numList = intList;
        List<Long> longList = Arrays.asList(1L, 4L, 7L, 2L, 5L, 0L);
        List<Double> doubleList = Arrays.asList(1d,4d,2.2,3d,1.2,0d);

        List<String> list1 = fromArrayToList(doubleList.toArray(new Double[0]), d -> "Double: " + d);
        list1.forEach(System.out::println);

        System.out.println(sum(intList));
        System.out.println(sum(longList));
        System.out.println(sum(doubleList));



        // testing the generic method with Integer and String type
        Integer[] intArr = { 1, 2, 3, 4, 5 };
        List<String> stringList = fromArrayToList(intArr, Object::toString);
        stringList.forEach(element -> System.out.println(element));
    }

    public static long sum(List<? extends Number> numbers) {
        return numbers.stream().filter(number -> number.doubleValue() < 3).count();
    }

}