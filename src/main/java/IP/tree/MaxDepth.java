package main.java.IP.tree;


/**
 * https://leetcode.com/problems/maximum-depth-of-binary-tree/
 * Given a binary tree, find its maximum depth.
 *
 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 *
 * Note: A leaf is a node with no children.
 *
 * Example:
 *
 * Given binary tree [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its depth = 3.
 */
public class MaxDepth {

    public static int maxDepth(TreeNode root) {
        if(root!=null)
        System.out.println("Root-->Val{}" + root.val);

        if(root == null)  {
            System.out.println("==========================");
            return 0;
        }
        int leftDepth = maxDepth(root.left);
        System.out.println("leftDepth -->{}" + leftDepth);
       // System.out.println("==========================");

        int rightDepth = maxDepth(root.right);


        System.out.println("rightDepth -->{}" + rightDepth);

        return Math.max(leftDepth,rightDepth) +1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println(maxDepth(root));

    }


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


}
