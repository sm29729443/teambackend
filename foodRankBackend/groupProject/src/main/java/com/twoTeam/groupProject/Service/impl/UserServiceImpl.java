package com.twoTeam.groupProject.Service.impl;

import com.twoTeam.groupProject.Service.ifs.UserService;
import com.twoTeam.groupProject.constants.UserRoles;
import com.twoTeam.groupProject.dto.UserComementRequest;
import com.twoTeam.groupProject.dto.UserLoginRequest;
import com.twoTeam.groupProject.dto.UserRegisterRequest;
import com.twoTeam.groupProject.entity.PostCommentEntity;
import com.twoTeam.groupProject.entity.UsersEntity;
import com.twoTeam.groupProject.exceptions.UserValidationException;
import com.twoTeam.groupProject.repository.PostCommentDao;
import com.twoTeam.groupProject.repository.UserDao;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
@Slf4j
@Api
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private PostCommentDao postCommentDao;
    @Override
    public UsersEntity register(UserRegisterRequest request) {
        if (userDao.findUsersEntitiesByEmail(request.getEmail()) != null) {
            log.warn("此信箱已被註冊:{}", request.getEmail());
            throw new UserValidationException("此信箱已被註冊");
        }
        UsersEntity usersEntity = new UsersEntity();
        usersEntity.setEmail(request.getEmail());
        usersEntity.setName(request.getName());
        usersEntity.setPassword(request.getPassword());
        usersEntity.setRole(UserRoles.NORMAL);
        return userDao.save(usersEntity);
    }

    @Override
    public UsersEntity login(UserLoginRequest userLoginRequest, HttpSession session) {
        UsersEntity userEntity = userDao.findUsersEntitiesByEmail(userLoginRequest.getEmail());
        if (userEntity == null) {
            log.warn("此信箱並不存在:{}", userLoginRequest.getEmail());
            throw new UserValidationException("帳號密碼輸入錯誤");
        }
        if (!userEntity.getEmail().equals(userLoginRequest.getEmail())) {
            log.warn("帳號輸入錯誤:{}", userLoginRequest.getPassword());
            throw new UserValidationException("帳號密碼輸入錯誤");
        }
        if (!userEntity.getPassword().equals(userLoginRequest.getPassword())) {
            log.warn("密碼輸入錯誤:{}", userLoginRequest.getPassword());
            throw new UserValidationException("帳號密碼輸入錯誤");
        }
        session.setAttribute("email", userEntity.getEmail());
        session.setAttribute("role", userEntity.getRole());
        session.setAttribute("name", userEntity.getName());
        log.info("登入成功, 執行 session 設定, email:{}, role:{}", session.getAttribute("email"), session.getAttribute("role"));
        return userEntity;
    }

    @Override
    public void createComment(String name, UserComementRequest userComementRequest) {
        PostCommentEntity postCommentEntity = new PostCommentEntity();
        postCommentEntity.setPostId(userComementRequest.getPostId());
        postCommentEntity.setName(name);
        postCommentEntity.setComment(userComementRequest.getComment());
        postCommentEntity.setStoreId(userComementRequest.getStoreId());
        postCommentDao.save(postCommentEntity);
    }
}
