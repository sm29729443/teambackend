package com.twoTeam.groupProject.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.twoTeam.groupProject.constants.UserRoles;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Table(name = "users")
@Setter
@Getter
public class UsersEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "user_id")
    private int userId;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "email",unique = true, nullable = false)
    private String email;
    @Basic
    @Column(name = "password")
    @JsonIgnore
    private String password;
    @Basic
    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private UserRoles role;

}
