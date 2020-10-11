package main.java.IP.arraySorting;

import java.util.*;

public class TopKFrequentWord {

    public List<String> topKFrequent(String[] words, int k) {

        HashMap<String, Integer> count =  new HashMap<String, Integer>();

        for (String s: words){
            count.put(s, count.getOrDefault(s, 0)+1);

        }

        PriorityQueue<String> heap = new PriorityQueue<String>(
                (w1, w2) -> count.get(w1).equals(count.get(w2)) ?
                        w2.compareTo(w1) : count.get(w1) - count.get(w2) );

        for (String n: count.keySet()) {
            heap.add(n);
            if (heap.size() > k)
                heap.poll();
        }


        List<String> result = new ArrayList<>();

        while(k !=0){
            result.add(heap.poll());
            k--;
        }

        Collections.reverse(result);

        return result;


    }

    //["i", "love", "leetcode", "i", "love", "coding"]
    //2

    public static void main(String[] args) {

        TopKFrequentWord  topKFrequentWord = new TopKFrequentWord();

        String[] input = {"i", "love", "leetcode", "i", "love", "coding"};

        List<String> output = topKFrequentWord.topKFrequent(input, 2);


        output.stream().forEach(i -> System.out.println(i));



    }


}
