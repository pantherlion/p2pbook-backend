package com.service;

import com.model.MyRead;

import java.text.ParseException;
import java.util.List;

public interface MyReadService {
    int addMyRead(int bookId);
    int removeMyRead(int bookId);
    List<MyRead> getMyRead();
    int updateSchedule(int bookId,int page,String deadLine);
}
