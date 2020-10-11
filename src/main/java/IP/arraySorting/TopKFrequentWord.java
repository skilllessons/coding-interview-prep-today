package main.java.IP.arraySorting;

import org.junit.Test;

import java.util.*;
import static org.junit.Assert.assertEquals;


/**
 * https://leetcode.com/problems/top-k-frequent-words/
 *
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

    @Test
    public void testTopK() {
        TopKFrequentWord  topKFrequentWord = new TopKFrequentWord();
        String[] input = {"i", "love", "leetcode", "i", "love", "coding"};
        List<String> output = topKFrequentWord.topKFrequent(input, 2);
        List<String> expected = new ArrayList<>();
        expected.add("i");
        expected.add("love");
        assertEquals(expected,output);
    }


}
