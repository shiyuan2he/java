package com.hsy.java.util.http;

import javax.servlet.http.HttpServletRequest;

/**
 * @author heshiyuan
 * @description <p></p>
 * @path java/com.hsy.java.util.http
 * @date 2018/1/23 9:33
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2017 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
public class RequestHelper {
    /**
     * @description <p>从request当中获取域名</p>
     * @param request http内置对象
     * @return 域名
     * @author heshiyuan
     * @date 2018/1/23 9:40
     */
    public static String getDomainFromRequest(HttpServletRequest request){
        int endIndex = request.getRequestURL().length() - request.getPathInfo().length() + 1;
        String url = request.getRequestURL().substring(0, endIndex);
        return url ;
    }
}
