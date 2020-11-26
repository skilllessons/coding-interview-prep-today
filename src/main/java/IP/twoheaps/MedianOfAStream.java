package main.java.IP.twoheaps;

import java.util.PriorityQueue;

class MedianOfAStream {

    PriorityQueue<Integer> maxheap = new PriorityQueue<>((a,b) -> b-a);
    PriorityQueue<Integer> minheap = new PriorityQueue<>((a,b) -> b-a);


    public void insertNum(int num) {

        if (maxheap.isEmpty() || maxheap.peek() >= num){
            maxheap.add(num);
        } else {
            minheap.add(num);

        }

        if (maxheap.size()> minheap.size()+1){
            minheap.add(maxheap.poll());
        } else if(maxheap.size() < minheap.size()){
            maxheap.add(minheap.poll());

        }



    }

    public double findMedian() {
        if (maxheap.size() == minheap.size()) {
            // we have even number of elements, take the average of middle two elements
            return maxheap.peek() / 2.0 + minheap.peek() / 2.0;
        }
        // because max-heap will have one more element than the min-heap
        return maxheap.peek();
    }

    public static void main(String[] args) {
        MedianOfAStream medianOfAStream = new MedianOfAStream();
        medianOfAStream.insertNum(3);
        medianOfAStream.insertNum(1);
        System.out.println("The median is: " + medianOfAStream.findMedian());
        medianOfAStream.insertNum(5);
        System.out.println("The median is: " + medianOfAStream.findMedian());
        medianOfAStream.insertNum(4);
        System.out.println("The median is: " + medianOfAStream.findMedian());
    }
}

