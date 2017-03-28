package com.sj.ilaoshi.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 访问拦截器
 * Created by slt on 2017/3/27.
 */
public class LoginHandlerInterceptor implements HandlerInterceptor {
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
