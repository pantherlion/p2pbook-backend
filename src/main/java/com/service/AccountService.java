package com.service;

import com.model.Book;
import com.model.User;

import java.util.List;

public interface AccountService {
     float getDeposit();
     int addDeposit(float deposit);
     int subDeposit(float deposit);
     List<Book> getMyBooks(String userName);
     User getUser(String userName);
     User getCurrentUser();
    int updatePassWord(String oldPassword,String newPassword);
}
