package main.java.IP.slidingwindow;

public class FindMaxSumSubArray {

    /**
     * The above algorithm’s time complexity will be O(N*K),
     * where ‘N’ is the total number of elements in the given array. Is it possible to find a better algorithm than this?
     * @param k
     * @param arr
     * @return
     */
    public static int findMaxSumSubArray(int k, int[] arr) {
       int maxSum = 0, windowsum =0;
        for (int i=0; i<arr.length -k; i++){
               windowsum = 0;
             for (int j=i; j<k+i; j++){
                 windowsum += arr[j];
             }
            maxSum = Math.max(maxSum, windowsum);
       }
        return maxSum;
    }

    public static int findMaxSumSubArraySlidingWindow(int k, int[] arr) {
        int maxSum = 0 ;
        int windowsum =0;
        int windowstart=0;
        for (int i=0; i<arr.length; i++){
            windowsum += arr[i];

            if(i >= k-1){
                maxSum = Math.max(maxSum, windowsum);
                windowsum -= arr[windowstart];
                windowstart ++;
            }

        }
        return maxSum;
    }

    public static void main(String[] args) {
        System.out.println("Maximum sum of a subarray of size K: "
                + FindMaxSumSubArray.findMaxSumSubArraySlidingWindow(3, new int[] { 2, 1, 5, 1, 3, 2 }));
        System.out.println("Maximum sum of a subarray of size K: "
                + FindMaxSumSubArray.findMaxSumSubArraySlidingWindow(2, new int[] { 2, 3, 4, 1, 5 }));
    }


}


