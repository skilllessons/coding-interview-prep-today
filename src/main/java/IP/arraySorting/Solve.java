package main.java.IP.arraySorting;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Solve {

    static String[] solve(String[] arr) {

        Map<String, String> map = new TreeMap<>();
        Map<String, Integer> map1 = new HashMap<>();

        for (String str : arr) {
            String key = str.split(" ")[0];
            String value = str.split(" ")[1];
            map1.put(value, map1.getOrDefault(value, 0) + 1);
            String newKey = key + ":" +map1.get(value);
            map.put(newKey, value);
        }

        String[] result = new String[map.size()];
        int counter=0;

        for (Map.Entry<String,String> entry: map.entrySet()) {

            result[counter++] = String.valueOf(entry.getKey() + " " + entry.getValue());
        }

      return result;
    }

    public static void main(String[] args) {

        String[]  str = new String[8];
        str[0] = "this testcase";
        str[1] = "would be";
        str[2] = "sitting on";
        str[3] = "a server";
        str[4] = "somewhere out";
        str[5] = "of reach";
        str[6] = "of an";
        str[7] = "ordinary man";

    }



}
