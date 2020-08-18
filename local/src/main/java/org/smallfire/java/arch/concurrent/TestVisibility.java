package org.smallfire.java.arch.concurrent;

/**
 * 线程的可见性
 * <p>
 * Test thread visibility.
 *
 * 线程特点:
 * 可见性
 * 原子性
 * 有序性
 *
 */
public class TestVisibility {

    /**
     * 未添加 volatile 关键字, 成员变量线程间不可见
     */
//    public static boolean flag = false;

    /**
     * 添加 volatile 关键字, 成员变量线程间可见
     */
    public static volatile boolean flag = false;

    public static void main(String[] args) throws Exception {

        Thread t1 = new Thread(() -> {
            while (!flag) {

            }
            System.out.println("状态变化");
        });

        Thread t2 = new Thread(() -> {
            flag = true;

            System.out.println(flag);
        });

        t1.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t2.start();

        t1.join();
        t2.join();
    }
}


