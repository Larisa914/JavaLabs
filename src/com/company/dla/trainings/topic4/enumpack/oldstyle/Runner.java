package com.company.dla.trainings.topic4.enumpack.oldstyle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Runner {
    public static void main(String[] args) {
        List<User> userList = init();
        final Service service = new Service();

        userList.add(new User("Dummy Supporter", 2));
        userList.add(new User("generic Admin", 5));
//        userList.add(new User("Hacker", 5));

        userList.stream().filter(u -> u.getRole() == Roles.SUPPORT).forEach(System.out::println);

        System.out.println("======================================");
        System.out.println("Users who can do Support");
        userList.stream().filter(service::isSupport).forEach(System.out::println);

        System.out.println("======================================");


        userList.stream()
                .filter(u -> !service.isAdmin(u))
                .forEach(u -> System.out.println(u.getName() + ": " + service.getAccessLevel(u.getRole())));
    }







    private static List<User> init() {
        return new ArrayList<>(Arrays.asList(
                new User("Bill"),
                new User("Sam"),
                new User("Michal"),
                new User("Neeraj"),
                new User("Alla"),
                new User("Oleg", Roles.ADMIN),
                new User("Olga", Roles.SUPER_USER),
                new User("Stepan", Roles.SUPPORT),
                new User("Nikolay", Roles.SUPPORT)
        ));
    }
}
