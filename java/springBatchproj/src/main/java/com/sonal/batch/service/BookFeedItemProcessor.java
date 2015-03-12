package com.sonal.batch.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import com.sonal.batch.persistence.bo.BookType;
import com.sonal.batch.persistence.bo.BooksForSale;
import com.sonal.batch.vo.BooksFeed;

@Component
public class BookFeedItemProcessor implements ItemProcessor<List<BooksFeed>, List<BooksForSale>> {

    
    @Override
    public List<BooksForSale> process(List<BooksFeed> item) throws Exception {
	System.out.println("---------------------------------------");
	System.out.println("BookFeed Processor Started");
	List<BooksForSale> booksForSaleList = new ArrayList<BooksForSale>();
	BooksForSale booksForSale = null;
	Thread.sleep(3000);
	for (BooksFeed booksFeed : item) {
	    booksForSale = convertToBooksForSale(booksFeed);
	    System.out.println("BooksForSale Processed !!");
	    booksForSaleList.add(booksForSale);
	    
	}
	System.out.println("BookFeed Processor Ended SuccessFully");
	System.out.println("---------------------------------------");
	return booksForSaleList;
    
    }
    
    
    
    private BooksForSale convertToBooksForSale(BooksFeed booksFeed){
	BooksForSale booksForSale = new BooksForSale();

	booksForSale.setBookName(booksFeed.getBookName());
	booksForSale.setCount(booksFeed.getCount());
	booksForSale.setPrice(booksFeed.getPrice());

	if (BookType.JAVA.name().equals("JAVA")) {
	    booksForSale.setBookType(BookType.JAVA);
	} else {
	    booksForSale.setBookType(BookType.SCALA);
	}
	try {
	    Thread.sleep(1000);
	} catch (InterruptedException e) {
	    e.printStackTrace();
	}
	
	return booksForSale;
    }

}
