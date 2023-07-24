package com.example.demo.mapper;
import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import com.example.demo.entity.User;

//　MyBatisが持つO/Rマッパー機能を使うためのアノテーション
//　O/Rマッパーとは、オブジェクト（Object）とデータベース（RDB）を容易に変換（マッピング）するための機能。
@Mapper
public interface UserMapper {
	@Insert("INSERT into derivery_info(id, sender_name, receiver_name) values(#{name}, #{age})")
	@Options(useGeneratedKeys = true , keyColumn = "id", keyProperty = "id")
	void insert(User user);
	
	@Select("SELECT id, name, age FROM user")
	List<User> getAllUser();
}


//　Mybatisのアノテーションについてはあとでググるべし
