package com.company.dla.trainings.topic4.reflection.proxy.model;

public class RusTax implements TaxCalculator {
    @Override
    public double getTax(double summ) {
        return summ * 0.13;
    }

    @Override
    public double getMinTax(double summ) {
        return summ * 0.13;
    }

    @Override
    public double getMaxTax(double summ) {
        return summ * 0.13;
    }

    @Override
    public String getTaxName() {
        return "Rus";
    }
}
