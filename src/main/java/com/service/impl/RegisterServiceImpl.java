package com.service.impl;

import com.dao.UserDao;
import com.model.User;
import com.service.RegisterService;
import com.util.MessageDigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterServiceImpl implements RegisterService {

    @Autowired
    private UserDao userDao;
    @Override
    public int register(User user) {
        User u = userDao.getUserByUserName(user.getUserName());
        if(u!=null){
            //用户名已经存在
            return -1;
        }
        String passWord=user.getPassWord();
        //SHA1编码
        user.setPassWord(MessageDigestUtils.sha1(passWord));
        return userDao.addUser(user);
    }
}
