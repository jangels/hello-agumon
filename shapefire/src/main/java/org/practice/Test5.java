package org.practice;

public class Test5 {

    static void some(int x){
        System.out.println("a");
    }
    static void some(double x){
        System.out.println("b");
    }

    static void some(Object x){
        System.out.println("c");
    }

    public static void main(String[] args) {
        some("3.14");
        some(100);
    }

}
