package main.java.IP.arraySorting;

import java.util.HashSet;

public class ArrayInterval {

    public static HashSet<Integer> mergeInterval(int[] a1, int[] a2) {

        HashSet<Integer> result = new HashSet<Integer>();

        int i = 0, j = 0;

        while (i <= a1.length - 1 && j <= a2.length - 1) {
            if (a1[i] == a2[j]) {
                i++;
                j++;
                result.add(a1[i]);
            } else if (a1[i] > a2[j]) {
                j++;

            } else if (a1[i] < a2[j]) {
                i++;
            }
        }
        return result;

    }

    public static void main(String[] args) {
        int[] a1 = {2, 3, 3, 5, 5, 6, 7, 7, 8, 12};
        int[] a2 = {5, 5, 6, 8, 8, 9, 10, 10};

        mergeInterval(a1, a2);

    }

}
