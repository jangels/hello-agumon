package org.smallfire.java.guava;

import java.util.function.Consumer;

public class TestMain {

    public static void main(String[] args) {
//        for (int i = 0; i < 200; i++) {
//            System.out.println(i+" 的ascii为：" + (char) i);
//        }
        Runnable r = ()-> System.out.println("hello lambda!");
        r.run();

        Consumer<String> consumer = x-> System.out.println(x);
        consumer.accept("he!");
    }
}
