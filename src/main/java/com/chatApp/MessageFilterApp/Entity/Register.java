package com.chatApp.MessageFilterApp.Entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="register")
public class Register {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="username",nullable=false )
	private String username;
	
	@Column(name="email",nullable=false )
	private String email;
	
	@Column(name="password",nullable=false )
	private String password;
	
	@Column(name="url",nullable=false )
	private String url;
	
	@JsonIgnore
	@ManyToMany(mappedBy="register")
	private List<Friends> friends;

	public List<Friends> getFriends() {
		return friends;
	}

	public void setFriends(Friends friends) {
		this.friends.add(friends);
	}

	public Register() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Register(String username, String email, String password,String url) {
		super();
		this.username = username;
		this.email = email;
		this.password = password;
		this.url=url;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Register [id=" + id + ", username=" + username + ", email=" + email + ", password=" + password + "url=" + url + "]";
	}
	
	
	
}
