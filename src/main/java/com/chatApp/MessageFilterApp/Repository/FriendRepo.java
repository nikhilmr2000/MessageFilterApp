package com.chatApp.MessageFilterApp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.chatApp.MessageFilterApp.Entity.Friends;

@Repository
public interface FriendRepo extends JpaRepository<Friends,Integer>{

}
