package com.company.dla.trainings.topic4.reflection.proxy;


import com.company.dla.trainings.topic4.reflection.proxy.model.RusTax;
import com.company.dla.trainings.topic4.reflection.proxy.model.TaxCalculator;
import com.company.dla.trainings.topic4.reflection.proxy.model.USATax;
import com.company.dla.trainings.topic4.reflection.proxy.utils.TaxInvocationHandler;

import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.Map;
import java.util.Random;

@SuppressWarnings("")
public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        double summ = random.nextDouble() * 200000;
        TaxCalculator rusTax = new RusTax();

        Object proxyCalculator =
                Proxy.newProxyInstance(
                        TaxCalculator.class.getClassLoader(),
                        new Class[]{TaxCalculator.class, Map.class},
                        new TaxInvocationHandler(rusTax)
                );

        TaxCalculator proxyOfProxyCalculator =
                (TaxCalculator) Proxy.newProxyInstance(
                        TaxCalculator.class.getClassLoader(),
                        new Class[]{TaxCalculator.class},
                        new TaxInvocationHandler((TaxCalculator) proxyCalculator)
                );

        System.out.println(proxyCalculator.getClass().getName());
        System.out.println(Arrays.toString(proxyCalculator.getClass().getInterfaces()));

        System.out.println();
        displayTaxInfo((TaxCalculator) proxyCalculator);
        System.out.println();
        displayTaxInfo(proxyOfProxyCalculator);

        System.out.println();
        System.out.println(((Map)proxyCalculator).get("a"));


        USATax usaTax = new USATax();
//        while (true) {
//            if (summ < 100000) {
//                System.out.println("Rus tax = " + proxyCalculator.getTax(summ));
//                proxyCalculator.getTaxName();
//            } else {
//                System.out.println("USA tax = " + usaTax.getTax(summ));
//            }
//            summ = random.nextDouble() * 200000;
//        }
    }

    private static void displayTaxInfo(TaxCalculator calculator) {
        System.out.println(calculator.getTaxName());
    }
}
