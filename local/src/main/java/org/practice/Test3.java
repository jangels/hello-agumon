package org.practice;

public class Test3 {
    int k = 11;

    public void some() {
        System.out.println("k1=" + k);
    }
}

class Demo extends Test3 {
    int k = 20;

    public static void main(String[] args) {
        Demo obj = new Demo();
        obj.some();
        System.out.println("k2=" + obj.k);
    }
}
