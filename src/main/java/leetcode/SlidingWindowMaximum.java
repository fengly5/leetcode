package leetcode;

import java.util.*;

/**
 * 给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。
 * 你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 * <p>
 * 返回滑动窗口中的最大值。
 */
public class SlidingWindowMaximum {

    //优先队列（大顶堆）
    public static int[] maxSlidingWindowSecond(int[] nums, int k) {
        if (nums.length == 0) return new int[0];
        int[] res = new int[nums.length + 1 - k];
        int bar = 0;
        //排序，优先队列取最大值
        Comparator<Integer> comparator = new Comparator<Integer>() {
            public int compare(Integer integer, Integer t1) {
                return t1 - integer;
            }
        };
        PriorityQueue<Integer> win = new PriorityQueue<Integer>(k, comparator);
        for (int i = 0; i < nums.length; i++) {
            if (win.size() < k) {
                win.offer(nums[i]);
                if (win.size() == k) {//从第k个元素开始计数
                    res[bar++] = win.peek();
                }
            } else {
                win.remove(nums[i - k]);
                win.offer(nums[i]);
                res[bar++] = win.peek();
            }
        }
        return res;
    }

    //双端队列的方式
    public static int[] maxSlidingWindowThird(int[] nums, int k) {
        if (nums == null || nums.length < 2) return nums;
        Deque<Integer> queue = new LinkedList<Integer>();
        int[] res = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length; i++) {
            //队列中删除全部比它小的左边节点
            while (!queue.isEmpty() && nums[queue.peekLast()] < nums[i]) {
                queue.pollLast();
            }
            queue.addLast(i);
            //队列中删除已经溢出窗口的元素
            if (queue.peekFirst() < i - k + 1)
                queue.pop();
            //从第k个元素开始计数，加入到res中
            if (i - k + 1 >= 0)
                res[i - k + 1] = nums[queue.peekFirst()];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {7, 2, 4};
        maxSlidingWindowThird(nums, 2);
    }
}
