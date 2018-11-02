package com.hsy.java.base.stream;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FlatMapStreamHelperTest {

    @Test
    public void testFlatMap(){
        Assert.assertEquals(Arrays.asList(1,2,3,4), Stream.of(Arrays.asList(1, 2), Arrays.asList(3, 4))
                .flatMap(num -> num.stream())
                .collect(Collectors.toList()));
    }
}