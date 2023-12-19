package com.twoTeam.groupProject.entity;

import java.time.LocalDateTime;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "post_info")
public class PostInfo {

	//貼文流水號
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "post_id")
	private int postId;
	
	@Column(name = "store_id")
	private int storeId;
	
	@Column(name = "user_id")
	private int userId;
	
	@Column(name = "post_title")
	private String postTitle;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "post_like_number")
	private int postLikeNumber;
	
	@Column(name = "file_path")
	private String filePath;
	
//	@Lob 
//	@Basic(fetch = FetchType.LAZY)
//	@Column(length=100000)
//	private byte[] picture;
	
	//上傳時間
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss") // 指定日期時間的格式
	@Column(name = "post_updatetime")
	private LocalDateTime postUpdateTime;

	public PostInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
//byte[] picture,
	public PostInfo(int postId, int storeId, int userId, String postTitle, String description, int postLikeNumber, String filePath, LocalDateTime postUpdateTime) {
		super();
		this.postId = postId;
		this.storeId = storeId;
		this.userId = userId;
		this.postTitle = postTitle;
		this.description = description;
		this.postLikeNumber = postLikeNumber;
		this.filePath = filePath;
//		this.picture = picture;
		this.postUpdateTime = postUpdateTime;
	}

	public int getPostId() {
		return postId;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}

	public int getStoreId() {
		return storeId;
	}

	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getPostTitle() {
		return postTitle;
	}
	public void setPostTitle(String postTitle) {
		this.postTitle = postTitle;
	}
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getPostLikeNumber() {
		return postLikeNumber;
	}

	public void setPostLikeNumber(int postLikeNumber) {
		this.postLikeNumber = postLikeNumber;
	}

//	public byte[] getPicture() {
//		return picture;
//	}
//
//	public void setPicture(byte[] picture) {
//		this.picture = picture;
//	}

	public LocalDateTime getPostUpdateTime() {
		return postUpdateTime;
	}

	public void setPostUpdateTime(LocalDateTime postUpdateTime) {
		this.postUpdateTime = postUpdateTime;
	}

	public boolean isPresent() {
		
		return false;
	}
	
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	
	
}
