package com.company.dla.trainings.topic4.annot;

import java.lang.annotation.*;

import static java.lang.annotation.ElementType.*;

@Target({TYPE, METHOD, PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(MyAnnotationsContainer.class)
public @interface MyAnnotation {
    String label() default "def";
}