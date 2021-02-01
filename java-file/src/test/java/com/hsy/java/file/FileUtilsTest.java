package com.hsy.java.file;

import org.junit.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import static org.junit.Assert.*;

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