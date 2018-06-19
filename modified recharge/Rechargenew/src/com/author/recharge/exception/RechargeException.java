package com.author.recharge.exception;

public class RechargeException extends Exception{
	private static final long serialVersionUID = -9169087956619494264L;
	private String message;

	public RechargeException(String message) 
	{
		
		this.message=message;
	}

	public RechargeException() {
	}
	public String toString()
	{
		return this.message;
		
	}
}
