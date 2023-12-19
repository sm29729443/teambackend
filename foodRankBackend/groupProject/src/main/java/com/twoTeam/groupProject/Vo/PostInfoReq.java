package com.twoTeam.groupProject.Vo;

import org.springframework.web.multipart.MultipartFile;

import com.twoTeam.groupProject.constants.RtnCode;


public class PostInfoReq {

	private int storeId;
    private int userId;
    private String postTitle;
    private String description;
    private MultipartFile picture;
	
	private RtnCode rtnCode;

	public PostInfoReq() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PostInfoReq(int storeId, int userId, String description, String postTitle, MultipartFile picture, RtnCode rtnCode) {
		super();
		this.storeId = storeId;
		this.userId = userId;
		this.postTitle = postTitle;
		this.description = description;
		this.picture = picture;
		this.rtnCode = rtnCode;
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

	public MultipartFile getPicture() {
		return picture;
	}

	public void setPicture(MultipartFile picture) {
		this.picture = picture;
	}

	public RtnCode getRtnCode() {
		return rtnCode;
	}

	public void setRtnCode(RtnCode rtnCode) {
		this.rtnCode = rtnCode;
	}


}
