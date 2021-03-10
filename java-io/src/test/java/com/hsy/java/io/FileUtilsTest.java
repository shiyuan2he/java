package com.hsy.java.io;

import org.junit.Test;

import java.io.FileNotFoundException;

/**
 * @author heshiyuan
 * @date 2020/1/22 09:54
 */
public class FileUtilsTest {

    @Test
    public void main() throws FileNotFoundException {
        String path = "/Users/heshiyuan/Desktop/产品资料前端JSON/1128917127147347968";
        System.out.println(FileUtils.getFiles(path).toJSONString(4));
    }
}