package com.sj.ilaoshi.common.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sj.ilaoshi.common.enumerate.ResultEnum;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 拦截器工具类
 * Created by slt on 2017/3/27.
 */
public class InterceptorUtil {
    public static final String UTF8="UTF-8";
    public static final String CONTENT_TYPE="application/json; charset=utf-8";


    /**
     * 设置消息拦截
     * @param resopnse  相应
     * @param msgEnum   消息
     */
    public static void setMessageIntercept(HttpServletResponse resopnse,ResultEnum msgEnum) throws IOException {
        resopnse.setCharacterEncoding(UTF8);
        resopnse.setContentType(CONTENT_TYPE);
        PrintWriter out=resopnse.getWriter();
        ObjectMapper objectMapper = new ObjectMapper();
        String resultStr=objectMapper.writeValueAsString(ModelMapUtil.createModelMap(
                msgEnum,null));
        out.append(resultStr);
    }
}
