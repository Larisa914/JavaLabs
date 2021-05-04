package com.company.dla.trainings.topic4.reflection.getinfo;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

public class ClassInfo extends SuperClassInfo {
    private int myInt;
    public int myInt2;
    public static void main(String[] args) throws Exception {
        Class cl1 = ClassInfo.class;
        Class<Integer> integerClass = int.class;
        Class<int[]> aClass = int[].class;
        Class<int[][]> aClass2 = int[][].class;

        ClassInfo classInfo = new ClassInfo();
        Class cl2 = classInfo.getClass();

        if (cl1 == cl2) {
            System.out.println("Equals!!");
        }

        OtherClass instance = new OtherClass();

        Class<OtherClass> otherClass = OtherClass.class;

        Field field = otherClass.getDeclaredField("myInt");

        field.setAccessible(true);
        System.out.println(field.get(instance));
        field.set(instance, 13);
        System.out.println(field.get(instance));

//        showFields(cl1.getFields());
//        showFields(cl1.getDeclaredFields());


//
//        Field[] fields = cl1.getFields();
//        Method[] methods = cl1.getMethods();
//
//        System.out.println(containsA(new ClassInfo()));
//        System.out.println(containsA(""));
//        System.out.println(containsA(new Object()));
////    ClassPath
////        Map<Class, Object>
//
//        Class newClassLoaded = Class.forName(args[0]);
//        Object object = newClassLoaded.newInstance();
////        Integer i = (Integer) newClassLoaded.getConstructor(int.class).newInstance(5);
//        Method method = newClassLoaded.getMethods()[0];
//        method.invoke(object);
    }

    private static void showFields(Field[] fields) {
        System.out.println("Fields");
        for (Field field: fields) {
            field.setAccessible(true);
            System.out.print(field.getModifiers() + " ");
            System.out.println(field.getType().getSimpleName() + " " + field.getName());
        }
        System.out.println("------------------------------");
    }

    public static boolean containsA(Object obj) {
        return obj.getClass().getSimpleName().contains("a");
    }
}
