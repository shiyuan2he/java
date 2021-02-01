package com.hsy.algorithm.ai0003;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Scanner;
/**
 * @author heshiyuan
 * @description <p></p>
 * @path java/com.hsy.algorithm.ai0003
 * @date 2019/9/29 09:28
 */
@Slf4j
public class LuhnTest {

    @Test
    public void check() {
        log.info("{}", Luhn.check(new int[]{1,2}));
    }
    @Test
    public void test(){
        // TODO Auto-generated method stub
        Scanner scanner = new Scanner(System.in);

        //输入字符串
        String str = scanner.next();
        //从字符串提取数字
        Luhn bNum = new Luhn(str.length());



        //放入数据
        for (int j = 0; j < str.length(); j++) {
            bNum.setElem(j, str.charAt(j)-48);
        }

        if (bNum.isLuhn()) {
            System.out.print("成功");
        }else {
            System.out.print("失败");
        }
    }
}