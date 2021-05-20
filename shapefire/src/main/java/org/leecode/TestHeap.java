package org.leecode;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class TestHeap {
    public static void main(String[] args) {

        int[] array = {1, 23, 2323, 112, 1312, 13};
        System.out.println(solutionByHeap(array, 3));
        System.out.println(getLeastNumbers(array,3));

    }

    /**
     * https://juejin.cn/post/6844903774004183047
     *
     * @param input
     * @param k
     * @return
     */

    public static List<Integer> solutionByHeap(int[] input, int k) {
        List<Integer> list = new ArrayList<>();
        if (k > input.length || k == 0) {
            return list;
        }
        Queue<Integer> queue = new PriorityQueue<>();
        for (int num : input) {
            if (queue.size() < k) {
                queue.add(num);
            } else if (queue.peek() < num) {
                queue.poll();
                queue.add(num);
            }
        }
        while (k-- > 0) {
            list.add(queue.poll());
        }
        return list;
    }


    /**
     * 作者：nettee
     * 链接：https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof/solution/tu-jie-top-k-wen-ti-de-liang-chong-jie-fa-you-lie-/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @param arr
     * @param k
     * @return
     */
    public static List<Integer> getLeastNumbers(int[] arr, int k) {
        if (k == 0) {
            return null;
        }
        // 使用一个最大堆（大顶堆）
        // Java 的 PriorityQueue 默认是小顶堆，添加 comparator 参数使其变成最大堆
        Queue<Integer> heap = new PriorityQueue<>(k, (i1, i2) -> Integer.compare(i2, i1));

        for (int e : arr) {
            // 当前数字小于堆顶元素才会入堆
            if (heap.isEmpty() || heap.size() < k || e < heap.peek()) {
                heap.offer(e);
            }
            if (heap.size() > k) {
                heap.poll(); // 删除堆顶最大元素
            }
        }

        // 将堆中的元素存入数组
        List<Integer> result = new ArrayList<>();
        for (int e : heap) {
            result.add(e);
        }
        return result;
    }


}
