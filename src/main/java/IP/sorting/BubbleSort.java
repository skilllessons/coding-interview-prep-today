package main.java.IP.sorting;

public class BubbleSort {

    public static int[] bubbleSort(int[] array) {

        boolean isSorted = false;

        while (!isSorted) {
            isSorted = true;
            for (int i=0; i<array.length-1; i++) {
                if (array[i] > array[i+1]){
                    swap(array, i, i+1);
                    isSorted = false;
                }
            }


        }

     return array;
    }

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;

    }

    public static void main(String[] args) {
        int[] input = {10, 13, 45, 2, 3, 4, 1, 5, 6, 29};
        System.out.println(printArray(bubbleSort(input)));
    }

    private static String printArray(int[] bubbleSort) {
        StringBuilder sb = new StringBuilder();

        for (int i : bubbleSort) {
            sb.append(i+",");

        }

        return sb.toString();
    }


}
