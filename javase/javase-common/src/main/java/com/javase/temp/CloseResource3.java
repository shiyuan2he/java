package com.hsy.codebase.utils.javase.temp;

import java.io.*;

/**
 * 
 * @description <p>
 *              请输入属性描述
 *              </p>
 * @time 2016年3月19日 下午4:29:28
 */
public class CloseResource3 {
	public static void main(String[] args) throws Exception {
		Wolf w = new Wolf("灰太狼");
		System.out.println("Wolf对象创建完成～");
		Wolf w2 = null;
		ObjectOutputStream oos = null;
		ObjectInputStream ois = null;
		try {
			// 创建对象输出流
			oos = new ObjectOutputStream(new FileOutputStream("a.bin"));
			// 创建对象输入流
			ois = new ObjectInputStream(new FileInputStream("a.bin"));
			// 序列化输出Java对象
			oos.writeObject(w);
			oos.flush();
			// 反序列化恢复Java对象
			w2 = (Wolf) ois.readObject();
		}
		// 使用finlly块来回收资源
		finally {
			if (oos != null) {
				try {
					oos.close();
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
			if (ois != null) {
				try {
					ois.close();
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		}
	}
}
