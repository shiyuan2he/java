package org.hsy.java.exercise.ip;

import org.hsy.java.base.number.NumberHelper;
import org.apache.commons.lang3.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author heshiyuan
 * @description <p></p>
 * @path java/org.hsy.java.exercise.ip
 * @date 2018/8/20 9:33
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2018 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
public class IPFilter {

    public static boolean validate(String ipAddress) {
        if(StringUtils.isBlank(ipAddress)) return false;
        if(!ipAddress.contains(".")) return false;
        if(ipAddress.indexOf(".")==0 || ipAddress.lastIndexOf(".")==ipAddress.length()-1) return false;
        String[] ips = ipAddress.split("\\.");
        if(ips.length > 4) return false;

        for (int i = 0; i < ips.length; i++) {
            if(!NumberHelper.isNumber(ips[i])) return false;
            int number = Integer.parseInt(ips[i]);
            if(number<0 || number>255) return false;
        }
        return true;
    }

    public static boolean validateByPattern(String ipAddress) {
        String ip = "([1-9]|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])(\\.(\\d|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])){3}";
        Pattern pattern = Pattern.compile(ip);
        Matcher matcher = pattern.matcher(ipAddress);
        return matcher.matches();
    }

    public static boolean validate(String allowIP, String allowIPRange, String allowIPWildcard) {

        //匹配IP地址每一段的正则
        String regx = "(1\\d{1,2}|2[0-4]\\d|25[0-5]|\\d{1,2})";
        //把四段用点连接起来,那就是匹配整个ip地址的表达式
        String ipRegx = regx + "\\." + regx + "\\." + regx + "\\." + regx;

        //校验第一种配置方式配置的IP白名单格式是否正确
        Pattern pattern = Pattern.compile("(" + ipRegx + ")|(" + ipRegx + "(,|;))*");
        if (!validate(allowIP, pattern)) {
            return false;
        }

        //校验第二种配置方式配置的的IP白名单格式是否正确
        pattern = Pattern.compile("(" + ipRegx + ")\\-(" + ipRegx + ")|" + "((" + ipRegx + ")\\-(" + ipRegx + ")(,|;))*");
        if (StringUtils.isNotBlank(allowIPRange) && !validate(allowIPRange, pattern)) {
            return false;
        }

        //校验第三种配置方式配置的的IP白名单格式是否正确
        pattern = Pattern.compile("(" + regx + "\\." + regx + "\\." + regx + "\\." + "\\*)|" + "(" + regx + "\\." + regx + "\\." + regx + "\\." + "\\*(,|;))*");
        if (StringUtils.isNotBlank(allowIPWildcard) && !validate(allowIPWildcard, pattern)) {
            return false;
        }
        return true;
    }
    //校验用户配置的ip列表格式是否正确
    public static boolean validate(String allowIP,Pattern pattern){
        //如果为空则不做处理
        if(null != allowIP && !allowIP.trim().equals("")){
            StringBuilder sb = new StringBuilder(allowIP);

            //如果用户配置的IP配置了多个,但没有以分号结尾,这里就给它加上分号
            if(!allowIP.endsWith(";")){
                sb.append(";");
            }
            //匹配
            if(!pattern.matcher(sb).matches()){
                return false;
            }
        }
        return true;
    }
}
