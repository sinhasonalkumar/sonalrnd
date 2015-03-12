package com.sonal.batch.dao;

import java.util.List;

import com.sonal.batch.persistence.bo.BooksForSale;

public interface IBookInventoryDAO {

    public abstract void saveBooks(List<BooksForSale> booksToSave);

}