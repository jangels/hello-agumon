package org.leecode;

/**
 * 136. 只出现一次的数字
 */
public class Solution_136 {
    /**
     * 使用异或
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        int single=0;
        for (int i : nums) {
            single ^= i;
        }

        return single;
    }

    public static void main(String[] args) {

        int[] nums ={2,2,1};
        System.out.println(new Solution_136().singleNumber(nums));
    }
}
