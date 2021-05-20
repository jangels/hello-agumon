package org.leecode;

import java.util.HashSet;
import java.util.Set;

/**
 * 141. 环形链表
 */
public class Solution_141 {

    /**
     * 使用set存储访问过的节点
     *
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {

        Set<ListNode> temp = new HashSet<>();
        while (head != null) {
            if (temp.contains(head)) {
                return true;
            }
            temp.add(head);
            head = head.next;
        }
        return false;
    }

    /**
     * 快慢指针
     *
     * @param head
     * @return
     */
    public boolean hasCycle2(ListNode head) {

       if(head == null || head.next == null){
           return false;
       }

       ListNode slow = head.next ;
       ListNode fast = head.next.next ;
       while(slow!=fast){

           if(fast ==null || fast.next == null){
               return false ;
           }
           slow = slow.next ;
           fast = fast.next.next ;

       }

       return true ;
    }

    public static void main(String[] args) {

        ListNode node4 = new ListNode(4);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);

        node4.next = node1;

        System.out.println(new Solution_141().hasCycle2(node1));
    }
}
