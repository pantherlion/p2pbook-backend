package com.controller;

import com.service.CertPicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping(value = "/",produces = "application/json;charset=utf-8")
public class CertPicController {

    @Autowired
    private CertPicService certPicService;

    @RequestMapping("/getCertPic")
    public Map<String,Object> getCertPic(){
       return  certPicService.generateCertPic();
    }
}
