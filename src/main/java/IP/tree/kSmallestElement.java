package main.java.IP.tree;

import java.util.PriorityQueue;

public class kSmallestElement {

   static  PriorityQueue<Integer> heap = new PriorityQueue<>((a,b) -> a-b);
    static int kthSmallestElement= -1;

    static int kth_smallest_element(TreeNode root, int k) {
        dfs(root,k);
        return kthSmallestElement;

    }

    static void  dfs(TreeNode node, int k) {
        if (node == null) {
            return;
        }

        dfs(node.left_ptr,k);
        heap.add(node.val);

        if(heap.size() > k){
            heap.poll();
        }
        dfs(node.right_ptr,k);
        kthSmallestElement = heap.poll();
    }


    static class TreeNode
    {
        int val;
        TreeNode left_ptr;
        TreeNode right_ptr;

        TreeNode(int _val)
        {
            val = _val;
            left_ptr = null;
            right_ptr = null;
        }
    };
}
