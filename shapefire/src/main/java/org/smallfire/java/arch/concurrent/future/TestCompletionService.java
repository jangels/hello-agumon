package org.smallfire.java.arch.concurrent.future;

import java.util.concurrent.*;

public class TestCompletionService {

    public static void main(String[] args) throws Exception {

        // 创建线程池
        ExecutorService executor =
                Executors.newFixedThreadPool(3);

        // 创建CompletionService
        CompletionService<Integer> cs = new
                ExecutorCompletionService<>(executor);

        // 异步向电商S1询价
        cs.submit(() -> {
            System.out.println("查询S1价格");
            return 1212;
        });

        cs.submit(() -> {
            System.out.println("查询S2价格");
            return 12;
        });

        cs.submit(() -> {
            System.out.println("查询S3价格");
            return 1213;
        });

        for (int i = 0; i < 3; i++) {
            Integer r = cs.take().get();
            executor.execute(() -> {
                System.out.println("队列中获取异步执行结果-> " + r);
            });
        }
    }
}
