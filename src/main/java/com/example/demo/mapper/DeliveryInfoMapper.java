package com.example.demo.mapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;

import com.example.demo.entity.DeliveryInfo;

//　MyBatisが持つO/Rマッパー機能を使うためのアノテーション
//　O/Rマッパーとは、オブジェクト（Object）とデータベース（RDB）を容易に変換（マッピング）するための機能。
@Mapper
public interface DeliveryInfoMapper {
	@Insert("INSERT into delivery_info(sender_name, sender_kana_name, sender_birth, "
			+ "sender_post_code, sender_address, pickup_at, receiver_name, receiver_kana_name, "
			+ "receiver_post_code, receiver_address, delivery_at, quantity) "
			+ "values(#{senderName}, #{senderKanaName}, #{senderBirth},"
			+ "#{senderPostCode}, #{senderAddress}, #{pickupAt}, #{receiverName}, #{receiverKanaName},"
			+ "#{receiverPostCode}, #{receiverAddress}, #{deliveryAt}, #{quantity})")
	@Options(useGeneratedKeys = true , keyColumn = "id", keyProperty = "id")
	void insertDelilveryInfo(DeliveryInfo delilveryInfo);

}


//　Mybatisのアノテーションについてはあとでググるべし
