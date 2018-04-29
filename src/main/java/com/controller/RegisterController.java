package com.controller;

import com.model.User;
import com.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value="/",produces="application/json;charset=UTF-8")
public class RegisterController {
    @Autowired
    private RegisterService registerService;

    @RequestMapping("/register")
    public Map<String,String> register(@RequestBody  User user){
        int rows=registerService.register(user);
        System.out.println("新插入的主键为:"+user.getId());
        Map<String,String> resultMap=new HashMap<>();
        if(rows==-1){
            //用户名存在，插入失败
            resultMap.put("result","fail");
        }
        else{
            resultMap.put("result","success");
        }
        return resultMap;
    }
}
