package com.twoTeam.groupProject.dto;




import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserRegisterRequest {
    @NotNull(message = "名稱不得為空")
    @JsonProperty("name")
    private String name;
    @NotNull(message = "信箱不得為空")
    @Email(message = "請輸入正確的信箱格式: xxx@xxx.com")
    @JsonProperty("email")
    private String email;
    @NotNull(message = "密碼不得為空")
    @JsonProperty("password")
    private String password;

}
