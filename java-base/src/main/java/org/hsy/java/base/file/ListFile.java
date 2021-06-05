package org.hsy.java.base.file;

import java.io.File;

/**
 * @author heshiyuan
 * @date 2021/3/9 11:25
 */
public class ListFile {
    public static void main(String[] args) {
        String path = "/Users/heshiyuan/data/devTools/repo/git/java";
        test(path);
    }
    private static void test(String path) {
        File f = new File(path);
        File[] fs = f.listFiles();
        if (fs == null) {
            return;
        }
        for (File file : fs) {
            if (file.isFile()) {
                System.out.println(file.getPath());
            } else {
                test(file.getPath());
            }
        }
    }
}
