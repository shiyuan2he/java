package org.hsy.java.base.stream;

import org.junit.Assert;
import org.junit.Test;

import java.util.function.BinaryOperator;

public class BinaryOperatorHelperTest {

    @Test
    public void testBinaryOperator(){
        BinaryOperator<Integer> sum = (a, b) -> a + b;
        int total = sum.apply(sum.apply(sum.apply(1, 2), 3),4);
        Assert.assertEquals(total, 10);
    }
}