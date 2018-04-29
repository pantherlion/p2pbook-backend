package com.dao;

import com.model.User;

public interface UserDao {
     User getUserByUserName(String userName);
     User getAdminByUserName(String userName);
     int addUser(User user);
     int addDeposit(int id,float deposit);
     int subDeposit(int id,float deposit);
     float getDeposit(String userName);
     int updatePassWord(int id,String newPassWord);
}
