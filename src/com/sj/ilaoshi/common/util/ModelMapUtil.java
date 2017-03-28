package com.sj.ilaoshi.common.util;

import com.sj.ilaoshi.common.enumerate.ResultEnum;
import org.springframework.ui.ModelMap;

/**
 * model返回值工具
 * Created by slt on 2017/3/27.
 */
public class ModelMapUtil {

    public static final String RESULT_CODE="code";
    public static final String RESULT_MSG="msg";
    public static final String DATA="data";

    /**
     * 创建modelMap，并传入指定参数
     * @param code      返回码
     * @param msg       返回消息
     * @param data      返回数据
     * @return modelMap
     */
    public static ModelMap createModelMap(int code,String msg,Object data){
        ModelMap modelMap=new ModelMap();
        modelMap.addAttribute(RESULT_CODE,code);
        modelMap.addAttribute(RESULT_MSG,msg);
        modelMap.addAttribute(DATA,data);
        return modelMap;
    }

    /**
     * 根据枚举来生成一个modelMap
     * @param resultEnum    result枚举
     * @param data          数据
     * @return              modelMap
     */
    public static ModelMap createModelMap(ResultEnum resultEnum, Object data){
        return createModelMap(resultEnum.getCode(),resultEnum.getValue(),data);
    }

    /**
     * 创建一个默认成功的modelMap
     * @return modelMap
     */
    public static ModelMap createDefaultSuccessModelMap(){
        return createModelMap(ResultEnum.SUCCESS,null);
    }
}
