package com.company.dla.lab10;

public class Main {

    public static void main(String[] args) {
        // write your code here
        System.out.println("Hello, Lab10!");

        Integer[] intArr = {4, -10, 6, 38, 171, 20, -1};
        GenericListAggregator<Integer> arrInt = new GenericListAggregator<>(intArr);
        System.out.println("Max: " + arrInt.getMaxValue());
        System.out.println("Min: " + arrInt.getMinValue());
        System.out.println("Avg: " + arrInt.getAvgValue());

        Double[] ddArr = {1.0, 5.2, 400.9, -5.2};
        GenericListAggregator<Double> arrDd = new GenericListAggregator<>(ddArr);
        System.out.println("Max: " + arrDd.getMaxValue());
        System.out.println("Min: " + arrDd.getMinValue());
        System.out.println("Avg: " + arrDd.getAvgValue());
    }
}
