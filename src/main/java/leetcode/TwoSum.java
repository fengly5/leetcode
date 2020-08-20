package leetcode;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {

    /**
     * 两遍hash
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] towSum(int[] nums, int target) {
        int[] res = new int[2];
        HashMap<Integer, Integer> subscriptMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            subscriptMap.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int other = target - nums[i];
            if (subscriptMap.containsKey(other) && !subscriptMap.get(other).equals(i)) {
                res[0] = i;
                res[1] = subscriptMap.get(other);
                return res;
            }
        }
        return res;
    }

    /**
     * 一遍hash
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] towSumSecond(int[] nums, int target) {
        HashMap<Integer, Integer> numsMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            int other = target - nums[i];
            if (numsMap.containsKey(other)) {
                return new int[]{i, numsMap.get(other)};
            }
            numsMap.put(nums[i], i);
        }
        return new int[0];
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int[] ints = towSumSecond(nums, 17);
        System.out.println(Arrays.toString(ints));
    }
}
