package main.java.IP.arraySorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MaxDistance {


    public int maxDistance(List<List<Integer>> arrays) {

        List<Integer> resultArray = new ArrayList<>();
        List<Integer> resultArray1 = new ArrayList<>();


        for (List<Integer> list : arrays){
            resultArray.addAll(list);

        }

        //Collections.sort(resultArray);


      //  for (Integer i : resultArray){
      //      if(i != 0)
      //      resultArray1.add(i);

      //  }

        return Math.abs(resultArray1.get(0) - resultArray1.get(resultArray1.size()-1));

    }



}
