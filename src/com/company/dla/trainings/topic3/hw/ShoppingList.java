package com.company.dla.trainings.topic3.hw;

import com.company.dla.trainings.topic3.equalshash.Book;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class ShoppingList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int count = 0;

        //массивы для хранения продуктов
        String[] arrOfProducts = new String[5];
        Integer[] arrOfCosts = new Integer[5];
        Integer[] arrOfCounts = new Integer[5];

        System.out.println("Введите список продуктов в формате:");
        System.out.println("Название_продукта цена_продукта количество");
        System.out.println("Для выхода наберите \"exit\"");

        //Пользовательский ввод
        while (sc.hasNext() && count < 5) {
            String s = sc.nextLine();
            if("exit".equals(s)){
                break;
            }
            count++;

            //Разделение введённой строки на части
            String[] parts = s.split(" ");

            //Проверка, что строка состоит из трёх элементов
            if(parts.length != 3){
                System.out.println("Wrong number of arguments! Retry!");
                continue;
            }

            //Заполнение массивов названий, цены и количества
            String productName = parts[0];
            Integer productCost;
            Integer productCount;

            //Реакция на неверный формат числа
            try{
                productCost = Integer.parseInt(parts[1]);
                productCount = Integer.parseInt(parts[2]);
            } catch (NumberFormatException ex){
                System.out.println(ex.getMessage());
                System.out.println("Retry!");
                continue;
            }

            //Поиск продукта по существующим продуктам
            //Если продукт найден, то обновить его
            boolean productAlreadyExists = false;

            for (int i = 0; i < 5; i++) {
                if(productName.equals(arrOfProducts[i])){
                    arrOfCosts[i] = productCost;
                    arrOfCounts[i] += productCount;
                    productAlreadyExists = true;
                }
            }

            //Если продукт НЕ найден, то добавить его
            if(!productAlreadyExists){
                for (int i = 0; i < 5; i++) {
                    if(arrOfProducts[i] == null){
                        arrOfProducts[i] = productName;
                        arrOfCosts[i] = productCost;
                        arrOfCounts[i] = productCount;
                        break;
                    }
                }
            }
        }

        //Массив для хранения отсортированный продуктов (пока без сортировки)
        String[] sortedProducts = new String[5];
        System.arraycopy(arrOfProducts, 0, sortedProducts, 0, 5);

        //Сортировка только что созданного массива
        Arrays.sort(sortedProducts, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int res = String.CASE_INSENSITIVE_ORDER.compare(o1, o2);
                if (res == 0){
                    res = o1.compareTo(o2);
                }
                return res;
            }
        });

        //Вывод сортированного массива на консоль
        System.out.println(Arrays.toString(sortedProducts));

        //Сумма покупок
        long sum = 0;
        for (int i = 0; i < 5; i++){
            sum += arrOfCosts[i] * arrOfCounts[i];
        }
        System.out.println(sum);

        //3 раза: поиск и удаление самого популярного продукта
        for (int j = 0; j < 3; j++) {
            //Индекс самого популярного продукта
            int indexOfMostPopularProduct = 0;
            for (int i = 0; i < 5; i++){
                if(arrOfCounts[i] > arrOfCounts[indexOfMostPopularProduct]){
                    indexOfMostPopularProduct = i;
                }
            }

            //Вывод самого популярного продукта на консоль
            System.out.println("Most popular product is " +
                    arrOfProducts[indexOfMostPopularProduct]);

            //Удаление самого популярного продукта из всех массивов
            arrOfProducts[indexOfMostPopularProduct] = null;
            arrOfCounts[indexOfMostPopularProduct] = 0;
            arrOfCosts[indexOfMostPopularProduct] = 0;
        }
    }


}

//Проблемы/Вопросы
//1. Приложение принимает 6 товаров (вместо 5 ожидаемых)
//2. Выводится массив из 5 штук первого товара (вместо отсортированного массива всех товаров)
//3. 3 раза выводится сообщение "Most popular product is <первый продукт в массиве>"
//4. Пока не понял как считается общая сумма