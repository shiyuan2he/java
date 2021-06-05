package org.hsy.java.io;

import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;

/**
 * @author heshiyuan
 * @date 2020/1/22 09:46
 */
public class FileUtils {
    static List<String> ignoreFile = Arrays.asList(".DS_Store");

    public static JSONObject getFiles(String path) throws FileNotFoundException {
        JSONObject json = new JSONObject();
        int index = 0;
        String pathPrefix = "http://oss.zhongbaounion.com/share/product";
        File file = new File(path);
        if(!file.exists()){
            throw new FileNotFoundException("文件不存在");
        }
        if (file.isDirectory()) {
            JSONArray array = new JSONArray();
            File[] files = file.listFiles();
            for (int i = 0; i < files.length; i++) {
                JSONObject json333 = new JSONObject();
                if (files[i].isDirectory()) {
                    JSONArray array222 = new JSONArray();
                    File[] innerFiles = files[i].listFiles();
                    for (int j = 0; j < innerFiles.length; j++) {
                        if(innerFiles[j].isDirectory()){
                            JSONArray array111 = new JSONArray();
                            File[] inner2 = innerFiles[j].listFiles();
                            for (int k = 0; k < inner2.length; k++) {
                                if(inner2[k].isDirectory()){
                                }else{
                                    if(!ignoreFile.contains(inner2[k].getName())){
                                        JSONObject json111 = new JSONObject();
                                        json111.put("type", inner2[k].getName().substring(inner2[k].getName().indexOf(".")+1));
                                        json111.put("url", pathPrefix + "/" + file.getName() + "/" +
                                                files[i].getName()+ "/" + innerFiles[j].getName()+ "/" + inner2[k].getName());
                                        json111.put("name", inner2[k].getName().substring(0, inner2[k].getName().indexOf(".")));
                                        array111.add(json111);
                                    }
                                }
                            }
                            JSONObject json222 = new JSONObject();
                            json222.put("folderId", ++index);
                            json222.put("folderName", innerFiles[j].getName());
                            json222.put("sourceList", array111);
                            array222.add(json222);
                        }
                    }
                    json333.put("moudle", files[i].getName());
                    json333.put("folderList", array222);
                }
                array.add(json333);
            }
            json.put(file.getName(), array);
        }
        return json;
    }
}
