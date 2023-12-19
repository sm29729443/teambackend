package com.twoTeam.groupProject.controller;

import com.twoTeam.groupProject.Service.ifs.UserService;
import com.twoTeam.groupProject.constants.UserRoles;
import com.twoTeam.groupProject.dto.UserComementRequest;
import com.twoTeam.groupProject.dto.UserLoginRequest;
import com.twoTeam.groupProject.dto.UserRegisterRequest;
import com.twoTeam.groupProject.entity.UsersEntity;
import com.twoTeam.groupProject.repository.UserDao;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@RestController
@Slf4j
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping(value = "/users/register")
    public ResponseEntity<UsersEntity> register(@RequestBody @Valid UserRegisterRequest userRegisterRequest) {
        UsersEntity usersEntity = userService.register(userRegisterRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(usersEntity);
    }

    //或許可以設計成登入後，返回權限給前端，讓前端可以把權限加入request header，雖然這樣會使得session超時後，
    // 前端依然保有權限，但此時沒有email了，勢必要重新登入，而重新登入便會刷新權限
    @PostMapping(value = "/users/login")
    @ApiOperation(value = "登入")
    public ResponseEntity<String> login(@RequestBody @Valid UserLoginRequest userLoginRequest,
                                        HttpSession session) {
        log.info("login 測試用, sessionId:{}", session.getId());
        UsersEntity userEntity = userService.login(userLoginRequest, session);
        // 暫時先不 return role 給前端，還沒想到實際用途或符合的設計
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping(value = "/users/logout")
    @ApiOperation(value = "登出")
    public ResponseEntity<?> logout(HttpSession session) {
        log.info("logout 測試用, sessionId:{}", session.getId());
        log.info("logout 操作執行");
        session.removeAttribute("email");
        session.removeAttribute("role");
        log.info("確認是否刪除, email:{}, role:{}", session.getAttribute("email"), session.getAttribute("role"));
        session.invalidate();
        return ResponseEntity.status(HttpStatus.OK).build();
    }


    /*
     *原本預計把 url 設計為 "/users/{email}/comments"，代表者某個特定用戶的留言功能
     *但如此設計的話會喪失 RESTful API 對於資源的定義，因此改 currentUser 代替，看來應該是比較合理的
     * Bing AI 建議的。
     */
    // 留言功能，帳號從 session 拿，所以這裡傳遞的 parameter 只有 留言內容(comment) 而已
    @PostMapping(value = "/users/currentUser/comment")
    @ApiOperation(value = "留言功能", notes = " 需要登入才能使用，否則會 return 401 ")
    public ResponseEntity<?> comment(HttpSession session,
                                     @RequestBody @Valid UserComementRequest userComementRequest
    ) {
        String email = session.getAttribute("email").toString();
        String name = session.getAttribute("name").toString();
        log.info("目前登入的 email:{}, name:{}", email, name);
        userService.createComment(name, userComementRequest);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
