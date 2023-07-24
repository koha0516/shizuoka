package com.example.demo.form;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class InputForm {
//	↓バリデーションチェックの内容をアノテーションで記述
	@NotBlank	//空白か
	@Length(min = 1, max = 20)	//　文字列の長さ
	private String senderName;
	
	@NotNull
    private String senderPostCord;
    
	@NotNull
    private String senderAddress;          
    
	@NotNull
    private String pickUpAt;
	
	@NotBlank	//空白か
	@Length(min = 1, max = 20)	//　文字列の長さ
	private String receiverName;
	
	@NotNull
    private String receiverPostCord;
    
	@NotNull
    private String receiverAddress;
	
	@NotNull
    private String arriveAt;
	
	@NotNull
	private int quantity;

	public String getSenderName() {
		return senderName;
	}

	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}

	public String getSenderPostCord() {
		return senderPostCord;
	}

	public void setSenderPostCord(String senderPostCord) {
		this.senderPostCord = senderPostCord;
	}

	public String getSenderAddress() {
		return senderAddress;
	}

	public void setSenderAddress(String senderAddress) {
		this.senderAddress = senderAddress;
	}

	public String getPickUpAt() {
		return pickUpAt;
	}

	public void setPickUpAt(String pickUpAt) {
		this.pickUpAt = pickUpAt;
	}

	public String getReceiverName() {
		return receiverName;
	}

	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}

	public String getReceiverPostCord() {
		return receiverPostCord;
	}

	public void setReceiverPostCord(String receiverPostCord) {
		this.receiverPostCord = receiverPostCord;
	}

	public String getReceiverAddress() {
		return receiverAddress;
	}

	public void setReceiverAddress(String receiverAddress) {
		this.receiverAddress = receiverAddress;
	}

	public String getArriveAt() {
		return arriveAt;
	}

	public void setArriveAt(String arriveAt) {
		this.arriveAt = arriveAt;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
}

