package com.twoTeam.groupProject.constants;


public enum UserRoles {
    ADMIN(0),
    MANAGER(1),
    NORMAL(2);
    private Integer roleLevel;

    UserRoles(Integer roleLevel) {
        this.roleLevel = roleLevel;
    }
}
