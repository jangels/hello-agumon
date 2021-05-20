package org.leecode;

/**
 * 206. 链表反转
 */
public class Solution_206 {
    /**
     * 迭代
     *
     * @param head
     * @return
     */
    public static ListNode reverseList(ListNode head) {

        // null?
        // max? min?
        // 特殊?
        // 时间 , 空间?
        // 线程?

       // 1> 2> 3
        ListNode prev = null ;
        ListNode next ;
        ListNode curr = head ;

        while(curr != null){
            next = curr.next ;
            curr.next = prev ;
            prev = curr ;
            curr = next ;
        }

        return prev ;
    }


    public static void printNode(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }

    public static void main(String[] args) {
        ListNode node5 = new ListNode(5);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);
        printNode(node1);
        System.out.println("\n-------------------");
        ListNode prev = reverseList(node1);
        printNode(prev);
    }
}
