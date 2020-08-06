package org.smallfire.java.base;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class TestArraylistThread {

    public static List list = new ArrayList();

    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            list.forEach(i -> {
                System.out.println(i);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });

            System.out.println("done");
        });

        Thread t1 = new Thread(() -> {
            System.out.println("lalal");
        });


        IntStream.rangeClosed(1,10).forEach(i->{
            IntStream.rangeClosed(1, 100).forEach(item -> {
                list.add(item);
            });

            ExecutorService executorService = Executors.newFixedThreadPool(10);
            executorService.execute(t);
        });



    }
}
