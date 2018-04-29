package com.service.impl;

import com.dao.BookDao;
import com.model.Book;
import com.model.User;
import com.service.RepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
public class RepositoryServiceImpl implements RepositoryService {
    @Autowired
    private BookDao bookDao;
    @Autowired
    HttpServletRequest request;
    @Override
    public int addBook(Book book) {
        User currentUser = (User) request.getSession().getAttribute("currentUser");
        book.setUser(currentUser);
        return bookDao.addBook(book);
    }

    @Override
    public List<Book> showAllBooksExceptSelf() {
        return bookDao.showAllBooksExceptSelf();
    }

    @Override
    public List<Book> showMyBooks() {
        User currentUser = (User) request.getSession().getAttribute("currentUser");
        return bookDao.showMyBooks(currentUser.getId());
    }
}
