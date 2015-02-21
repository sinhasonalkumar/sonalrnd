package com.sonal.services;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Service;

import com.sonal.vo.User;

@Service
@EnableCaching
public class CachedService {

	// @Cacheable(value = "default",key = "#userId")
	@Cacheable(value = "nameCache", key = "#userId")
	public String computeFullName(String userId, String fname, String lname, String middleName) {
		System.out.println("Computing Full Name : ");
		String fullName = fname + " " + middleName + " " + lname;
		System.out.println("Computed Full Name : " + fullName);
		return fullName;
	}

	//@Cacheable(value = "nameCache", key = "#user.userId", unless ="#user == null")
	@Cacheable(value = "nameCache", key = "#user.userId")
	public User cacheSomeUserData(User user) {

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}

}
