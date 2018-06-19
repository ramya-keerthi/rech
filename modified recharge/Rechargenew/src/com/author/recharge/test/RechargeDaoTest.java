package com.author.recharge.test;

import static org.junit.Assert.*;


import java.sql.SQLException;

import org.junit.BeforeClass;
import org.junit.Test;

import com.author.recharge.bean.RechargeBean;
import com.author.recharge.dao.RechargeDaoImpl;
import com.author.recharge.exception.RechargeException;

public class RechargeDaoTest {
	static RechargeDaoImpl rech=null;
	static RechargeBean b=null;
	@BeforeClass
	public static void Initialize()
	{
		System.out.println("in before class");
		rech=new RechargeDaoImpl();
		b=new RechargeBean();
	}
  
	@Test
	public void testaddUserDetails()  throws RechargeException,SQLException {
		b.setUserName("ramya");
		b.setUserMobileNum(9010116617L);
		b.setPlanName("Rc100");
		rech.retrieveAmount("Rc100");
		//rech.addUserDetails(b);
		assertEquals(1011,rech.addUserDetails(b.getUserName(),b.getUserMobileNum(),b.getPlanName(),b.getStatus(),b.getAmount()));
	}

		/************************************
		 * Test case for adduserDetails()
		 * 
		 ************************************/
		
	@Test
        public void testaddUserDetails1()  throws RechargeException,SQLException{
		b.setUserName("ramya");
		b.setUserMobileNum(9010116617L);
		b.setPlanName("Rc100");
		rech.retrieveAmount("Rc100");
		//rech.addUserDetails(b);
		assertEquals("Success",true,rech.validPlan(b.getPlanName()));
	}
		
}
		
/*@Test
public void testaddUserDetails2()  throws RechargeException {
	b.setUserName("ramya");
	b.setUserMobileNum(9010116617L);
	b.setPlanName("Rc100");
	try {
		rech.retrieveAmount("Rc100");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		System.out.println(e);
	}
	//rech.addUserDetails(b);
	assertEquals("1002","b.getStatus()");
}
	
}
/*@Test 
public void testRettriveUserDetails1() throws  RechargeException
{
	assertSame(false,rech.retrieveUserDetails("10000",b));
}
public void testRettriveUserDetails() throws RechargeException
{
	assertNotSame(false,rech.retriveUserDetails("10000",b));
}
*/


                      /************************************
                          * Test case for adduserDetails()
                              * 
                       ************************************/






