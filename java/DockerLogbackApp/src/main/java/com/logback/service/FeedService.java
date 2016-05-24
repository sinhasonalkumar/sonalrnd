package com.logback.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.logback.service.client.vo.Feed;

@Service
public class FeedService {


    public List<Feed> getFeed(){
	ArrayList<Feed> feed = new ArrayList<Feed>();
	return feed;
    }
    
    
    
    public void sendAck(String message){
	
    }
}
