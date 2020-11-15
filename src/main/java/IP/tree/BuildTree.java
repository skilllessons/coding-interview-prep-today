package main.java.IP.tree;

import java.util.HashMap;

/**
 * https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 * 105. Construct Binary Tree from Preorder and Inorder Traversal
 * Medium
 *
 * 4206
 *
 * 111
 *
 * Add to List
 *
 * Share
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 *
 * Note:
 * You may assume that duplicates do not exist in the tree.
 *
 * For example, given
 *
 * preorder = [3,9,20,15,7]
 * inorder = [9,3,15,20,7]
 * Return the following binary tree:
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * Accepted
 * 417,600
 * Submissions
 * 828,898
 */

public class BuildTree {
    HashMap<Integer, Integer> map = new HashMap<>();


    public TreeNode buildTree(int[] preorder, int[] inorder) {
        //Put the inorder index into map
        for (int i = 0; i <= inorder.length - 1; i++) {
            map.put(inorder[i], i);
        }
        return buildTreeHelper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    public TreeNode buildTreeHelper(int[] preorder, int start1, int end1, int[] inorder, int start2, int end2) {

        //Base condition

        if (start1 > end1) {
            return null;
        } else if (start1 == end1) {
            return new TreeNode(preorder[start1]);
        } else {
            int rootVal = preorder[start1];
            int rootIndex = map.get(rootVal);
            int numleft = rootIndex - start2;
            int numright = end2 - rootIndex;


            TreeNode root = new TreeNode(preorder[start1]);
            root.left = buildTreeHelper(preorder, start1 + 1, start1 + numleft, inorder, start2, start2 + numleft - 1);
            root.right = buildTreeHelper(preorder, start1 + numleft + 1, start1 + numleft + numright, inorder, rootIndex + 1, rootIndex + numright);

            return root;
        }


    }
}
