package leetcode;

import domain.TreeNode;
import domain.TreeNodeGlobalInitialize;

/**
 * 有相等的节点不是二叉搜索树
 * 判断一个树是否为二叉搜索树
 */
public class ValidateBinarySearchTree {

    static long lastVal = Long.MIN_VALUE;

    /**
     * 中序
     * 只需要比较一次
     *
     * @param root
     * @return
     */
    public static boolean isValidBST1(TreeNode root) {
        if (root == null)
            return true;
        if (!isValidBST1(root.left))
            return false;
        if (root.val <= lastVal)
            return false;
        lastVal = (long) root.val;
        if (!isValidBST1(root.right))
            return false;
        return true;
    }

    /**
     * 前序
     * 需要有两个条件
     *
     * @param root
     * @return
     */
    public static boolean isValidBST(TreeNode root) {
        return dfs(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private static boolean dfs(TreeNode root, long min, long max) {
        if (root == null) {
            return true;
        }
        if (root.val < min) {
            return false;
        }
        if (root.val > max) {
            return false;
        }
        if (!dfs(root.left, min, root.val)) {
            return false;
        }
        if (!dfs(root.right, root.val, max)) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        isValisBSTMTest();
    }

    public static void isValisBSTMTest() {
        System.out.println("false:" + isValidBST(TreeNodeGlobalInitialize.initMoreNotOrderNode()));
    }

    public static void isValidBSTTest() {
        System.out.println("true:" + isValidBST(TreeNodeGlobalInitialize.initNullNode()));
        lastVal = Long.MIN_VALUE;
        System.out.println("true:" + isValidBST(TreeNodeGlobalInitialize.initRootNode()));
        lastVal = Long.MIN_VALUE;
        System.out.println("true:" + isValidBST(TreeNodeGlobalInitialize.initOneLeftOrderNode()));
        lastVal = Long.MIN_VALUE;
        System.out.println("false:" + isValidBST(TreeNodeGlobalInitialize.initOneLeftNotOrderNode()));
        lastVal = Long.MIN_VALUE;
        System.out.println("true:" + isValidBST(TreeNodeGlobalInitialize.initOneRightOrderNode()));
        lastVal = Long.MIN_VALUE;
        System.out.println("false:" + isValidBST(TreeNodeGlobalInitialize.initOneRightNotOrderNode()));
        lastVal = Long.MIN_VALUE;
        System.out.println("true:" + isValidBST(TreeNodeGlobalInitialize.initTwoOrderNode()));
        lastVal = Long.MIN_VALUE;
        System.out.println("false:" + isValidBST(TreeNodeGlobalInitialize.initTwoNotOrderNode()));
        lastVal = Long.MIN_VALUE;
        System.out.println("true:" + isValidBST(TreeNodeGlobalInitialize.initMoreOrderNode()));
    }
}
