package org.hsy.java.base.stream;

import org.junit.Assert;
import org.junit.Test;

import java.util.Optional;
import java.util.stream.Stream;

public class ReduceStreamHelper {

    @Test
    public void testReduceStream(){
        Assert.assertEquals(Optional.of(6), Stream.of(1,2,3).reduce((a, b) -> sum(a, b)));
    }

    @Test
    public void testReduceStream2(){
        Assert.assertEquals(new Integer(10), Stream.of(2,3,4).reduce(1, (a, b) -> a+b));
    }

    public int sum(int a, int b){
        return a+b;
    }
}
