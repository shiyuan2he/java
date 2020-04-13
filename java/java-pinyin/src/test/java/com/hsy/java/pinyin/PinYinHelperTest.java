package com.hsy.java.pinyin;

import lombok.extern.slf4j.Slf4j;
import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author heshiyuan
 * @description <p></p>
 * @path java/com.hsy.java.pinyin
 * @date 2019/10/30 14:28
 */
@Slf4j
public class PinYinHelperTest {
    List<String> hanYuList = Arrays.asList("张三", "李四", "王五", "赵", "者行孙");
    @Test
    public void hanyuToFirstChar(){
        hanYuList.stream().forEach(str -> log.info("{}", PinyinHelper.toHanyuPinyinStringArray(str.charAt(0))));

    }

    @Test
    public void hanyuToFirstChar2(){
        HanyuPinyinOutputFormat outputFormat = new HanyuPinyinOutputFormat();
        outputFormat.setCaseType(HanyuPinyinCaseType.UPPERCASE);
        hanYuList.stream().forEach(str -> {
            try {
                log.info("{}", PinyinHelper.toHanyuPinyinStringArray(str.charAt(0), outputFormat));
            } catch (BadHanyuPinyinOutputFormatCombination badHanyuPinyinOutputFormatCombination) {
                badHanyuPinyinOutputFormatCombination.printStackTrace();
            }
        });
    }
}