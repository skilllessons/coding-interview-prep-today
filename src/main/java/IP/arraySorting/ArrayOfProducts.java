package main.java.IP.arraySorting;

public class ArrayOfProducts {

    public static int[] arrayOfProducts(int[] array) {

        int temp =1;

        int[] result = new int[array.length];

        result[0] = 1;

        for (int i=1; i<array.length; i++) {
            temp  *= array[i-1];
            result[i] = temp;
        }

        temp =1;

        for (int i=array.length -2; i>=0; i--) {
            temp  *= array[i+1];
            result[i] = temp * result[i];
        }
        return result;
    }

    public static void main(String[] args) {
        arrayOfProducts(new int[] {5,1,4,2});
    }



}
