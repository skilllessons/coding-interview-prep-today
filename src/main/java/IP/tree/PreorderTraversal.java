package main.java.IP.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/binary-tree-preorder-traversal/
 * 144. Binary Tree Preorder Traversal
 * Medium
 *
 * 1854
 *
 * 71
 *
 * Add to List
 *
 * Share
 * Given the root of a binary tree, return the preorder traversal of its nodes' values.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [1,null,2,3]
 * Output: [1,2,3]
 * Example 2:
 *
 * Input: root = []
 * Output: []
 * Example 3:
 *
 * Input: root = [1]
 * Output: [1]
 * Example 4:
 *
 *
 * Input: root = [1,2]
 * Output: [1,2]
 * Example 5:
 *
 *
 * Input: root = [1,null,2]
 * Output: [1,2]
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [0, 100].
 * -100 <= Node.val <= 100
 *
 *
 * Follow up:
 *
 * Recursive solution is trivial, could you do it iteratively?
 */

public class PreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null) return result;
        dfs(root, result);
        return result;

    }

    public void dfs(TreeNode node, List<Integer> result) {
        //Base case
        if(node.left == null && node.right == null){
            result.add(node.val);
            return;
        }

        result.add(node.val);

        if(node.left !=null){
            dfs(node.left, result);
        }

        if(node.right !=null){
            dfs(node.right, result);
        }

    }
}
