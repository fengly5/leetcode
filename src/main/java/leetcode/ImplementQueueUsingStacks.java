package leetcode;

import java.util.Stack;

public class ImplementQueueUsingStacks {

    Stack<Integer> inStack = new Stack<Integer>();
    Stack<Integer> outStack = new Stack<Integer>();

    /**
     * Initialize your data structure here.
     */
    public ImplementQueueUsingStacks() {

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
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }
        return outStack.pop();
    }

    /**
     * Get the front element.
     */
    public int peek() {
        if (outStack.isEmpty()) {
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }
        return outStack.peek();
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return outStack.isEmpty() && inStack.isEmpty();
    }

    public static void main(String[] args) {
        ImplementQueueUsingStacks obj = new ImplementQueueUsingStacks();
        obj.push(1);
        obj.push(2);
        int peek = obj.peek();// 返回 1
        int pop1 = obj.pop();   // 返回 1
        int pop2 = obj.pop();   // 返回 2
        boolean isEn = obj.empty();
        boolean param_4 = obj.empty();
    }
}
