package com.company.dla.trainings.topic4.enumpack.newstyle;

import java.io.Serializable;
import java.util.EnumSet;

public enum Roles /*extends User */ implements Serializable {
//    public static Roles REGULAR_USER = new Roles("Regular User") {
//        @Override
//        public EnumSet<Roles> includesRoles() {
//            return EnumSet.of(REGULAR_USER);
//        }
//    }

    REGULAR_USER("Regular User") {
        @Override
        public EnumSet<Roles> includesRoles() {
            return EnumSet.of(REGULAR_USER);
        }
    },
    SENIOR_USER("Senior User"),
    COUNTRY_ADMIN("Country level admin"),
    SUPPORT("Support specialist"),
    ADMIN("Admin"),
    SUPER_USER("Super Admin"),
    ONE_MORE;

    Roles() {
        this.fineName = "<Default>";
    }

    Roles(String fineName) {
        this.fineName = fineName;
    }

    private final String fineName;

    public String getFineName() {
        return fineName;
    }

    public String getFineNameInBrackets() {
        return "(" + fineName + ")";
    }

    //    public abstract EnumSet<Roles> includesRoles();
    public EnumSet<Roles> includesRoles() {
        return EnumSet.range(REGULAR_USER, this);
    }

}
