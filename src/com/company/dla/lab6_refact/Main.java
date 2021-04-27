package com.company.dla.lab6_refact;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    static final int countPurch = 5;
    public static void main(String[] args) {
        // write your code here
        System.out.println("Hello, Lab6 REFACTORING!!!");
        int lenPurch = 0;
        Purchase[] masOfPurch = new Purchase[countPurch];

        //
        lenPurch = imputPurchase(masOfPurch);
        //System.out.println("длина массива: " + lenPurch);

        if (lenPurch > 0) {
            showSortProduct(masOfPurch, lenPurch);
            showSumPurch(masOfPurch, lenPurch);
            showThreePopularProduct(masOfPurch, lenPurch);
        }

    }
    public static int imputPurchase(Purchase[] masOfPurch){
        // ввод с консоли списка покупок и иициализация массива покупок
        Scanner sc = new Scanner (System.in);
        int count = 0;
        int len = 0;

        while(sc.hasNext() && count < countPurch) {
            String s = sc.nextLine();
            if("q".equals(s)) {
                break;
            }
            String[] parts = s.split(" ");
            if(parts.length != 3){
                System.out.println("Wrong number of arguments! Retry!");
                continue;
            }

            String productName = parts[0];
            Integer productCost;
            Integer productCount;
            try {
                productCost = Integer.parseInt(parts[1]);
                productCount = Integer.parseInt(parts[2]);
            } catch (NumberFormatException ex){
                System.out.println(ex.getMessage());
                System.out.println("Retry!");
                continue;
            }

            count++;
            boolean productAlreadyExists = false;
            for (int i = 0; i < countPurch; i++) {
                if (masOfPurch[i] == null) {
                    break;
                }
                if(productName.equals(masOfPurch[i].getProductName())){
                    masOfPurch[i].setCost(productCost);
                    masOfPurch[i].addCount(productCount);
                    productAlreadyExists = true;
                    break;
                }
            }

            if(!productAlreadyExists) {
                len++;
                for (int i = 0; i < countPurch; i++) {
                    if(masOfPurch[i] == null){
                        masOfPurch[i] = new Purchase(productName, productCost, productCount);
                        break;
                    }
                }
            }
            if (count == countPurch){
                break;
            }
        }
        return len;
    }

    public static void  listOfProducts(Purchase[] masOfPurch, String[] masOfProducts, int len){
        for (int i = 0; i < len; i++){
            masOfProducts[i] = masOfPurch[i].getProductName();
        }
    }

    public static void showSortProduct(Purchase[] masOfPurch, int len){
        String[] sortedProducts = new String[len];
        listOfProducts(masOfPurch, sortedProducts, len);
        //System.arraycopy(masOfProducts, 0, sortedProducts, 0, len);

        Arrays.sort(sortedProducts, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int res = String.CASE_INSENSITIVE_ORDER.compare(o1, o2);
                if (res == 0) {
                    res = o1.compareTo(o2);
                }
                return res;
            }
        });
        //Выведите получившийся массив на консоль
        System.out.println(Arrays.toString(sortedProducts));
    }

    public static void showSumPurch(Purchase[] masOfPurch, int len){
        long sum = 0;
        for (int i = 0; i < len; i++) {
            sum += masOfPurch[i].getCost() * masOfPurch[i].getCount();
        }
        System.out.println("total sum: " + sum);

    }

    public static void showThreePopularProduct(Purchase[] masOfPurch, int len){
        //Найдите индекс самого популярного продукта
        //Выведите самый популярный продукт на консоль и удалите его из всех
        //массивов

        for (int j = 0; j < 3; j++) {
            int indexOfMostPopularProduct = 0;
            for (int i = 0; i < len; i++) {
                if(masOfPurch[i].getCount() >
                masOfPurch[indexOfMostPopularProduct].getCount()){
                    indexOfMostPopularProduct = i;
                }
            }
            System.out.println("Popular product № "+(j+1)+" is " +
                    masOfPurch[indexOfMostPopularProduct].getProductName());
            masOfPurch[indexOfMostPopularProduct].setProductName(null);
            masOfPurch[indexOfMostPopularProduct].setCost(0);
            masOfPurch[indexOfMostPopularProduct].setCount(0);
        }
    }
}
