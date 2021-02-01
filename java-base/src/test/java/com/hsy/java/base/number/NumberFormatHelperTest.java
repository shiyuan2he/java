package com.hsy.java.base.number;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author heshiyuan
 * @description <p></p>
 * @path java/com.hsy.java.base.number
 * @date 2019/10/10 16:42
 */
@Slf4j
public class NumberFormatHelperTest {
    List<String> moneyList = Arrays.asList("1499999", "1500000", "111115", "11115", "1115", "115", "15", "5", "0.5");
    @Test
    public void getTwoFromNum() {
        moneyList.parallelStream().forEach(str -> log.info("{}", NumberFormatHelper.getTwoFromNum(str)));
    }
    @Test
    public void getTwoFromNum2() {
        moneyList.parallelStream().forEach(str -> log.info("{} ==> {}",str, NumberFormatHelper.getTwoFromNum2(str)));
    }
}