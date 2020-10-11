package main.java.companies.facebook;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/top-k-frequent-words/
 * 692. Top K Frequent Words
 * Medium
 *
 * 2248
 *
 * 159
 *
 * Add to List
 *
 * Share
 * Given a non-empty list of words, return the k most frequent elements.
 *
 * Your answer should be sorted by frequency from highest to lowest. If two words have the same frequency, then the word with the lower alphabetical order comes first.
 *
 * Example 1:
 * Input: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
 * Output: ["i", "love"]
 * Explanation: "i" and "love" are the two most frequent words.
 *     Note that "i" comes before "love" due to a lower alphabetical order.
 * Example 2:
 * Input: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k = 4
 * Output: ["the", "is", "sunny", "day"]
 * Explanation: "the", "is", "sunny" and "day" are the four most frequent words,
 *     with the number of occurrence being 4, 3, 2 and 1 respectively.
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
 * Input words contain only lowercase letters.
 * Follow up:
 * Try to solve it in O(n log k) time and O(n) extra space.
 */

public class TopKFrequentWord {


    public List<String> topKFrequent(String[] words, int k) {

        HashMap<String, Integer> count =  new HashMap<String, Integer>();

        for (String s: words){
            count.put(s, count.getOrDefault(s, 0)+1);

        }

        PriorityQueue<String> heap = new PriorityQueue<String>(
                (n1, n2) -> count.get(n1) - count.get(n2));


        for (String n: count.keySet()) {
            heap.add(n);
            if (heap.size() > k) heap.poll();
        }


        List<String> result = new ArrayList<>();

       while(k!=0){
           result.add(heap.poll());
           k--;
       }

       return result;


    }
}
