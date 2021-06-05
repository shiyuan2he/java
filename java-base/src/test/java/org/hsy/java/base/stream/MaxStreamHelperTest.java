package org.hsy.java.base.stream;

import org.hsy.java.base.bean.User;
import org.junit.Assert;
import org.junit.Test;

import java.util.Comparator;
import java.util.stream.Stream;

public class MaxStreamHelperTest {

    @Test
    public void testMaxStream(){
        Assert.assertEquals(new User("333", "333").getUsername(),
                Stream.of(new User("1", "1"),
                        new User("22", "22"),
                        new User("333", "333"))
                        .max(Comparator.comparing(user -> user.getUsername().length()))
                        .get().getUsername());
    }
}