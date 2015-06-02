package com.sonal.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

@Service
public class ThirdPartyClient implements IThirdPartyClient {

    @Override
    public List<String> someTimeTakingOperation() {

	List<String> directFiendNames = null;
	
	pieOperation();

	
	directFiendNames = new ArrayList<String>();
	
	
	
	for(int i = 0 ; i < 10 ; i++ ){
	    directFiendNames.add("Freind :: Id :: " + UUID.randomUUID().toString() );
	}
	
	return directFiendNames;
	
    }

    private void pieOperation() {
	double n = 12345678;
	double pi= 0;
	double s = 0;
	for(int i = 1; i <= (n * 2); i += 2){
	     pi = pi + s * (4 / i);
	     s = -s;
	   }

    }
}
