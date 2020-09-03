package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 36. 有效的数独
 * 判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。
 * <p>
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 */
public class ValidSudoku {
    /**
     * 使用set进行求解,可以换数组会更快,下标存储的是board里面的数值.
     *
     * @param board
     * @return
     */
    public static boolean isValidSudoku(char[][] board) {
        Set<Character>[] sets = new HashSet[27];//0-8放行 9-17 放列 18-27放bolck
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (sets[row] == null) {
                    sets[row] = new HashSet<>();
                }
                if (sets[col + 9] == null) {
                    sets[col + 9] = new HashSet<>();
                }
                if (sets[3 * (row / 3) + col / 3 + 18] == null) {
                    sets[3 * (row / 3) + col / 3 + 18] = new HashSet<>();
                }
                if ('.' != board[row][col]) {
                    if (sets[row].contains(board[row][col])) {
                        return false;
                    } else {
                        sets[row].add(board[row][col]);
                    }
                    if (sets[col + 9].contains(board[row][col])) {
                        return false;
                    } else {
                        sets[col + 9].add(board[row][col]);
                    }
                    if (sets[3 * (row / 3) + col / 3 + 18].contains(board[row][col])) {
                        return false;
                    } else {
                        sets[3 * (row / 3) + col / 3 + 18].add(board[row][col]);
                    }
                }
            }
        }
        return true;
    }

    public static boolean isValidSudokuBest(char[][] board) {
        int[][] rows = new int[9][10];
        int[][] cols = new int[9][10];
        int[][] blocks = new int[9][10];
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if ('.' == board[row][col]) {
                    continue;
                }
                int curnum = board[row][col] - '0';
                if (rows[row][curnum] == 1) {
                    return false;
                }
                if (cols[col][curnum] == 1) {
                    return false;
                }
                if (blocks[(col / 3 + (row / 3) * 3)][curnum] == 1) {
                    return false;
                }
                rows[row][curnum] = 1;
                cols[col][curnum] = 1;
                blocks[(col / 3 + (row / 3) * 3)][curnum] = 1;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] ch = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        System.out.println(isValidSudokuBest(ch));
    }
}
