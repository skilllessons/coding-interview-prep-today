package main.java.IP.tree;

import java.util.*;

/**
 * https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
 *
 * 103. Binary Tree Zigzag Level Order Traversal
 * Medium
 *
 * 2733
 *
 * 111
 *
 * Add to List
 *
 * Share
 * Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).
 *
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its zigzag level order traversal as:
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 */

public class ZigzagLevelOrder {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;

        bfs(root, result);
        return result;
    }

    private void bfs(TreeNode root, List<List<Integer>> result) {

        Queue<TreeNode> q  = new LinkedList<>();
        q.add(root);
        int counter = 0;
        while(!q.isEmpty()){
            List<Integer> res = new ArrayList<>();
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                res.add(node.val);
                if(node.left!=null){
                    q.add(node.left);
                }if(node.right!=null){
                    q.add(node.right);

                }

            }
            counter++;
            if(counter % 2 !=0) {
                Collections.reverse(res);
                result.add(res);
            } else {
                result.add(res);

            }
        }


    }


}
