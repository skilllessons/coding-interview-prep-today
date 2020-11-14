package main.java.IP.tree;


/**
 * https://leetcode.com/problems/count-univalue-subtrees/
 * 250. Count Univalue Subtrees
 * Medium
 *
 * 591
 *
 * 159
 *
 * Add to List
 *
 * Share
 * Given the root of a binary tree, return the number of uni-value subtrees.
 *
 * A uni-value subtree means all nodes of the subtree have the same value.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [5,1,5,5,5,null,5]
 * Output: 4
 * Example 2:
 *
 * Input: root = []
 * Output: 0
 * Example 3:
 *
 * Input: root = [5,5,5,5,5,null,5]
 * Output: 6
 *
 *
 * Constraints:
 *
 * The numbrt of the node in the tree will be in the range [0, 1000].
 * -1000 <= Node.val <= 1000
 */

public class CountUnivalSubtrees {
    public int count =0;
    public int countUnivalSubtrees(TreeNode root) {
        if(root == null) return 0;
        dfs(root);
        return count;
    }

    public boolean dfs(TreeNode node){

        boolean amiunival = true;
        //Base condition
        if(node.left == null && node.right == null) {
            count++;
            return true;
        }

        //Recursive case
        if(node.left!=null) {
            boolean leftunival = dfs(node.left);
            if(!leftunival || node.left.val != node.val){
                amiunival = false;
            }

        }

        if(node.right!=null) {
            boolean rightunival = dfs(node.right);
            if(!rightunival || node.right.val != node.val){
                amiunival = false;
            }
        }

        if(amiunival) {
            count++;
        }

        return amiunival;


    }

}
