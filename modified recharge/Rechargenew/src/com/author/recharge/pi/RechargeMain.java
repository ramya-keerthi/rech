package com.author.recharge.pi;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.author.recharge.bean.RechargeBean;
import com.author.recharge.service.IRechargeService;
import com.author.recharge.service.RechargeServiceImpl;

public class RechargeMain {
	

	public static void main(String a[]) throws SQLException
	{
		Logger logger=Logger.getRootLogger();
		try{
		RechargeBean b1=new RechargeBean();
		IRechargeService s1=new RechargeServiceImpl();
		Scanner sc=new Scanner(System.in);
		System.out.println("enter username");
		String name=sc.next();
		b1.setUserName(name);
		System.out.println("enter mobile number");
		String mobileNum=sc.next();
		while (true)
		{
			if (s1.validateMobileNum(mobileNum))
			{
				break;
			} 
			else
			{
				System.err.println("Please enter valid mobile number");
				mobileNum= sc.next();
			}
		}
		long mobilenum=Long.parseLong(mobileNum);
		b1.setUserMobileNum(mobilenum);
		System.out.println("enter plan from below ones");
		System.out.println(s1.displayrecharge_plan());
		String planName=sc.next();
		if(s1.validPlan(planName))
		{
	 		b1.setPlanName(planName);
			s1.retrieveAmount(planName);
			b1.setAmount(s1.retrieveAmount(planName));
			b1.setStatus("recharge sucessfull");
			System.out.print("recharge successful with rechargeId:");
			logger.info("Recharge Successful");
		}
		else
		{
			b1.setPlanName(planName);
			b1.setAmount(0);
			b1.setStatus("Recharge Failed");
			System.out.print("recharge unsuccessful with rechargeId:");
			logger.info("Recharge Unsuccessful");
		}
		int recId=s1.addUserDetails(b1.getUserName(),b1.getUserMobileNum(),b1.getStatus(),b1.getPlanName(),b1.getAmount());
		System.out.println(recId);
		int ch,rechId;
		do
		{
			System.out.println("please select a choice");
			System.out.println("1.do you want to get any recharge details??");
			System.out.println("2.exit");
			ch=sc.nextInt();
			if(ch==1)
			{
				System.out.println("please enter recharge id");
				rechId=sc.nextInt();
				if(s1.validRechId(rechId))
				{
					System.out.println(s1.retrieveUserDetails(rechId));
				}
				else
				{
					System.out.println("no details found");
				}
			}
			//psc.close();
		}while(ch==1);
		System.out.println("bye bye");
	}
		catch(InputMismatchException e)
		{
			logger.error("Exception occured");
			System.out.println(e);
		}
		catch(ClassCastException e)
		{
			logger.error("Exception occured");
			System.out.println(e);
		}
	}
}
