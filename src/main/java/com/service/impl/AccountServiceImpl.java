package com.service.impl;

import com.dao.UserDao;
import com.model.*;
import com.service.AccountService;
import com.util.Config;
import com.util.MessageDigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private HttpServletRequest request;

    @Override
    public float getDeposit() {
        User user = (User)request.getSession().getAttribute(Config.CURRENTUSER);
        return userDao.getDeposit(user.getUserName());
    }

    @Override
    @Transactional
    public int addDeposit(float deposit) {
        User user = (User)request.getSession().getAttribute(Config.CURRENTUSER);
        int result = userDao.addDeposit(user.getId(),deposit);
        if(result>0){
            RechargeDetail rechargeDetail = new RechargeDetail();
            rechargeDetail.setT_user_id(user.getId());
            rechargeDetail.setTime(new Timestamp(System.currentTimeMillis()));
            rechargeDetail.setMoney(deposit);
            return userDao.addRechargeDetail(rechargeDetail);
        }
        return -1;
    }

    @Override
    @Transactional
    public int subDeposit(float deposit) {
        User user = (User)request.getSession().getAttribute(Config.CURRENTUSER);
        int result = userDao.subDeposit(user.getId(),deposit);
        if(result>0){
            ConsumeDetail consumeDetail =new ConsumeDetail();
            consumeDetail.setMoney(deposit);
            consumeDetail.setTime(new Timestamp(System.currentTimeMillis()));
            consumeDetail.setT_user_id(user.getId());
            return userDao.addConsumeDetail(consumeDetail);
        }
        return -1;
    }

    @Override
    public List<Book> getMyBooks(String userName) {
        return null;
    }


    @Override
    public User getUser(String userName) {
        return userDao.getUserByUserName(userName);
    }

    @Override
    public User getCurrentUser() {
        User user = (User)request.getSession().getAttribute(Config.CURRENTUSER);
        return getUser(user.getUserName());
    }

    @Override
    @Transactional
    public int updatePassWord(String oldPass,String newPass) {
        User user = (User)request.getSession().getAttribute(Config.CURRENTUSER);
        oldPass=MessageDigestUtils.sha1(oldPass);
        newPass=MessageDigestUtils.sha1(newPass);
        if(!user.getPassWord().equals(oldPass)){
            return -1;
        }
        return userDao.updatePassWord(user.getId(),newPass);
    }

    @Override
    public List<RechargeDetail> getRechargeDetails() {
        User user = (User)request.getSession().getAttribute(Config.CURRENTUSER);
        return userDao.getRechargeDetails(user.getId());
    }

    @Override
    public List<ConsumeDetail> getConsumeDetails() {
        User user = (User)request.getSession().getAttribute(Config.CURRENTUSER);
        return userDao.getConsumeDetails(user.getId());
    }
}
