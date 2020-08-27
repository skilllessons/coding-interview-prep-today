package main.java.IP.tree;

public class IsBST {

    static boolean isBST(TreeNode root){
        if(root == null) return true;
         return  isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);

    }

    static boolean isBST(TreeNode node, int minValue, int maxValue){

        if(node == null) return true;
        if(node != null && node.val> minValue && node.val<maxValue) return true;

        boolean leftBST = false;
        if(node.left != null){
           leftBST = isBST(node.left, minValue, maxValue);

        }

        boolean rightBST = false;
        if(node.left != null){
            rightBST = isBST(node.left, minValue, maxValue);

        }

        if(leftBST && rightBST) return true;


      return false;


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
