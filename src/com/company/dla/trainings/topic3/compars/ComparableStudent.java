package com.company.dla.trainings.topic3.compars;

import java.util.Objects;

public class ComparableStudent implements Comparable<ComparableStudent>{
    private String name;
    private int age;

    public ComparableStudent(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ComparableStudent that = (ComparableStudent) o;
        return age == that.age &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public String toString() {
        return "ComparableStudent{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int compareTo(ComparableStudent o) {
        if (o.getAge() != age) return age - o.getAge();
        else return name.compareTo(o.getName());
    }
}
