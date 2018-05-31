package com.service;

import com.model.Book;

import java.util.List;

public interface RepositoryService {
    int addBook(Book book);
    int removeBook(int bookId);
    int updateBookStatus(int bookId);
    int resumeBookStatus(int bookId);
    List<Book> showAllBooksByCategory(int categoryId);
    List<Book> showMyBooks();
    List<Book> showAllBooksByAuthorOrBookName(String searchContent);
    List<Book> getMyAvaliableBooks();
}
