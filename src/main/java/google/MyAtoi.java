package main.java.google;

public class MyAtoi {

    public int myAtoi(String str) {
        if (str == null || str.length() == 0) return 0;
        char chs[] = str.toCharArray();
        long base = 0;
        int i = 0, sign = 1;

        while (chs[i] == ' ') i++;	// Trim whitespace
        if (chs[i] == '-') {		// sign: '-'
            i++;
            sign = -1;
        } else if (chs[i] == '+') {	// sign: '+'
            i++;
        }
        while (i < str.length() && (chs[i] >= '0' && chs[i] <= '9')) {// Parse numerical digits
            base = base * 10 + (chs[i] - '0');
            // Check integer boundary
            if (sign * base > Integer.MAX_VALUE) return Integer.MAX_VALUE;
            if (sign * base < Integer.MIN_VALUE) return Integer.MIN_VALUE;
            i++;
        }
        return (int)(sign * base);
    }

    public static void main(String[] args) {
        MyAtoi myAtoi = new MyAtoi();
        myAtoi.myAtoi(" -42");
    }

}
