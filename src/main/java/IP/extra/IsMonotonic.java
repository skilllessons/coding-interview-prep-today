package main.java.IP.extra;

public class IsMonotonic {


    public static boolean isMonotonic(int[] array) {
        boolean  isNonDecreasing = true;
        boolean  isNonIncreasing = true;

        for(int i=1; i<array.length; i++) {
            if(array[i] < array[i-1]) {
                isNonDecreasing = false;
            }
            if(array[i] > array[i-1]) {
                isNonIncreasing = false;
            }

        }

        return isNonIncreasing || isNonDecreasing;
    }



    public static void main(String[] args) {

        System.out.println(isMonotonic(new int[]{-1, -5, -10, -1100, -1100, -1101, -1102, -9001}));
    }

}
