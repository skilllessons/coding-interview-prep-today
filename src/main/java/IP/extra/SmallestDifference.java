package main.java.IP.extra;

import org.junit.Test;

import java.util.Arrays;

public class SmallestDifference {

    public static int[] smallestDifference(int[] arrayOne, int[] arrayTwo) {
        // Write your code here.
        Arrays.sort(arrayOne);
        Arrays.sort(arrayTwo);
        return new int[] {arrayOne[arrayOne.length-1], arrayTwo[0]};
    }


    @Test
    public void TestCase1() {
        int[] expected = {28, 26};
        //AssertTrue(
        //        Arrays.equals(
        //                Program.smallestDifference(
        //                        new int[] {-1, 5, 10, 20, 28, 3}, new int[] {26, 134, 135, 15, 17}),
        //                expected));
    }


}
