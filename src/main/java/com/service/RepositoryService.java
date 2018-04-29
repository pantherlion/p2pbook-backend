package com.service;

import com.model.Book;

import java.util.List;

public interface RepositoryService {
    public  int addBook(Book book);
    public List<Book> showAllBooksExceptSelf();
    List<Book> showMyBooks();
}
