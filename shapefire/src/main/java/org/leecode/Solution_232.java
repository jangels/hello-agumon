package org.leecode;

import java.util.Stack;

/**
 * 232 使用栈实现队列
 */
public class Solution_232 {

    Stack<Integer> inStack;
    Stack<Integer> outStack;

    /**
     * Initialize your data structure here.
     */
    public Solution_232() {
        inStack = new Stack<>();
        outStack = new Stack<>();
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        inStack.push(x);
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        if (outStack.isEmpty()) {
            inToOutStack();
        }
        return outStack.pop();
    }

    // instack --> outstack , 负负得正
    private void inToOutStack() {
        while (!inStack.isEmpty()) {
            outStack.push(inStack.pop());
        }
    }


    /**
     * Get the front element.
     */
    public int peek() {
        if (outStack.isEmpty()) {
            inToOutStack();
        }
        return outStack.peek();
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return inStack.isEmpty() && outStack.isEmpty();
    }

    public static void main(String[] args) {
        Solution_232 obj = new Solution_232();
        obj.push(1);
        obj.push(2);
        int param_2 = obj.pop();
        int param_3 = obj.peek();
        boolean param_4 = obj.empty();
        System.out.println(param_2);
        System.out.println(param_3);
        System.out.println(param_4);
    }
}
