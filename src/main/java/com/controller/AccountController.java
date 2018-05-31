package com.controller;

import com.model.ConsumeDetail;
import com.model.PassWord;
import com.model.RechargeDetail;
import com.model.User;
import com.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping(value="/",produces="application/json;charset=UTF-8")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @RequestMapping(value = "/getCurrentUser")
    public User getCurrentUser(){
        return accountService.getCurrentUser();
    }

    @RequestMapping(value = "/addDeposit")
    public Map<String,Object> addDeposit(@RequestBody User user){
        int result =accountService.addDeposit(user.getDeposit());
        Map<String,Object> resultMap=new HashMap<>();
        if (result>0){
            resultMap.put("result","success");
        }
        else{
            resultMap.put("result","fail");
        }
        return resultMap;
    }
    @RequestMapping(value = "/getDeposit")
    public Map<String,Object> getDeposit(){
        Map<String,Object> resultMap=new HashMap<>();
        float deposit= accountService.getDeposit();
        resultMap.put("deposit",deposit);
        return resultMap;
    }
    @RequestMapping(value = "/updatePass")
    public Map<String,Object> updatePass(@RequestBody PassWord passWord){
        Map<String,Object> resultMap=new HashMap<>();
        int result=accountService.updatePassWord(passWord.getOldPassWord(),passWord.getNewPassWord());
        if(result>0){
            resultMap.put("result","success");
        }
        else {
            resultMap.put("result", "fail");
        }
        return resultMap;
    }

   @RequestMapping(value="/getRechargeDetail")
    public List<RechargeDetail> getRechargeDetails(){
        return accountService.getRechargeDetails();
    }

    @RequestMapping("/getConsumeDetail")
    public List<ConsumeDetail> getConsumeDetails(){
        return accountService.getConsumeDetails();
    }
}
