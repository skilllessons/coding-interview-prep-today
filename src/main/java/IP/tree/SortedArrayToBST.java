package main.java.IP.tree;

/**
 * 108. Convert Sorted Array to Binary Search Tree
 * Easy
 *
 * 3081
 *
 * 236
 *
 * Add to List
 *
 * Share
 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
 *
 * For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 *
 * Example:
 *
 * Given the sorted array: [-10,-3,0,5,9],
 *
 * One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:
 *
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 * Accepted
 * 461,976
 * Submissions
 * 779,324
 *
 */

public class SortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0)
            return null;

        return sortedArrayToBST(nums, 0, nums.length - 1);
    }

    public TreeNode sortedArrayToBST(int[] num, int start, int end) {
        if (start > end)
            return null;
        else if(start == end){
            return new TreeNode(num[start]);
        } else {
            int mid = (start + end) / 2;
            TreeNode root = new TreeNode(num[mid]);
            root.left = sortedArrayToBST(num, start, mid - 1);
            root.right = sortedArrayToBST(num, mid + 1, end);
            return root;
        }

    }
}
