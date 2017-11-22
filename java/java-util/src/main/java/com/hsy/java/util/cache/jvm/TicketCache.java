package com.hsy.java.util.cache.jvm;
import com.hsy.java.bean.vo.SessionBean;
import com.hsy.java.enums.CacheEnum;
import com.hsy.java.exception.cache.CacheException;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

/**
 * @author heshiyuan
 * @description <p>jvm虚拟机缓存</p>
 * @path sso/com.hsy.sso.common.cache
 * @date 18/10/2017 5:36 PM
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2017 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
public class TicketCache {
    // 通票信息跟用户映射缓存
    private static Map<String, TicketInfo> TICKET_AND_NAME = new HashMap<>() ;
    /**
     * @description <p>缓存存储</p>
     * @param ticket 用户通票
     * @param userinfo 购票者信息
     * @param expire 过期时间
     * @return 
     * @author heshiyuan 
     * @date 2017/10/27 11:34
     */
    public static void put(String ticket, SessionBean userinfo, long expire){
        long expireTime = Calendar.getInstance().getTime().getTime() + expire * 1000 ;
        TicketInfo ticketInfo = new TicketInfo() ;
        ticketInfo.setExpire(expireTime);
        ticketInfo.setUserinfo(userinfo);
        TICKET_AND_NAME.remove(ticket) ;
        TICKET_AND_NAME.put(ticket,ticketInfo) ;
    }
    /**
     * @description <p>获取此人的用户信息-验票</p>
     * @param   ticket  通票
     * @return 用户信息对象
     * @author heshiyuan
     * @date 2017/10/27 14:44
     */
    public static SessionBean get(String ticket){
        TicketInfo ticketInfo = TICKET_AND_NAME.get(ticket) ;
        if(ticketInfo.getExpire() > System.currentTimeMillis()){
            TICKET_AND_NAME.remove(ticket) ;
            throw new CacheException(CacheEnum.CACHE_LOGIN_EXPIRE_EXCEPTION) ;
        }
        return ticketInfo.getUserinfo() ;
    }
    /**
     * @description <p>清除缓存</p>
     * @param ticket 清除此人通票信息
     * @author heshiyuan
     * @date 2017/10/27 13:44
     */
    public static void clear(String ticket){
        TICKET_AND_NAME.remove(ticket) ;
    } ;

    private static class TicketInfo{
        private long expire ;
        private SessionBean userinfo;

        public long getExpire() {
            return expire;
        }

        public void setExpire(long expire) {
            this.expire = expire;
        }

        public SessionBean getUserinfo() {
            return userinfo;
        }

        public void setUserinfo(SessionBean userinfo) {
            this.userinfo = userinfo;
        }
    }
}


