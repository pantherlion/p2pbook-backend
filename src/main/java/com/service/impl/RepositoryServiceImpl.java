package com.service.impl;

import com.dao.BookDao;
import com.model.Book;
import com.model.User;
import com.service.RepositoryService;
import com.util.Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
public class RepositoryServiceImpl implements RepositoryService {
    @Autowired
    private BookDao bookDao;
    @Autowired
    HttpServletRequest request;
    @Override
    @Transactional
    public int addBook(Book book) {
        User currentUser = (User) request.getSession().getAttribute(Config.CURRENTUSER);
        book.setUser(currentUser);
        return bookDao.addBook(book);
    }

    @Override
    @Transactional
    public int removeBook(int bookId) {
        return bookDao.removeBook(bookId);
    }

    @Override
    @Transactional
    public int updateBookStatus(int bookId) {
        return bookDao.updateBookStatus(bookId);
    }

    @Override
    @Transactional
    public int resumeBookStatus(int bookId) {
        return bookDao.resumeBookStatus(bookId);
    }

    @Override
    public List<Book> showAllBooksByCategory(int categoryId) {
        return bookDao.showAllBooksByCategory(categoryId);
    }

    @Override
    public List<Book> showMyBooks() {
        User currentUser = (User) request.getSession().getAttribute(Config.CURRENTUSER);
        return bookDao.showMyBooks(currentUser.getId());
    }

    @Override
    public List<Book> showAllBooksByAuthorOrBookName(String searchContent) {
        return bookDao.showAllBooksByAuthorOrBookName(searchContent);
    }

    @Override
    public List<Book> getMyAvaliableBooks() {
        User currentUser = (User) request.getSession().getAttribute(Config.CURRENTUSER);
        return bookDao.getMyAvaliableBooks(currentUser.getId());
    }
}
