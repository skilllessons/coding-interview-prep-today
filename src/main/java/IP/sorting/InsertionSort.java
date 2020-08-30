package main.java.IP.sorting;

public class InsertionSort {

    public static void sortInsertion(int[] sort_arr) {

        if (sort_arr == null || sort_arr.length == 0 || sort_arr.length == 1)
            throw new RuntimeException("Can't perform sorting on this input");

        for (int i = 0; i < sort_arr.length; ++i) {
            int j = i;
            while (j > 0 && sort_arr[j - 1] > sort_arr[j]) {
                int key = sort_arr[j];
                sort_arr[j] = sort_arr[j-1];
                sort_arr[j-1] = key;
                j = j - 1;
            }
        }
    }

    public static void main( String args[] ) {
        int [] arr = {5,2,12,12,1};
        sortInsertion(arr);

        for(int i=0;i<arr.length;++i){
            System.out.print(arr[i] + " ");
        }
    }
}
