package com.twoTeam.groupProject.Vo;

import java.util.List;

import com.twoTeam.groupProject.constants.RtnCode;
import com.twoTeam.groupProject.entity.StoreInfo;

public class StoreInfoRes {

	private StoreInfo storeInfo;
	
    private List<StoreInfo> storeInfoList;

    private RtnCode rtnCode;

//    public StoreInfoRes() {
//        super();
//    }

    public List<StoreInfo> getStoreInfoList() {
        return storeInfoList;
    }

    public void setStoreInfoList(List<StoreInfo> storeInfoList) {
        this.storeInfoList = storeInfoList;
    }

	public StoreInfoRes(RtnCode rtnCode) {
		this.rtnCode = rtnCode;
	}

	
	public StoreInfoRes(StoreInfo storeInfo, RtnCode rtnCode) {
		super();
		this.storeInfo = storeInfo;
		this.rtnCode = rtnCode;
	}

	public StoreInfoRes(List<StoreInfo> storeInfoList, RtnCode rtnCode) {
		super();
		this.storeInfoList = storeInfoList;
		this.rtnCode = rtnCode;
	}

	public RtnCode getRtnCode() {
        return rtnCode;
    }

    public void setRtnCode(RtnCode rtnCode) {
        this.rtnCode = rtnCode;
    }

	public boolean isSuccess() {
        return rtnCode != null && rtnCode.equals(RtnCode.SUCCESSFUL);
	}

	public StoreInfo getStoreInfo() {
		return storeInfo;
	}

	public void setStoreInfo(StoreInfo storeInfo) {
		this.storeInfo = storeInfo;
	}
	
}