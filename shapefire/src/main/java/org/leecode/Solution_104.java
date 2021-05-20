package org.leecode;

/**
 * 104. 二叉树的最大深度
 */
public class Solution_104 {

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDep = maxDepth(root.left);
        int rightDep = maxDepth(root.right);

        return Math.max(leftDep, rightDep) + 1;
    }

    // test case
    public static void main(String[] args) {
        TreeNode root = new TreeNode();
        TreeNode left = new TreeNode(1);
        root.left = left;
        System.out.println(new Solution_104().maxDepth(root));
    }


}
