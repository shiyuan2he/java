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
public class RedeemInfoDto {

    private Integer redeemConfirmDay; //赎回确认天数
    private Date redeemConfirmDate; //赎回确认日期
    private Integer accountToBankDay; //银行卡到账天数
    private Date accountToBankDate; //银行卡到账日期

    public Integer getRedeemConfirmDay() {
        return redeemConfirmDay;
    }

    public void setRedeemConfirmDay(Integer redeemConfirmDay) {
        this.redeemConfirmDay = redeemConfirmDay;
    }

    public Date getRedeemConfirmDate() {
        return redeemConfirmDate;
    }

    public void setRedeemConfirmDate(Date redeemConfirmDate) {
        this.redeemConfirmDate = redeemConfirmDate;
    }

    public Integer getAccountToBankDay() {
        return accountToBankDay;
    }

    public void setAccountToBankDay(Integer accountToBankDay) {
        this.accountToBankDay = accountToBankDay;
    }

    public Date getAccountToBankDate() {
        return accountToBankDate;
    }

    public void setAccountToBankDate(Date accountToBankDate) {
        this.accountToBankDate = accountToBankDate;
    }

    @Override
    public String toString() {
        return "RedeemInfoDto{" +
                "redeemConfirmDay=" + redeemConfirmDay +
                ", redeemConfirmDate=" + redeemConfirmDate +
                ", accountToBankDay=" + accountToBankDay +
                ", accountToBankDate=" + accountToBankDate +
                '}';
    }
}

