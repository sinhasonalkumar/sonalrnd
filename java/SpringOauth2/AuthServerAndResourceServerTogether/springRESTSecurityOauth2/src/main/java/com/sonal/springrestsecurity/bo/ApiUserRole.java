package com.sonal.springrestsecurity.bo;

import lombok.Getter;
import lombok.Setter;

import org.springframework.security.core.GrantedAuthority;

@Setter
@Getter
public class ApiUserRole implements GrantedAuthority{

    private Integer id;
    private String roleName;
    @Override
    public String getAuthority() {
	return roleName;
    }
    
    

}
