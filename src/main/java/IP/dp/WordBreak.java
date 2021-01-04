package main.java.IP.dp;

import java.util.List;

public class WordBreak {

    public boolean wordBreak(String s, List<String> wordDict) {

        return wordBreakHelper(s, wordDict, 0);
    }

    private boolean wordBreakHelper(String s, List<String> wordDict, int start) {
        //Base case
        if (start == s.length()){
            return true;
        }

        for (int end= start+1; end<s.length(); end++) {
            if (wordDict.contains(s.substring(start, end)) && wordBreakHelper(s,wordDict, start)){
                return true;
            }

        }

       return false;
    }

}
