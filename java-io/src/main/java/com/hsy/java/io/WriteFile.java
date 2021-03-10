package com.hsy.java.io;

import java.io.*;

/**
 * @author heshiyuan
 * @date 2021/3/10 13:53
 */
public class WriteFile {
    /**
     * 将字符串写入文件
     * @param str
     */
    public void writeFile(String path, String str){
        if(null==path || "".equals(path)){
            return;
        }
        try {
            Writer fileWriter = new FileWriter(new File(path));
            fileWriter.write(str);
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void writeFile2(String path, String str){
        if(null==path || "".equals(path)){
            return;
        }
        try {
            OutputStream outputStream = new FileOutputStream(new File(path));
            outputStream.write(str.getBytes());
            outputStream.flush();
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void writeFile3(String path, String str){
        if(null==path || "".equals(path)){
            return;
        }
        try {
            OutputStream outputStream = new FileOutputStream(new File(path));
            PrintStream ps = new PrintStream(outputStream);
            ps.print(str);
            ps.flush();
            ps.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
