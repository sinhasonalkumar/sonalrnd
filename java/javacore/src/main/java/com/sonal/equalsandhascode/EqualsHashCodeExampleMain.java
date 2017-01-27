package com.sonal.equalsandhascode;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class EqualsHashCodeExampleMain {

    public static void main(String[] args) {
	
	Set<Asset> assetSet = new HashSet<>();
	
	Asset instance = null;
	for(int i = 0 ; i < 3; i++){
	    instance = getInstance();
	    System.out.println(instance);
	    assetSet.add(instance);
	}
	
	System.out.println(assetSet.size());
	
	
    }
    
    private static Asset getInstance(){
	Asset asset = new Asset();
	asset.setId(UUID.randomUUID().toString());
	asset.setName(UUID.randomUUID().toString());
	return asset;
    }
}
