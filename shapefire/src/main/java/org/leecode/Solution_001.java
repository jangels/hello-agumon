package org.leecode;

import java.util.HashMap;
import java.util.Map;

/**
 * 1. 两数之和
 */
class Solution_001 {
    // O(n^2)
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                if ((nums[i] + nums[j]) == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[0];
    }

    // O(1)
    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int sub = target - nums[i];
            if (!map.containsKey(sub)) {
                map.put(nums[i], i);
            } else {
                return new int[]{map.get(sub), i};
            }
        }

        return new int[0];
    }

    public static void main(String[] args) {

        // [2,7,11,15] , 9
        int[] array = {2, 7, 11, 15};

        int[] result = new Solution_001().twoSum2(array, 9);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]);
        }
    }
}