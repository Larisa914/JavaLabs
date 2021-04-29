package com.company.dla.lab8;

public class Main {
    public static void main(String[] args) {
        // ---------------------------------
        // Урезанный вариант HashMap
        // В корзине только одно значение
        //-----------------------------------
        System.out.println("Hello Lab8!");

        HashMapImpl map = new HashMapImpl();

        //todo ошибка!
        map.containsKey(null);

        // заполняем значениями
        map.put("Anapa", 18);
        map.put("Vladivostok", 14);
        map.put("Murmansk", 8);
        map.put("Phuket", 32); // ошибка локации -11
        map.put("Artem", 18);
        map.put("Artem3567931", 20);//91

        if (!map.isEmpty()) {
            System.out.println("Не пусто!");
        }

        System.out.println("размер: " + map.size());
        if (map.containsValue(10)) {
            System.out.println("нет 10");
        }

        // обновляем значение по существующему ключу
        map.put("Anapa", 29);
        System.out.println(map.get("Anapa")); // проверяем, что значение изменилось
        System.out.println("размер: " + map.size()); // прверяем, что размер не изменился

        // вводим ключ для сущкствующей корзины
        map.put("Artem35679311111", 18);//91
        System.out.println("размер: " + map.size()); // прверяем, что размер не изменился

        if (!map.containsKey("Artem35679311111")) {
            System.out.println("нет Artem35679311111");
        }
        // удаляем значение
        map.remove("Artem3567931");//91
        System.out.println("размер: " + map.size()); // прверяем, что размер уменьшился
        if (!map.containsKey("Artem3567931")) {
            System.out.println("нет Artem3567931");
        }
        // еще раз вводим ключ для корзины, которую опустошили выше
        map.put("Artem35679311111", 18);//91
        System.out.println("размер: " + map.size()); // прверяем, что размер увеличился

        if (!map.containsKey("Artem35679311111")) {
            System.out.println("нет Artem35679311111"); // этого сообщения быть не должно
        }

    }

}
