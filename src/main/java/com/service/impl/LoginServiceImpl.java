package com.service.impl;

import com.dao.UserDao;
import com.model.User;
import com.service.LoginService;
import com.util.Config;
import com.util.MessageDigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private UserDao userDao;
    @Autowired
    HttpServletRequest request;

    @Override
    public boolean login(User user) {
        String identity=user.getIdentity();
        if ("1".equals(identity)){
            //普通用户
            User u = userDao.getUserByUserName(user.getUserName());
            if(u!=null && user.getPassWord()!=null  && u.getPassWord().equals(MessageDigestUtils.sha1(user.getPassWord()))){
                //在session中保存用户信息
                request.getSession().setAttribute(Config.CURRENTUSER,u);
                return true;
            }
        }
        else if("2".equals(identity)){
            //平台管理员
            User admin = userDao.getAdminByUserName(user.getUserName());
            if (admin!=null && user.getPassWord()!=null && admin.getPassWord().equals(MessageDigestUtils.sha1(user.getPassWord()))){
                return true;
            }
        }
            return false;
    }


}
