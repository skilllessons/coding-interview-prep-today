package main.java.IP.recursion;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {
    public static boolean wordBreak(String s, List<String> wordDict) {
        return wordBreakHelper(s, 0, new HashSet<>(wordDict));
    }

    private static boolean wordBreakHelper(String s, int start, Set<String> wordDict) {
        // base case
        if(s.length() == start) {
            return true;
        }

        for (int end = start+1; end<=s.length(); end++) {
            if (wordDict.contains(s.substring(start, end)) && wordBreakHelper(s, end, wordDict)){
                return true;
            }
        }
      return false;
    }


    public static void main(String[] args) {

        wordBreak("leetcode", Arrays.asList("leet","code"));

    }
}
