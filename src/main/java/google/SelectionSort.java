package main.java.google;

public class SelectionSort {

    public static int[] selectionsort(int[] input) {


        for (int i = 0; i < input.length - 1; i++) {


            int min = i;


            for (int j = i + 1; j < input.length; j++) {

                if (input[j] < input[min]) {

                    min = j;

                }

                int temp = input[min];

                input[min] = input[i];

                input[i] = temp;
            }


        }
       return input;

    }

    public static void main(String[] args) {
        int [] input = {4,7,8,10,2,3,};
        int[] result = selectionsort(input);
        System.out.println(result);
    }
}
