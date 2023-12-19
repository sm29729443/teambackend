package com.twoTeam.groupProject.Service.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.twoTeam.groupProject.repository.storeInfoDao;
import com.twoTeam.groupProject.constants.RtnCode;
import com.twoTeam.groupProject.Service.ifs.foodMapService;
import com.twoTeam.groupProject.Vo.StoreInfoReq;
import com.twoTeam.groupProject.Vo.StoreInfoRes;
import com.twoTeam.groupProject.entity.StoreInfo;

@EnableScheduling
@Service
public class foodMapServiceImpl implements foodMapService{

	@Autowired
	private storeInfoDao storeInfoDao;
	
	@Override
	public StoreInfoRes SearchLocation(String locationCity) {
		System.out.println("===========");
		System.out.println(locationCity);
		System.out.println("===========");

		List<StoreInfo> storeInfoList=storeInfoDao.findByLocationCity(locationCity);
		
		 if (storeInfoList != null && !storeInfoList.isEmpty()) {
		    	for (StoreInfo storeInfo : storeInfoList) {
		    		System.out.println(storeInfo.getName());
		    		System.out.println(storeInfo.getFoodStyle());
//					return new StoreInfoRes(storeInfoList,RtnCode.SUCCESSFUL);
		        }
		    	return new StoreInfoRes(storeInfoList,RtnCode.SUCCESSFUL);
	        }
	     System.out.println("未找到相應的StoreInfo");
	     return new StoreInfoRes(RtnCode.LOCATION_CITY_ERROR);		
		
	}

	@Override
	public StoreInfoRes CreateStoreInfo(StoreInfoReq req) {
	    StoreInfo storeInfo = req.getStoreInfo();
	    System.out.println(storeInfo.getName());
	    StoreInfo existingStore = storeInfoDao.findByAddress(storeInfo.getAddress());
	    StoreInfo existingStoreName = storeInfoDao.findByName(storeInfo.getName());
	    if (existingStore != null && existingStoreName != null) {
	        return new StoreInfoRes(RtnCode.STORE_ALREADY_EXISTS);
	    }

	    // Check if storeName and address are not empty
	    if (storeInfo.getName() == null || storeInfo.getName().isEmpty()) {
	        return new StoreInfoRes(RtnCode.STORENAMEPARM_ERROR);
	    }

	    if (storeInfo.getAddress() == null || storeInfo.getAddress().isEmpty()) {
	        return new StoreInfoRes(RtnCode.STOREADRESSPARM_ERROR);
	    }
//	    storeInfoDao.save(req.getStoreInfo().getStoreId());
	    storeInfo.setUpdateTime(LocalDateTime.now());
	    
	    storeInfoDao.save(storeInfo);
	    // Return success response
	    return new StoreInfoRes(storeInfo, RtnCode.SUCCESSFUL);
	}

	//搜尋店名加1點排名
	@Override
	public StoreInfoRes SearchStoreName(String name) {
		
		List<StoreInfo> storeInfoList=storeInfoDao.findAllByName(name);
		
		 if (storeInfoList != null && !storeInfoList.isEmpty()) {
		    	for (StoreInfo storeInfo : storeInfoList) {
		    		System.out.println(storeInfo.getName());
		    		int MN = storeInfo.getRankingMonthNumber();
		    		storeInfo.setRankingMonthNumber(++MN);
		    		int YN = storeInfo.getRankingYearNumber();
		    		storeInfo.setRankingYearNumber(++YN);
		    		
		        }
		    	storeInfoDao.saveAll(storeInfoList);
		    	return new StoreInfoRes(storeInfoList,RtnCode.SUCCESSFUL);
	        }
		 return new StoreInfoRes(storeInfoList, RtnCode.NAME_NOTFOUNT);
	}
	
	//按讚店家
		@Override
		public StoreInfoRes addStoreLike(int storeId,String name) {
			
			System.out.println(name);
			StoreInfo storeInfo=storeInfoDao.findByStoreId(storeId);
			List<StoreInfo> storeInfoList=storeInfoDao.findAllByName(storeInfo.getName());
			double storeLiker = storeInfo.getUserLike()+1;
			storeInfo.setUserLike(storeLiker);;
			
			if (storeInfoList != null && !storeInfoList.isEmpty()) {
		    	for (StoreInfo storeInfolist : storeInfoList) {
		    		if(storeInfolist.getName().equals(storeInfo.getName())) {
		    			double userListLiker = storeInfolist.getRankingMonthNumber()+0.25;
		    			storeInfolist.setUserLike(userListLiker);		    			
		    		}
		        }
		    	storeInfoDao.saveAll(storeInfoList);
		    	return new StoreInfoRes(storeInfoList,RtnCode.SUCCESSFUL);
	        }
			
			return new StoreInfoRes(storeInfo, RtnCode.ID_NOTFOUNT);
		}
		
		//每月定期減少
		@Scheduled(cron= "0 0 0 1 * ?")
		public StoreInfoRes scheduledTimeMounth() {
			List<StoreInfo> storeInfoList = storeInfoDao.findAll();
			for(StoreInfo storeInfolist : storeInfoList) {
				int storeInfolistMonth = (storeInfolist.getRankingMonthNumber()/3);
				storeInfolist.setUserLike(storeInfolistMonth);
			}
			storeInfoDao.saveAll(storeInfoList);
			return new StoreInfoRes(RtnCode.SUCCESSFUL);
		}
		
		//每年定期減少
		@Scheduled(cron= "0 0 0 1 1 *")
		public StoreInfoRes scheduledTimeYear() {
			List<StoreInfo> storeInfoList = storeInfoDao.findAll();
			for(StoreInfo storeInfolist : storeInfoList) {
				int storeInfolistMonth = (storeInfolist.getRankingMonthNumber()/3);
				storeInfolist.setUserLike(storeInfolistMonth);
			}
			storeInfoDao.saveAll(storeInfoList);
			return new StoreInfoRes(RtnCode.SUCCESSFUL);
		}

		//搜尋店家
		@Override
		public StoreInfoRes SearchStoreId(String name) {
			StoreInfo storeInfo = storeInfoDao.findByName(name);
		    
			if(storeInfo==null) {
				return new StoreInfoRes(RtnCode.NAME_NOTFOUNT);
			}
			return new StoreInfoRes(storeInfo,RtnCode.SUCCESSFUL);
		}
}
