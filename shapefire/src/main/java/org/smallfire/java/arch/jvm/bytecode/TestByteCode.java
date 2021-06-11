package org.smallfire.java.arch.jvm.bytecode;

public class TestByteCode {

    private int[] intArray = new int[1000000];

    public static void main(String[] args) throws InterruptedException {

        for (int i = 0; i < 100000000; i++) {
            new TestByteCode();
            Thread.sleep(1);
        }
    }
}
