package com.sonal.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResourcePath {

    private String path;

    public static ResourcePath getInstance(String path) {
	ResourcePath resourcePath = new ResourcePath();
	resourcePath.setPath(path);
	return resourcePath;
    }

}
