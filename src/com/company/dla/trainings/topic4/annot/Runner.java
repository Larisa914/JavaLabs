package com.company.dla.trainings.topic4.annot;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Runner {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        for (Annotation a : Book.class.getAnnotations()) {
            if (a instanceof MyAnnotation) {
                MyAnnotation ma = (MyAnnotation) a;
                System.out.println(
                        String.format("Annotation %s (label = %s)",
                                ma.annotationType().getSimpleName(),
                                ma.label()
                        )
                );
            } else if (a instanceof SecondAnnotation) {
                SecondAnnotation ma = (SecondAnnotation) a;
                System.out.println(
                        String.format("Annotation %s (name = %s)",
                                ma.annotationType().getSimpleName(),
                                ma.name()
                        )
                );
            }
        }

        for (Method m : Book.class.getDeclaredMethods()) {
            System.out.println(m.getName());
            for (Annotation a : m.getAnnotations()) {
                System.out.println(
                        " " + a.annotationType().getSimpleName());
                MyAnnotation myAnnotation = m.getAnnotation(MyAnnotation.class);
                if (myAnnotation != null) {
                    System.out.println("    " + myAnnotation.label());
                }
            }
//            m.invoke(new Book(), 1);
        }
    }
}
