package com.twoTeam.groupProject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.twoTeam.groupProject.entity.StoreInfo;


@Repository
public interface storeInfoDao extends JpaRepository<StoreInfo, Integer>{

	public List<StoreInfo> findByLocationCity(String locationCity);

	public StoreInfo findByAddress(String address);
	
	public int save(int storeId);

	public StoreInfo findByName(String name);

	public List<StoreInfo> findAllByName(String name);

	public StoreInfo findByStoreId(int storeId);
}
