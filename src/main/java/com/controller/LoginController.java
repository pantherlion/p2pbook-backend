package com.controller;

import com.model.User;
import com.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value="/",produces="application/json;charset=UTF-8")
public class LoginController {
    @Autowired
    private LoginService loginService;

    @RequestMapping(value = "/login")
    public Map<String,String> login(@RequestBody User user){
         boolean flag = loginService.login(user);
         Map<String,String> resultMap=new HashMap<>();
         if(flag==true){
             resultMap.put("result","success");
             if(user.getIdentity().equals("1")){
                 resultMap.put("identity","user");
             }
             else{
                 resultMap.put("identity","admin");
             }
         }
         else{
             resultMap.put("result","fail");
         }
        return resultMap;
    }

}
