package main.java.techcompanies.amazon;

import java.util.*;

public class Solution {
    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    static List<Integer> lengthEachScene(List<Character> inputList) {
        int[] last = new int[26];


        for (int i = 0; i < inputList.size(); ++i)
            last[inputList.get(i) - 'a'] = i;

        int j = 0, anchor = 0;
        List<Integer> ans = new ArrayList();


        for (int i = 0; i < inputList.size(); ++i) {
            j = Math.max(j, last[inputList.get(i) - 'a']);
            if (i == j) {
                ans.add(i - anchor + 1);
                anchor = i + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {

        List<Character> characters = new ArrayList<>();

        for (char ch : "ababcbacadefegdehijhklij".toCharArray()) {

            characters.add(ch);
        }


        List<Integer> response = lengthEachScene(characters);

        response.stream().forEach(i -> {

            System.out.println(i);
        });
    }

    // METHOD SIGNATURE ENDS
}
