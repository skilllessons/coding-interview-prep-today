package main.java.IP.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class WordBreakII {

    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> result = new ArrayList<>();
        wordBreakHelper(s, 0, "", new HashSet<>(wordDict), result);
        return result;
    }

    private boolean wordBreakHelper(String s, int start, String slate, HashSet<String> wordDict, List<String> result) {

        if(!slate.isEmpty())
        result.addAll(Arrays.asList(slate.split(",")));

        if (start == s.length()) {
            return true;
        }

        for (int end = start + 1; end <= s.length(); end++) {
            if (wordDict.contains(s.substring(start, end)) && wordBreakHelper(s, end, s.substring(start, end) + ",", wordDict, result)) {
                return true;

            }

        }

        return false;
    }

    public static void main(String[] args) {
        WordBreakII wb2 = new WordBreakII();
        List<String> result = wb2.wordBreak("catsanddog", Arrays.asList("cat","cats","and","sand","dog"));
        System.out.println(result);

    }

}
