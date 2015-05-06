package com.sonal.batch.service.feedclient;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.sonal.batch.vo.BooksFeed;

@Service
public class BookFeedClient implements IBookFeedClient {

    
    @Override
    public List<BooksFeed> getBookFeed() {
	List<BooksFeed> bookFeedList = new ArrayList<BooksFeed>();
	try {
	    System.out.println("Going To Get BookFeed ");
	    Thread.sleep(900);
	    //Thread.sleep(30);
	    bookFeedList = dummyBookFeed();
	} catch (InterruptedException e) {
	    e.printStackTrace();
	}
	System.out.println("BookFeed Fetched Successfully !!");
	return bookFeedList;
    }
    
    private List<BooksFeed> dummyBookFeed(){
	List<BooksFeed> bookFeedList = new ArrayList<BooksFeed>();
	
	BooksFeed booksFeed = null;
	for(int i = 1 ; i <= 10 ; i++){
	    
	    if(i % 3 == 0){
		booksFeed = new BooksFeed();
		booksFeed.setBookName(" LEARN SCALA " + i);
		booksFeed.setBookType("SCALA");
		booksFeed.setCount(1000l);
		booksFeed.setPrice(BigDecimal.valueOf(45));
		bookFeedList.add(booksFeed);
	    }else{
		booksFeed = new BooksFeed();
		booksFeed.setBookName(" THINK JAVA " + i);
		booksFeed.setBookType("JAVA");
		booksFeed.setCount(1000l);
		booksFeed.setPrice(BigDecimal.valueOf(35));
		bookFeedList.add(booksFeed);
	    }
	}
	
	return bookFeedList;
	
    }
   
}
