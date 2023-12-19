package com.twoTeam.groupProject.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.twoTeam.groupProject.Service.ifs.PostInfoService;
import com.twoTeam.groupProject.Vo.PostInfoReq;
import com.twoTeam.groupProject.Vo.PostInfoRes;
import com.twoTeam.groupProject.constants.RtnCode;
import com.twoTeam.groupProject.entity.PostInfo;

@RestController
@CrossOrigin
@RequestMapping("/posts")
public class PostInfoController {

	    @Autowired
	    private PostInfoService postInfoService;

	    @PostMapping("/create")
	    public ResponseEntity<PostInfoRes> createPost(@ModelAttribute PostInfoReq req) {
	        try {
	        	PostInfoRes result = postInfoService.createPost(req);
	        	return new ResponseEntity<>(result, HttpStatus.CREATED);
	        } catch (IOException e) {
	            
	        	return new ResponseEntity<>(new PostInfoRes("Error creating post: " + e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
	        }
	    }
	    
	    //獲取貼文
	    @GetMapping("/getPost")
	    public PostInfoRes getPostList(@RequestParam int postId) {
	    	return postInfoService.getImageData(postId);
	    }
	    
	    //按讚貼文
	    @GetMapping("/getPostLike")
	    public PostInfoRes getPostLike(@RequestParam int postId) {
	    	return postInfoService.addPostLike(postId);
	    }

	    //隨機給前二十新增的貼文
	    @GetMapping("/random-top-twenty")
	    public ResponseEntity<List<PostInfo>> getRandomTopTwentyWithinLastSevenDays(HttpSession session) {
	        List<PostInfo> result = postInfoService.getPostList();
	        session.setAttribute("previousTwenty", result);
	        return new ResponseEntity<>(result, HttpStatus.OK);
	    }

	    //再新增二十個貼文
	    @GetMapping("/next-twenty")
	    public ResponseEntity<List<PostInfo>> getNextTwentyWithinLastSevenDays(HttpSession session) {
	    	List<PostInfo> previousTwenty = (List<PostInfo>) session.getAttribute("previousTwenty");
	        List<PostInfo> result = postInfoService.findNextTwentyWithinLastSevenDays(previousTwenty);
	        session.setAttribute("previousTwenty", result);
	        return new ResponseEntity<>(result, HttpStatus.OK);
	    }


}
