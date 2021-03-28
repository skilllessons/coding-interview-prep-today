package main.java.recursion;

public class Gcd {

    public static int gcd(int num1, int num2) {
        // Base case
        if (num1 == num2) {
            //System.out.println(num1 + "::"+ num2);
            return num1;
        }
        // Recursive case
        if (num1 > num2) {
           int result = gcd(num1-num2, num2);
            System.out.println("if");
            System.out.println(result);

        }
        else {
            //System.out.println(num1 + "<"+ num2);
            //return gcd(num1, num2-num1);
            int result = gcd(num1, num2-num1);
            System.out.println("else");
            System.out.println(result);


        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(gcd(9,15));
    }
}
