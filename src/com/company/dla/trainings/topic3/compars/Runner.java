package com.company.dla.trainings.topic3.compars;

import java.util.*;

public class Runner {

    private static class StudentsComparator implements Comparator<Student> {

        @Override
        public int compare(Student o1, Student o2) {
            return o2.getName().compareTo(o1.getName());
        }
    }

    public static void main(String[] args) {
//        Set<Student> students = new TreeSet<>();
//
        Set<Student> students = new TreeSet<>(new StudentsComparator());
//        Set<Student> students = new TreeSet<>((o1, o2) -> o2.getName().compareTo(o1.getName()));
//        Set<Student> students = new TreeSet<>(new Comparator<Student>() {
//            @Override
//            public int compare(Student o1, Student o2) {
//                return o2.getName().compareTo(o1.getName());
//            }
//        });
//        Set<Student> students = new HashSet<>();
        students.add(new Student("Sam Jones"));
        students.add(new Student("Ivan Dow"));
        students.add(new Student("Bill Gates"));
        students.add(new Student("Zzzz Dummy"));
//        students.add((Student) new Object());


        for (Student student: students) {
            System.out.println(student);
        }
    }
}


//package ru.luxoft.cources.topic3.compars;
//
//        import java.util.*;
//
//public class Runner {
//
//    private static class StudentsComparator implements Comparator<Student> {
//
//        @Override
//        public int compare(Student o1, Student o2) {
//            return o2.getName().compareTo(o1.getName());
//        }
//    }
//
//    public static void main(String[] args) {
//
////        Set<Student> students = new TreeSet<>(new StudentsComparator());
////        Set<Student> students = new TreeSet<>((o1, o2) -> o2.getName().compareTo(o1.getName()));
//        Set students = new TreeSet<>(new Comparator<Student>() {
//            @Override
//            public int compare(Student o1, Student o2) {
//                return o2.getName().compareTo(o1.getName());
//            }
//        });
////        Set<Student> students = new HashSet<>();
//        students.add(new Student("Sam Jones"));
//        students.add(new Student("Ivan Dow"));
//        students.add(new Student("Bill Gates"));
//        students.add(new Student("Zzzz Dummy"));
//        students.add("Student");
//
//        for (Object student: students) {
//            Student st = (Student) student;
//            System.out.println(student);
//        }
//    }
//}
