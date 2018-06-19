package com.author.recharge.service;

import java.sql.SQLException;

public interface IRechargeService {
	StringBuilder displayrecharge_plan() throws SQLException;
	int addUserDetails(String name,long mobile,String status,String planName,int amount) throws SQLException;
	StringBuilder retrieveUserDetails(int rechId) throws SQLException;
	int retrieveAmount(String plan) throws SQLException;
	boolean validPlan(String planName) throws SQLException;
	boolean validRechId(int rechId) throws SQLException;
	boolean validateMobileNum(String mobileNum);
}
