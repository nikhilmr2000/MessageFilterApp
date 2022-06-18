package com.chatApp.MessageFilterApp.Entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="friends")
public class Friends {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="mail")
	private String mail;
	
	public Friends(String mail) {
		super();
		this.mail = mail;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}
	
	public Friends() {
		super();
	}



	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	@JoinTable(name="friends_register",
		joinColumns={ @JoinColumn(name="friends_id") },
		inverseJoinColumns={ @JoinColumn(name="register_id") })
	private List<Register> register=new ArrayList<>();

	public List<Register> getRegister() {
		return register;
	}

	public void setRegister(Register register) {
		this.register.add(register);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	

	@Override
	public String toString() {
		return "Friends [id=" + id + mail +" register=" + register + "]";
	}
	
	
}
