package com.sj.ilaoshi.service.impl;


import com.sj.ilaoshi.common.constants.Constants;
import com.sj.ilaoshi.service.SecurityService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.Map;
import java.util.TreeMap;

/**
 * 签名
 * Created by slt on 2017/3/28.
 */
@Service
public class SecurityServiceImpl implements SecurityService {

    private static Log log = LogFactory.getLog(SecurityServiceImpl.class);
    @Override
    public String getSign(HttpServletRequest request, String secretKey) throws UnsupportedEncodingException {
        Map<String, String> resultMap = new TreeMap<String, String>();
        Map map = request.getParameterMap();
        for (Object key : map.keySet()) {
            String keyStr=key.toString();
            if(Constants.SIGN_NAME.equals(keyStr)){
                continue;
            }
            resultMap.put(keyStr, request.getParameter(keyStr));
        }

        return getSign(resultMap,secretKey);
    }

    @Override
    public String getSign(Map<String, String> map, String secretKey) throws UnsupportedEncodingException {
        Map<String, String> resultMap = new TreeMap<String, String>();
        for (Object key : map.keySet()) {
            resultMap.put(key.toString(), map.get(key.toString()));
        }
        StringBuilder strB = new StringBuilder();
        for (String key : resultMap.keySet()) {
            if (!StringUtils.isEmpty(resultMap.get(key))) {
                strB.append("&" + key + "=" + resultMap.get(key));
            }

        }
        String toSign = (strB.toString().length() > 0 ? strB.toString().substring(1) : "")
                +secretKey;
        log.info(toSign);
        return DigestUtils.md5DigestAsHex(toSign.getBytes("UTF-8")).toLowerCase();
    }

    @Override
    public boolean checkSign(HttpServletRequest request, String secretKey) {
        String sign=request.getParameter(Constants.SIGN_NAME);
        if(StringUtils.isEmpty(sign)){
            return false;
        }
        try {
            String realSign=getSign(request,"123456");
            if(!sign.equals(realSign)){
                return false;
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

}
