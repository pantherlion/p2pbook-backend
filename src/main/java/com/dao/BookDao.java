package com.dao;

import com.model.Book;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface BookDao {
     int addBook(Book book);
     int removeBook(int bookId);
     List<Book> showAllBooksByCategory(int categoryId);
     List<Book> showAllBooksByAuthorOrBookName(String searchContent);
     List<Book> showMyBooks(int userId);
     int updateBookStatus(int bookId);
     int resumeBookStatus(int bookId);
     int modifyBookStatus(int bookId);
     List<Book> getMyAvaliableBooks(int userId);
     int updateBookOwner(int userId,int bookId);
}
