package leetcode;

import java.util.*;

/**
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组。
 * 示例：
 * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * 满足要求的三元组集合为：
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 */
public class ThreeSum {

    /**
     * 空间复杂度为O（1）
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSumSecond(int[] nums) {
        if (nums != null && nums.length < 3) {
            return Collections.emptyList();
        }
        Arrays.sort(nums);
        List<List<Integer>> res = new LinkedList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
                int a = -nums[i], pre = i + 1, last = nums.length - 1;
                while (last > pre) {
                    if (a == nums[pre] + nums[last]) {
                        while (pre < last && nums[pre] == nums[pre + 1]) pre++;
                        while (pre < last && nums[last] == nums[last - 1]) last--;
                        res.add(Arrays.asList(nums[i], nums[pre], nums[last]));
                        pre++;
                        last--;
                    } else if (a > nums[pre] + nums[last]) {
                        pre++;
                    } else {
                        last--;
                    }
                }
            }
        }
        return res;
    }

    /**
     * set的方式
     *
     * @param nums
     * @return
     */
    private static List<List<Integer>> hashSolution(int[] nums) {
        if (nums != null && nums.length < 3) {
            return Collections.emptyList();
        }
        Set<List<Integer>> result = new HashSet<>();
        for (int i = 0; i < nums.length - 2; i++) {
            int target = -nums[i];
            Set<Integer> set = new HashSet<>();
            for (int j = i + 1; j < nums.length; j++) {
                int v = target - nums[j];
                boolean isExist = set.contains(v);
                if (isExist) {
                    List<Integer> asList = Arrays.asList(nums[i], nums[j], v);
                    asList.sort(Comparator.naturalOrder());
                    result.add(asList);
                } else {
                    set.add(nums[j]);
                }
            }
        }
        return new ArrayList<>(result);
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> lists = hashSolution(nums);
        System.out.println(lists.toString());
    }
}
