package com.author.recharge.dao;

import java.sql.SQLException;

public interface IRechargeDao {
	StringBuilder displayrecharge_plan() throws SQLException;
	int addUserDetails(String name,long mobile,String status,String planName,int amount) throws SQLException;
	StringBuilder retrieveUserDetails(int rechId) throws SQLException;
	int retrieveAmount(String plan) throws SQLException;
	boolean validPlan(String planName) throws SQLException;
	boolean validRechId(int rechId) throws SQLException;
	//StringBuilder displayplans() throws SQLException;
}