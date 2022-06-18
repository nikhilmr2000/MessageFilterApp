package com.chatApp.MessageFilterApp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.chatApp.MessageFilterApp.Entity.Register;

@Repository
public interface RegisterRepo extends JpaRepository<Register,Integer>{
	
}
