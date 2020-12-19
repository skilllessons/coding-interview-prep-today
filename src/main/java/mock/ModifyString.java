package main.java.mock;

import java.util.Random;

public class ModifyString {



    public static String modifyString(String s) {
        //StringBuil


        char[] s1 = s.toCharArray();

        //Base Case

        if(s1[0] == '?') {
            char c1;

            do{
                c1 = getRandom();
                if(c1!= s1[1]) {
                    s1[0] = c1;
                    break;
                }


            } while(c1 == s1[1]);
        }


        for(int i=1; i<s1.length-1; i++) {
            if(s1[i] == '?') {
                char c = getRandom();
                while(c!= s1[i-1] && c!= s1[i+1]) {
                    s1[i] = c;
                    break;

                }
            }

        }
        return new String(s1);


    }

    private static char getRandom(){
        Random r = new Random();
        char c = (char) (r.nextInt(26) + 'a');
        return c;
    }

    public static void main(String[] args) {
        modifyString("ubv?w");

    }
}
