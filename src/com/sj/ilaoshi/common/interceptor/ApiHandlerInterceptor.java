package com.sj.ilaoshi.common.interceptor;

import com.sj.ilaoshi.common.constants.Constants;
import com.sj.ilaoshi.common.enumerate.ResultEnum;
import com.sj.ilaoshi.common.util.InterceptorUtil;
import com.sj.ilaoshi.dao.UserSignatureDao;
import com.sj.ilaoshi.entity.UserSignature;
import com.sj.ilaoshi.service.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 访问拦截器
 * Created by slt on 2017/3/27.
 */
@Component
public class ApiHandlerInterceptor implements HandlerInterceptor {

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    private UserSignatureDao userSignatureDao;

    @Autowired
    private SecurityService securityService;

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        String secretIdStr= request.getParameter(Constants.SECRETID);
        if(StringUtils.isEmpty(secretIdStr)){
            InterceptorUtil.setMessageIntercept(response, ResultEnum.BAD_REQUEST);
            return false;
        }
        Long secretId;
        try{
             secretId=Long.parseLong(secretIdStr);
        }catch (NumberFormatException e){
            InterceptorUtil.setMessageIntercept(response, ResultEnum.FORBIDDEN);
            return false;
        }

        UserSignature userSignature=userSignatureDao.findBySecretId(secretId);
        if(userSignature==null){
            InterceptorUtil.setMessageIntercept(response, ResultEnum.FORBIDDEN);
            return false;
        }
        String secretKey=userSignature.getSecretKey();

        boolean isLegal=securityService.checkSign(request,secretKey);
        if(!isLegal){
            InterceptorUtil.setMessageIntercept(response, ResultEnum.SIGNATURE_FAILURE);
            return false;
        }

        return true;
    }

    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o
            , ModelAndView modelAndView) throws Exception {

    }

    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o
            , Exception e) throws Exception {

    }
}
