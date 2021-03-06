package main.java.IP.tree;

import java.util.*;

/**
 * https://leetcode.com/problems/binary-tree-level-order-traversal-ii/
 Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).

 For example:
 Given binary tree [3,9,20,null,null,15,7],
 3
 / \
 9  20
 /  \
 15   7
 return its bottom-up level order traversal as:
 [
 [15,7],
 [9,20],
 [3]
 ]
 */

public class LevelOrderButtom {



    class Solution {

        public List<List<Integer>> levelOrderBottom(TreeNode root) {

            if (root == null) return new ArrayList<>();
            List<List<Integer>> res = new ArrayList<>();
            bfs(root, res);
            Collections.reverse(res);
            return res;

        }

        public void bfs(TreeNode root, List<List<Integer>> result) {


            Queue<TreeNode> q = new LinkedList<>();
            q.add(root);

            while (q.size() != 0) {
                int size = q.size();
                List<Integer> res = new ArrayList<>();
                for (int i = 0; i < size; i++) {
                    TreeNode node = q.poll();
                    res.add(node.val);
                    if (node.left != null) {
                        q.add(node.left);
                    }
                    if (node.right != null) {
                        q.add(node.right);
                    }

                }
                result.add(res);

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
