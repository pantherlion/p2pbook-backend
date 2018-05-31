package com.dao;

import com.model.ConsumeDetail;
import com.model.RechargeDetail;
import com.model.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UserDao {
     User getUserByUserName(String userName);
     User getAdminByUserName(String userName);
     int addUser(User user);
     int addDeposit(int id,float deposit);
     int subDeposit(int id,float deposit);
     float getDeposit(String userName);
     int updatePassWord(int id,String newPassWord);
     List<RechargeDetail> getRechargeDetails(int id);
     List<ConsumeDetail> getConsumeDetails(int id);
     int addRechargeDetail(RechargeDetail rechargeDetail);
     int addConsumeDetail(ConsumeDetail consumeDetail);
}
