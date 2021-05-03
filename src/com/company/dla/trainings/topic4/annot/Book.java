package com.company.dla.trainings.topic4.annot;


@MyAnnotation(label = "aaa")
@MyAnnotation(label = "aaa2")
@MyAnnotation(label = "aaa3")
@SecondAnnotation(name = "Second name")
public class Book {

    //    @MyAnnotation
    int aa;

    @MyAnnotation(label = "bbb")
    void methodToPlayWithBook(@MyAnnotation int param) {
        System.out.println("PLAY WITH BOOK!");
    }

    void methodToPlayWithBook2(int param) {
        System.out.println("PLAY WITH BOOK2!");
    }
}
