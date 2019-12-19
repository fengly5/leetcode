package leetcode;

import java.util.Arrays;

public class RotateArray {
    /**
     * 暴力解法，效率低
     * 时间复杂度：O(n*k)O(n∗k) 。每个元素都被移动 1 步（O(n)O(n)） k次（O(k)O(k)） 。
     * 空间复杂度：O(1)O(1) 。没有额外空间被使用。
     * @param nums
     * @param k
     */
    public static void rotate(int[] nums, int k) {
        for (int i = 0; i < k; i++) {
            int temp = 0;
            int pre = nums[nums.length - 1];
            for (int j = 0; j < nums.length; j++) {
                temp = nums[j];
                nums[j] = pre;
                pre = temp;
            }
        }
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 我们可以用一个额外的数组来将每个元素放到正确的位置上，也就是原本数组里下标为 ii 的
     * 我们把它放到 (i+k)\%数组长度(i+k)%数组长度 的位置。然后把新的数组拷贝到原数组中。
     * 时间复杂度： O(n)O(n) 。将数字放到新的数组中需要一遍遍历，另一边来把新数组的元素拷贝回原数组。
     * 空间复杂度： O(n)O(n)。另一个数组需要原数组长度的空间。
     * @param nums
     * @param k
     */
    public static void rotate1(int[] nums, int k) {
        int[] a = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            a[(i + k) % nums.length] = nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = a[i];
        }
    }

    public static void main(String[] args) {
        rotate1(new int[]{1, 2, 3, 4}, 3);
    }
}
