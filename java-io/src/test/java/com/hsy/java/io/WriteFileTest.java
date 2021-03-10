package com.hsy.java.io;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author heshiyuan
 * @date 2021/3/10 13:58
 */
public class WriteFileTest {
    WriteFile writeFile = new WriteFile();
    @Test
    public void writeFile() {
        String path = "/Users/heshiyuan/data/devTools/repo/git/java/java-io/src/main/java/com/hsy/java/io/aa.txt";
        writeFile.writeFile(path, "hello girl");
    }

    @Test
    public void writeFile2() {
        String path = "/Users/heshiyuan/data/devTools/repo/git/java/java-io/src/main/java/com/hsy/java/io/aa1.txt";
        writeFile.writeFile2(path, "hello girl");
    }
    @Test
    public void writeFile3() {
        String path = "/Users/heshiyuan/data/devTools/repo/git/java/java-io/src/main/java/com/hsy/java/io/aa3.txt";
        writeFile.writeFile3(path, "hello girl");
    }
}