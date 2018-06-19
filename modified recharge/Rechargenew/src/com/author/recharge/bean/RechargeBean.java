package com.author.recharge.bean;

public class RechargeBean {
	private String userName;
	private long userMobileNum;
	private String userEmailId;
	private String planName;
	private String status;
	private int amount;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public long getUserMobileNum() {
		return userMobileNum;
	}
	public void setUserMobileNum(long mobileNum) {
		this.userMobileNum = mobileNum;
	}
	public String getUserEmailId() {
		return userEmailId;
	}
	public void setUserEmailId(String userEmailId) {
		this.userEmailId = userEmailId;
	}
	public String getPlanName() {
		return planName;
	}
	public void setPlanName(String planName) {
		this.planName = planName;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
}
