package main.java.IP.recursion;

import java.util.ArrayList;
import java.util.List;

public class AllSubset {


    static String[] generate_all_subsets(String s) {

        List<String> result = new ArrayList<>();
        StringBuilder slate = new StringBuilder();
        helper(s.toCharArray(), slate, 0, result);

        String[] finalResult = new String[result.size()];
        int counter=0;
        for(String st : result){
            finalResult[counter] = st;
            counter++;
        }

        return finalResult;
    }

    public static void helper(char[] input, StringBuilder slate, int index, List<String> result) {

        if (index == input.length) {
            result.add(slate.toString());
            return;
        }

        helper(input, slate, index + 1, result);


        slate.append(input[index]);
        helper(input, slate, index + 1, result);
        slate.deleteCharAt(slate.length() - 1);


    }

    public static void main(String[] args) {
        String[] result = generate_all_subsets("xy");
        System.out.println(result);
    }

}
