package main.java.IP.extra;

import java.util.ArrayList;
import java.util.List;

public class MoveElementToEnd {


    public static List<Integer> moveElementToEnd(List<Integer> array, int toMove) {
        // Write your code here.

        int count = 0;

        for(int i=0;i<array.size(); i++) {
            if(array.get(i) == toMove) {
                count++;
            }
        }

        List<Integer> result = new ArrayList<>();

        for(int i=0;i<array.size(); i++) {
            if(array.get(i) != toMove) {
                result.add(array.get(i));
            }
        }

        while(count!=0) {

            result.add(toMove);
            count --;
        }



        return result;
    }



}
