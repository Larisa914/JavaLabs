package com.company.dla.trainings.topic4.enumpack.newstyle;

import java.util.Arrays;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;

public class Service {

//    public static final Set<Roles> NO_ROLES =
//            EnumSet.noneOf(Roles.class);
//
//    public static final Set<Roles> ALL_ROLES =
//            EnumSet.allOf(Roles.class);
//
//    public static final Set<Roles> ADMIN_ROLES =
//            EnumSet.of(Roles.ADMIN, Roles.SUPER_USER);
//
//    public static final Set<Roles> ADMIN_ROLES2 =
//            new HashSet<>(Arrays.asList(Roles.ADMIN, Roles.SUPER_USER));
//
//    public static final EnumSet<Roles> SUPPORT_ROLES =
//            EnumSet.range(Roles.SUPPORT, Roles.SUPER_USER);

    public boolean isAdmin(User user) {
        return Roles.ADMIN.includesRoles().contains(user.getRole());
    }

    public boolean isRegularUser(User user) {
//        return Roles.REGULAR_USER.equals(user.getRole());
//        return Roles.REGULAR_USER.includesRoles().contains(user.getRole());
        return Roles.REGULAR_USER == user.getRole();
    }

    public boolean isSupport(User user) {
        return Roles.SUPPORT.includesRoles().contains(user.getRole());
    }

    public String getAccessLevel(Roles role) {
        switch (role) {
            case REGULAR_USER:
                return "I am read docs only";
            case COUNTRY_ADMIN:
                return "I am read docs of users in my country only";
            case SUPPORT:
                return "I am able to see user's docs";
            case ADMIN:
                return "I can delete and update user documents";
            case SUPER_USER:
                return "I can do everything!";
            default:
                throw new RuntimeException("Unknown role");
        }
    }

}
