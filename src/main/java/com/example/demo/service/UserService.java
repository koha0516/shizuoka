package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.User;

//　インターフェイスを作成し、抽象メソッドを定義する
//　（具体的な処理内容はこのインターフェイスを継承したクラスでオーバーライドするときに記述する）
public interface UserService {
//	User情報を登録するメソッド
	void insertUser(User user);
//	UserリストをDBから取得するメソッド
	List<User> getAllUser();
}
