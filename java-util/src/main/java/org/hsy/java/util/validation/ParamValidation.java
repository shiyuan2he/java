package org.hsy.java.util.validation;

import org.hsy.java.exception.web.ParamValidationException;
import org.hsy.java.base.string.StringHelper;
import org.springframework.validation.BindingResult;

import static java.util.stream.Collectors.toList;

/**
 * @author heshiyuan
 * @description <p>参数校验公共方法</p>
 * @path java/org.hsy.java.base.validation
 * @date 2017/10/27 14:05
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2017 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
public class ParamValidation {

    /**
     * @description <p>非空校验</p>
     * @param   args 数组参数
     * @return  校验结果
     * @author heshiyuan
     * @date 2017/10/27 14:11
     */
    public static void notNullValid(Object ... args){
        for(Object arg : args){
            if(arg instanceof String){
                if(StringHelper.isNullOrEmpty((String) arg)){
                    throw new ParamValidationException("参数：【"+ arg + "】不能为空！");
                }
            }
        }
    }
    /**
     * @description <p>spring参数校验工具类</p>
     * @param result spring-context 数据校验结果对象
     * @return 
     * @author heshiyuan
     * @date 2017/12/26 9:31
     */
    public static String validateRequestParam(BindingResult result){
        return result.getAllErrors()
                .stream()
                .filter(errorObjuct -> null!=errorObjuct.getObjectName())
                .collect(toList())
                .get(0)
                .getObjectName()
                ;

    }
}
