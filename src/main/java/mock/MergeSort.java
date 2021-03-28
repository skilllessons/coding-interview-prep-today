package main.java.mock;

import java.util.Arrays;

public class MergeSort {



    static void  mergeSort(int arr[], int start, int end) {

        if(start < end) {
            int mid = (start+ end) /2;
            mergeSort(arr, start, mid);
            mergeSort(arr, mid+1, end);
            merge(arr, start, mid, end);

        }
    }

    private static void merge(int[] arr, int start, int mid, int end) {

          int[] temp = new int[end - start +1];

          int i=start;
          int j= end;
          int k = 0;

          while (i<=mid && j<=end) {
              if (arr[i] <= arr[j]){
                  temp[k] = arr[i];
                  k++;
                  i++;
              } else {
                  temp[k] = arr[j];
                  k++;
                  j++;
              }

          }

          while (i<=mid) {
              temp[k] = arr[i];
              k++;
              i++;

          }


        while (j<=end) {
            temp[k] = arr[j];
            k++;
            j++;

        }

        // copy from temp to original...

       // copy temp to original interval
        for(i = start; i <= end; i += 1) {
            arr[i] = temp[i - start];
        }





    }


    public static void main(String[] args) {
       int [] input =  new int[]{4,12,1,2,3,67,45,12};
        mergeSort(input, 0, input.length-1);
        Arrays.stream(input).forEach( i-> {
            System.out.println(i);
        });


    }

}
