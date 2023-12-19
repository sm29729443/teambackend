package com.twoTeam.groupProject.rolemanager;

import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

/*
 * 此類用來定義 URL 對應到什麼權限
 * 於 UserInterceptor 使用
 * */
@Component
public class RoleUrlMapping {

    private final  MultiValueMap<String, String> map = new LinkedMultiValueMap<>();

    public RoleUrlMapping() {
        map.add("NORMAL", "/users/currentUser/comment");

    }

    public MultiValueMap<String, String> getMap() {
        return this.map;
    }

}
