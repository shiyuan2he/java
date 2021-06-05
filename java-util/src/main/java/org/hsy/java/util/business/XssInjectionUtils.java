package org.hsy.java.util.business;

import org.apache.commons.lang3.StringEscapeUtils;

/**
 * @author heshiyuan
 * @description <p>防注入工具类</p>
 * @path java/org.hsy.java.util.idea
 * @date 2017/11/2 08:47
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2017 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
public class XssInjectionUtils {
    private static final String XSS_EVENT = "((?i) onload|onunload|onchange|onsubmit|onreset|onselect|onblur|onfocus|onkeydown|onkeypress|onkeyup|onerror|script|alert|onclick|ondblclick|onmousedown|onmousemove|onmouseout|onfScripTocus|alscRiPtert|onmouseover|onmouseup|<|>|%3C|%3E)";
    private static final String HTTP_EVENTS = "((?i)http|https|href|location|www|com|cn|src)";
    private static final String SQL_REGEX = "('.+--)|(--)|(\\|)|(%7C)";

    public XssInjectionUtils() {
    }

    public static String filterXssStr(String param) {
        return filterXssStr(param, false, true, false, true);
    }

    public static String filterXssStr(String param, boolean html, boolean event, boolean httpevent, boolean sqlevent) {
        if(html) {
            param = StringEscapeUtils.escapeHtml4(param);
        }

        if(event) {
            param = param.replaceAll("((?i) onload|onunload|onchange|onsubmit|onreset|onselect|onblur|onfocus|onkeydown|onkeypress|onkeyup|onerror|script|alert|onclick|ondblclick|onmousedown|onmousemove|onmouseout|onfScripTocus|alscRiPtert|onmouseover|onmouseup|<|>|%3C|%3E)", "#");
        }

        if(httpevent) {
            param = param.replaceAll("((?i)http|https|href|location|www|com|cn|src)", param);
        }

        if(sqlevent) {
            param = param.replaceAll("('.+--)|(--)|(\\|)|(%7C)", param);
        }

        return param;
    }
}
