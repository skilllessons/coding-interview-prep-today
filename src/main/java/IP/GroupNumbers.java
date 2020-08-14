package main.java.IP;

public class GroupNumbers {

    static int[] solve(int[] arr) {

        if(arr == null || arr.length == 0) return new int[0];

        int i =0, j=arr.length-1;

        while(i<=j) {
            if(arr[i] % 2 == 0){
                i++;
                continue;
            } else {
                while(arr[j] % 2 !=0){
                    j --;
                    continue;
                }
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }

        }
     return arr;
    }

    public static void main(String[] args) {
        int[] arr = {3,4,1};
        solve(arr);

    }



}
