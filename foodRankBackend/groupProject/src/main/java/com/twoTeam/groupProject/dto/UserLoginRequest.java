package com.twoTeam.groupProject.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class UserLoginRequest {
    @NotNull(message = "請輸入帳號")
    @JsonProperty("email")
    private String email;
    @NotNull(message = "請輸入密碼")
    @JsonProperty("password")
    private String password;
}
