package main.java.mock;

public class ReverseVowels {

    public static String reverseVowels(String s) {

        int start=0;
        int end = s.length() -1;

        char[] c = s.toCharArray();

        while(start < end) {

            if(!isVowel(c[start])) {
                start++;
            } else if(!isVowel(c[end])) {
                end --;
            } else if(isVowel(c[start]) && isVowel(c[end])){
                char temp =  c[start];
                c[start] = c[end];
                c[end] = temp;
                start++;
                end--;

            }

        }
        return new String(c);
    }

    private static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i'
                || c == 'o' || c == 'u' || c == 'A'
                || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }

    public static void main(String[] args) {

        System.out.println(reverseVowels("hello"));

    }
}
