package main.java.IP.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode.com/problems/average-of-levels-in-binary-tree/submissions/
 *637. Average of Levels in Binary Tree
 * Easy
 *
 * 1529
 *
 * 173
 *
 * Add to List
 *
 * Share
 * Given a non-empty binary tree, return the average value of the nodes on each level in the form of an array.
 * Example 1:
 * Input:
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * Output: [3, 14.5, 11]
 * Explanation:
 * The average value of nodes on level 0 is 3,  on level 1 is 14.5, and on level 2 is 11. Hence return [3, 14.5, 11].
 */

public class AverageOfLevels {
    List<Double> result = new ArrayList<>();

    public List<Double> averageOfLevels(TreeNode root) {
        if(root == null) return new ArrayList<>();
        helper(root);
        return result;
    }

    public void helper(TreeNode node) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);

        while(!queue.isEmpty()) {
            List<Integer> res = new ArrayList<>();
            int size = queue.size();

            for(int i =0; i<size;i++){
                TreeNode n = queue.poll();
                res.add(n.val);
                if(n.left!=null){
                    queue.add(n.left);
                }
                if(n.right!=null){
                    queue.add(n.right);
                }
            }


            result.add(res.stream().mapToInt(val -> val).average().orElse(0.0));


        }

    }
}
