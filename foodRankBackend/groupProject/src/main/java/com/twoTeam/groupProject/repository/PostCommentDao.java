package com.twoTeam.groupProject.repository;


import com.twoTeam.groupProject.entity.PostCommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostCommentDao extends JpaRepository<PostCommentEntity, Integer> {
}
