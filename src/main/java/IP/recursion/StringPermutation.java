package main.java.IP.recursion;

import java.util.ArrayList;
import java.util.List;



//TODO: This is not working need to check

public class StringPermutation {


    public static List<String> permute(String input) {
        List<String> results = new ArrayList<>();
        permuteHelper(input.toCharArray(), new ArrayList<>(), 0, results);

        return results;
    }


    public static void permuteHelper(char[] input, List<String> slate, int index, List<String> results) {

        if (index == input.length) {
            results.add(copyString(slate));
            return;
        }

        for (int i = index; i < input.length; i++) {
            swap(i,index,input);
            slate.add(String.valueOf(input[i]));
            permuteHelper(input, slate, index + 1, results);
            slate.remove(slate.size() -1);
            swap(index,i,input);

        }


    }

    private static String copyString(List<String> slate) {
        StringBuilder sb = new StringBuilder();
        slate.stream().forEach(i ->{
            sb.append(i);

        });
        return sb.toString();

    }

    private static void swap( int i, int j, char[] input) {
        char temp = input[i];
        input[i] = input[j];
        input[j] = temp;

    }

    public static void main(String[] args) {
        List<String> results = permute("abc");

        results.stream().forEach(i -> System.out.println(i));
    }


}
