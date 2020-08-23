package main.java.sorting;

public class MergeSort3 {

    public static void mergeSort(int[] array) {
        int[] temp = new int[array.length];
        mergesort(array, temp, 0, array.length - 1);

        for (int i = 0; i < temp.length; i++) {
            System.out.println(temp[i]);
        }


    }

    private static void mergesort(int[] array, int[] temp, int leftStart, int rightEnd) {

        if (leftStart >= rightEnd) {
            return;
        }

        int middle = (leftStart + rightEnd) / 2;
        mergesort(array, temp, leftStart, middle);
        mergesort(array, temp, middle + 1, rightEnd);
        mergeHalves(array, temp, leftStart, rightEnd);

    }

    private static void mergeHalves(int[] array, int[] temp, int leftStart, int rightEnd) {

        int leftEnd = (rightEnd + leftStart) / 2;
        int rightStart = leftEnd + 1;
        int size = rightEnd - leftStart + 1;

        int left = leftStart;
        int right = rightStart;
        int index = leftStart;

        while (left <= leftEnd && right <= rightEnd) {

            if (array[left] <= array[right]) {
                temp[index] = array[left];
                left++;
            } else {

                temp[index] = array[right];
                right++;

            }

            index++;

        }

        while (left <= leftEnd) {
            temp[index] = array[left];
            index++;
            left++;
        }
        while (right <= rightEnd) {
            temp[index] = array[right];
            index++;
            right++;
        }

       // System.arraycopy(array, left, temp, index, leftEnd - left + 1);
       // System.arraycopy(array, right, temp, index, rightEnd - right + 1);
        System.arraycopy(temp, leftStart, array, leftStart, size);

    }

    public static void main(String[] args) {
        int[] array = {3, 2, 4, 16, 7, 8, 2, 3, 5, 6,56,3,45,1,2,78};
        mergeSort(array);
    }
}
