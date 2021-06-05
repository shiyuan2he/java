package org.hsy.java.base.bean;

import org.hsy.java.base.bean.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author heshiyuan
 * @description <p></p>
 * @path java/org.hsy.java.base.bean
 * @date 2018-12-14 19:35
 * Copyright (c) 2018 heshiyuan@huobi.com All rights reserved.
 */
public class UserTest {
    List<User> userList = new ArrayList<>();
    @Before
    public void setup(){
        userList.add(new User("张一", null, null, 111));
        userList.add(new User("张2", null, null, 33));
        userList.add(new User("张3", null, null, 9));
        userList.add(new User("张4", null, null, 2));
    }
    @Test
    public void testCompareTo() {
        Collections.sort(userList);
        Assert.assertFalse(userList.get(0).getAge() < userList.get(1).getAge());
    }
}