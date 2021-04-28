package com.company.dla.lab9;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        // write your code here
        System.out.println("Hello Lab9!");
        TreeMap<String, TreeMap<String, Integer>> clients = new
                TreeMap<String, TreeMap<String, Integer>>();

        Scanner sc = new Scanner(System.in);
// цикл ввода данных
        while (sc.hasNext()) {
            String s = sc.nextLine();
            if (s.equals("exit") || s.equals("q")) {
                break;
            }
            String[] parts = s.split(" ");
            if(parts.length != 3){
                System.out.println("Wrong number of arguments! Retry!");
                continue;
            }

            String name = parts[0];
            String productName = parts[1];
            Integer count;
            try {
                count = Integer.parseInt(parts[2]);
            } catch (NumberFormatException ex){
                System.out.println(ex.getMessage());
                System.out.println("Retry!");
                continue;
            }

            if (!clients.containsKey(name))
                clients.put(name, new TreeMap <String, Integer>());
            // структура карты покупателя
            TreeMap <String, Integer> temp = clients.get(name);

            // проверить наличие товара в карте покупателя,
            // если нет такого товара - добавляем с количеством 0
            if (!temp.containsKey(productName))
                temp.put(productName,0);
            // изменяем количество товара в карте покупателя
            Integer oldCount = temp.get(productName);
            temp.put(productName, oldCount + count);
        }
// цикл для вывода карт пользователей
        for(Map.Entry<String, TreeMap <String, Integer>> entry :
            clients.entrySet()) {
            String key = entry.getKey();
            TreeMap <String, Integer> value = entry.getValue();
            //Выводим имя покупателя
            System.out.println(key + ":");
            //цикл для вывода продуктов
            for(Map.Entry<String,Integer> product : value.entrySet()) {
                String keyProduct = product.getKey();
                Integer valueProduct = product.getValue();
                System.out.println(keyProduct + " " + valueProduct);
            }
        }
    }

}

