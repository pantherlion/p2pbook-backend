package com.service;

import com.model.Swap;

import java.util.List;

public interface SwapService {
    int addSwap(int bookId1,int bookId2);
    List<Swap> getWaitingSwap();
    int agreeSwap(int swapId);
    List<Swap> getSwapStatus();
    List<Swap> getAuditDeals();
    int agreeDeal(int dealId);
    int rejectDeal(int dealId);
}
