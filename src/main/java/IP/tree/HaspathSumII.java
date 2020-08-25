package main.java.IP.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/path-sum-ii/
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
 *
 * Note: A leaf is a node with no children.
 *
 * Example:
 *
 * Given the below binary tree and sum = 22,
 *
 *       5
 *      / \
 *     4   8
 *    /   / \
 *   11  13  4
 *  /  \    / \
 * 7    2  5   1
 * Return:
 *
 * [
 *    [5,4,11,2],
 *    [5,8,4,5]
 * ]
 */



public class HaspathSumII {

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;
        dfs(root, new ArrayList<Integer>(),0,sum, result);
        return result;

    }

    void dfs(TreeNode node,List<Integer> slate, int sumSoFar, int target, List<List<Integer>> result){
        //If leaf node
        if (node.left == null && node.right == null) {
            if (node.val + sumSoFar == target) {
                slate.add(node.val);
                result.add(new ArrayList<>(slate));
                slate.remove(slate.size() -1);
                return;
            }
            return;
        }
        slate.add(node.val);
        if(node.left != null){
            dfs(node.left,slate,node.val+sumSoFar, target, result);
        }

        if(node.right != null){
            dfs(node.right,slate,node.val+sumSoFar, target, result);
        }
        slate.remove(slate.size() -1);


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
