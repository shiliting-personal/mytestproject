package com.sj.ilaoshi.common.interceptor;

import com.mysql.jdbc.StringUtils;
import com.sj.ilaoshi.common.constants.Constants;
import com.sj.ilaoshi.common.util.CookieUtil;
import com.sj.ilaoshi.service.UserIdentityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 访问拦截器
 * Created by slt on 2017/3/27.
 */
@SuppressWarnings("ALL")
public class LoginHandlerInterceptor implements HandlerInterceptor {
    @Autowired
    UserIdentityService userIdentityService;
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse
            , Object o) throws Exception {
        //获取cookie中的唯一标识符
        String uniqueId=CookieUtil.getUid(httpServletRequest, Constants.USER_UNIQUEID_NAME);

        if(StringUtils.isNullOrEmpty(uniqueId)){
            //跳转到登录页面
        }
        Long userId=userIdentityService.getUserId(uniqueId);
        if(userId==null){
            //唯一标识验证无效，跳转到登录页面

        return true;
    }

    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o
            , ModelAndView modelAndView) throws Exception {

    }

    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o
            , Exception e) throws Exception {

    }
}
