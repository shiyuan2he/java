package org.hsy.java.base.stream;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FilterStreamHelperTest {
    @Test
    public void testFilter(){
        List<String> filterList = Stream.of("a", "1abc", "abc").filter(ele -> Character.isDigit(ele.charAt(0)))
                .collect(Collectors.toList());
        Assert.assertEquals(Arrays.asList("1abc"), filterList);
    }
}