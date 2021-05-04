package com.company.dla.trainings.topic4.enumpack.oldstyle;

public class Service {

    public boolean isAdmin(User user) {
        return user.getRole() >= Roles.ADMIN;
    }

    public boolean isSupport(User user) {
        return user.getRole() >= Roles.SUPPORT;
    }

    public String getAccessLevel(int role) {
        switch (role) {
            case Roles.REGULAR_USER:
                return "I am read docs only";
            case Roles.COUNTRY_ADMIN:
                return "I am read docs of users in my country only";
            case Roles.SUPPORT:
                return "I am able to see user's docs";
            case Roles.ADMIN:
                return "I can delete and update user documents";
            case Roles.SUPER_USER:
                return "I can do everything!";
            default:
                throw new RuntimeException("Unknown role");
        }
    }

}