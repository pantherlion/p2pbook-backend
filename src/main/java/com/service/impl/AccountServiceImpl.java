package com.service.impl;

import com.dao.UserDao;
import com.model.Book;
import com.model.User;
import com.service.AccountService;
import com.util.MessageDigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private HttpServletRequest request;

    @Override
    public float getDeposit() {
        User user = (User)request.getSession().getAttribute("currentUser");
        return userDao.getDeposit(user.getUserName());
    }

    @Override
    public int addDeposit(float deposit) {
        User user = (User)request.getSession().getAttribute("currentUser");
        return userDao.addDeposit(user.getId(),deposit);
    }

    @Override
    public int subDeposit(float deposit) {
        User user = (User)request.getSession().getAttribute("currentUser");
        return userDao.subDeposit(user.getId(),deposit);
    }

    @Override
    public List<Book> getMyBooks(String userName) {
        return null;
    }


    @Override
    public User getUser(String userName) {
        User user=userDao.getUserByUserName(userName);
        return user;
    }

    @Override
    public User getCurrentUser() {
        User user = (User)request.getSession().getAttribute("currentUser");
        return getUser(user.getUserName());
    }

    @Override
    public int updatePassWord(String oldPass,String newPass) {
        User user = (User)request.getSession().getAttribute("currentUser");
        oldPass=MessageDigestUtils.sha1(oldPass);
        newPass=MessageDigestUtils.sha1(newPass);
        if(!user.getPassWord().equals(oldPass)){
            return -1;
        }
        return userDao.updatePassWord(user.getId(),newPass);
    }

}
