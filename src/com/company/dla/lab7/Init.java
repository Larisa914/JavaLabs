package com.company.dla.lab7;

public class Init {
    private Init() {
    }

    public static void addFourElementsWithSuffixTo(MyArrayList<String> array, String a) {
        array.add("1" + a);
        array.add("2" + a);
        array.add("3" + a);
        array.add("4" + a);
    }

    public static void addTwelveElementsTo(MyArrayList<String> array) {
        array.add("0");
        array.add("1");
        array.add("2");
        array.add("3");
        array.add("4");
        array.add("5");
        array.add("6");
        array.add("7");
        array.add("8");
        array.add("9");
        array.add("10 - я одиннацатый :)");
        array.add("11");
    }
}
