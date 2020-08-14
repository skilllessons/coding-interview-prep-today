package main.java.practice;

import java.util.PriorityQueue;

public class PriorityQueueDemo {



    public static void main(String[] args) {

        // Creating an empty PriorityQueue
        PriorityQueue<String> queue = new PriorityQueue<String>();


        // Use add() method to add elements into the Queue
        queue.add("Welcome");
        queue.add("To");
        queue.add("Geeks");
        queue.add("For");
        queue.add("Geeks");

        // Displaying the PriorityQueue
        System.out.println("Initial PriorityQueue: " + queue);

        // Fetching and removing the element at the head of the queue
        System.out.println("The element at the head of the"
                + " queue is: " + queue.poll());

        // Displaying the Queue after the Operation
        System.out.println("Final PriorityQueue: " + queue);




        // Creating an empty PriorityQueue
        PriorityQueue<Integer> queue1 = new PriorityQueue<Integer>();

        // Use add() method to add elements into the Queue
        queue1.add(10);
        queue1.add(15);
        queue1.add(30);
        queue1.add(20);
        queue1.add(5);

        // Displaying the PriorityQueue
        System.out.println("Initial PriorityQueue: " + queue1);

        // Fetching the element at the head of the queue
        System.out.println("The element at the head of the"
                + " queue is: " + queue1.poll());

        // Displaying the Queue after the Operation
        System.out.println("Final PriorityQueue: " + queue1);
    }
}
