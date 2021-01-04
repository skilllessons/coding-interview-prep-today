package main.java.mock;

public class AlternatingSort {

    static boolean alternatingSort(int[] a) {

        int currentIndex = 0;
        int start=0;
        int end=a.length-1;
        int mid = end/2;

        int[] b = new int[a.length];
        while(start <= mid) {
            b[currentIndex] = a[start];
            currentIndex++;
            b[currentIndex] = a[end];
            start++;
            end--;
            currentIndex++;
        }

        for(int i=0; i<a.length-1; i++) {
            if(b[i] > b[i+1]) return false;

        }

        return true;
    }

    public static void main(String[] args) {
        alternatingSort(new int[]{1, 3, 5, 6, 4, 2});
    }
}
