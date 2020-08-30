package leetcode;

import java.util.*;

/**
 * n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 */
public class NQueens {
    private Set<Integer> col;
    private Set<Integer> master;
    private Set<Integer> slave;
    private int n;
    private List<List<String>> res;

    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        res = new ArrayList<>();
        if (n == 0) {
            return res;
        }

        col = new HashSet<>();
        master = new HashSet<>();
        slave = new HashSet<>();

        Stack<Integer> stack = new Stack<>();
        dfs(0, stack);
        return res;
    }

    private void dfs(int row, Stack<Integer> stack) {
        if (row == n) {
            System.out.println("得到结果-----------------------");
            List<String> board = convert2board(stack, n);
            res.add(board);
            return;
        }

        // 针对每一列，尝试是否可以放置
        for (int i = 0; i < n; i++) {
            if (!col.contains(i) && !master.contains(row + i) && !slave.contains(row - i)) {
                stack.add(i);
                col.add(i);
                master.add(row + i);
                slave.add(row - i);
                System.out.println("满足的条件第" + (row + 1) + "行,第" + (i + 1) + "列");
                dfs(row + 1, stack);

                System.out.println("-------回溯第" + (row + 1) + "行,第" + (i + 1) + "列");
                slave.remove(row - i);
                master.remove(row + i);
                col.remove(i);
                stack.pop();
            } else {
                System.out.println("!!不满足的条件第:" + (row + 1) + "行,第" + (i + 1) + "列");
            }
        }
    }

    private List<String> convert2board(Stack<Integer> stack, int n) {
        List<String> board = new ArrayList<>();
        for (Integer num : stack) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < n; i++) {
                stringBuilder.append(".");
            }
            stringBuilder.replace(num, num + 1, "Q");
            board.add(stringBuilder.toString());
        }
        return board;
    }

    public static void main(String[] args) {
        List<List<String>> lists = new NQueens().solveNQueens(4);
        System.out.println(lists.toString());
    }
}
