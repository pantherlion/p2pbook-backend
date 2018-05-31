package com.service.impl;

import com.service.CertPicService;
import com.util.ValidateCodeUtil;
import org.springframework.stereotype.Service;


import java.util.HashMap;
import java.util.Map;


@Service
public class CertPicServiceImpl implements CertPicService {
    private static char[] mapTable= { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i',
            'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v',
            'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8',
            '9' };
    @Override
    public Map<String, Object> generateCertPic() {
       ValidateCodeUtil.Validate validate= ValidateCodeUtil.generateCertPic(120,50,10,4);
       Map<String,Object> result=new HashMap<>();
       result.put("randStr",validate.getValue());
       result.put("imgSrc",validate.getBase64());
       return result;
    }
}
