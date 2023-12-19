package com.twoTeam.groupProject.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.IdClass;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "store_info")
public class StoreInfo {


	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "store_id")
	private int storeId;

	//¦a§}
	@Column(name = "address")
	private String address;

	//©±®a¦WºÙ
	@Column(name = "name")
	private String name;

	@Column(name = "ranking_Ynumber")
	private int rankingYearNumber;


	//¤ë±Æ¦æº]
	@Column(name = "ranking_Mnumber")
	private int rankingMonthNumber;

	//¦ì¸m«°¥«

	@Column(name = "location_city")
	private String locationCity;

	//é£Ÿç‰©é¢¨æ ¼
	@Column(name = "food_style")
	private String foodStyle;


	@Column(name = "user_like")
	private double userLike;


	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss") // ??‡å?šæ—¥??Ÿæ?‚é?“ç?„æ ¼å¼?
	@Column(name = "update_time")
	private LocalDateTime updateTime;

	public StoreInfo() {
		super();
//		this.updateTime = LocalDateTime.now();
	}

	public StoreInfo(int storeId, String address, String name, int rankingYearNumber, int rankingMonthNumber,
					 String locationCity, String foodStyle, LocalDateTime updateTime) {
		super();
		this.storeId = storeId;
		this.address = address;
		this.name = name;
		this.rankingYearNumber = rankingYearNumber;
		this.rankingMonthNumber = rankingMonthNumber;
		this.locationCity = locationCity;
		this.foodStyle = foodStyle;
		this.updateTime = updateTime != null ? updateTime : LocalDateTime.now();
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocationCity() {
		return locationCity;
	}

	public void setLocationCity(String locationCity) {
		this.locationCity = locationCity;
	}

	public String getFoodStyle() {
		return foodStyle;
	}

	public void setFoodStyle(String foodStyle) {
		this.foodStyle = foodStyle;
	}

	public int getStoreId() {
		return storeId;
	}

	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}

	public int getRankingYearNumber() {
		return rankingYearNumber;
	}

	public void setRankingYearNumber(int rankingYearNumber) {
		this.rankingYearNumber = rankingYearNumber;
	}

	public int getRankingMonthNumber() {
		return rankingMonthNumber;
	}

	public void setRankingMonthNumber(int rankingMonthNumber) {
		this.rankingMonthNumber = rankingMonthNumber;
	}

	public LocalDateTime getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(LocalDateTime updateTime) {
		this.updateTime = updateTime;
	}


	public double getUserLike() {
		return userLike;
	}

	public void setUserLike(double userLike) {
		this.userLike = userLike;
	}


}
