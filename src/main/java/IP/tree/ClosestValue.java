package main.java.IP.tree;

public class ClosestValue {

    double min = Double.MIN_VALUE;


    public int closestValue(TreeNode root, double target) {

        dfs(root, target, 0);
        return (int)min;

    }

    private void dfs(TreeNode node, double target, double somesofar) {

        if(node.left == null && node.right ==null) return;

        if(node != null && Math.abs(target -somesofar) <= min){
            min = Math.abs(target -somesofar);
        }

        if(node.left!=null) {
            dfs(node.left, target, target-node.left.val);

        }

        if(node.right!=null) {
            dfs(node.right, target,target-node.right.val);

        }



    }
}
