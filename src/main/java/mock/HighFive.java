package main.java.mock;

import java.util.*;

public class HighFive {

    public static int[][] highFive(int[][] items) {

        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int[] item : items) {

            if (map.containsKey(item[0])) {
                List<Integer> newValue = map.get(item[0]);
                newValue.add(item[1]);
                map.put(item[0], newValue);

            } else {
                List<Integer> newValue = new ArrayList<>();
                newValue.add(item[1]);
                map.put(item[0], newValue);
            }
        }

        int[][] finalResult = new int[map.size()][2];
        int counter = 0;
        for (Map.Entry<Integer, List<Integer>> result: map.entrySet()){
            int [] ia = new int[2];
            ia[0] = result.getKey();
            double avg;
            if(result.getValue().size() >5) {
                Collections.sort(result.getValue());
                //result.getValue().stream().peek(5).
                List<Integer> top5 = new ArrayList<Integer>(result.getValue().
                        subList(result.getValue().size() -5, result.getValue().size()));
                avg = top5
                        .stream()
                        .mapToInt(a -> a)
                        .average().orElse(0);

            } else {

             avg = result.getValue()
                        .stream()
                        .mapToInt(a -> a)
                        .average().orElse(0);
            }

            ia[1] = (int) avg;
            finalResult[counter]  = ia;
            counter++;

        }
     return finalResult;

    }

    public static void main(String[] args) {
        int[][] input = {{1,91},{1,92},{2,93},{2,97},{1,60},{2,77},{1,65},{1,87},{1,100},{2,100},{2,76}};
        highFive(input);

    }

}
