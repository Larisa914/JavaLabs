package com.company.dla.trainings.topic4.reflection.invoker;

import com.company.dla.trainings.topic4.reflection.getinfo.Child;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class PrivateMethodInvoker {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Child child = new Child();
        Child child2 = new Child();
        System.out.println(child == child2);
        System.out.println(child.getClass() == child2.getClass());

        Class<?> clazz = child.getClass();
        Method method = clazz.getDeclaredMethod("getNumber");
        method.setAccessible(true);
        System.out.println(method.invoke(child));
        System.out.println(method.invoke(child2));
    }
}
