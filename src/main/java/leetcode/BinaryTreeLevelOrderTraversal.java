package leetcode;

import domain.TreeNode;

import java.util.*;

/**
 * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
 */
public class BinaryTreeLevelOrderTraversal {

    /**
     * 广度优先，如果是树的话可以不加visited
     *
     * @param root
     * @return
     */
    public static List<List<Integer>> bfs(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if (root == null) {
            return null;
        }

        Set<TreeNode> visited = new HashSet<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> curLevel = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                curLevel.add(poll.val);
                visited.add(poll);

                if (visited.contains(poll)) {
                    continue;
                }
                if (poll.left != null) {
                    queue.offer(poll.left);
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                }
            }
            res.add(curLevel);
        }
        return res;
    }

    static List<List<Integer>> res = new LinkedList<>();

    /**
     * 深度优先搜索
     *
     * @param root
     * @return
     */
    public static List<List<Integer>> dfs(TreeNode root) {
        if (root == null) {
            return res;
        }
        _dfs(root, 0);
        return res;
    }

    public static void _dfs(TreeNode root, int level) {
        List<Integer> curLevel = new LinkedList<>();
        if (res.size() > level) {
            curLevel = res.get(level);
        }
        curLevel.add(root.val);

        if (root.left != null) {
            _dfs(root.left, level++);
        }
        if (root.right != null) {
            _dfs(root.right, level++);
        }
    }
}
