package main.java.IP.tree;

import java.util.*;

public class LargestValues {

    public static List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null) return result;
        bfs(root, result);
        return result;
    }

    public static void bfs(TreeNode root, List<Integer> result) {

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(queue.size() !=0) {
            int size = queue.size();
            List<Integer> result1 = new ArrayList<>();

            for(int i=0; i<size; i++) {
                TreeNode node = queue.poll();
                result1.add(node.val);

                if(node.left!=null){
                    queue.add(node.left);
                }
                if(node.right!=null){
                    queue.add(node.right);
                }
            }
            result.add(Collections.max(result1));

        }

    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(9);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(3);
        largestValues(root);

    }

}
