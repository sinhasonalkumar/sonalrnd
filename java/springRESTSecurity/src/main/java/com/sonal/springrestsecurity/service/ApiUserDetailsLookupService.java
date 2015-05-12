package com.sonal.springrestsecurity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.sonal.springrestsecurity.bo.ApiUser;
import com.sonal.springrestsecurity.config.ApiUserDetails;
import com.sonal.springrestsecurity.dao.IApiUserDAO;

@Service
public class ApiUserDetailsLookupService implements UserDetailsService {

    @Autowired
    private IApiUserDAO apiUserDAO;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
	ApiUser user = apiUserDAO.findApiUserByName(userName);
	if (user == null) {
	    throw new UsernameNotFoundException(String.format("User %s does not exist!", userName));
	}
	ApiUserDetails apiUserDetails = new ApiUserDetails(user);

	return apiUserDetails;
    }

}
