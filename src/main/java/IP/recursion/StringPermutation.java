package main.java.IP.recursion;

import java.util.ArrayList;
import java.util.List;

public class StringPermutation {


    public static List<String> permute(String input) {
        List<String> results = new ArrayList<>();
        permuteHelper(input.toCharArray(), "", 0, results);

        return results;
    }


    public static void permuteHelper(char[] input, String slate, int index, List<String> results) {

        if (index == input.length) {
            results.add(slate);
            return;
        }

        for (int i = index; i < input.length; i++) {
            swap(input, i, index);
            permuteHelper(input, slate + input[i], index + 1, results);
            swap(input, i, index);

        }


    }

    private static void swap(char[] input, int i, int index) {
        char temp = input[i];
        input[i] = input[index];
        input[index] = temp;

    }

    public static void main(String[] args) {
        List<String> results = permute("abc");

        results.stream().forEach(i -> System.out.println(i));
    }


}
