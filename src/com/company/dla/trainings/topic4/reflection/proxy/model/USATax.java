package com.company.dla.trainings.topic4.reflection.proxy.model;

public class USATax implements TaxCalculator {
    @Override
    public double getTax(double summ) {
        return summ * 0.2;
    }

    @Override
    public double getMinTax(double summ) {
        return summ * 0.02;
    }

    //    @Override
    public double getMinTax(int summ) {
        return summ * 0.02;
    }

    @Override
    public double getMaxTax(double summ) {
        return summ * 0.35;
    }

    @Override
    public String getTaxName() {
        return "US";
    }

}
