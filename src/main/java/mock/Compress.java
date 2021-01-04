package main.java.mock;

public class Compress {

    public static int compress(char[] chars) {
        if(chars != null && chars.length > 0){
            int index = 0;
            for(int i = 0; i < chars.length; i++){
                int count = 1;
                while(i+1 < chars.length && chars[i] == chars[i+1]){
                    count++;
                    i++;
                }
                chars[index++] = chars[i];
                if(count > 1){
                    StringBuffer num = new StringBuffer();
                    while(count > 0){
                        num.insert(0,count%10);
                        count = count/10;
                    }
                    for(char c : num.toString().toCharArray()){
                        chars[index++] = c;
                    }
                }
            }
            return index;
        }
        return -1;

    }

    public static void main(String[] args) {
        compress(new String("aabbccc").toCharArray());
    }
}
