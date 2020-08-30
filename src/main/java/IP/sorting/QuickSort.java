package main.java.IP.sorting;

import org.junit.Test;


public class QuickSort {

    public static void quickSort(int arr[]) {
        quickSort(arr, 0, arr.length - 1);
    }


    private static void quickSort(int[] arr, int left, int right) {

        if (left >= right) {
            return;
        }
        int pivot = arr[(left + right) / 2];
        int index = partition(arr, left, right, pivot);

        quickSort(arr, left, index - 1);
        quickSort(arr, index, right);
    }

    private static int partition(int[] arr, int left, int right, int pivot) {

        while (left <= right) {

            while (arr[left] < pivot) {
                left++;
            }

            while (arr[right] > pivot) {
                right--;
            }

            if (left <= right) {
                swap(arr, left, right);
                left++;
                right--;

            }

        }
        return left;
    }

    private static void swap(int[] arr, int left, int right) {

        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }


    @Test
    public void testQuickSort() {
        int arr[] = {5, 6, 3, 4, 12, 22, 10};
        quickSort(arr, 0, arr.length - 1);

        for (int i = 0; i < arr.length - 1; i++) {
            System.out.println(arr[i]);
        }

    }

}
