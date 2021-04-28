package com.company.dla.lab8;

public class Main {
    public static void main(String[] args) {
        // write your code here
        //
        // НЕ ГОТОВО!!!
        //
        System.out.println("Hello Lab8!");

        HashMapImpl map = new HashMapImpl();
        map.put("Anapa", 18);
        map.put("Vladivostok", 14);
        map.put("Murmansk", 8);
        //map.put("Phuket", 32); // ошибка локации -11
        map.put("Artem", 18);

        map.get("Anapa");
        map.size(); // не считается

    }

}
