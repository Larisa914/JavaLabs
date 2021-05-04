package com.company.dla.trainings.topic4.generic;

public class Main {
    public static void main(String[] args) {
        BoxObject box = new BoxObject(new HorseInVaccum());
        //so many strings of code
//        box.setValue("message");
        //another many strings of code
//        box.getValue().rideInVacuum();
        ((HorseInVaccum)box.getValue()).rideInVacuum();
//        System.out.println((String)box.getValue());

        BoxGeneric<HorseInVaccum> horseBox =
                new BoxGeneric<>(new HorseInVaccum());
//        horseBox = new BoxGeneric<>(76);
        //horseBox.setValue("message");
        horseBox.getValue().rideInVacuum();
        horseBox.setValue(new HorseInVaccum());

//        horseBox.setValue("Some String");
        BoxGeneric temp = horseBox;
        temp.setValue("Some String");
//        HorseInVaccum horse = horseBox.getValue();
        System.out.println(temp.getValue());

        BoxGeneric<String> stringBox = new BoxGeneric<>("some");
        System.out.println(stringBox.getValue());
        stringBox.setValue("new");
//        stringBox.setValue(56);
//        stringBox.setValue(new HorseInVaccum());
//        Number[] nums = new Long[10];


        BoxNumber<Long> longBox = new BoxNumber<>(56L);
        BoxNumber<Number> boxNumber =
                new BoxNumber<>(56L);

        Number number = 78;
        Long lng = 89l;
        boxNumber.setValue(lng);

        BoxNumber<?> someBoxNumber;
        //do some job
        someBoxNumber = new BoxNumber<Double>(45d);
        BoxNumber<? extends Double> someBoxNumber2;

        BoxGeneric<? extends Number> genNumberBox;
        genNumberBox = new BoxGeneric<Long>(8l);
        //genNumberBox = new BoxGeneric<String>("7878");


    }

}
