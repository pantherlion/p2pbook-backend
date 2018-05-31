package com.controller;

import com.model.Swap;
import com.service.SwapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/",produces = "application/json;charset=UTF-8")
public class SwapController {
    @Autowired
   private SwapService swapService;
    @RequestMapping("/add-swap")
    public Map<String,Object> addSwap(int bookId1,int bookId2){
        int result = swapService.addSwap(bookId1,bookId2);
        Map<String,Object> resultMap = new HashMap<>();
        if(result>0){
            resultMap.put("result","success");
        }
        else{
            resultMap.put("result","fail");
        }
        return resultMap;
    }

    @RequestMapping("/getWaitingSwap")
    public List<Swap> getWaitingSwap(){
        return swapService.getWaitingSwap();
    }

    @RequestMapping("/agreeSwap")
    public  Map<String,Object> agreeSwap(int swapId){
        int result = swapService.agreeSwap(swapId);
        Map<String,Object> resultMap = new HashMap<>();
        if(result>0){
            resultMap.put("result","success");
        }
        else{
            resultMap.put("result","fail");
        }
        return resultMap;
    }

    @RequestMapping("/getSwapStatus")
    public List<Swap> getSwapStatus(){
        return swapService.getSwapStatus();
    }

    @RequestMapping("/getAuditDeals")
    public List<Swap> getAuditDeals(){
        return swapService.getAuditDeals();
    }

    @RequestMapping("/agreeDeal")
    public  Map<String,Object> agreeDeal(int dealId){
        int result = swapService.agreeDeal(dealId);
        Map<String,Object> resultMap = new HashMap<>();
        if(result>0){
            resultMap.put("result","success");
        }
        else{
            resultMap.put("result","fail");
        }
        return resultMap;
    }

    @RequestMapping("/rejectDeal")
    public  Map<String,Object> rejectDeal(int dealId){
        int result = swapService.rejectDeal(dealId);
        Map<String,Object> resultMap = new HashMap<>();
        if(result>0){
            resultMap.put("result","success");
        }
        else{
            resultMap.put("result","fail");
        }
        return resultMap;
    }
}
