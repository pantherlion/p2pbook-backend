package com.dao;

import com.model.MyRead;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;

public interface MyReadDao {
    int addMyRead(int bookId);
    int deleteMyRead(int bookId);
    List<MyRead> getMyRead(int userId);
    int updateSchedule(int bookId,int page,Timestamp deadLine);
}
