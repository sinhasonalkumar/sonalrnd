package com.logback.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.logback.persistence.bo.VideoLibBO;
import com.logback.persistence.dao.VideoFeedDAO;

@Service
public class VideoService {

    @Autowired
    private VideoFeedDAO videoFeedDAO;
    
    
    public List<VideoLibBO> getAllVideos(){
	List<VideoLibBO> findAll = videoFeedDAO.findAll();
	return findAll;
    }
    
}
