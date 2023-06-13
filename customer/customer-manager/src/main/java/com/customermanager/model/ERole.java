package com.customermanager.model;

public enum ERole {
    AMIN, USER;

    public static ERole getERoleUser(String user) {
        for (ERole eRole : ERole.values()) {
            if (eRole.toString().equals(user)) {
                return eRole;
            }
        }
        return null;
    }

}
