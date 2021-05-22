package main.java.IP.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode.com/problems/binary-tree-level-order-traversal/submissions/
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
 *
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its level order traversal as:
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 */

public class LevelOrder {



    class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {

            if (root == null) return new ArrayList<>();
            List<List<Integer>> res = new ArrayList<>();
            bfs(root, res);
            return res;

        }

        public void bfs(TreeNode root, List<List<Integer>> result) {


            Queue<TreeNode> q = new LinkedList<>();
            q.add(root);

            while (q.size() != 0) {
                int size = q.size();
                List<Integer> res = new ArrayList<>();
                for (int i = 0; i < size; i++) {  //2
                    TreeNode node = q.poll();
                    res.add(node.val); //9, 20
                    if (node.left != null) {
                        q.add(node.left);
                    }
                    if (node.right != null) {
                        q.add(node.right);
                    }

                }
                result.add(res); // [3][9,20] Q => 9,20  //9 ,

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
}
