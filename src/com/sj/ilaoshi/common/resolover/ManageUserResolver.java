/*
 * 版权所有:杭州火图科技有限公司
 * 地址:浙江省杭州市滨江区西兴街道阡陌路智慧E谷B幢4楼
 *  (c) Copyright Hangzhou Hot Technology Co., Ltd.
 *  Floor 4,Block B,Wisdom E Valley,Qianmo Road,Binjiang District
 *  2013-2016. All rights reserved.
 */

package com.sj.ilaoshi.common.resolover;

import com.huotu.huotao.interceptor.ManageInterceptor;
import com.huotu.huotao.repository.ManageUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * token转HotUser处理器
 *
 * @author slt
 */
@Component
public class ManageUserResolver implements HandlerMethodArgumentResolver {
    @Autowired
    private ManageUserRepository manageUserRepository;


    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.getParameterAnnotation(ManageUserAn.class) != null;
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer
            , NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        HttpServletRequest request = (HttpServletRequest) webRequest.getNativeRequest();
        HttpSession session = request.getSession();
        if (StringUtils.isEmpty(session.getAttribute(ManageInterceptor.sessionName))) {
            return null;
        }
        return manageUserRepository.findByLoginName(session.getAttribute(ManageInterceptor.sessionName).toString());
    }
}
