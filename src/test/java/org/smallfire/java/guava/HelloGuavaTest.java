package org.smallfire.java.guava;

import com.google.common.base.Charsets;
import com.google.common.base.Joiner;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Maps;
import com.google.common.io.Files;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * 谷歌工具类
 * Created by lzh on 2018/12/28.
 */
public class HelloGuavaTest {


    @Test
    public void testCollections() {
        System.out.println("before ...");
        Map<String, Map<Long, List<String>>> map = new HashMap<String, Map<Long, List<String>>>();
        System.out.println(map);

        System.out.println("with guava...");
        Map<String, Map<Long, List<String>>> map1 = Maps.newHashMap();
        System.out.println(map1);
    }

    @Test
    public void testListAndSet() {
        System.out.println("before ...");
        List<String> list = new ArrayList<String>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");

        System.out.println("with guava...");

        ImmutableList<String> of = ImmutableList.of("a", "b", "c", "d");

        assertEquals(list, of);
    }

    @Test
    public void testFile() {
        File file = new File(getClass().getResource("/test.txt").getFile());
        List<String> lines = null;
        try {
            lines = Files.readLines(file, Charsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(lines);
    }

    @Test
    public void testJoiner() {
        String str = Joiner.on(',').join(1, 2, 3);
        System.out.println(str);
    }

}