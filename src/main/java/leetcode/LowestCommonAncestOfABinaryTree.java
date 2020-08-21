package leetcode;

import domain.TreeNode;
import domain.TreeNodeGlobalInitialize;

/**
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * <p>
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 * <p>
 * 例如，给定如下二叉树:  root = [3,5,1,6,2,0,8,null,null,7,4]
 */
public class LowestCommonAncestOfABinaryTree {
    /**
     * 递归求解
     * 思想：如果q，p在某一个节点的左子树和右子树上出现的话，那么这个节点就是交点
     * 结束的条件
     * 递归的过程
     * 返回的结果
     *
     * @param root
     * @param q
     * @param p
     * @return
     */
    public static TreeNode lowestCommonAncest(TreeNode root, TreeNode q, TreeNode p) {
        if (root == null || root == q || root == p) {
            return root;
        }
        TreeNode left = lowestCommonAncest(root.left, q, p);
        TreeNode right = lowestCommonAncest(root.right, q, p);
        return left == null ? right : right == null ? left : root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(20);
        TreeNode left1 = new TreeNode(18);
        TreeNode left2 = new TreeNode(25);
        TreeNode left3 = new TreeNode(21);
        TreeNode right = new TreeNode(30);
        TreeNode right2 = new TreeNode(34);
        root.left = left1;
        left1.left = left2;
        left1.right = left3;
        root.right = right;
        right.right = right2;
        TreeNode treeNode = lowestCommonAncest(root, left2, left3);
        System.out.println(treeNode.val);
    }

}
