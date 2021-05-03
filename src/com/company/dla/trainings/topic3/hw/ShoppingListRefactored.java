package com.company.dla.trainings.topic3.hw;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class ShoppingListRefactored {
    public static final int LIST_SIZE = 5;
    //массивы для хранения продуктов
    private static String[] arrOfProducts = new String[LIST_SIZE];
    private static Integer[] arrOfCosts = new Integer[LIST_SIZE];
    private static Integer[] arrOfCounts = new Integer[LIST_SIZE];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        printIntro();
        int count = 0;

        //Пользовательский ввод
        while (count < LIST_SIZE && sc.hasNext()) {
            String input = sc.nextLine();
            if ("exit".equals(input)) {
                break;
            }
            if (!isInputValid(input)) {
                continue;
            }

            String[] parts = input.split(" ");

            //Заполнение массивов названий, цены и количества
            String productName = getProductName(parts);
            Integer productCost = getProductCost(parts);
            Integer productCount = getProductCount(parts);

            //Поиск продукта по существующим продуктам
            //Если продукт найден, то обновить его
            if (isProductAlreadyExists(productName)) {
                updateProduct(productName, productCost, productCount);
            } else {
                insertProduct(productName, productCost, productCount, count++);
            }
            printStatus(count);
        }

        printSortedProductNames();

        //Сумма покупок
        System.out.println(getTotal());

        //3 раза: поиск и удаление самого популярного продукта
        for (int j = 0; j < 3; j++) {
            //Индекс самого популярного продукта
            int indexOfMostPopularProduct = getIndexOfMostPopularProduct();

            //Вывод самого популярного продукта на консоль
            System.out.println("Most popular product is " + arrOfProducts[indexOfMostPopularProduct]);

            deleteProduct(indexOfMostPopularProduct);
//            printStatus(-1);
        }
        printStatus(LIST_SIZE - 3);
    }

    private static void printIntro() {
        System.out.println("Введите список продуктов в формате:");
        System.out.println("Название_продукта цена_продукта количество");
        System.out.println("Для выхода наберите \"exit\"");
    }

    private static void printSortedProductNames() {
        //Массив для хранения отсортированный продуктов (пока без сортировки)
        String[] sortedProducts = new String[LIST_SIZE];
        System.arraycopy(arrOfProducts, 0, sortedProducts, 0, LIST_SIZE);

        //Сортировка только что созданного массива
        Arrays.sort(sortedProducts, (o1, o2) -> {
            int res = String.CASE_INSENSITIVE_ORDER.compare(o1, o2);
            if (res == 0) {
                res = o1.compareTo(o2);
            }
            return res;
        });

        //Вывод сортированного массива на консоль
        System.out.println(Arrays.toString(sortedProducts));
    }

    private static void printStatus(int count) {
        System.out.printf("NoOfProducts: %s \n", count );
        System.out.println("Products:" + Arrays.toString(arrOfProducts));
        System.out.println("Costs:" + Arrays.toString(arrOfCosts));
        System.out.println("Counts:" + Arrays.toString(arrOfCounts));
    }

    private static int getIndexOfMostPopularProduct() {
        int indexOfMostPopularProduct = 0;
        for (int i = 0; i < LIST_SIZE; i++) {
            if (arrOfCounts[i] > arrOfCounts[indexOfMostPopularProduct]) {
                indexOfMostPopularProduct = i;
            }
        }
        return indexOfMostPopularProduct;
    }

    private static long getTotal() {
        long sum = 0;
        for (int i = 0; i < LIST_SIZE; i++) {
            sum += arrOfCosts[i] * arrOfCounts[i];
        }
        return sum;
    }

    private static int indexOfProduct(String name) {
        int pos = 0;
        while (pos < arrOfProducts.length && !name.equals(arrOfProducts[pos])) {
            pos++;
        }
        return pos == LIST_SIZE ? -1 : pos;
    }

    private static void insertProduct(String name, Integer cost, Integer count, int index) {
        arrOfProducts[index] = name;
        arrOfCounts[index] = count;
        arrOfCosts[index] = cost;
    }

    private static void updateProduct(String name, Integer cost, Integer count) {
        int pos = indexOfProduct(name);
        insertProduct(name, cost, count, pos);
    }

    private static void deleteProduct(int index) {
        arrOfProducts[index] = null;
        arrOfCounts[index] = 0;
        arrOfCosts[index] = 0;
    }

    private static boolean isProductAlreadyExists(String searchFor) {
        return indexOfProduct(searchFor) != -1;
    }

    private static Integer getProductCost(String[] parts) {
        return Integer.parseInt(parts[1]);
    }

    private static Integer getProductCount(String[] parts) {
        return Integer.parseInt(parts[2]);
    }

    private static String getProductName(String[] parts) {
        return parts[0];
    }

    private static boolean isInputValid(String input) {
        //Разделение введённой строки на части
        String[] parts = input.split(" ");

        //Проверка, что строка состоит из трёх элементов
        if (parts.length != 3) {
            System.out.println("Wrong number of arguments! Retry!");
            return false;
        }


        //Реакция на неверный формат числа
        try {
            int productCost = Integer.parseInt(parts[1]);
            int productCount = Integer.parseInt(parts[2]);
        } catch (NumberFormatException ex) {
            System.out.println(ex.getMessage());
            System.out.println("Retry!");
            return false;
        }
        return true;
    }


}

//Проблемы/Вопросы
//1. Приложение принимает 6 товаров (вместо 5 ожидаемых)
//2. Выводится массив из 5 штук первого товара (вместо отсортированного массива всех товаров)
//3. 3 раза выводится сообщение "Most popular product is <первый продукт в массиве>"
//4. Пока не понял как считается общая сумма
