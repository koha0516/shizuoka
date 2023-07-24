package com.example.demo.form;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class InputForm {
//	↓バリデーションチェックの内容をアノテーションで記述
	@NotBlank	//空白か
	@Length(min = 1, max = 20)	//　文字列の長さ
	private String name;
	
	@NotBlank	//空白か
	@Length(min = 1, max = 30)	//　文字列の長さ
	private String kanaName;
	
	@NotNull
	private String birth;
	                        
	@NotNull
    private String postCord;
    
	@NotNull
    private String address;          
    
	@NotNull
    private String pickUpAt;
	
	@NotNull
	private int quantity;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getKanaName() {
		return kanaName;
	}

	public void setKanaName(String kanaName) {
		this.kanaName = kanaName;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getPostCord() {
		return postCord;
	}

	public void setPostCord(String postCord) {
		this.postCord = postCord;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPickUpAt() {
		return pickUpAt;
	}

	public void setPickUpAt(String pickUpAt) {
		this.pickUpAt = pickUpAt;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
}

