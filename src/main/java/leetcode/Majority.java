package leetcode;

import java.util.Arrays;

/**
 * 169. 多数元素
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 * <p>
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 */
public class Majority {
    /**
     * 排序
     * 时间复杂度　Ｏ（log n）
     *
     * @param nums
     * @return
     */
    //1,2,1,3,1,4,1,8
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    /**
     * 投票法
     * 时间复杂度　Ｏ（ｎ）
     * 也可以用栈来替代，理解起来跟更容易
     *
     * @param nums
     * @return
     */
    public int majorityElementBest(int[] nums) {
        int counts = 0, res = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (res == nums[i]) {
                counts++;
            } else if (--counts <= 0) {
                res = nums[++i];
                counts++;
            }
        }
        return res;
    }


    public static void main(String[] args) {
        int[] arr = new int[]{3};
        new Majority().majorityElement(arr);
    }
}
