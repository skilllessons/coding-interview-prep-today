package main.java.IP.arraySorting;

import java.util.ArrayList;
import java.util.List;

public class MergeSort3 {


    public static List<Integer> merge_sort(List<Integer> arr) {
        // Write your code here

        List<Integer> result = new ArrayList<>();

        mergesort_helper(arr, result, 0, arr.size()-1);

        return result;

    }

    private static void mergesort_helper(List<Integer> arr, List<Integer> result, int start, int end) {

        if (start >= end) return;

        int mid = (start + end) / 2;
        int i = start;
        int j = mid + 1;

        mergesort_helper(arr, result, i, mid);
        mergesort_helper(arr, result, j, end);
        mergeHalves(arr, result, i, end);


        //int index
        while (i <= mid && j <= end) {

            if (arr.get(i) < arr.get(j)) {
                result.add(arr.get(i));
                i++;
            } else {
                result.add(arr.get(j));
                j++;
            }
        }


    }
    private static void mergeHalves(List<Integer> arr, List<Integer> result, int leftStart, int rightEnd) {

        int leftEnd = (rightEnd + leftStart) / 2;
        int rightStart = leftEnd + 1;
        int size = rightEnd - leftStart + 1;

        int left = leftStart;
        int right = rightStart;
        int index = leftStart;

        while (left <= leftEnd && right <= rightEnd) {

            if (arr.get(left) <= arr.get(right)) {
                result.add(arr.get(left));
                left++;
            } else {
                result.add(arr.get(right));
                right++;

            }

            index++;

        }


    }

    public static void main(String[] args) {
        List<Integer> input = new ArrayList<>();
        input.add(2);
        input.add(10);
        input.add(21);
        input.add(3);
        input.add(5);
        input.add(34);
        input.add(1);



        List<Integer> res = merge_sort(input);
        res.stream().forEach(i -> {
            System.out.println(i);
        });
    }
}
