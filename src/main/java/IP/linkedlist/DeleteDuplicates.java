package main.java.IP.linkedlist;


/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/
 *Given the head of a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list. Return the linked list sorted as well.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: head = [1,2,3,3,4,4,5]
 * Output: [1,2,5]
 * Example 2:
 *
 *
 * Input: head = [1,1,1,2,3]
 * Output: [2,3]
 *
 *
 * Constraints:
 *
 * The number of nodes in the list is in the range [0, 300].
 * -100 <= Node.val <= 100
 * The list is guaranteed to be sorted in ascending order.
 *


/**
 * Definition for singly-linked list.
 */
class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }


public class DeleteDuplicates {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode sentinal = new ListNode(0, head);
        ListNode pred = sentinal;

        while (head != null) {

            if(head.next != null && head.val == head.next.val) {

                while (head.next !=null && head.val == head.next.val) {
                    head = head.next;
                }

                pred.next = head.next;

            }  else {
                pred = pred.next;
            }

            head = head.next;
        }

        return  sentinal.next;

    }

    public static void main(String[] args) {

    }


}
