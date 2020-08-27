package main.java.IP.tree;

import java.util.*;

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
