package com.author.recharge.service;

import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.author.recharge.dao.IRechargeDao;
import com.author.recharge.dao.RechargeDaoImpl;
import com.author.recharge.exception.RechargeException;

public class RechargeServiceImpl implements IRechargeService{

	@Override
	public StringBuilder displayrecharge_plan() throws SQLException {
		IRechargeDao i=new RechargeDaoImpl();
		return i.displayrecharge_plan();
	}

	@Override
	public int addUserDetails(String name,long mobile,String status,String planName,int amount) throws SQLException {
		// TODO Auto-generated method stub
		IRechargeDao r=new RechargeDaoImpl();
		return r.addUserDetails(name, mobile, status, planName, amount);
	}

	@Override
	public StringBuilder retrieveUserDetails(int rechId) throws SQLException {
		IRechargeDao i=new RechargeDaoImpl();
		return i.retrieveUserDetails(rechId);
	}

	@Override
	public int retrieveAmount(String plan) throws SQLException {
		IRechargeDao i=new RechargeDaoImpl();
		return i.retrieveAmount(plan);
	}

	@Override
	public boolean validateMobileNum(String mobileNum) {
		Pattern phonePattern=Pattern.compile("^[1-9]{1}[0-9]{9}");
		Matcher phoneMatcher=phonePattern.matcher(mobileNum);
		return phoneMatcher.matches();
	}

	@Override
	public boolean validPlan(String planName) throws SQLException {
		IRechargeDao i=new RechargeDaoImpl();
		return i.validPlan(planName);
	}

	@Override
	public boolean validRechId(int rechId) throws SQLException {
		IRechargeDao i=new RechargeDaoImpl();
		return i.validRechId(rechId);
	}

}
