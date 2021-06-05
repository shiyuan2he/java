package org.hsy.java.util.json;
/**
 * @CreateDate: 2018/8/6 14:47
 * @Description: TODO
 * @author: jingmiao
 * @version: V1.0
 */
public class FundDetailDb {
    private PurchaseInfoDto cFundPchRedmDto;
    private RedeemInfoDto redeemInfoDto;

    public PurchaseInfoDto getcFundPchRedmDto() {
        return cFundPchRedmDto;
    }

    public void setcFundPchRedmDto(PurchaseInfoDto cFundPchRedmDto) {
        this.cFundPchRedmDto = cFundPchRedmDto;
    }

    public RedeemInfoDto getRedeemInfoDto() {
        return redeemInfoDto;
    }

    public void setRedeemInfoDto(RedeemInfoDto redeemInfoDto) {
        this.redeemInfoDto = redeemInfoDto;
    }
}
