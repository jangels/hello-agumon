package org.smallfire.java.arch.concurrent.pool;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class TestPool {


    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(10, 10, 10,
                TimeUnit.MINUTES, new LinkedBlockingQueue(10));

        IntStream.rangeClosed(1,4).forEach(i -> {
            executor.execute(new Task(IntStream.rangeClosed(1, 50).toArray()));

            System.out.println("一次循环");
        });
    }

}


class Task implements Runnable {
    int[] intArray;

    public Task(int[] intArray) {
        this.intArray = intArray;
    }

    @Override
    public void run() {

        IntStream.of(intArray).forEach(i -> {
            System.out.println("线程-" + Thread.currentThread().getName() + " , 值:" + i);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

    }
}
