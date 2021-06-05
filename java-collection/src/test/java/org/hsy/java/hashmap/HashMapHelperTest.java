package org.hsy.java.hashmap;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class HashMapHelperTest {
    @Test
    public void testHashMap(){
        HashMap<String, String> map = new HashMap<>(4);
        map.put("Aa", "Aa");
        map.put("BB", "Aa");
        map.put("C#", "Aa");
        map.put("历史", "");
        map.put("政治", "");
        map.put("地理", "");
        map.put("生物", "");
        map.put("化学", "");
        map.put("化学2", "");
        map.put("化学3", "");
        for(Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    @Test
    public void testHashMap2(){
        Integer a = 100;
        Integer b = 100;
        Integer c = 120;
        System.out.println(a == b);
        System.out.println(a == c);
        System.out.println(a.equals(b));
        System.out.println(a.equals(c));
        return ;
    }
    @Test
    public void test(){
        String key = "Aa";
        int h = key.hashCode();
        System.out.println(Integer.toBinaryString(h) + " h = " + h);
        int temp = h >>> 16;
        System.out.println(Integer.toBinaryString(temp) + " temp = " + temp);
        int ret = h ^ temp;
        System.out.println(Integer.toBinaryString(ret) + " ret = " + ret);

        String key2 = "BB";
        int h2 = key2.hashCode();
        System.out.println(Integer.toBinaryString(h2) + " h2 = " + h2);
        int temp2 = h2 >>> 16;
        System.out.println(Integer.toBinaryString(temp2) + " temp2 = " + temp2);
        int ret2 = h2 ^ temp2;
        System.out.println(Integer.toBinaryString(ret2) + " ret2 = " + ret2);
    }
}