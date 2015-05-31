package com.sonal.springrestsecurity.oauth2authserver.config;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.sonal.springrestsecurity.oauth2authserver.bo.ApiUser;

public class ApiUserDetails extends ApiUser implements UserDetails {

    public ApiUserDetails(ApiUser user) {
	super(user);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
	return getRoles();
    }

    @Override
    public String getUsername() {
	return super.getUserName();
    }

    @Override
    public boolean isAccountNonExpired() {
	return true;
    }

    @Override
    public boolean isAccountNonLocked() {
	return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
	return true;
    }

    @Override
    public boolean isEnabled() {
	return true;
    }

}
