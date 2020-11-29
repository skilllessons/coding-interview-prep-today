package main.java.IP.tree;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode sufficientSubset(TreeNode root, int limit) {

        boolean res = sufficientSubsetHelper(root,0, limit);
        if(res) {
            return null;
        } else {
            return root;
        }
    }

    public boolean sufficientSubsetHelper(TreeNode node, int sum, int limit) {

        if (node == null) {
            return true;
        }
        sum += node.val;
        if (node.left == null && node.right == null) {
            if (sum < limit) {
                return true;
            } else {
                return false;
            }
        }

        boolean left = sufficientSubsetHelper(node.left,sum, limit);
        boolean right = sufficientSubsetHelper(node.right,sum, limit);

        if(left) node.left = null;

        if(right) node.right = null;

        return left && right ;
    }
}
