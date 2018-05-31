package com.dao;

import com.model.MyRead;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface MyReadDao {
    int addMyRead(int bookId);
    int deleteMyRead(int bookId);
    List<MyRead> getMyRead(int userId);
}
