package com.company.dla.trainings.topic4.enumpack.newstyle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Runner {
    public static void main(String[] args) {
        System.out.println(Roles.REGULAR_USER.getClass().getSimpleName());
        System.out.println(Roles.SENIOR_USER.getClass().getSimpleName());
        System.out.println(Roles.REGULAR_USER.getClass().getSuperclass().getSimpleName());
        System.out.println(Roles.SENIOR_USER.getClass().getSuperclass().getSimpleName());
        System.out.println("======================================");

        List<User> userList = init();
        final Service service = new Service();

        userList.add(new User("Dummy Supporter", Roles.SUPPORT));
        userList.add(new User("generic Admin", Roles.ADMIN));
        userList.add(new User("Hacker"));

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