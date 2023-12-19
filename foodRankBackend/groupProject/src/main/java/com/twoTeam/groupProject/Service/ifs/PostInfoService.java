package com.twoTeam.groupProject.Service.ifs;

import java.io.IOException;
import java.util.List;

import com.twoTeam.groupProject.Vo.PostInfoReq;
import com.twoTeam.groupProject.Vo.PostInfoRes;
import com.twoTeam.groupProject.entity.PostInfo;

public interface PostInfoService {

//	PostInfoRes savePost(int storeId, int userId, String description, byte[] picture);

	PostInfoRes createPost(PostInfoReq req) throws IOException;

	PostInfoRes getImageData(int postId);

	public List<PostInfo> getPostList();

	List<PostInfo> findNextTwentyWithinLastSevenDays(List<PostInfo> previousTwenty);

	PostInfoRes addPostLike(int postId);

	
}
