package org.hsy.java.base.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description <p>类文件描述</p>
 * @author heshiyuan @date 2017年3月11日 下午3:11:47
 * @path: javase-common/com.javase.bean/User.java
 * @price ￥：5元
 * @copyright 如有复制粘贴请通知本人或者捐赠，微信号：hewei1109
 * @email heshiyuan@chtwm.com
 * @callnumber 15910868535
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements Comparable<User>{
	private String username ;
	private String password ;
	private String testNamePassword ;
	private Integer age;

	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

	@Override
	public int compareTo(User o) {
		return o.getAge().compareTo(this.age);
	}
}

