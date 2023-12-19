package com.twoTeam.groupProject.Service.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.twoTeam.groupProject.Service.ifs.PostInfoService;
import com.twoTeam.groupProject.Vo.PostInfoReq;
import com.twoTeam.groupProject.Vo.PostInfoRes;
import com.twoTeam.groupProject.constants.RtnCode;
import com.twoTeam.groupProject.entity.PostInfo;
import com.twoTeam.groupProject.entity.StoreInfo;
import com.twoTeam.groupProject.repository.PostInfoDao;

@Service
public class PostInfoServiceImpl implements PostInfoService{

	@Autowired
	private PostInfoDao postInfoDao;

	@Override
	public PostInfoRes createPost(PostInfoReq req) throws IOException{
		try {
//			byte[] pictureData = req.getPicture().getBytes();

			// 獲取上傳的圖像文件
	        MultipartFile pictureFile = req.getPicture();

	        // 生成文件名，可以使用UUID來確保唯一性
	        String fileName = UUID.randomUUID().toString() + "_" + pictureFile.getOriginalFilename();

	        // 設置文件存儲路徑
	        String filePath = "src/main/resources/static/images/" + fileName;

	        // 將文件保存到文件系統
	        Files.copy(pictureFile.getInputStream(), Paths.get(filePath), StandardCopyOption.REPLACE_EXISTING);
            // 將數據保存到數據庫中
            PostInfo postInfo = new PostInfo();
            postInfo.setStoreId(req.getStoreId());
            postInfo.setUserId(req.getUserId());
            postInfo.setPostTitle(req.getPostTitle());
            postInfo.setDescription(req.getDescription());
//            postInfo.setPicture(pictureData);
            postInfo.setFilePath(filePath);
            postInfo.setPostUpdateTime(LocalDateTime.now());
            PostInfo savedPost = postInfoDao.save(postInfo);

            // 返回包含成功信息和貼文資訊的 PostInfoRes 對象
            return new PostInfoRes(savedPost, "Post created successfully");
        } catch (Exception e) {
            e.printStackTrace();
            // 返回包含錯誤信息的 PostInfoRes 對象，你也可以擲回一個例外
            return new PostInfoRes("Error creating post: " + e.getMessage());
        }
	}

	//找貼文
	@Override
	public PostInfoRes getImageData(int postId) {
		PostInfo postInfo = postInfoDao.findByPostId(postId);
        
        if (postInfo != null) {
            System.out.println("Found PostInfo with id: " + postInfo.getPostId());	
            return new PostInfoRes(postInfo, RtnCode.SUCCESSFUL);
        } 
        System.out.println("PostInfo not found for id: " + postId);
        return new PostInfoRes(RtnCode.POST_ID_NOT_FOUND);
	}
	
	@Override
	public PostInfoRes addPostLike(int postId) {
		PostInfo postInfo = postInfoDao.findByPostId(postId);
		int postLiker = postInfo.getPostLikeNumber()+1;
		postInfo.setPostLikeNumber(postLiker);
		return new PostInfoRes(postInfo, RtnCode.SUCCESSFUL);
	}
	
	//七天內的隨機內容
	@Override
	public List<PostInfo> getPostList() {
		
		LocalDateTime Now = LocalDateTime.now();
		
		// 計算七天前的日期時間
        LocalDateTime sevenDaysAgo = Now.minus(Duration.ofDays(7));
        // 使用yourEntityRepository進行搜尋，這裡假設有一個方法叫做findByDateBetween
        List<PostInfo> postInfoList= postInfoDao.findByPostUpdateTimeBetween(sevenDaysAgo, Now);
		
        Collections.shuffle(postInfoList);
        return postInfoList.stream().limit(20).collect(Collectors.toList());        
//        return new PostInfoRes(null, RtnCode.POST_ID_NOT_FOUND);
	}

	//七天內的隨機內容，再搜尋
	@Override
	public List<PostInfo> findNextTwentyWithinLastSevenDays(List<PostInfo> previousTwenty) {
	    // 根據 postLikeNumber 或其他條件（如果需要的話）對 previousTwenty 進行排序
	    previousTwenty.sort(Comparator.comparingInt(PostInfo::getPostLikeNumber));

	    // 從前一次搜尋結果的最後一個實體後面取得下一批 20 個實體
	    int startIndex = Math.min(previousTwenty.size(), 20);
	    int endIndex = Math.min(previousTwenty.size() + 20, previousTwenty.size());

	    return previousTwenty.subList(startIndex, endIndex);
	}
}
