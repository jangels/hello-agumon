package org.leecode;

/**
 * 2. 两数相加
 */
public class Solution_002 {


    public static void main(String[] args) {
        /**
         * [2,4,3]
         * [5,6,4]
         */
        ListNode l1_end = new ListNode(3);
        ListNode l1_middle = new ListNode(4,l1_end);
        ListNode l1_first = new ListNode(2,l1_middle);


        ListNode l2_end = new ListNode(4);
        ListNode l2_middle = new ListNode(6,l1_end);
        ListNode l2_first = new ListNode(5,l1_middle);


        new Solution().addTwoNumbers(l1_first,l2_first);
    }
}


class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return null;
    }
}


class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

