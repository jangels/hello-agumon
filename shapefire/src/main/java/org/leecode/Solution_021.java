package org.leecode;

/**
 * 21. 合并有序链表
 */
public class Solution_021 {

    /**
     * prev -->
     * 1  3  4
     * 1  2  4
     *
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode temp = new ListNode(0);

        ListNode prev = temp;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }

            prev = prev.next;
        }

        prev.next = l1 == null ? l2 : l1;

        return temp.next;
    }

    public static void printNode(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }

    public static void main(String[] args) {
        ListNode node8 = new ListNode(6);
        ListNode node7 = new ListNode(5, node8);
        ListNode node6 = new ListNode(4, node7);
        ListNode node5 = new ListNode(2, node6);
        ListNode node4 = new ListNode(1, node5);

        ListNode node3 = new ListNode(7);
        ListNode node2 = new ListNode(3, node3);
        ListNode node1 = new ListNode(1, node2);

        ListNode resultNode = mergeTwoLists(node4, node1);

        printNode(resultNode);
    }
}
