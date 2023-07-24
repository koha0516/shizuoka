package com.example.demo.entity;
//  エンティティとはDBテーブルの一行と一つのインスタンスが対応するクラス
//  エンティティを作ることでjavaとdbのやり取りが簡単になる



public class DeliveryInfo {
	private long id;
	private String senderName;
	private String senderKanaName;
    private String senderBirth;
    private String senderPostCord;
    private String senderAddress;          
    private String pickUpAt;
	private String receiverName;
	private String receiverKanaName;
    private String receiverPostCord;
    private String receiverAddress;
    private String arriveAt;
	private int quantity;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getSenderName() {
		return senderName;
	}
	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}
	public String getSenderKanaName() {
		return senderKanaName;
	}
	public void setSenderKanaName(String senderKanaName) {
		this.senderKanaName = senderKanaName;
	}
	public String getSenderBirth() {
		return senderBirth;
	}
	public void setSenderBirth(String senderBirth) {
		this.senderBirth = senderBirth;
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
	public String getReceiverKanaName() {
		return receiverKanaName;
	}
	public void setReceiverKanaName(String receiverKanaName) {
		this.receiverKanaName = receiverKanaName;
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
