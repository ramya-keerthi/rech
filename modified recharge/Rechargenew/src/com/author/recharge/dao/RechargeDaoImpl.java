package com.author.recharge.dao;

//import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.author.recharge.exception.RechargeException;
import com.author.recharge.util.DBConnection;

public class RechargeDaoImpl implements IRechargeDao{
	Logger logger=Logger.getRootLogger();
	public RechargeDaoImpl()
	{
	PropertyConfigurator.configure("resources//log4j.properties");
	
	}
	StringBuilder s2=new StringBuilder("");
	@Override
	public StringBuilder displayrecharge_plan() throws SQLException {
		//Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@10.219.34.3:1521/orcl","trg1120","training1120");
		
		try{
			Connection connection = DBConnection.getInstance().getConnection();	
			
			//java.sql.Statement s=conn.createStatement();
			PreparedStatement ps=connection.prepareStatement(IQueryMapper.selectrecharge_Plan);
			ResultSet r=ps.executeQuery();
			if(r.next())
			{
				s2.append("plans      amount\n");
				s2.append(r.getString(1)+"     "+r.getInt(2)+"\n");
				while(r.next())
				{
					s2.append(r.getString(1)+"     "+r.getInt(2)+"\n");
				}
			}
			else
			{
				throw new RechargeException("please select valid plan");
			}
			return s2;
		}
		catch(RechargeException e)
		{
			s2.append(e.getMessage());
			System.out.println(s2);
			logger.warn("Invalid selection plan");
		}
		return s2;
	}

	@Override
	public int addUserDetails(String name,long mobile,String status,String planName,int amount) throws SQLException {
		//Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@10.219.34.3:1521/orcl","trg1120","training1120");
		StringBuilder s2=new StringBuilder("");
		try{
		Connection connection = DBConnection.getInstance().getConnection();	
		
		PreparedStatement s=connection.prepareStatement(IQueryMapper.insertQuery);
		PreparedStatement sq=connection.prepareStatement(IQueryMapper.seqQuery);
		
		//java.sql.Statement sw=conn.createStatement();
		ResultSet r1=sq.executeQuery();
		int val=0;
		while(r1.next())
		{
			val=r1.getInt(1);
		}
		s.setInt(1,val);
		s.setString(2,name);
		s.setLong(3, mobile);
		s.setString(4,status);
		s.setString(5,planName);
		s.setInt(6,amount);
		s.executeUpdate();
		return val;
		}
	catch(RechargeException e)
	{
		s2.append(e.getMessage());
		System.out.println(s2);
		logger.warn("Invalid details");
	}
		return 0;
	}
	@Override
	public StringBuilder retrieveUserDetails(int rechId) throws SQLException {
		try{
		//Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@10.219.34.3:1521/orcl","trg1120","training1120");
		Connection connection = DBConnection.getInstance().getConnection();	
		PreparedStatement s=connection.prepareStatement(IQueryMapper.userDetailsQuery);
		s.setInt(1, rechId);
		ResultSet r=s.executeQuery();
			if(r.next())
			{
				s2.append("rech id"+r.getInt(1)+"\nname:"+r.getString(2)+"\nmobile:"+r.getLong(3)+"\nstatus:"+r.getString(4)
					+"\nplan name:"+r.getString(5)+"\namount:"+r.getInt(6));
			}
	}
		catch(RechargeException e)
		{
			s2.append(e.getMessage());
			System.out.println(s2);
			logger.warn("Error at retrieving details");
		}
		return s2;
		
	}

	@Override
	public int retrieveAmount(String plan) throws SQLException {
		try{
		//Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@10.219.34.3:1521/orcl","trg1120","training1120");
		Connection connection = DBConnection.getInstance().getConnection();
		PreparedStatement s=connection.prepareStatement(IQueryMapper.retrieveAmountQuery);
		s.setString(1,plan);
		int amount=0;
		ResultSet r=s.executeQuery();
		while(r.next())
		{
			amount=r.getInt(1);
		}
		return amount;
	}
		catch(RechargeException e)
		{
			s2.append(e.getMessage());
			System.out.println(s2);
			logger.warn("Error at retrieving amount");
		}
		return 0;
	}

	@Override
	public boolean validPlan(String planName) throws SQLException {
		//Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@10.219.34.3:1521/orcl","trg1120","training1120");
		try{
		Connection connection = DBConnection.getInstance().getConnection();	
		PreparedStatement s=connection.prepareStatement(IQueryMapper.validPlanQuery);
		s.setString(1,planName);
		ResultSet r=s.executeQuery();
		int count=0;
		while(r.next())
		{
			count=r.getInt(1);
		}
		if(count==0)
		{
			return false;
		}
		else
		{
			return true;
		}
		}
		catch(RechargeException e)
		{
			s2.append(e.getMessage());
			System.out.println(s2);
			logger.warn("Invalid plan");
		}
		return false;
		
	}

	@Override
	public boolean validRechId(int rechId) throws SQLException {
		try{
		//Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@10.219.34.3:1521/orcl","trg1120","training1120");
		Connection connection = DBConnection.getInstance().getConnection();	
		PreparedStatement s=connection.prepareStatement(IQueryMapper.validRechIdQuery);
		s.setInt(1, rechId);
		ResultSet r=s.executeQuery();
		int count=0;
		while(r.next())
		{
			count=r.getInt(1);
		}
		if(count==0)
		{
			return false;
		}
		else
		{
			return true;
		}
	}
		catch(RechargeException e)
		{
			s2.append(e.getMessage());
			System.out.println(s2);
			logger.warn("Invalid recharge id");
		}
		return false;
}
}
