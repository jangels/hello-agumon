package org.leecode;

/**
 * 1. 两数之和
 */
class Solution_001 {
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            int num1 = nums[i];
            for (int j = 0; j < nums.length; j++) {
                int num2 = nums[j];
                if ((num1 == num2) && (i == j)) {
                    continue;
                }
                if ((num1 + num2) == target) {
                    int[] targetArray = {i, j};
                    System.out.println(i + "," + j);
                    return targetArray;
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {

        // [2,7,11,15]
        //9

        int[] array = {2, 7, 11, 15};

        System.out.println(new Solution_001().twoSum(array, 9));
    }
}