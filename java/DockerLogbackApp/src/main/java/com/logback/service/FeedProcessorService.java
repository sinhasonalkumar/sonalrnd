package com.logback.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rx.Observable;
import rx.observables.AsyncOnSubscribe;

import com.logback.persistence.bo.VideoLibBO;
import com.logback.service.client.vo.Feed;

@Service
public class FeedProcessorService {

    @Autowired
    private VideoService videoService;

    @Autowired
    private FeedService feedService;

    public String processFeed() {

	List<VideoLibBO> videos = videoService.getAllVideos();
	List<Feed> feed = feedService.getFeed();
	merge(videos, feed);
	feedService.sendAck("Success");
	return "Done";
    }

    public Observable<String> processFeedv2() {
	
	List<VideoLibBO> videos = videoService.getAllVideos();
	List<Feed> feed = feedService.getFeed();
	merge(videos, feed);
	feedService.sendAck("Success");
	return null;
    }

    public List<VideoLibBO> merge(List<VideoLibBO> videos, List<Feed> feed) {

	List<VideoLibBO> mergedVideos = new ArrayList<VideoLibBO>();

	return mergedVideos;
    }
}
