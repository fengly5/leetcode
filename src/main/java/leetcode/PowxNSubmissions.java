package leetcode;

/**
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数。
 * -100.0 < x < 100.0
 * n 是 32 位有符号整数，其数值范围是 [−231, 231 − 1] 。
 */
public class PowxNSubmissions {
    /**
     * 循环解法
     *
     * @param x
     * @param n
     * @return
     */
    public static double powN(double x, int n) {
        boolean positiveNumber = true;
        if (n < 0) {
            positiveNumber = false;
            n = -n;
        }
        double sum = 1.0;
        for (int i = n; i > 0; i--) {
            sum *= x;
        }
        if (positiveNumber) {
            return sum;
        } else {
            return 1 / sum;
        }
    }


    /**
     * 分治思想
     *
     * @param x
     * @param n
     * @return
     */
    public static double powxSecond(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            return 1 / powxSecond(x, -n);
        }
        if (n % 2 == 0) {
            return powxSecond(x * x, n / 2);
        }
        return x * powxSecond(x, n - 1);
    }

    /**
     * 非递归的求解
     *
     * @param x
     * @param n
     * @return
     */
    public static double powxBest(double x, int n) {
        if (n == 0) {
            return 1;
        }
        long lo = n;
        double res = 1.0;
        if (lo < 0) {
            x = 1 / x;
            lo = -lo;
        }
        while (lo > 0) {
            if (lo % 2 == 1) {
                res *= x;
                lo--;
            }
            x *= x;
            lo /= 2;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(powxBest(2, 6));
    }
}
