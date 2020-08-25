package main.java.IP.tree;


/**
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.
 * <p>
 * Note: A leaf is a node with no children.
 * <p>
 * Example:
 * <p>
 * Given the below binary tree and sum = 22,
 * <p>
 * 5
 * / \
 * 4   8
 * /   / \
 * 11  13  4
 * /  \      \
 * 7    2      1
 * return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
 */
public class HasPathSum {
    boolean hasPathSum = false;

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        dfs(root, 0, sum);
        return hasPathSum;
    }

    public void dfs(TreeNode node, int sumSoFar, int target) {
        if (node.left == null && node.right == null) {
            if (node.val + sumSoFar == target) {
                hasPathSum = true;
                return;
            }
        }
        if (node.left != null) {
            if (hasPathSum) return;
            dfs(node.left, node.val + sumSoFar, target);
        }

        if (node.right != null) {
            if (hasPathSum) return;
            dfs(node.right, node.val + sumSoFar, target);
        }


    }

    /**
     * Definition for a binary tree node.
     */

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}
