package com.sonal.services;

import net.spy.memcached.MemcachedClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sonal.vo.User;

@Service
public class MemcachedCachedService {

    @Autowired
    private MemcachedClient memcachedClient;
   
    public User getUser(String userId){
	User user = (User) memcachedClient.get(userId);
	return user;
    }
    
    public void putUser(User updateUser){
	User cahcedUser = (User) memcachedClient.get(updateUser.getUserId());
	
	if(cahcedUser == null){
	    memcachedClient.add(updateUser.getUserId(), 70, updateUser);
	    System.out.println("User Added :: " + updateUser.getUserId());
	}else{
	    System.out.println("User Already Added");
	}
    }
	

}
