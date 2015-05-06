package com.sonal.batch.service;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.beans.factory.annotation.Autowired;

import com.sonal.batch.service.feedclient.IBookFeedClient;
import com.sonal.batch.vo.BooksFeed;

public class BookFeedItemReader implements ItemReader<List<BooksFeed>>{

    @Autowired
    private IBookFeedClient feedreader;
    
    private AtomicInteger readcount = new AtomicInteger(1);
    
    @Override
    public List<BooksFeed> read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
	System.out.println("---------------------------------------");
	System.out.println("BookFeed Reader Started ");
	List<BooksFeed> bookFeed = null;
	if(readcount.intValue() <= 5){
	    bookFeed = feedreader.getBookFeed();
	    System.out.println(readcount.intValue());
	    readcount.addAndGet(1);
	}
	
	System.out.println("BookFeed Reader Ended Successfully ");
	System.out.println("---------------------------------------");
	
	return bookFeed;
    }

    
}
