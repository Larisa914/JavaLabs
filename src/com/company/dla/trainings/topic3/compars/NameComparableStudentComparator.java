package com.company.dla.trainings.topic3.compars;

import java.util.Comparator;

public class NameComparableStudentComparator implements Comparator<ComparableStudent> {

    @Override
    public int compare(ComparableStudent o1, ComparableStudent o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
