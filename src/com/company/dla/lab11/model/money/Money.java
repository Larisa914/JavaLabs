package com.company.dla.lab11.model.money;

import com.company.dla.lab11.model.constants.CurrencyHolder;

public class Money {
    private Currency currency;
    private double value;

    public Money(double value, String currencyName) {
        this.value = value;
        this.currency = CurrencyHolder.getCurrencyByName(currencyName);
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
