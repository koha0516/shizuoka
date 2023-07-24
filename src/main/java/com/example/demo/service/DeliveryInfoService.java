package com.example.demo.service;

import com.example.demo.entity.DeliveryInfo;

//　インターフェイスを作成し、抽象メソッドを定義する
//　（具体的な処理内容はこのインターフェイスを継承したクラスでオーバーライドするときに記述する）
public interface DeliveryInfoService {
//	User情報を登録するメソッド
	void insertDelilveryInfo(DeliveryInfo delilveryInfo);
}
