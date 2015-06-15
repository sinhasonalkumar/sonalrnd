package com.sonal.springrestsecurity.dao;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Repository;

import com.sonal.springrestsecurity.bo.ApiUser;
import com.sonal.springrestsecurity.bo.ApiUserRole;

@Repository
public class ApiUserDAO implements IApiUserDAO {

    @Override
    public ApiUser findApiUserByName(String userName){
	
	ApiUser apiUser = new ApiUser();
	apiUser.setUserName("sonal");
	apiUser.setPassword("password");
	
	Set<ApiUserRole> apiUserRole = new HashSet<ApiUserRole>();
	ApiUserRole userRole = new ApiUserRole();
	userRole.setRoleName("USER");
	apiUserRole.add(userRole);
	
	apiUser.setRoles(apiUserRole);
	
	return apiUser;
    }
}
