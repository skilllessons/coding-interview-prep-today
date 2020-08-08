package main.java.LinkedList;

public class LinkedList {

    public static void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }


    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return null;
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;

        while (curr != null) {
           next = curr.next;
           curr.next = prev;


           prev = curr;
           curr = next;

        }

        return prev;


    }




    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        //deleteNode(head.next.next);
        reverseList(head);
        printList(head);

    }


    private static void printList(ListNode head) {
        while (head != null) {
            System.out.println(head.val);
            head = head.next;

        }

    }
}
