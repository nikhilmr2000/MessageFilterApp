package com.chatApp.MessageFilterApp.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.chatApp.MessageFilterApp.Entity.ActiveUser;

import com.chatApp.MessageFilterApp.Entity.FriendList;
import com.chatApp.MessageFilterApp.Entity.Friends;
import com.chatApp.MessageFilterApp.Entity.Login;
import com.chatApp.MessageFilterApp.Entity.Register;
import com.chatApp.MessageFilterApp.Repository.FriendRepo;
import com.chatApp.MessageFilterApp.Repository.RegisterRepo;


@Service
public class MessageFilterService {
	
	@Autowired
	public RegisterRepo registerRepo;
	
	@Autowired
	public FriendRepo friendRepo;
	
	@Autowired
	public ActiveUser isActive;
	
	
	
	
	
	//**** Register Service *****
	
	//Save Register Service
	
	public Register registerUsers(Register register) {
		List<Register> allUsers=registerRepo.findAll();
		Register newUser=new Register();
		 int newVal=0;
		for(Register user: allUsers) {
			if(user.getUsername().equals(register.getUsername())
					&& user.getEmail().equals(register.getEmail())) {
				newVal=1;
			}
				
		}
		if(newVal==0) {
			 newUser=registerRepo.save(register);
		}
		return newUser;
	}
	
	//List All Register Service
	
	public List<Register> getRegisterUsers(){
		List<Register> allUsers=registerRepo.findAll();
		return allUsers;
	}
	
	//Log in Registered User
	
	//Return Active User
	
	 public Register getLoggedIn(Login login) {
		 Register activeUser=null;
		 List<Register> allUsers=registerRepo.findAll();
		 for(Register user :allUsers) {
			 if(user.getEmail().equals(login.getMail()) && user.getPassword().equals(login.getPass())) {
				 activeUser=user;
				 isActive.setIsActive(user.getEmail());
			 }
		 }
		 return activeUser;
	 
	 }
	 
//Associate E-mail Id (isActive) with a method so that the active user 
 //can be get in all areas (Friends,AddFriends,FriendChat).
	  
	 public Register activeUser() {
		 Register userDetails=null;
		 List<Register> allUser=registerRepo.findAll();
		 for(Register user:allUser) {
			 if(user.getEmail().equals(isActive.getIsActive())) {
				 userDetails=user;
			 }
		 }
		 return userDetails;
	 }
	 
	 //LogOut Account
	 public void Logout() {
		 isActive.setIsActive("");
	 }
	 
	 
	 
	 
	 //Create a entity for addFriend.
	 //connect it with register (Manytomany map).
	 
	/* public List<Register> friendList(){
		 
	 }*/
	 
 	 public Friends postFriends(String username) {
 		Friends friendList=new Friends();
		 List<Register> users=registerRepo.findAll();
		 
		//Current User
		 String activeUser=isActive.getIsActive();
		 
		 for(Register register:users) {
			 	if(register.getUsername().equals(username)){
					//Add Friend Database for a user in isActive
			 		//Yet to Add
			 		friendList.setMail(register.getEmail());
			}
			 	
			 if(register.getEmail().equals(activeUser)) {
					 friendList.setRegister(register);
			}
			 
		 }
		 
		 if(friendList.getMail()!=null && friendList.getRegister().isEmpty()==false) {
			 System.out.println(true);
			friendRepo.save(friendList);
		 }
		 
		
		 //Add register to friendList
		  
		//Now add this returned friend to Friends Database
		 
		 return friendList;	 
 	 }
 	 
 	 
 	 //Friends List
 	 
 	 public List<Register> Friends() {
 		 List<Register> allUsers=registerRepo.findAll();
 		 Register user=new Register();
 		 List<String> emails=new ArrayList<>();
 		 
 		//Current User
		 String activeUser=isActive.getIsActive();
 		 
 		 for(Register register:allUsers) {
 			 System.out.println(register);
 			 if(register.getEmail().equals(activeUser)) {
 				 user=register;
 			 }
 		 }
 		 
 		 List<Friends> allFriends=friendRepo.findAll();
 		 
 		
 		 //MutualFriends
 		 for(Register users :allUsers) {
 			 
 				for(int i=0;i<users.getFriends().size();i++) {
 					System.out.println(users.getFriends().get(i));
 					
 						if(users.getFriends().get(i).getMail().equals(activeUser)) {
 	 	 					emails.add(users.getEmail()); 
 	 	 				 }
 					
 					
 	 			 }
 		 }
 		 
 		 //Friends
 		for(Friends friend: allFriends) {
 			if(friend.getRegister().size()>0) {
 			 for(int i=0;i<friend.getRegister().size();i++) {
 				 if(friend.getRegister().get(i).equals(user)) {
 					 emails.add(friend.getMail());
 				 }
 			 }
 			}
 		 }
 		 
 		 List<Register> friendlist=new ArrayList<>();
 		 
 		 //register
 		 for(Register users:allUsers) {
 			 for(int i=0;i<emails.size();i++) {
 				 
 				 if(users.getEmail().equals(emails.get(i))) {
 					 friendlist.add(users);
 				 }
 			 }
 		 }
 		 
 		 return friendlist;
 		 
 	 }
 	 
 	 //Add Friend
 	 
 	 public List<Register> addFriend(){
 		List<Register> allUsers=registerRepo.findAll();
		 Register user=new Register();
		 List<String> emails=new ArrayList<>();
		 
		//Current User
		 String activeUser=isActive.getIsActive();
		 
		 for(Register register:allUsers) {
			 if(register.getEmail().equals(activeUser)) {
				 user=register;
			 }
		 }
		 
		 List<Friends> allFriends=friendRepo.findAll();
		 
		
		 //MutualFriends
 		 for(Register users :allUsers) {
 			 if(users.getFriends().size()>0) {
 				for(int i=0;i<users.getFriends().size();i++) {
 	 				 if(users.getFriends().get(i).getMail().equals(activeUser)) {
 	 					emails.add(users.getEmail()); 
 	 				 }
 	 			 }
 			 }
 			 
 		 }
 		 
 		 //Friends
 		 for(Friends friend: allFriends) {
 			if(friend.getRegister().size()>0) {
 			 for(int i=0;i<friend.getRegister().size();i++) {
 				 if(friend.getRegister().get(i).equals(user)) {
 					 emails.add(friend.getMail());
 				 }
 			 }
 			}
 		 }
		 
		 emails.add(activeUser);
		 
		 List<Register> addFriend=new ArrayList<>();
		 
		 for(Register users:allUsers) {
			 int j=0;
			 for(int i=0;i<emails.size();i++) {
				 if(!users.getEmail().equals(emails.get(i))) {
					 j++;
				 }
			 }
			 if(j==emails.size()) {
				 addFriend.add(users);
			 }
		 }
		 
		 return addFriend;
		 
 	 }
 	 
 	 public List<Register> getRegisterList(){
 		 return registerRepo.findAll();
 	 }
	
}
