package com.qa.hubspot.util;

public class Credentials {
//this is created to avoid entering multiple parameters, we use obj instead of that in that obj those values
	//are available then using setter and getter to get them in other classes 
	String appUsername; 
	String appPassword;
//constructor of class created and when creating obj its constructor will be called 
	public Credentials(String appUsername, String appPassword) {
	this.appUsername=appUsername; 
	this.appPassword=appPassword; 
	}
	
	public String getAppUsername() {
		return appUsername;
	}
	
	public void setAppUsername(String appUsername) {
		this.appUsername=appUsername;
	}
	
	public String getAppPassword() {
		return appPassword; 
	}
	
	public void getAppPassword(String appPassword) {
		this.appPassword=appPassword;
	}
	
	
}
