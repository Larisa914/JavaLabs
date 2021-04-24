package com.company.dla.lab5.model.constants;

import com.company.dla.lab5.model.money.Currency;
import java.util.Map;
import java.util.HashMap;

public class CurrencyHolder {
    private static final Map<String, Currency> currencies = new
            HashMap<String, Currency>();
    static {
        currencies.put("USD",new Currency("USD", 1));
        currencies.put("RUR",new Currency("RUR", 65.5f));
    }
    public static Currency getCurrencyByName(String name) {
        return currencies.get(name);
    }

}
