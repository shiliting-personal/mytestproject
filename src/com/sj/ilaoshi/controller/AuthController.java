package com.sj.ilaoshi.controller;

import com.sj.ilaoshi.common.constants.Constants;
import com.sj.ilaoshi.common.enumerate.ResultEnum;
import com.sj.ilaoshi.common.util.ModelMapUtil;
import com.sj.ilaoshi.service.SecurityService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.util.UUID;

/**
 * 验证controller
 * Created by slt on 2017/3/28.
 */
@Controller
public class AuthController {
    @Autowired
    SecurityService securityService;


    public String buildUniqueId(){
        return UUID.randomUUID().toString();
    }



    @RequestMapping(value = "/checkSign",method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public ModelMap checkSign(HttpServletRequest request, HttpServletResponse response){
        response.addHeader("Access-Control-Allow-Origin", "*");
        String sign=request.getParameter(Constants.SIGN_NAME);
        if(StringUtils.isEmpty(sign)){
            return ModelMapUtil.createModelMap(ResultEnum.BAD_REQUEST,null);
        }
        try {
            String realSign=securityService.getSign(request,"123456");
            if(!sign.equals(realSign)){
                return ModelMapUtil.createModelMap(ResultEnum.SIGNATURE_FAILURE,null);
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return ModelMapUtil.createModelMap(ResultEnum.SIGNATURE_FAILURE,null);
        }

        return ModelMapUtil.createModelMap(ResultEnum.SUCCESS,null);
    }
}
