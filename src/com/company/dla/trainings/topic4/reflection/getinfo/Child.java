package com.company.dla.trainings.topic4.reflection.getinfo;

public class Child extends Parent implements MyInterface {
    public Double salary;
    protected String info;
    private short number = 50;

    public Child(String name, int age, boolean isSecret, Double salary, String info) {
        super(name, age, isSecret);
        this.salary = salary;
        this.info = info;
    }

    public Child() {
    }

    public Double getSalary() {
        return salary;
    }

    protected void setSalary(Double salary) {
        this.salary = salary;
    }

    private String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    protected final short getNumber() {
        return (short) (number+1);
    }

    protected void setNumber(short number) {
        this.number = number;
    }

    @Override
    public void log() {
        System.out.println("Something");
    }

    @Override
    public int getAge(int start) {
        return 0;
    }
}
