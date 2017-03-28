package com.sj.ilaoshi.common.interceptor;

import com.sj.ilaoshi.dao.UserAuthDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 访问拦截器
 * Created by slt on 2017/3/27.
 */
public class ApiHandlerInterceptor implements HandlerInterceptor {
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse
            , Object o) throws Exception {
        //请求身份验证服务器，http请求
        return true;
    }

    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o
            , ModelAndView modelAndView) throws Exception {

    }

    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o
            , Exception e) throws Exception {

    }
}
