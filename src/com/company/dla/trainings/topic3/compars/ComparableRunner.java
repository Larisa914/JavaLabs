package com.company.dla.trainings.topic3.compars;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class ComparableRunner {

    public static void main(String[] args) {

        Set<ComparableStudent> students = new TreeSet<>(//);
                new NameComparableStudentComparator());

                /*new Comparator<ComparableStudent>() {
            @Override
            public int compare(ComparableStudent o1, ComparableStudent o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
                 */
        students.add(new ComparableStudent("Sam Jones", 16));
        students.add(new ComparableStudent("Ivan Dow", 16));
        students.add(new ComparableStudent("Ivan Jones", 16));
        students.add(new ComparableStudent("Bill Gates", 22));
        students.add(new ComparableStudent("Zed Dow", 22));
        students.add(new ComparableStudent("Zzzz Dummy", 14));

        for (ComparableStudent student: students) {
            System.out.println(student);
        }
    }
}
