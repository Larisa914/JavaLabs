package com.company.dla.trainings.topic4.reflection.invoker;

import com.company.dla.trainings.topic4.reflection.getinfo.Child;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class PrivateFieldInvoker {
    public static void main(String[] args) {
        Child myObject = new Child();
//        myObject.getClass().getClass().getClass().getClass().getClass().getClass();


        short number = 0; //no getter =(
        System.out.println(number);//output 0null
        try {
            Class<? extends Child> aClass = myObject.getClass();
            Field field = aClass.getDeclaredField("number");
            field.setAccessible(true);
            number = (short) field.get(myObject);
            System.out.println(number);//output 0default

            Method method = aClass.getDeclaredMethod("getAge", int.class);
            method.setAccessible(true);
            int i = (Integer) method.invoke(myObject, 12);
            System.out.println(i);

        } catch (NoSuchFieldException | IllegalAccessException
                | NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
