package com.sonal.batch.service;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;

import com.sonal.batch.dao.IBookInventoryDAO;
import com.sonal.batch.persistence.bo.BooksForSale;

public class BookFeedItemWriter implements ItemWriter<List<BooksForSale>> {

    @Autowired
    private IBookInventoryDAO bookInventoryDAO;

    @Override
    public void write(List<? extends List<BooksForSale>> items) throws Exception {
	System.out.println("---------------------------------------");
	System.out.println("BookFeed Writer Started ");
	System.out.println("Books To Save Count :: " + items.size());
	// System.out.println(0/0);
	for (List<BooksForSale> booksToSave : items) {
	    bookInventoryDAO.saveBooks(booksToSave);
	}
	System.out.println("BookFeed Writer Ended Successfully ");
	System.out.println("---------------------------------------");

    }

}
