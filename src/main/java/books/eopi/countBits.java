package main.java.books.eopi;

public class countBits {

    public static short countBits(int x) {
        short numBits = 0;
        while (x != 0) {
            numBits += (x & 1);
            x >>>= 1;
        }
        return numBits;
    }

    public static void main(String[] args) {
        System.out.println(countBits(16));
    }



}
