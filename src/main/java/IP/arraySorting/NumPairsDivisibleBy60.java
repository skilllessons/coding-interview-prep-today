package main.java.IP.arraySorting;

public class NumPairsDivisibleBy60 {


    public int numPairsDivisibleBy60(int[] time) {

        int[] temp = new int[60];

        int count=0;

        for(int i=0; i<time.length; i++) {

            if(time[i] % 60 ==0) {
                count +=temp[0];
            } else {
                count += temp[60 - time[i] % 60];

            }
            temp[time[i] % 60]++;
        }
        return count;
    }

    public static void main(String[] args) {

    }
}
