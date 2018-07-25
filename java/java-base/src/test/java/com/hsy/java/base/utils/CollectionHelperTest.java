package com.hsy.java.base.utils;

import com.hsy.java.base.utils.CollectionHelper;
import com.hsy.java.base.utils.RandomHelper;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author heshiyuan
 * @description <p>集合工具类测试类</p>
 * @path java/com.hsy.javase.utils
 * @date 17/08/2017 11:20 AM
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2017 shiyuan4work@sina.com All rights reserved.
 * @price ?5    微信：hewei1109
 */
public class CollectionHelperTest {
    /**
     * @description <p>测试list去重工具类方法</p>
     * @author heshiyuan
     * @date 17/08/2017 11:21 AM
     * @email shiyuan4work@sina.com
     * @github https://github.com/shiyuan2he.git
     * Copyright (c) 2016 shiyuan4work@sina.com All rights reserved
     */
    @Test
    public void testDuplicateRemoval(){
        List<Integer> listInteger = Arrays.asList(100,200,900,300,400,400,200,100);
        CollectionHelper.duplicateRemoval(listInteger);
        List<Integer> listInteger2 = new ArrayList<>() ;
        for(int i=0;i<100000;i++){
            listInteger2.add(RandomHelper.generateRandomByLength(1)) ;
        }
        CollectionHelper.duplicateRemoval(listInteger2);
    }

    @Test
    public void testRemoveTheSameOfList(){
        List<Long> listA = Arrays.asList(1l,2l,3l) ;
        List<Long> listB = Arrays.asList(2l,3l,4l) ;

        CollectionHelper.removeTheSameOfList(listA,listB);
    }
}
