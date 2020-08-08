package main.java.amazon;

import java.util.*;

public class MostCommonWord {

    public String mostCommonWord(String paragraph, String[] banned) {

        if(paragraph== null || paragraph.isEmpty()) return paragraph;

        String[] paragraph1 = paragraph.replaceAll("[^a-zA-Z ]", "").toLowerCase().split("\\s+");
        List<String> bandList = Arrays.asList(banned);

        Map<String,Integer> cache = new TreeMap<>(Collections.reverseOrder());
        for(String word: paragraph1){
             if(!bandList.contains(word)){
                 cache.put(word, cache.getOrDefault(word,0)+1);

             }

        }
        return  cache.entrySet().iterator().next().getKey();
    }

    public static void main(String[] args) {

        MostCommonWord mostCommonWord = new MostCommonWord();
        String[] banned = {"hit"};

        System.out.println(mostCommonWord.mostCommonWord("Bob hit a ball, the hit BALL flew far after it was hit.",banned ));

    }
}
