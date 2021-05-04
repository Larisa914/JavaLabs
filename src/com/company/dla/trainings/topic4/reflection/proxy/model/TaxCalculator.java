package com.company.dla.trainings.topic4.reflection.proxy.model;

public interface TaxCalculator {
    double getTax(double summ);
    double getMinTax(double summ);
    double getMaxTax(double summ);

    /**
     * DO NOT USE THIS METHOD!!!!!
     * @return nothing
     */
    @Deprecated
    String getTaxName();
}