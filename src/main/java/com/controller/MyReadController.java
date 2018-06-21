package com.controller;

import com.model.MyRead;
import com.service.MyReadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/",produces = "application/json;charset=UTF-8")
public class MyReadController {

    @Autowired
    private MyReadService myReadService;

    @RequestMapping("/getMyRead")
    public List<MyRead> getMyRead(){
        return myReadService.getMyRead();
    }

    @RequestMapping("/addMyRead")
    public Map<String,String> addMyRead(int bookId){
        int result =myReadService.addMyRead(bookId);
        Map<String,String> resultMap=new HashMap<>();
        if(result>0){
            resultMap.put("result","success");
        }
        else{
            resultMap.put("result","fail");
        }
        return resultMap;
    }

    @RequestMapping("/deleteMyRead")
    public Map<String,String> deleteMyRead(int bookId){
        int result =myReadService.removeMyRead(bookId);
        Map<String,String> resultMap=new HashMap<>();
        if(result>0){
            resultMap.put("result","success");
        }
        else{
            resultMap.put("result","fail");
        }
        return resultMap;
    }

    @RequestMapping("/updateSchedule")
    public Map<String,String> updateSchedule(int bookId,int page,String deadLine){
        System.out.println(deadLine);
        int result = myReadService.updateSchedule(bookId,page,deadLine);
        Map<String,String> resultMap=new HashMap<>();
        if(result>0){
            resultMap.put("result","success");
        }
        else{
            resultMap.put("result","fail");
        }
        return resultMap;
    }

}
