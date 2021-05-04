package com.company.dla.trainings.topic4.generic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
//Producer extends, Consumer super
public class Pecs {
    @Override
    public String toString() {
//        Class<Pecs> pecsClass = Pecs.class;
//        Class<? extends Pecs> aClass = this.getClass();
//        try {
//            Class<?> aClass1 = Class.forName("ru.luxoft.cources.topic4.generic.Pecs");
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//        if (pecsClass == aClass && aClass == pecsClass) { /*  ALWAYS TRUE!!! */ }
        return "This is PECS object";
    }

    static class PecsChild extends Pecs{
        @Override
        public String toString() {
            return super.toString();
        }
    }

    public static void main(String[] args) {
        List<String> source = Arrays.asList("One", "Two", "Three");
        List unsafe = source;
        List<Object> destination = Arrays.asList(new Object(),new Object(),new Object());
        unsafe = destination;
//        destination = source;
        System.out.println(destination);

        Collections.copy(destination, source);
        System.out.println(destination);

        Collections.fill(destination,"<Empty>");
        System.out.println(destination);

        new Object().toString();
        Object ob = new Object();
        System.out.println(ob);
        System.out.println(ob);
        System.out.println(new Object());

        System.out.println(new Pecs());
        System.out.println(new PecsChild());


    }
}
