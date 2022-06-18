package com.chatApp.MessageFilterApp.Entity;

public class Login {
	private String mail;
	private String pass;
	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Login(String mail, String pass) {
		super();
		this.mail = mail;
		this.pass = pass;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	@Override
	public String toString() {
		return "Login [mail=" + mail + ", pass=" + pass + "]";
	}
	
	
}
