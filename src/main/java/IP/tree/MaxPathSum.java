package main.java.IP.tree;

public class MaxPathSum {
    private static int pathSum = Integer.MIN_VALUE;
    public static int maxPathSum(TreeNode root) {
        dfs(root);
        return pathSum;

    }

    public static int dfs(TreeNode node){

        if(node == null){
            return 0;
        }

        int leftSum = Math.max(dfs(node.left), 0);
        int rightSum = Math.max(dfs(node.right), 0);
        int totalsum = node.val + leftSum + rightSum;

        pathSum = Math.max(pathSum, totalsum);

        return node.val + Math.max(leftSum, rightSum);

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(-10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(maxPathSum(root));

    }


}
