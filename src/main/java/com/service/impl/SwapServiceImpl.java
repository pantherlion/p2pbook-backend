package com.service.impl;

import com.dao.SwapDao;
import com.model.CONST;
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
import java.util.List;

@Service
public class SwapServiceImpl implements SwapService {
    @Autowired
    private SwapDao swapDao;

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private AccountService accountService;

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
    public int agreeSwap(int swapId) {
        return swapDao.agreeSwap(swapId);
    }

    @Override
    public List<Swap> getSwapStatus() {
        User currentUser = (User)(request.getSession().getAttribute("currentUser"));
        return swapDao.getSwapStatus(currentUser.getId());
    }

    @Override
    public List<Swap> getAuditDeals() {
        return swapDao.getAuditDeals();
    }

    @Override
    public int agreeDeal(int dealId) {
        return swapDao.agreeDeal(dealId);
    }

    @Override
    public int rejectDeal(int dealId) {
        return swapDao.rejectDeal(dealId);
    }

}
