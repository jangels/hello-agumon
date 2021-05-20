package org.leecode;

public class Main {
    public static void main(String[] args) {
        System.out.println(exist(5));
    }


// 一个正整数c, 判断是否存在另外两个正整数a,b, 满足 a*a + b*b = c

    // 时间复杂度 <= O(N)
    public static boolean exist(int c) {
        for (int a = 1; a * a <= c; a++) {
            double b = Math.sqrt(c - a * a);
            if ((b == (int) b) && b > 0) {
                return true;
            }
        }
        return false;
    }


}

