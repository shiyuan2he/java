package com.hsy.java.util.json;

import java.util.Date;

/**
 * @author heshiyuan
 * @description <p></p>
 * @path htjf/com.hengtianjf.inteface.pof.entities
 * @date 2018/7/9 13:35
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2018 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
public class PurchaseInfoDto {

    private Integer confirmDay; //确认份额天数 T+1
    private Date confirmDate; //确认份额日期
    private Integer lookEarnDay; //查看盈亏日
    private Date lookEarnDate; //查看盈亏日期
    private Date applyDate;//申请日期

    public Date getApplyDate() {
        return applyDate;
    }

    public void setApplyDate(Date applyDate) {
        this.applyDate = applyDate;
    }

    public Integer getLookEarnDay() {
        return lookEarnDay;
    }

    public void setLookEarnDay(Integer lookEarnDay) {
        this.lookEarnDay = lookEarnDay;
    }

    public Date getLookEarnDate() {
        return lookEarnDate;
    }

    public void setLookEarnDate(Date lookEarnDate) {
        this.lookEarnDate = lookEarnDate;
    }

    public Date getConfirmDate() {
        return confirmDate;
    }

    public void setConfirmDate(Date confirmDate) {
        this.confirmDate = confirmDate;
    }

    public Integer getConfirmDay() {
        return confirmDay;
    }

    public void setConfirmDay(Integer confirmDay) {
        this.confirmDay = confirmDay;
    }

    @Override
    public String toString() {
        return "PurchaseInfoDto{" +
                "confirmDay=" + confirmDay +
                ", confirmDate=" + confirmDate +
                ", lookEarnDay=" + lookEarnDay +
                ", lookEarnDate=" + lookEarnDate +
                ", applyDate=" + applyDate +
                '}';
    }
}

