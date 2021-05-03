package com.company.dla.trainings.topic4.annot;

import java.lang.annotation.Annotation;

public class RunRepeatable {
    public static void main(String[] args) {
        for (Annotation a: Book.class.getAnnotations()) {
            System.out.println(a);
        }

        System.out.println();

        for (MyAnnotation a: Book.class.getDeclaredAnnotationsByType(MyAnnotation.class)) {
            System.out.println(a.label());
            System.out.println(a);
        }
    }
}