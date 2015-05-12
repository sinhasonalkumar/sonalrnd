package com.sonal.springrestsecurity.bo;

import java.util.Set;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ApiUser {

    private Integer id;

    private String userName;

    private String password;

    private Set<ApiUserRole> roles;

    public ApiUser() {
    }

    public ApiUser(ApiUser user) {
	super();
	this.id = user.getId();
	this.userName = user.getUserName();
	this.password = user.getPassword();
	this.roles = user.getRoles();
    }
}
