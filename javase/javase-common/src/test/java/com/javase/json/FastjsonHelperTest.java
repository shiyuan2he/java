package com.hsy.codebase.utils.javase.json;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.hsy.codebase.utils.javase.logger.SystemLogger;

public class FastjsonHelperTest {
	/****************************	起始符	*******************************/
	@Test
	public void testJavaBeanToJson() {
		User user = new User("541013100112","hehe","UI001","password",Calendar.getInstance().getTime(),"127.0.0.1") ;
		SystemLogger.log(JSON.toJSONString(user));
	}
	@Test
	public void testListToJson() {
		List<User> list = new ArrayList<User>() ;
		for (int i = 0; i < 10; i++) {
			list.add(new User("541013100112","hehe","UI001","password",Calendar.getInstance().getTime(),"127.0.0.1"));
		}
		SystemLogger.log(JSON.toJSONString(list));
	}
	@Test
	public void testMapToJson() {
		Map<String,Object> map = new HashMap<String,Object>() ;
		map.put("username", "hehe") ;
		map.put("password", "password") ;
		SystemLogger.log(JSON.toJSONString(map));
	}
	@Test
	public void testMapListToJson() {
		Map<String,Object> map = new HashMap<String,Object>() ;
		map.put("username", "hehe") ;
		map.put("password", "password") ;
		List<User> list = new ArrayList<User>() ;
		for (int i = 0; i < 3; i++) {
			list.add(new User("541013100112","hehe","UI001","password",Calendar.getInstance().getTime(),"127.0.0.1"));
		}
		map.put("list", list) ;
		
		SystemLogger.log(JSON.toJSONString(map));
	}
	/****************************	分界符	*******************************/
	@Test
	public void testJsonToJavaBean() {
		try{
			User user = new User("541013100112","hehe","UI001","password",Calendar.getInstance().getTime(),"127.0.0.1") ;
			String josnStr = JSON.toJSONString(user);
			SystemLogger.log("转化前的json串: \n",josnStr);
			User temp = JSON.parseObject(josnStr, User.class) ;
			SystemLogger.log("转化后的JavaBean: \n",temp.toString()) ;
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	@Test
	public void testJsonToList() {
		try{
			List<User> list = new ArrayList<User>() ;
			for (int i = 0; i < 3; i++) {
				list.add(new User("541013100112","hehe","UI001","password",Calendar.getInstance().getTime(),"127.0.0.1"));
			}
			String jsonStr = JSON.toJSONString(list) ;
			SystemLogger.log("转化前的json串: \n",jsonStr);
			List<User> temp = JSON.parseArray(jsonStr, User.class) ;
			SystemLogger.log("转化后的List:\n") ;
			for(User u : temp){
				SystemLogger.log(u.toString()) ;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	@Test
	public void testJsonToMap() {
		try{
			Map<String,Object> map = new HashMap<String,Object>() ;
			map.put("username", "hehe") ;
			map.put("password", "password") ;
			String jsonStr = JSON.toJSONString(map) ;
			SystemLogger.log("转化前的json串: \n",jsonStr);
			@SuppressWarnings("unchecked")
			Map<String,Object> temp = JSON.parseObject(jsonStr, Map.class) ;
			SystemLogger.log("转化后的map:\n",temp.toString(),"	==	",temp.get("username").toString()) ;
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	@Test
	public void testJsonToMapList() {
		try{
			Map<String,Object> map = new HashMap<String,Object>() ;
			map.put("username", "hehe") ;
			map.put("password", "password") ;
			List<User> list = new ArrayList<User>() ;
			for (int i = 0; i < 2; i++) {
				list.add(new User("541013100112","hehe","UI001","password",Calendar.getInstance().getTime(),"127.0.0.1"));
			}
			map.put("list", list) ;
			String jsonStr = JSON.toJSONString(map);
			SystemLogger.log("转化前的json串: \n",jsonStr);
			@SuppressWarnings("unchecked")
			Map<String,Object> temp = JSON.parseObject(jsonStr, Map.class) ;
			SystemLogger.log("转化后的map:\n",temp.toString(),"	==	",temp.get("username").toString()) ;
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	/****************************	结束符	*******************************/
	
}
