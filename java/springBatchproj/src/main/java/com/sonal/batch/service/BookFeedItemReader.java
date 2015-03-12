package com.sonal.batch.service;

import java.util.List;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sonal.batch.service.feedclient.IBookFeedClient;
import com.sonal.batch.vo.BooksFeed;

@Component
public class BookFeedItemReader implements ItemReader<List<BooksFeed>>{

    @Autowired
    private IBookFeedClient feedreader;
    
    @Override
    public List<BooksFeed> read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
	System.out.println("---------------------------------------");
	System.out.println("BookFeed Reader Started ");
	List<BooksFeed> bookFeed = feedreader.getBookFeed();
	System.out.println("BookFeed Reader Ended Successfully ");
	System.out.println("---------------------------------------");
	
	return bookFeed;
    }

    
}
