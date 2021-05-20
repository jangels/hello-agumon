package org.leecode;

/**
 * 70. 爬楼梯
 */
public class Solution_70 {

    /**
     * 滚动数组
     *
     * @param n
     * @return
     */
    public int climbStairs(int n) {

        //
        int p = 0, q = 0, r = 1;
        for (int i = 1; i <= n; i++) {
            p = q;
            q = r;
            r = p + q;
        }
        return r;
    }

    public static void main(String[] args) {
        System.out.println(new Solution_70().climbStairs(5));
    }
}
