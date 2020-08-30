package main.java.IP.arraySorting;

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

    public static void main(String[] args) {
        char[] c = {'G', 'B', 'G', 'G', 'R', 'B', 'R', 'G'};
        dutch_flag_sort(c);
    }
}
