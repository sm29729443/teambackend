package com.twoTeam.groupProject.repository;


import com.twoTeam.groupProject.entity.UsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<UsersEntity, Integer> {
    public UsersEntity findUsersEntitiesByEmail(String email);

}
