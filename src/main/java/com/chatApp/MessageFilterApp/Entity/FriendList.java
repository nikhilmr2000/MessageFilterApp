package com.chatApp.MessageFilterApp.Entity;

public class FriendList {
	private String friendname;
	private String mailID;
	private boolean status;
	public FriendList() {
		super();
		// TODO Auto-generated constructor stub
	}
	public FriendList(String friendname, String mailID, boolean status) {
		super();
		this.friendname = friendname;
		this.mailID = mailID;
		this.status = status;
	}
	public String getFriendname() {
		return friendname;
	}
	public void setFriendname(String friendname) {
		this.friendname = friendname;
	}
	public String getMailID() {
		return mailID;
	}
	public void setMailID(String mailID) {
		this.mailID = mailID;
	}
	public boolean getStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "FriendList [friendname=" + friendname + ", mailID=" + mailID + ", status=" + status + "]";
	}
	
	
}
