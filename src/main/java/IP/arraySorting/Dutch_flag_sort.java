package main.java.IP.arraySorting;

import java.util.ArrayList;

public class Dutch_flag_sort {

    public static void dutch_flag_sort(char[] balls) {
        int start = 0;
        int end = balls.length - 1;
        int index = 0;

        while (index <= end && start < end) {

            if (balls[index] == 'R') {
                balls[index] = balls[start];
                balls[start] = 'R';
                start++;
                index++;
            } else if (balls[index] == 'B') {
                balls[index] = balls[end];
                balls[end] = 'B';
                end--;

            } else {
                index++;
            }

        }

        System.out.println(balls);

    }

    public static ArrayList<Integer> sortColors(ArrayList<Integer> A) {

        // start, end, index

        int start =0;
        int index=0;
        int end = A.size()-1;

        while (index <= end && start < end) {

            if(A.get(index) == 0) {
                A.add(index, A.get(start));
                A.add(start, 0);
                start++;
                index++;
            } else if(A.get(index) == 2) {
                A.add(index, A.get(end));
                A.add(end, 2);
                end --;
            } else {
                index++;
            }

        }
        return A;
    }

    public static void main(String[] args) {
        ArrayList<Integer> input = new ArrayList<>();
        input.add(1);
        input.add(1);
        input.add(0);
        input.add(0);
        input.add(2);
        input.add(2);
        input.add(1);
        ArrayList<Integer> output = sortColors(input);
        System.out.println(output);
        //char[] c = {'G', 'B', 'G', 'G', 'R', 'B', 'R', 'G'};
        //dutch_flag_sort(c);
    }
}
