/*
 * 版权所有:杭州火图科技有限公司
 * 地址:浙江省杭州市滨江区西兴街道阡陌路智慧E谷B幢4楼
 *  (c) Copyright Hangzhou Hot Technology Co., Ltd.
 *  Floor 4,Block B,Wisdom E Valley,Qianmo Road,Binjiang District
 *  2013-2016. All rights reserved.
 */

package com.sj.ilaoshi.common.resolover;

import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletRequest;

/**
 *  token转HotUser处理器
 * @author slt
 */
//@Component
public class TokenHotUserResolver implements HandlerMethodArgumentResolver {

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.getMethodAnnotation(TokenHotUser.class)!=null;
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer
            , NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {

        HttpServletRequest request = webRequest.getNativeRequest(HttpServletRequest.class);

        String token =request.getParameter("data");
//        Method method=parameter.getMethod();
//        method.invoke(null,new Object[]{"i love you","i fuck you"});
        return "123";

//        if(StringUtils.isEmpty(token)){
//            return null;
//        }
//        return null;
    }
}
