package com.sonal.springrestsecurity.oauth2authserver.bo;

import lombok.Getter;
import lombok.Setter;

import org.springframework.security.core.GrantedAuthority;

@Setter
@Getter
public class ApiUserRole implements GrantedAuthority{

   
    private static final long serialVersionUID = 6817215546403045276L;
   
    private Integer id;
    private String roleName;
    @Override
    public String getAuthority() {
	return roleName;
    }
    
    

}
