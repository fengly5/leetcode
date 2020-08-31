package leetcode;

import domain.TreeNode;

public class BalacedBinaryTree {
    static boolean isBa = true;

    public static boolean isBalanced(TreeNode root) {
        int max = maxDept(root);
        return isBa;
    }

    public static int maxDept(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftMax = maxDept(root.left);
        int rightMax = maxDept(root.right);
        if (-1 > (leftMax - rightMax) || 1 < (leftMax - rightMax)) {
            isBa = false;
        }
        return 1 + Math.max(leftMax, rightMax);
    }

    public static void main(String[] args) {
        test4();
    }

    public static void test1() {
        TreeNode root = new TreeNode(3);
        TreeNode node1 = new TreeNode(9);
        TreeNode node2 = new TreeNode(20);
        TreeNode node3 = new TreeNode(15);
        TreeNode node4 = new TreeNode(7);
        root.left = node1;
        root.right = node2;
        node2.left = node3;
        node2.right = node4;
        System.out.println(isBalanced(root));
    }

    public static void test2() {
        TreeNode root = new TreeNode(3);
        System.out.println(isBalanced(root));
    }

    public static void test3() {
        System.out.println(isBalanced(null));
    }

    public static void test4() {
        TreeNode root = new TreeNode(3);
        TreeNode node2 = new TreeNode(20);
        TreeNode node3 = new TreeNode(15);
        TreeNode node4 = new TreeNode(7);
        root.right = node2;
        node2.left = node3;
        node2.right = node4;
        System.out.println(isBalanced(root));
    }

    //[1,2,2,3,null,null,3,4,null,null,4]
    public static void test5() {
        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(2);
        TreeNode node41 = new TreeNode(3);
        TreeNode node4 = new TreeNode(3);
        TreeNode node5 = new TreeNode(4);
        TreeNode node6 = new TreeNode(4);
        root.right = node2;
        root.left = node3;
        node2.left = node4;
        node3.right = node41;
        node4.left = node5;
        node41.right = node6;
        System.out.println(isBalanced(root));
    }


}
