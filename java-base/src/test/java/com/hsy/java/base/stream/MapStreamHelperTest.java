package com.hsy.java.base.stream;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
@Slf4j
public class MapStreamHelperTest {

    @Test
    public void testMapExercise(){
        List<String> collected = Stream.of("a", "b", "hello", "world")
                .map(str -> str.toUpperCase())
                .collect(Collectors.toList());
        log.debug(Arrays.toString(collected.toArray()));
        Assert.assertEquals(Arrays.asList("A", "B", "HELLO", "WORLD"), collected);
    }
}