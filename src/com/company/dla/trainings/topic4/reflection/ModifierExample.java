package com.company.dla.trainings.topic4.reflection;

import com.company.dla.trainings.topic4.reflection.getinfo.Child;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class ModifierExample {
    public static void main(String[] args) throws NoSuchMethodException {
        Child child = new Child();

        Class<?> clazz = child.getClass();
        Method method = clazz.getDeclaredMethod("getNumber");
        System.out.println(clazz.getModifiers());
        System.out.println(Modifier.toString(clazz.getModifiers()));
        System.out.println(Modifier.isFinal(clazz.getModifiers()));


        System.out.println(method.getModifiers());
        System.out.println(Modifier.toString(method.getModifiers()));
        System.out.println(Modifier.isFinal(method.getModifiers()));

        System.out.println(Modifier.toString(Modifier.classModifiers()));
        System.out.println(Modifier.toString(Modifier.methodModifiers()));
        System.out.println(Modifier.toString(Modifier.fieldModifiers()));

        int modif = Modifier.ABSTRACT | Modifier.FINAL | Modifier.PRIVATE;
        System.out.println(Modifier.toString(modif));

    }
}
