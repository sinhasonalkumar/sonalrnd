package com.sonal.batch.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.sonal.batch.persistence.bo.BooksForSale;

@Repository
public class BookInventoryDAO implements IBookInventoryDAO {

    @Override
    public void saveBooks(List<BooksForSale> booksToSave) {
	System.out.println("Going to Save Books");
	try {
	    Thread.sleep(5000);
	    System.out.println(booksToSave.size() + " :: BooksForSale Saved In Inventory");
	} catch (InterruptedException e) {
	    e.printStackTrace();
	}
	System.out.println("Books Saved SuccessFully !!");
    }

}
