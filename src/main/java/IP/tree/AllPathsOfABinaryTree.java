package main.java.IP.tree;

import java.util.ArrayList;
import java.util.List;

public class AllPathsOfABinaryTree {
    static List<List<Integer>> allPathsOfABinaryTree(TreeNode root){

        List<List<Integer>> result = new ArrayList<>();
        dfs(root, new ArrayList<>(), result);
        return result;
    }


    public static void  dfs(TreeNode node, List<Integer> slate, List<List<Integer>> result){

        //We have reached to Leaf
        if(node.left_ptr == null || node.right_ptr == null){
            result.add(new ArrayList<>(slate));
            return;
        }

        //

        if(node.left_ptr!=null) {
            slate.add(node.left_ptr.val);
            dfs(node.left_ptr, slate, result);
            slate.remove(slate.size() -1);
        }

        if(node.right_ptr!=null) {
            slate.add(node.right_ptr.val);
            dfs(node.left_ptr, slate, result);
            slate.remove(slate.size() -1);
        }




    }

    /**
     * Definition for a binary tree node.
     */

    public class TreeNode {
        int val;
        TreeNode left_ptr;
        TreeNode right_ptr;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left_ptr = left;
            this.right_ptr = right;
        }
    }
}
