package domain;

public class TreeNodeGlobalInitialize {
    public static TreeNode initNullNode() {
        return null;
    }

    public static TreeNode initRootNode() {
        return new TreeNode(4);
    }

    public static TreeNode initOneLeftOrderNode() {
        TreeNode treeNode = new TreeNode(4);
        TreeNode left = new TreeNode(4);
        treeNode.left = left;
        return treeNode;
    }

    public static TreeNode initOneLeftNotOrderNode() {
        TreeNode treeNode = new TreeNode(4);
        TreeNode left = new TreeNode(5);
        treeNode.left = left;
        return treeNode;
    }

    public static TreeNode initOneRightNotOrderNode() {
        TreeNode treeNode = new TreeNode(4);
        TreeNode right = new TreeNode(3);
        treeNode.right = right;
        return treeNode;
    }

    public static TreeNode initOneRightOrderNode() {
        TreeNode treeNode = new TreeNode(4);
        TreeNode right = new TreeNode(8);
        treeNode.right = right;
        return treeNode;
    }

    public static TreeNode initTwoOrderNode() {
        TreeNode treeNode = new TreeNode(4);
        TreeNode left = new TreeNode(3);
        TreeNode right = new TreeNode(8);
        treeNode.right = right;
        treeNode.left = left;
        return treeNode;
    }

    public static TreeNode initTwoNotOrderNode() {
        TreeNode treeNode = new TreeNode(4);
        TreeNode left = new TreeNode(8);
        TreeNode right = new TreeNode(3);
        treeNode.right = right;
        treeNode.left = left;
        return treeNode;
    }

    public static TreeNode initMoreOrderNode() {
        TreeNode treeNode = new TreeNode(20);
        TreeNode left1 = new TreeNode(18);
        TreeNode left2 = new TreeNode(15);
        TreeNode left3 = new TreeNode(19);
        TreeNode right = new TreeNode(30);
        TreeNode right2 = new TreeNode(34);
        treeNode.left = left1;
        left1.left = left2;
        left1.right = left3;
        treeNode.right = right;
        right.right = right2;
        return treeNode;
    }
    public static TreeNode initMoreNotOrderNode() {
        TreeNode treeNode = new TreeNode(20);
        TreeNode left1 = new TreeNode(18);
        TreeNode left2 = new TreeNode(25);
        TreeNode left3 = new TreeNode(21);
        TreeNode right = new TreeNode(30);
        TreeNode right2 = new TreeNode(34);
        treeNode.left = left1;
        left1.left = left2;
        left1.right = left3;
        treeNode.right = right;
        right.right = right2;
        return treeNode;
    }
}
