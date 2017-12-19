package com.hsy.java.bean.web;

import com.hsy.java.bean.dto.ResponseBodyBean;
import com.hsy.java.enums.ConstantEnum;

/**
 * @author heshiyuan
 * @description <p></p>
 * @path framework/com.hsy.web
 * @date 18/08/2017 11:05 AM
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2017 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
public class BaseController {
    /**
     * @description <p>通用失败返回</p>
     * @param
     * @return No such property: code for class: Script1
     * @author heshiyuan
     * @date 18/08/2017 11:12 AM
     * @email shiyuan4work@sina.com
     * @github https://github.com/shiyuan2he.git
     * Copyright (c) 2016 shiyuan4work@sina.com All rights reserved
     */
    protected <T> ResponseBodyBean<T> failure(){
        return new ResponseBodyBean<>(false, ConstantEnum.RETURN_COMMON_FAILURE.getCode(), ConstantEnum.RETURN_COMMON_FAILURE.getMessage()) ;
    }
    /**
     * @description <p>定制失败返回</p>
     * @param
     * @return No such property: code for class: Script1
     * @author heshiyuan
     * @date 18/08/2017 11:13 AM
     * @email shiyuan4work@sina.com
     * @github https://github.com/shiyuan2he.git
     * Copyright (c) 2016 shiyuan4work@sina.com All rights reserved
     */
    protected <T> ResponseBodyBean<T> failure(String code , String errorInfo){
        return new ResponseBodyBean<>(false, code,errorInfo) ;
    }
    /**
     * @description <p>定制失败返回</p>
     * @param
     * @return No such property: code for class: Script1
     * @author heshiyuan
     * @date 18/08/2017 11:13 AM
     * @email shiyuan4work@sina.com
     * @github https://github.com/shiyuan2he.git
     * Copyright (c) 2016 shiyuan4work@sina.com All rights reserved
     */
    protected <T> ResponseBodyBean<T> failure(String errorInfo){
        return new ResponseBodyBean<>(false, ConstantEnum.RETURN_COMMON_FAILURE.getCode(), ConstantEnum.RETURN_COMMON_FAILURE.getMessage()) ;
    }
    /**
     * @description <p>通用成功返回</p>
     * @param
     * @return No such property: code for class: Script1
     * @author heshiyuan
     * @date 18/08/2017 11:12 AM
     * @email shiyuan4work@sina.com
     * @github https://github.com/shiyuan2he.git
     * Copyright (c) 2016 shiyuan4work@sina.com All rights reserved
     */
    protected <T>ResponseBodyBean<T> success(){
        return new ResponseBodyBean<>(true, ConstantEnum.RETURN_COMMON_SUCCESS.getCode(), ConstantEnum.RETURN_COMMON_SUCCESS.getMessage()) ;
    }

    /**
     * @description <p>定制成功返回</p>
     * @param
     * @return No such property: code for class: Script1
     * @author heshiyuan
     * @date 18/08/2017 11:13 AM
     * @email shiyuan4work@sina.com
     * @github https://github.com/shiyuan2he.git
     * Copyright (c) 2016 shiyuan4work@sina.com All rights reserved
     */
    protected <T>ResponseBodyBean<T> success(T obj){
        return new ResponseBodyBean<>(true, ConstantEnum.RETURN_COMMON_SUCCESS.getCode(),ConstantEnum.RETURN_COMMON_SUCCESS.getMessage(),obj) ;
    }
}