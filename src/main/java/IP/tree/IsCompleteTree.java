package main.java.IP.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/check-completeness-of-a-binary-tree/
 *
 * 958. Check Completeness of a Binary Tree
 * Medium
 *
 * 981
 *
 * 14
 *
 * Add to List
 *
 * Share
 * Given a binary tree, determine if it is a complete binary tree.
 *
 * Definition of a complete binary tree from Wikipedia:
 * In a complete binary tree every level, except possibly the last, is completely filled, and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.
 *
 *
 *
 * Example 1:
 *
 *
 *
 * Input: [1,2,3,4,5,6]
 * Output: true
 * Explanation: Every level before the last is full (ie. levels with node-values {1} and {2, 3}), and all nodes in the last level ({4, 5, 6}) are as far left as possible.
 * Example 2:
 *
 *
 *
 * Input: [1,2,3,4,5,null,7]
 * Output: false
 * Explanation: The node with value 7 isn't as far left as possible.
 *
 * Note:
 *
 * The tree will have between 1 and 100 nodes.
 */

public class IsCompleteTree {
    public boolean isCompleteTree(TreeNode root) {
        if (root == null) return true;
        return bfs(root);
    }


    public boolean bfs(TreeNode root) {
        boolean isNullChild = false;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();

            if (current.left != null) {

                if (isNullChild) {
                    return false;

                }
                queue.offer(current.left);
            } else {
                isNullChild = true;
            }


            if (current.right != null) {
                if (isNullChild) {
                    return false;
                }
                queue.offer(current.right);
            } else {
                isNullChild = true;
            }


        }


        return true;

    }
}
