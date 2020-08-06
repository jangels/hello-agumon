package org.smallfire.java.base;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class TestHash {


    @Test
    public void testHashMap() {
        Map map = new HashMap();

        IntStream.rangeClosed(1, 20).forEach(e -> {
            System.out.println(e);
        });

        IntStream.rangeClosed(1, 20).forEach(i -> {
            map.put(i, i + "-value");
        });

        System.out.println(map);

    }
}
