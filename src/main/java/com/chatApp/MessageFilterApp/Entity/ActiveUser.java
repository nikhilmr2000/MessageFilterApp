package com.chatApp.MessageFilterApp.Entity;



public class ActiveUser {
	public String isActive;

	public ActiveUser() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ActiveUser(String isActive) {
		super();
		this.isActive = isActive;
	}

	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	@Override
	public String toString() {
		return "ActiveUser [isActive=" + isActive + "]";
	}
	
}
