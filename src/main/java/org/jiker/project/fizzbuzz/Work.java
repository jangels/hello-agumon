package org.jiker.project.fizzbuzz;


import org.junit.Assert;
import org.junit.Test;

public class Work {

    public static void main(String[] args) {
        fizzBuzz();
    }


    public static void fizzBuzz() {
        for (int i = 1; i <= 100; i++) {
            if (judgePrint3(i) && judgePrint5(i)) {
                System.out.println("FizzBuzz\r");
            } else if (judgePrint3(i)) {
                System.out.println("Fizz\r");
            } else if (judgePrint5(i)) {
                System.out.println("Buzz\r");
            } else {
                System.out.println(i + "\r");
            }
        }
    }

    private static boolean judgePrint5(int i) {
        return i % 5 == 0;
    }

    private static boolean judgePrint3(int i) {
        return i % 3 == 0;
    }

    @Test
    public void test3Succ() {
        Assert.assertTrue(judgePrint3(3));
    }

    @Test
    public void test3Fail() {
        Assert.assertTrue(judgePrint3(1));
    }

    @Test
    public void test5Succ() {
        Assert.assertTrue(judgePrint5(5));
    }
    @Test
    public void test5Fail() {
        Assert.assertTrue(judgePrint5(2));
    }
}
