package com.dao;

import com.model.Swap;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface SwapDao {
    int addSwap(int bookId1,int bookId2);
    List<Swap> getWaitingSwaps(int userId);
    int agreeSwap(int swapId);
    List<Swap> getSwapStatus(int userId);
    List<Swap> getDeals(int statusId);
    Swap getDealsById(int dealId);
    int agreeDeal(int dealId);
    int rejectDeal(int dealId);
}
