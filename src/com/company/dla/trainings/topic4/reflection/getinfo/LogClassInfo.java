package com.company.dla.trainings.topic4.reflection.getinfo;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class LogClassInfo {
    public static void main(String[] args) {
        Child child = new Child();

//        logClassInfo(child.getClass());
//        logClassInfo(int.class);
        logClassInfo(int[].class);
//        logClassInfo(Child.class);
    }

    private static void logClassInfo(Class<?> aClass) {
        System.out.print("Class ");
        System.out.println(aClass.getName());

        System.out.println("-------");
        for (Method method : aClass.getMethods()) {
            logMethodInfo(method);
        }
        System.out.println("-------");
        for (Method method : aClass.getDeclaredMethods()) {
//            aClass.getDeclaredMethod("myMethod", int.class, String.class);
//            method.getReturnType();
//            Void.class
//            method.invoke()
            logMethodInfo(method);
        }
        System.out.println("-------");
        for (Field field : aClass.getFields()) {
            logFieldInfo(field);
        }
        System.out.println("-------");
        for (Field field : aClass.getDeclaredFields()) {
            logFieldInfo(field);
        }
        System.out.println("-------");
        for (Annotation annotation : aClass.getAnnotations()) {
            logAnnotation(annotation);
        }
        System.out.println("-------");
        for (Class inter : aClass.getInterfaces()) {
            logClassInfo(inter);
        }
        System.out.println("-------");


        if (aClass.getSuperclass() != null) {
            logClassInfo(aClass.getSuperclass());
        }

    }

    private static void logAnnotation(Annotation annotation) {
        System.out.println("annotation " + annotation.annotationType().getName());
    }

    private static void logFieldInfo(Field field) {
        System.out.print("Field ");

        int modifiers = field.getModifiers();
//        if (Modifier.isPrivate(modifiers)) {
//            System.out.print("private");
//        }
        System.out.print(Modifier.toString(modifiers));
        System.out.print(" " + field.getName());
        System.out.print(" " + field.getType().getName());
        for (Annotation annotation : field.getAnnotations()) {
            logAnnotation(annotation);
        }
        System.out.println();
    }

    private static void logMethodInfo(Method method) {
        System.out.print("Method ");
        System.out.print(Modifier.toString(method.getModifiers()));
        System.out.print(" " + method.getReturnType().getName());
        System.out.print(" " + method.getName());
        System.out.print(" " + method.getModifiers());
        System.out.print(" " + Arrays.toString(method.getParameterTypes()));
        System.out.println();
    }
}
