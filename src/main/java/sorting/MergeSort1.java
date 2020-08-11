package main.java.sorting;

public class MergeSort1 {

    private void mergeSort(int[] a){
         mergeSort_helper(a, new int[a.length],0, a.length-1);


    }

    private void mergeSort_helper(int[] a, int [] temp, int start, int end) {
           if(start>= end) return;
           int mid = (start+end)/2;
           int i = start;
           int j = mid+1;
           mergeSort_helper(a,temp, start,mid);
           mergeSort_helper(a,temp,j,end);

           //int[] resultList =
           int index = 0;
           while(i<=mid && j<=end){

               if(a[i]<=a[j]){
                   temp[index] = a[i];
                   i++;
               } else {
                   temp[index] = a[j];
                   i++;
               }

               index++;
           }


    }
}
