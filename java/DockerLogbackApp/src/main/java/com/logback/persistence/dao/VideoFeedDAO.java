package com.logback.persistence.dao;

import com.logback.persistence.bo.VideoLibBO;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class VideoFeedDAO {

    public List<VideoLibBO> findAll() {
	List<VideoLibBO> employees = new ArrayList<VideoLibBO>();
	return employees;
    }
}
