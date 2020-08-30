package main.java.IP.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MergeTwoBSTs {
    public static List<Integer> t1Nodes = new ArrayList<>();
    public static List<Integer> t2Nodes = new ArrayList<>();

    public static Node mergeTwoBSTs(Node t1, Node t2) {
        return BSTHelper(t1, t2);
    }

    public static Node BSTHelper(Node t1, Node t2) {
        dfs1(t1);
        dfs2(t2);
        t1Nodes.addAll(t2Nodes);
        Collections.sort(t1Nodes);
       Node root = construcTree(t1Nodes, 0, t1Nodes.size() - 1);
        return root;

    }


    public static Node construcTree(List<Integer> t1, int start, int end) {

        if (start > end) {
            return null;
        }


        int mid = (start + end) / 2;
        Node root = new Node(t1Nodes.get(mid));
        root.left = construcTree(t1, start, mid - 1);
        root.right = construcTree(t1, mid + 1, end);

        return root;

    }


    public static List<Integer> dfs1(Node t1) {

        if (t1 == null) {
            return null;
        }

        dfs1(t1.left);
        t1Nodes.add(t1.key);
        dfs1(t1.right);

        return t1Nodes;

    }

    public static List<Integer> dfs2(Node t1) {

        if (t1 == null) {
            return null;
        }

        dfs2(t1.left);
        t2Nodes.add(t1.key);
        dfs2(t1.right);

        return t2Nodes;

    }

    static class Node {

        Node left;
        Node right;
        int key;

        Node(int key) {
            this.left = null;
            this.right = null;
            this.key = key;
        }

    }

}
