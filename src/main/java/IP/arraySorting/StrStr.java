package main.java.IP.arraySorting;

public class StrStr {

     private static String smallestSubString = null;

    public static String findSmallestSubstringCS(String input, String cs){

        for (int i=0; i<input.length(); i++){
            for (int j=i; j<input.length(); j++){
                String subString = input.substring(i, j);
                StringBuilder temp = new StringBuilder(cs);
                int counter = 0;

                for (int k = 0; k < subString.length(); k++) {
                    if (temp.length() != 0) {
                        if (temp.charAt(counter) == subString.charAt(k)) {
                            temp.deleteCharAt(counter);
                        }
                        counter++;
                    }
                }
                if(temp.length() == 0){
                    if(smallestSubString == null){
                        smallestSubString = subString;
                    }
                    else if(smallestSubString.length() > subString.length()){
                        smallestSubString = subString;
                    }
                }
            }
        }

        return smallestSubString;
    }











    public static int strStr(String haystack, String needle) {
        if(haystack == null || needle == null) return -1;
        if(haystack.isEmpty() && needle.isEmpty()) return 0;
        if(!haystack.isEmpty() && needle.isEmpty()) return 0;
        if(haystack.isEmpty() || needle.isEmpty()) return -1;


        for (int i=0; i<haystack.length();i++){
            try {
                String str = haystack.substring(i, needle.length() + i);
                if(str == needle) return i;

            } catch (StringIndexOutOfBoundsException oobe) {}

        }



        return -1;
    }

    public static void main(String[] args) {
        //strStr("mississippi",
        //        "issip");

        System.out.println(findSmallestSubstringCS("ADOBECODEBANC","ABC"));
    }
}
