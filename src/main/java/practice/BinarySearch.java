package main.java.practice;

public class BinarySearch {

    static int binarySearchRec(int[] a, int key, int low, int high) {

        if (low > high) return -1;

        int mid = (low + high) / 2;

        if (key == a[mid]) {
            return mid;
        } else if (key < a[mid]) {

            return binarySearchRec(a, key, low, mid-1);

        } else {

            return binarySearchRec(a, key, mid+1, a.length - 1);

        }


    }

    static int binSearch(int[] a, int key) {
        return binarySearchRec(a, key, 0, a.length - 1);
    }

    public static void main(String[] args) {
        //binSearch([1, 2, 4, 7, 8, 12, 15, 19, 24, 50, 69, 80, 100],12)

        int[] input = {1, 2, 4, 7, 8, 12, 15, 19, 24, 50, 69, 80, 100};

       System.out.println(binSearch(input, 44 ));
    }


}
