package com.twoTeam.groupProject.interceptor;


import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import com.twoTeam.groupProject.constants.UserRoles;
import com.twoTeam.groupProject.exceptions.UserIdentityException;
import com.twoTeam.groupProject.exceptions.UserValidationException;
import com.twoTeam.groupProject.rolemanager.RoleUrlMapping;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@Component
@Slf4j
/*
 * 只要是涉及到需登入才能使用的功能，都在此攔截驗證身分
 * */
public class UserInterceptor implements HandlerInterceptor {
    @Autowired
    private RoleUrlMapping roleUrlMapping;

    /*
     * 設計邏輯:前端固定傳送/users/email/**近來，此攔截器會根據把email替換成session裡email的值
     * */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        HttpSession session = request.getSession();
        if (session.getAttribute("email") == null) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "尚未登入");
        }

//        log.info("測試用, sessionId:{}", session.getId());
//        log.info("測試用 email:{}", session.getAttribute("email"));
//        log.info("測試用 role:{}", session.getAttribute("role"));
        String role = session.getAttribute("role").toString();
        // ADMIN擁有最高權限，可以訪問任何 APIs
        if (role.equals("ADMIN")) {
            return true;
        }
        // 根據目前登入的帳戶的權限去決定目前訪問的 API 可否訪問
        String requestURI = request.getRequestURI().replace("\\","/");
        MultiValueMap<String, String> map = roleUrlMapping.getMap();
        List<String> roleList = map.get(role);
        for (String url : roleList) {
            if (requestURI.startsWith(url)) {
                return true;
            }
        }
        throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "權限不足");

    }


}
