package leetcode;

import java.util.PriorityQueue;

/**
 * 设计一个找到数据流中第K大元素的类（class）。注意是排序后的第K大元素，不是第K个不同的元素。
 *
 * 你的 KthLargest 类需要一个同时接收整数 k 和整数数组nums 的构造器，它包含数据流中的初始元素。
 * 每次调用 KthLargest.add，返回当前数据流中第K大的元素。
 *
 */
public class KthLargest {

    final PriorityQueue<Integer> priorityQueue;
    final int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        priorityQueue = new PriorityQueue(k);
        for (Integer num : nums) {
            if (priorityQueue.size() < k) {
                priorityQueue.add(num);
            } else if (priorityQueue.peek() < num) {
                priorityQueue.poll();
                priorityQueue.add(num);
            }
        }
    }

    public int add(int val) {
        if (priorityQueue.size() < k) {
            priorityQueue.add(val);
        } else if (priorityQueue.peek() < val) {
            priorityQueue.poll();
            priorityQueue.add(val);
        }
        return priorityQueue.peek();
    }


    public static void main(String[] args) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>(1);
        priorityQueue.add(12);
        System.out.println(priorityQueue.size());
        priorityQueue.add(34);
        System.out.println(priorityQueue.size());
    }
}
