package com.twoTeam.groupProject.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.twoTeam.groupProject.Vo.PostInfoRes;
import com.twoTeam.groupProject.entity.PostInfo;
import com.twoTeam.groupProject.entity.StoreInfo;

@Repository
public interface PostInfoDao extends JpaRepository<PostInfo, Integer>{
    
	public PostInfo findByPostId(int postId);

	public List<PostInfo> findByPostUpdateTimeBetween(LocalDateTime sevenDaysAgo, LocalDateTime now);


}
