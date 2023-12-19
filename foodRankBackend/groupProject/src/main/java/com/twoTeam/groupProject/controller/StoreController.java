package com.twoTeam.groupProject.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.twoTeam.groupProject.Service.ifs.foodMapService;
import com.twoTeam.groupProject.Vo.StoreInfoReq;
import com.twoTeam.groupProject.Vo.StoreInfoRes;
import com.twoTeam.groupProject.entity.StoreInfo;

@RestController
@CrossOrigin
public class StoreController {

	@Autowired
	private foodMapService foodMapService;
	
	//搜索都市店家
	 @GetMapping(value = "/foodMap/getlocation")
	    public StoreInfoRes getLocationCity(@RequestParam String locationCity) {
	        System.out.println(locationCity);
	        return foodMapService.SearchLocation(locationCity);
	    }
	 
	 //創建店家
	 @PostMapping("/foodMap/create")
	    public StoreInfoRes createStoreInfo(@RequestBody StoreInfoReq req) {
	        // Call your service method to handle the creation logic
		 StoreInfo storeInfo = req.getStoreInfo();
		 System.out.println("===========");
		 System.out.println(storeInfo.getName());
		 System.out.println(storeInfo.getAddress());
		 System.out.println(storeInfo.getLocationCity());
		 System.out.println("==========");
	     return foodMapService.CreateStoreInfo(req);
	         
	    }

	 //搜索店名
	 @GetMapping(value = "/foodMap/searchName")
	    public StoreInfoRes SearchStoreName(@RequestParam String name) {
	        System.out.println(name);
	        return foodMapService.SearchStoreName(name);
	    }
	 
	 //按讚店家+連鎖增加時間店家好感度
	 @GetMapping("/foodMap/addStoreLike")
	    public StoreInfoRes addStoreLike(@RequestParam int storeId,
	    		@RequestParam String name
	    		) {
	        System.out.println(storeId);
	        return foodMapService.addStoreLike(storeId,name);
	    }
}
