package org.hsy.java.base.stream;

import org.hsy.java.base.bean.User;
import org.junit.Assert;
import org.junit.Test;

import java.util.Comparator;
import java.util.stream.Stream;

public class MinStreamHelperTest {

    @Test
    public void testMinStream(){
        Assert.assertEquals(new User("1", "1").getUsername(),
                Stream.of(new User("1", "1"),
                new User("22", "22"),
                new User("333", "333"))
                .min(Comparator.comparing(user -> user.getUsername().length()))
                .get().getUsername());
    }

}