package com.author.recharge.dao;

public interface IQueryMapper {
	public static final String insertQuery="insert into rechargeinfo values(?,?,?,?,?,?)";
	public static final String selectrecharge_Plan="select * from recharge_plan";
	public static final String seqQuery="select rechId_sequence.nextval from dual";
	public static final String userDetailsQuery="select * from rechargeinfo where rech_Id=?";
	public static final String retrieveAmountQuery="select amount from recharge_plan where planName=?";
	public static final String validPlanQuery="select count(*) from recharge_plan where planName=?";
	public static final String validRechIdQuery="select count(*) from rechargeinfo where rech_Id=?";
}
