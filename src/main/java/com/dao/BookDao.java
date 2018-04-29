package com.dao;

import com.model.Book;

import java.util.List;

public interface BookDao {
     int addBook(Book book);
     List<Book> showAllBooksExceptSelf();
     List<Book> showMyBooks(int userId);
}
