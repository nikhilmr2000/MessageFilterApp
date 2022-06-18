package com.chatApp.MessageFilterApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.chatApp.MessageFilterApp.Entity.ActiveUser;
import com.chatApp.MessageFilterApp.Entity.FriendList;

@SpringBootApplication
public class MessageFilterAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(MessageFilterAppApplication.class, args);
	}
	
	@Bean
	public ActiveUser activeUser() {
		return new ActiveUser("");
	}
	
	@Bean
	public FriendList friends() {
		return new FriendList("","",false);
	}

}
