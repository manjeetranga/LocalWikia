package com.wikia.framework.exceptions;

@SuppressWarnings("serial")
public class WikiaTestException extends Exception{
	String message;
	public WikiaTestException(String message)
	{
		this.message = message;
	}
	
	public String toString()
	{
		return "Message: " + message;
	}
}