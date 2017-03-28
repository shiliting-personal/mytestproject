package com.sj.ilaoshi.common.resolover;

import java.lang.annotation.*;

/**
 * 用户将token转换为HotUser
 * Created by slt on 2017/1/11.
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface TokenHotUser {
}

