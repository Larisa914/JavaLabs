package com.company.dla.trainings.topic4.lamda;

public class Lambda4 {

    static int outerStaticNum;


    void testScopes() {
        int num = 1;

        final int outerNum= 13;


        Lambda2.Converter<Integer, String> stringConverter =
                (from) -> String.valueOf(from + num);

        String convert = stringConverter.convert(2);
        System.out.println(convert);    // 3

//        outerNum = 14;

        Lambda2.Converter<Integer, String> stringConverter2 =
                (from) -> String.valueOf(from + outerNum);

//        outerNum = 15;

        System.out.println(stringConverter2.convert(1));

        final String[] array = new String[1];
        Lambda2.Converter<Integer, String> stringConverter3 = (from) -> {
            array[0] = "Hi there";
            return String.valueOf(from);
        };

//        array = new String[3];

        stringConverter3.convert(23);

        System.out.println(array[0]);
    }

    public static void main(String[] args) {
        new Lambda4().testScopes();
    }

}
