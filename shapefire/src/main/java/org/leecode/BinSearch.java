package org.leecode;

/**
 * 二分查找
 */
public class BinSearch {

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 42, 32, 11, 12};
        int result = bsearch(a, 7, 42);
        System.out.println(result);

    }

    // 二分查找的递归实现
    public static int bsearch(int[] a, int n, int val) {
        return bsearchIn(a, 0, n - 1, val);
    }

    private static int bsearchIn(int[] a, int low, int high, int val) {
        if (low > high) {
            return -1;
        }

        int mid = low + ((high - low) >> 1);

        if (a[mid] == val) {
            return mid;
        } else if (a[mid] < val) {
            return bsearchIn(a, mid + 1, high, val);
        } else {
            return bsearchIn(a, low, mid - 1, val);
        }
    }

}


