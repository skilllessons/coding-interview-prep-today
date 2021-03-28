package main.java.pattern;

import java.util.*;

public class AlienDictionary {

    public static String findOrder(String[] words) {

        if(words == null || words.length ==0) return "";

        StringBuilder sb = new StringBuilder();

        Map<Character, List<Character>> graph = new HashMap<>();
        Map<Character, Integer> inDegree = new HashMap<>();
        //initialization
        for (String word: words){
            for (char word1: word.toCharArray()) {
                inDegree.put(word1, 0);
                graph.put(word1, new ArrayList<>());
            }
        }

        //compare the words build the graph
        for (int i=0; i< words.length-1; i++) {
            String word1 = words[i];
            String word2 = words[i+1];
            for (int j=0; j<Math.min(word1.length(), word2.length()); j++) {
                 char parent = word1.charAt(j);
                 char child = word2.charAt(j);
               if(parent != child) {
                   graph.get(parent).add(child);
                   inDegree.put(child, inDegree.get(child)+1);
                   break;
               }
            }
        }

        Queue<Character> queue = new LinkedList<>();
        for (Map.Entry<Character, Integer> entry: inDegree.entrySet()) {
             if (entry.getValue() == 0) {
                 queue.add(entry.getKey());
             }
        }


        while (!queue.isEmpty()) {
            char node = queue.poll();
            sb.append(node);
            for (char children:graph.get(node)) {
                 inDegree.put(children, inDegree.get(children)-1);
                 if(inDegree.get(children) == 0) {
                     queue.add(children);
                 }
            }

        }

        if (sb.length() != inDegree.size())
            return "";

        return sb.toString();
    }

    public static void main(String[] args) {
        String result = AlienDictionary.findOrder(new String[] { "ba", "bc", "ac", "cab" });
        System.out.println("Character order: " + result);

        result = AlienDictionary.findOrder(new String[] { "cab", "aaa", "aab" });
        System.out.println("Character order: " + result);

        result = AlienDictionary.findOrder(new String[] { "ywx", "wz", "xww", "xz", "zyy", "zwz" });
        System.out.println("Character order: " + result);
    }

}
