package org.hsy.java.util.json;

import org.junit.Test;

/**
 * @author heshiyuan
 * @description <p></p>
 * @path java/org.hsy.java.util.json
 * @date 2018/8/16 14:10
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2018 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
public class JsonHelperTest {

    @Test
    public void json2Obj() {
    }

    @Test
    public void obj2Json() {
    }

    @Test
    public void json2ObjStrong() {
    }

    @Test
    public void json2ObjStrong1() {
        String json = "{\"cFundPchRedmDto\":{\"applyDate\":1534397533199,\"confirmDate\":1534483933199,\"confirmDay\":1,\"lookEarnDate\":1534570333199,\"lookEarnDay\":2},\"redeemInfoDto\":{\"accountToBankDate\":1534743133199,\"accountToBankDay\":2,\"redeemConfirmDate\":1534483933199,\"redeemConfirmDay\":1}}";


        FundDetailDb db = JsonHelper.json2ObjStrong2(json, FundDetailDb.class);
    }

    @Test
    public void json2Arr() {
    }
}