package com.example.demo.service.impl;

import org.springframework.stereotype.Service;

import com.example.demo.entity.DeliveryInfo;
import com.example.demo.mapper.DeliveryInfoMapper;
import com.example.demo.service.DeliveryInfoService;

//
@Service
public class DeliveryInfoServiceImpl implements DeliveryInfoService {

//	UserMapper型の変数を定義
	private final DeliveryInfoMapper dm;
	
//	UserMapper型の変数を受け取るコンストラクタを作成
	public DeliveryInfoServiceImpl(DeliveryInfoMapper dm) {
		this.dm = dm;
	}
	
	@Override
	public void insertDelilveryInfo(DeliveryInfo deliveryInfo) {
		dm.insertDelilveryInfo(deliveryInfo);
	}
	
}
