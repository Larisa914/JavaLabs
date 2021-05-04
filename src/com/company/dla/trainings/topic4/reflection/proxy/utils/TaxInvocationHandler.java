package com.company.dla.trainings.topic4.reflection.proxy.utils;

import com.company.dla.trainings.topic4.reflection.proxy.model.TaxCalculator;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Map;

public class TaxInvocationHandler implements InvocationHandler {
    private TaxCalculator taxCalculator;

    public TaxInvocationHandler(TaxCalculator taxCalculator) {
        this.taxCalculator = taxCalculator;
    }

    @Override
    public Object invoke(Object proxy,
                         Method method,
                         Object[] args) throws Throwable {
        if (method.getDeclaringClass() == Map.class) {
            System.out.println("MAP!!!");
            return null;
        }

        if ("getTaxName".equals(method.getName())) {
            System.out.println("AAAAAAAAAAAA!!!!");
        }

        Object result = null;
        long startTime = System.currentTimeMillis();

        result = method.invoke(taxCalculator, args);

        System.out.println(method.getName()
                + " costs "
                + (System.currentTimeMillis() - startTime));
        return result;
    }
}
