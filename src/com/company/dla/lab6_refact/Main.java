package com.company.dla.lab6_refact;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static final int NO_OF_PURCHASES = 5;

    public static void main(String[] args) {
        // write your code here
        System.out.println("Hello, Lab6 REFACTORING!!!");
        Purchase[] purchases = new Purchase[NO_OF_PURCHASES];
        int purchasesLength = inputPurchases(purchases);

        if (purchasesLength > 0) {
            showSortProduct(purchases, purchasesLength);
            showSumPurch(purchases, purchasesLength);
            showThreePopularProduct(purchases, purchasesLength);
        }

    }

    public static int inputPurchases(Purchase[] masOfPurch) {
        // ввод с консоли списка покупок и иициализация массива покупок
        Scanner sc = new Scanner(System.in);
        int count = 0;
        int len = 0;

        while (count < NO_OF_PURCHASES && sc.hasNext()) {
            String s = sc.nextLine();
            if ("q".equals(s)) {
                break;
            }
            Purchase purchase = parsePurchaseFromString(s);
            if (purchase != null) {
                if (!isProductAlreadyExists(masOfPurch, purchase)) {
                    len++;
                    addNewPurchase(masOfPurch, purchase);
                }
                count++;
            }
        }
        return len;
    }

    private static Purchase parsePurchaseFromString(String s) {
        String[] parts = s.split(" ");
        if (parts.length != 3) {
            System.out.println("Wrong number of arguments! Retry!");
            return null;
        }

        try {
            return new Purchase(parts[0], Integer.parseInt(parts[1]), Integer.parseInt(parts[2]));
        } catch (NumberFormatException ex) {
            System.out.println(ex.getMessage());
            System.out.println("Retry!");
            return null;
        }
    }

    private static void addNewPurchase(Purchase[] masOfPurch, Purchase purchase) {
        int i = 0;
        while (i < NO_OF_PURCHASES && masOfPurch[i] != null) {
            i++;
        }
        masOfPurch[i] = purchase;
    }

    private static boolean isProductAlreadyExists(Purchase[] masOfPurch, Purchase purchase) {
        for (int i = 0; i < NO_OF_PURCHASES; i++) {
            if (purchase.equals(masOfPurch[i])) {
                masOfPurch[i].setCost(purchase.getCost());
                masOfPurch[i].addCount(purchase.getCount());
                return true;
            }
        }
        return false;
    }

    public static void listOfProducts(Purchase[] masOfPurch, String[] masOfProducts, int len) {
        for (int i = 0; i < len; i++) {
            masOfProducts[i] = masOfPurch[i].getProductName();
        }
    }

    public static void showSortProduct(Purchase[] masOfPurch, int len) {
        String[] sortedProducts = new String[len];
        listOfProducts(masOfPurch, sortedProducts, len);

        Arrays.sort(sortedProducts, String.CASE_INSENSITIVE_ORDER.thenComparing(String::compareTo));
        //Выведите получившийся массив на консоль
        System.out.println(Arrays.toString(sortedProducts));
    }

    public static void showSumPurch(Purchase[] masOfPurch, int len) {
        long sum = 0;
        for (int i = 0; i < len; i++) {
            sum += (long) masOfPurch[i].getCost() * masOfPurch[i].getCount();
        }
        System.out.println("total sum: " + sum);
    }

    public static void showThreePopularProduct(Purchase[] masOfPurch, int len) {
        //Найдите индекс самого популярного продукта
        //Выведите самый популярный продукт на консоль и удалите его из всех
        //массивов

        for (int j = 0; j < 3; j++) {
            int index = getIndexOfMostPopularProduct(masOfPurch, len);
            System.out.println("Popular product № " + (j + 1) + " is " +
                    masOfPurch[index].getProductName());
            masOfPurch[index].setProductName(null);
            masOfPurch[index].setCost(0);
            masOfPurch[index].setCount(0);
        }
    }

    private static int getIndexOfMostPopularProduct(Purchase[] masOfPurch, int len) {
        int indexOfMostPopularProduct = 0;
        for (int i = 1; i < len; i++) {
            if (masOfPurch[i].getCount() >
                    masOfPurch[indexOfMostPopularProduct].getCount()) {
                indexOfMostPopularProduct = i;
            }
        }
        return indexOfMostPopularProduct;
    }
}
