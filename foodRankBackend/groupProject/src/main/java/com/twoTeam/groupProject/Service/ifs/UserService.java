package com.twoTeam.groupProject.Service.ifs;


import com.twoTeam.groupProject.constants.UserRoles;
import com.twoTeam.groupProject.dto.UserComementRequest;
import com.twoTeam.groupProject.dto.UserLoginRequest;
import com.twoTeam.groupProject.dto.UserRegisterRequest;
import com.twoTeam.groupProject.entity.UsersEntity;

import javax.servlet.http.HttpSession;

public interface UserService {
    UsersEntity register(UserRegisterRequest userRegisterRequest);


    UsersEntity login(UserLoginRequest userLoginRequest, HttpSession session);

    void createComment(String name, UserComementRequest userComementRequest);
}
