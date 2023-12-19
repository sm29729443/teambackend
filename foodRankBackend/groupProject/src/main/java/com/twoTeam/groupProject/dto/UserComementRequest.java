package com.twoTeam.groupProject.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
@Getter
@Setter
public class UserComementRequest {
    @JsonProperty("comment")
    @NotNull( message = "請留言")
    String comment;
    @JsonProperty("postId")
    @NotNull( message = "postId Error")
    Integer postId;
    @JsonProperty("storeId")
    @NotNull( message = "storeId Error")
    Integer storeId;
}
