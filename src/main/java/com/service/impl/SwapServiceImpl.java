package com.service.impl;

import com.dao.BookDao;
import com.dao.SwapDao;
import com.dao.UserDao;
import com.model.CONST;
import com.model.ConsumeDetail;
import com.model.Swap;
import com.model.User;
import com.service.AccountService;
import com.service.RepositoryService;
import com.service.SwapService;
import com.util.Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.util.List;

@Service
public class SwapServiceImpl implements SwapService {
    @Autowired
    private SwapDao swapDao;

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private UserDao userDao;

    @Autowired
    private BookDao bookDao;

    @Autowired
    private RepositoryService repositoryService;

    @Override
    @Transactional
    public int addSwap(int bookId1, int bookId2) {
        repositoryService.updateBookStatus(bookId1);
        repositoryService.updateBookStatus(bookId2);
        return swapDao.addSwap(bookId1,bookId2);
    }

    @Override
    public List<Swap> getWaitingSwap() {
        User currentUser = (User)(request.getSession().getAttribute(Config.CURRENTUSER));
        return swapDao.getWaitingSwaps(currentUser.getId());
    }

    @Override
    @Transactional
    public int agreeSwap(int swapId) {
        return swapDao.agreeSwap(swapId);
    }

    @Override
    public List<Swap> getSwapStatus() {
        User currentUser = (User)(request.getSession().getAttribute(Config.CURRENTUSER));
        return swapDao.getSwapStatus(currentUser.getId());
    }

    @Override
    public List<Swap> getDeals(int statusId) {
        return swapDao.getDeals(statusId);
    }

    @Override
    @Transactional
    public int agreeDeal(int dealId) {
        Swap swap = swapDao.getDealsById(dealId);
        swapDao.agreeDeal(dealId);
        userDao.subDeposit(swap.getBook1().getUser().getId(),CONST.Fee);
        userDao.subDeposit(swap.getBook2().getUser().getId(),CONST.Fee);
        ConsumeDetail consumeDetail1 = new ConsumeDetail();
        consumeDetail1.setT_user_id(swap.getBook1().getUser().getId());
        consumeDetail1.setTime(new Timestamp(System.currentTimeMillis()));
        consumeDetail1.setMoney(CONST.Fee);
        userDao.addConsumeDetail(consumeDetail1);
        ConsumeDetail consumeDetail2 = new ConsumeDetail();
        consumeDetail2.setT_user_id(swap.getBook2().getUser().getId());
        consumeDetail2.setTime(new Timestamp(System.currentTimeMillis()));
        consumeDetail2.setMoney(CONST.Fee);
        userDao.addConsumeDetail(consumeDetail1);
        bookDao.resumeBookStatus(swap.getBook1().getId());
        bookDao.resumeBookStatus(swap.getBook2().getId());
        bookDao.updateBookOwner(swap.getBook1().getUser().getId(),swap.getBook2().getId());
        bookDao.updateBookOwner(swap.getBook2().getUser().getId(),swap.getBook1().getId());
        return 1;
    }

    @Override
    @Transactional
    public int rejectDeal(int dealId) {
        Swap swap = swapDao.getDealsById(dealId);
        swapDao.rejectDeal(dealId);
        bookDao.resumeBookStatus(swap.getBook1().getId());
        bookDao.resumeBookStatus(swap.getBook2().getId());
        return 1;
    }

}
