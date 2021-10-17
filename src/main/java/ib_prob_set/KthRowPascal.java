package main.java.ib_prob_set;

import java.util.ArrayList;
import java.util.List;

public class KthRowPascal {

    public static int[] getRow(int A) {
        List<List<Integer>> list = new ArrayList<>();
        for (int j = 0; j < A+1; j++) {
            list.add(new ArrayList<>());
        }
        //decorate the 1st row
        list.get(0).add(1);
        // if A ==1 just return
        if (A == 0) {
            return list.get(A).stream().mapToInt(a -> a).toArray();
        }

        for (int i = 1; i < A+1; i++) {
            List<Integer> res = new ArrayList<>();
            List<Integer> prev = list.get(i - 1);
            res.add(1);
            for (int j = 1; j < prev.size(); j++) {
                int r1 = prev.get(j - 1) + prev.get(j);
                res.add(r1);
            }
            res.add(1);
            list.get(i).addAll(res);
        }
        return list.get(A).stream().mapToInt(a -> a).toArray();
    }


    public static void main(String[] args) {
       // int[] res = getRow(4);
       // System.out.println(res.toString());

        int[] res1 = getRow(1);
        System.out.println(res1);
    }


}
