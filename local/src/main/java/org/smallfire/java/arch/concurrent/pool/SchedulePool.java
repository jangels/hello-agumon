package org.smallfire.java.arch.concurrent.pool;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 * @author lzh
 */
public class SchedulePool {

    /**
     使用场景:

     场景1:

     分布式锁自动续期

     场景2:

     注册中心心跳检测



     source:
     数据结构: heap


     */

    public static void main(String[] args) throws ExecutionException, InterruptedException {


        // 创建一个定时线程池
        ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(5);

        System.out.println("start: " + System.currentTimeMillis());

        // 执行一个无返回值任务，5秒后执行，只执行一次
        executor.schedule(() -> {
            System.out.println("spring: " + System.currentTimeMillis());
        }, 5, TimeUnit.SECONDS);

        // 执行一个有返回值任务，5秒后执行，只执行一次
        ScheduledFuture<String> future = executor.schedule(() -> {
            System.out.println("inner summer: " + System.currentTimeMillis());
            return "outer summer: ";
        }, 5, TimeUnit.SECONDS);
        // 获取返回值
        System.out.println(future.get() + System.currentTimeMillis());

        // 按固定频率执行一个任务，每2秒执行一次，1秒后执行
        // 任务开始时的2秒后
        executor.scheduleAtFixedRate(() -> {
            System.out.println("autumn: " + System.currentTimeMillis());
            LockSupport.parkNanos(TimeUnit.SECONDS.toNanos(1));
        }, 1, 2, TimeUnit.SECONDS);

        // 按固定延时执行一个任务，每延时2秒执行一次，1秒执行
        // 任务结束时的2秒后，本文由公从号“彤哥读源码”原创
        executor.scheduleWithFixedDelay(() -> {
            System.out.println("winter: " + System.currentTimeMillis());
            LockSupport.parkNanos(TimeUnit.SECONDS.toNanos(1));
        }, 1, 2, TimeUnit.SECONDS);
    }


}
