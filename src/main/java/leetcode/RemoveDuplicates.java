package leetcode;

public class RemoveDuplicates {

    public static int removeDuplicates(int[] nums) {
        int i = 0;
        for (int n : nums)
            if (i == 0 || n > nums[i - 1])
                nums[i++] = n;
        return i;
    }

    public static int removeDuplicates1(int[] A) {
        if (A.length == 0) return 0;
        int j = 0;
        for (int i = 0; i < A.length; i++)
            if (A[i] != A[j]) A[++j] = A[i];
        return ++j;
    }

    public static int removeDuplicates2(int[] A) {
        int count = 0;
        int n = A.length;
        for (int i = 1; i < n; i++) {
            if (A[i] == A[i - 1]) count++;
            else A[i - count] = A[i];
        }
        return n - count;
    }

    public static int removeDuplicates3(int[] nums) {
        if (nums.length == 0) return 0;
        int p = 0;
        int q = 1;
        while (q < nums.length) {
            if (nums[p] != nums[q]) {
                if (q - p > 1) {
                    nums[p + 1] = nums[q];
                }
                p++;
            }
            q++;
        }
        return p + 1;
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[]{1, 1, 1, 1, 2, 2, 2, 3, 4, 4, 5, 6, 7}));
        System.out.println(removeDuplicates1(new int[]{1, 1, 1, 1, 2, 2, 2, 3, 4, 4, 5, 6, 7}));
        System.out.println(removeDuplicates2(new int[]{1, 1, 1, 1, 2, 2, 2, 3, 4, 4, 5, 6, 7}));
        System.out.println(removeDuplicates3(new int[]{1, 1, 1, 1, 2, 2, 2, 3, 4, 4, 5, 6, 7}));
    }
}
