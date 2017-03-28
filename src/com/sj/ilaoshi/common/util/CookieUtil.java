package com.sj.ilaoshi.common.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Administrator on 2017/3/28.
 */
public class CookieUtil {

    public static void addCookie(HttpServletResponse response, String name, String value, int maxAge) {
        Cookie cookie = new Cookie(name, value);
        cookie.setPath("/");
        if (maxAge > 0) {
            cookie.setMaxAge(maxAge);
        }
        response.addCookie(cookie);
    }


    public static void removeCookie(HttpServletResponse response, String name) {
        Cookie uid = new Cookie(name, null);
        uid.setPath("/");
        uid.setMaxAge(0);
        response.addCookie(uid);
    }


    public static String getUid(HttpServletRequest request, String cookieName) {
        Cookie cookies[] = request.getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals(cookieName)) {
                return cookie.getValue();
            }
        }
        return null;
    }







}
