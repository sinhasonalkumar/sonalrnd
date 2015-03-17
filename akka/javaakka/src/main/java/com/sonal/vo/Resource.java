package com.sonal.vo;

import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Resource {

    private String id;
    private String resounceName;
    
    public static Resource getInstance(String id , String resourceName){
	Resource newResource = new Resource();
	newResource.setId(id);
	newResource.setResounceName(resourceName);
	return newResource;
    }
    
}
