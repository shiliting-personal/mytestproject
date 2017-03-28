package com.sj.ilaoshi.service;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.Map;

/**
 * 签名
 * Created by slt on 2017/3/28.
 */
public interface SecurityService {

    /**
     * 获取加密后的sign
     *
     * @param request
     * @param secretKey
     * @return
     * @throws UnsupportedEncodingException
     */
    String getSign(HttpServletRequest request, String secretKey) throws UnsupportedEncodingException;

    /**
     * 获得加密后的sign
     * @param resultMap
     * @param secretKey
     * @return
     * @throws UnsupportedEncodingException
     */
    String getSign(Map<String, String> resultMap, String secretKey) throws UnsupportedEncodingException;

    /**
     * 验证签名是否正确
     * @param request       请求
     * @param secretKey     secretKey
     * @return
     */
    boolean checkSign(HttpServletRequest request,String secretKey);


}
