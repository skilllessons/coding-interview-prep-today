package main.java.google;

import main.java.IP.tree.TreeNode;


/**
 * https://leetcode.com/problems/find-leaves-of-binary-tree/
 *
 * Given the root of a binary tree, collect a tree's nodes as if you were doing this:
 *
 * Collect all the leaf nodes.
 * Remove all the leaf nodes.
 * Repeat until the tree is empty.
 *
 *
 * Example 1:
 *
 *
 * Input: root = [1,2,3,4,5]
 * Output: [[4,5,3],[2],[1]]
 * Explanation:
 * [[3,5,4],[2],[1]] and [[3,4,5],[2],[1]] are also considered correct answers since per each level it does not matter the order on which elements are returned.
 * Example 2:
 *
 * Input: root = [1]
 * Output: [[1]]
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindLeaves {
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        while (root.left != null || root.right != null) {
            List<Integer> temp = new ArrayList();
            dfs(root, temp);
            result.add(temp);
        }

        result.add(Arrays.asList(root.val));

        return result;
    }

    public TreeNode dfs(TreeNode root, List<Integer> list) {
        if (root == null) return null;

        if (root.left == null && root.right == null) {
            list.add(root.val);
            return null;
        }

        root.left = dfs(root.left, list);
        root.right = dfs(root.right, list);


        return root;

    }


    // Definition for a binary tree node.
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
