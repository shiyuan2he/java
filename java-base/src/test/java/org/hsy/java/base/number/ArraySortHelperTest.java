package org.hsy.java.base.number;

import org.hsy.java.base.number.ArraySortHelper;
import org.hsy.java.base.utils.RandomHelper;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @author heshiyuan
 * @description <p></p>
 * @path javase/com.javase.array
 * @date 2017/6/18 下午1:24
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2017 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
public class ArraySortHelperTest {

    @Test
    public void testBubbleSortToSmall(){
        for(int i=0;i<10;i++){
            ArraySortHelper.bubbleSortToSmall(RandomHelper.generetaArrayByLength(1000));
        }
    }

    @Test
    public void testBubbleSortToBig(){
        for(int i=0;i<10;i++){
            ArraySortHelper.bubbleSortToBig(RandomHelper.generetaArrayByLength(1000));
        }
    }

    @Test
    public void test(){
        Long[] array1 = new Long[]{1l,2l} ;
        Long[] array2 = new Long[]{2l,3l,4l} ;
        List<Long> list1 = Arrays.asList(array1) ;
        List<Long> list2 = Arrays.asList(array2) ;

        list1.removeAll(list2);//此时temp中存在的是list1中去除相同那部分的数据
    }
}
