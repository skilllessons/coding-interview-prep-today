package main.java.IK09;

public class KLergest {

    int kthLargest(int[] input, int n, int k) {


        return helper(input, n, k, 0, n - 1);
    }

    private int helper(int[] input, int n, int k, int start, int end) {

        int pivot = rand(input, n, start, end);
        int pivot_idx = partition(input, start, end);

        if (pivot_idx == n - k) {
            return input[n - k];
        } else if (pivot_idx < n - k) {
            helper(input, n, k, start, pivot_idx);
        }

        return helper(input, n, k, pivot_idx, end);
    }

    private int rand(int[] input, int n, int start, int end) {
        return -1;
    }

    private int partition(int[] input, int start, int end) {
        return -1;
    }


}
