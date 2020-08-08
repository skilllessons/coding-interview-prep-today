package main.java.google;

public class MergeSort {

    public static void mergeSort(int [] array){

        mergesort(array, new int[array.length], 0, array.length-1);
    }

    private static void mergesort(int[] array, int[] temp, int leftStart, int rightEnd) {

        if (leftStart >= rightEnd){
            return;
        }

        int middle = (leftStart + rightEnd) /2;
        mergesort(array,temp, leftStart, middle);
        mergesort(array, temp, middle+1, rightEnd);
        mergeHalves(array, temp, leftStart, rightEnd);

    }

    private static void mergeHalves(int[] array, int[] temp, int leftStart, int rightEnd) {

         int leftEnd = (rightEnd + leftStart) / 2;
         int rightStart = leftEnd + 1;
         int size = rightEnd - leftStart + 1;

         int left = leftStart;
         int right = rightStart;
         int index = leftStart;

         while (left<=leftEnd && right<= rightEnd){

             if (array[left] <= array[right]){
                 temp[index] = array[left];
                 left ++ ;
             } else {

                 temp[index] = array[right];
                 right ++;

             }

             index ++ ;

         }




    }
}
