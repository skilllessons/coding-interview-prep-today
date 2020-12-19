package main.java.IP.arraySorting;

public class FindProduct {

    public static int[] findProduct(int arr[]) {

        int n = arr.length;
        int temp =1;


        int[] result = new int[n];


        for(int i=0; i<n; i++) {

            result[i] = temp;
            temp *= arr[i];
        }

        temp = 1;

        for (int i = n - 1; i >= 0; i--) {

            result[i] *= temp;
            temp *= arr[i];
        }

      return result;
    }

    public static void main(String[] args) {

        int[] input = {1,2,3,4};
        findProduct(input);
    }


}
