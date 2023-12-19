package com.twoTeam.groupProject.Vo;


import com.twoTeam.groupProject.constants.RtnCode;
import com.twoTeam.groupProject.entity.StoreInfo;

public class StoreInfoReq {
	
	private StoreInfo storeInfo;

    private RtnCode rtnCode;

    public StoreInfoReq() {
        super();
    }

	public StoreInfoReq(StoreInfo storeInfo, RtnCode rtnCode) {
		this.storeInfo = storeInfo;
		this.rtnCode = rtnCode;
	}	

	public StoreInfo getStoreInfo() {
		return storeInfo;
	}

	public void setStoreInfo(StoreInfo storeInfo) {
		this.storeInfo = storeInfo;
	}

	public RtnCode getRtnCode() {
        return rtnCode;
    }

    public void setRtnCode(RtnCode rtnCode) {
        this.rtnCode = rtnCode;
    }
}
