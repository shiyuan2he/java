package org.hsy.java.base.constructor;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * @author heshiyuan
 * @description <p></p>
 * @path java/org.hsy.java.base.constructor
 * @date 19/01/2019 21:47
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@126.com
 * Copyright (c) 2019 shiyuan4work@126.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
@Data
@Slf4j
public class ClassB extends ClassA{
    private String name;
    public ClassB() {
        log.debug("ClassB cons");
    }

    {
        log.debug("ClassB static");
    }
}

