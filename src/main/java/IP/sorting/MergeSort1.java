package main.java.IP.sorting;

public class MergeSort1 {

    private static void mergeSort(int[] a) {
        int[] temp = new int[a.length];

        mergeSort_helper(a, temp, 0, a.length - 1);

        for (int i = 0; i < temp.length; i++) {
            System.out.println(temp[i]);
        }


    }

    private static void mergeSort_helper(int[] a, int[] temp, int start, int end) {
        if (start >= end) return;
        int mid = (start + end) / 2;
        int i = start;
        int j = mid + 1;
        mergeSort_helper(a, temp, start, mid);
        mergeSort_helper(a, temp, j, end);

        //int[] resultList =
        int index = 0;
        while (i <= mid && j <= end) {

            if (a[i] <= a[j]) {
                temp[index] = a[i];
                i++;
            } else {
                temp[index] = a[j];
                j++;
            }

            index++;
        }

        while (i <= mid) {
            temp[index] = a[i];
            index++;
            i++;
        }


        while (j <= end) {
            temp[index] = a[j];
            index++;
            j++;
        }


    }

    public static void main(String[] args) {
        int[] array = {3, 2, 4, 16, 7, 8, 2, 3, 5, 67};
        mergeSort(array);
    }
}
