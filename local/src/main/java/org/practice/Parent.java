package org.practice;


public class Parent {

    int v = 100;

    public int m() {
        return v;
    }

    public static void main(String[] args) {


        // 4/8
        int a = 5531, m = 0;
        while (a > 0) {
            m += a % 10;
            a = a / 10;
        }
        System.out.println("m=" + m);


        // 3/8
        int x = 2345;

        System.out.println(x % 2);
        System.out.println(x / 10);
        System.out.println(++x);

        // 2/8
        Parent p = new Child();
        System.out.println(p.v);
        System.out.println(p.m());
    }

}


class Child extends Parent {
    int v = 200;

    @Override
    public int m() {
        return v;
    }
}