package main.java.mock;



public class NumTimesAllBlue {

    public static int numTimesAllBlue(int[] light) {
        int sum = 0, tmp = 0, res = 0;
        for(int i=0;i<light.length;i++){
            sum += i+1;
            tmp += light[i];
            if(sum == tmp)
                res++;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] input = {1,2,3,4,5,6};
        numTimesAllBlue(input);
    }
}
