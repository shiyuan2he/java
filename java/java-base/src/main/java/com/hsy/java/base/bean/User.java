package com.hsy.java.base.bean;
/**
 * @description <p>类文件描述</p>
 * @author heshiyuan @date 2017年3月11日 下午3:11:47
 * @path: javase-common/com.javase.bean/User.java
 * @price ￥：5元
 * @copyright 如有复制粘贴请通知本人或者捐赠，微信号：hewei1109
 * @email heshiyuan@chtwm.com
 * @callnumber 15910868535
 */
public class User {
	private String username ;
	private String password ;
	private String testNamePassword ;

	public User() {}
	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the testNamePassword
	 */
	public String getTestNamePassword() {
		return testNamePassword;
	}
	/**
	 * @param testNamePassword the testNamePassword to set
	 */
	public void setTestNamePassword(String testNamePassword) {
		this.testNamePassword = testNamePassword;
	}
}

