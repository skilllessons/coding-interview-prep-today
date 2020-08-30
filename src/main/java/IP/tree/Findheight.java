package main.java.IP.tree;


import java.util.*;

/**
 * Find a height of tree BFS implementation
 */

public class Findheight {
    static int level = 0;

    static int find_height(TreeNode1 root) {

        if (root == null) return 0;

        return dfs(root);
    }

    public static int dfs(TreeNode1 node) {
        if (node == null) return 1;

        Queue<TreeNode1> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {

            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode1 node1 = queue.poll();
                queue.addAll(node1.children);
            }
            level++;


        }

        return level;

    }

    static class TreeNode1 {
        List<TreeNode1> children = new ArrayList<>(0);

        TreeNode1() {
            children.clear();
        }
    }

    ;
}
