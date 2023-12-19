package com.twoTeam.groupProject.Vo;

import java.util.List;

import com.twoTeam.groupProject.constants.RtnCode;
import com.twoTeam.groupProject.entity.PostInfo;

public class PostInfoRes {

	private PostInfo postInfo;
	
	private RtnCode rtnCode;

	private String string;
	
	private List<PostInfo> postInfoList;

	public PostInfoRes() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PostInfoRes(RtnCode rtnCode) {
		super();
		this.rtnCode = rtnCode;
		
	}

	public PostInfoRes(PostInfo postInfo, RtnCode rtnCode) {
		super();
		this.postInfo = postInfo;
		this.rtnCode = rtnCode;
	}

	public PostInfoRes(String string) {
		super();
		this.string = string;
	}

	public PostInfoRes(PostInfo postInfo, String string) {
		super();
		this.postInfo = postInfo;
		this.string = string;
	}

	public PostInfoRes(List<PostInfo> postInfoList, RtnCode rtnCode) {
		super();
		this.postInfoList = postInfoList;
		this.rtnCode = rtnCode;
	}

	public PostInfo getPostInfo() {
		return postInfo;
	}

	public void setPostInfo(PostInfo postInfo) {
		this.postInfo = postInfo;
	}

	public RtnCode getRtnCode() {
		return rtnCode;
	}

	public void setRtnCode(RtnCode rtnCode) {
		this.rtnCode = rtnCode;
	}

	public List<PostInfo> getPostInfoList() {
		return postInfoList;
	}

	public void setPostInfoList(List<PostInfo> postInfoList) {
		this.postInfoList = postInfoList;
	}
	
	
}
