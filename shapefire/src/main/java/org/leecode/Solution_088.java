package org.leecode;

/**
 * 88. 合并有序数组
 */
public class Solution_088 {

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = 0, p2 = 0;
        int curr;

        int[] sorted = new int[m + n];
        while (p1 < m || p2 < n) {
            if (p1 == m) {
                curr = nums2[p2++];
            } else if (p2 == n) {
                curr = nums1[p1++];
            } else if (nums1[p1] < nums2[p2]) {
                curr = nums1[p1++];
            } else {
                curr = nums2[p2++];
            }

            sorted[p1 + p2 - 1] = curr;
        }

        for (int i = 0; i < (m + n); i++) {
            nums1[i] = sorted[i];
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {0, 1, 3, 0, 0, 0};
        int[] nums2 = {1, 2, 4};
        merge(nums1, 3, nums2, 3);
        for (int i = 0; i < 6; i++) {
            System.out.print(nums1[i]);
        }
    }
}
