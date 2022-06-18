package com.chatApp.MessageFilterApp.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.chatApp.MessageFilterApp.Entity.FriendList;
import com.chatApp.MessageFilterApp.Entity.Friends;
import com.chatApp.MessageFilterApp.Entity.Login;
import com.chatApp.MessageFilterApp.Entity.Register;
import com.chatApp.MessageFilterApp.Service.MessageFilterService;

@RestController
public class MessageFilterController {
	@Autowired
	private MessageFilterService service;
	
	@PostMapping("/register")
	public Register addUsers(@RequestBody Register register) {
		Register userRegister= service.registerUsers(register);
		return userRegister;
	}
	
	@PostMapping("/login")
	public Register addLogin(@RequestBody Login login) {
		Register loggedRegisterData=service.getLoggedIn(login);
		return loggedRegisterData;
	}
	
	@GetMapping("/user")
	public String getCurrentUser() {
		Register current=service.activeUser();
		if(current==null) {
			return null;
		}
		return current.getUsername();
	}
	
	@GetMapping("/{username}")
	public Friends FriendAdd(@PathVariable String username) {
		return service.postFriends(username);
	}
	
	@GetMapping("/Friends")
	public List<Register> addAsFriend(){
		if(service.Friends()==null) {
			return new ArrayList<Register>();
		}
		return service.Friends();
	}
	
	@GetMapping("/FriendList")
	public List<Register> addFriends() {
		if(service.addFriend()==null) {
			return new ArrayList<Register>();
		}
		return service.addFriend();
	}
	
	@GetMapping("/getRegisterList")
	public List<Register> AllRegister(){
		return service.getRegisterList();
	}
	
	@GetMapping("/logout")
	public void logoutAccount() {
		service.Logout();
	}
	

}
