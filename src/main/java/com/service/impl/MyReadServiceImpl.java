package com.service.impl;

import com.dao.BookDao;
import com.dao.MyReadDao;
import com.model.MyRead;
import com.model.User;
import com.service.MyReadService;
import com.util.Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
public class MyReadServiceImpl implements MyReadService {

    @Autowired
    private MyReadDao myReadDao;

    @Autowired
    private BookDao bookDao;

    @Autowired
    private HttpServletRequest request;

    @Override
    @Transactional
    public int addMyRead(int bookId) {
        bookDao.modifyBookStatus(bookId);
        return myReadDao.addMyRead(bookId);
    }

    @Override
    @Transactional
    public int removeMyRead(int bookId) {
        bookDao.resumeBookStatus(bookId);
        return myReadDao.deleteMyRead(bookId);
    }

    @Override
    public List<MyRead> getMyRead() {
        User currentUser = (User)(request.getSession().getAttribute(Config.CURRENTUSER));
        return myReadDao.getMyRead(currentUser.getId());
    }
}
