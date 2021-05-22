package main.java.companies.doordash;

import java.util.*;
class FirstUnique {

    Queue<Integer> queue = new LinkedList<>();
    Map<Integer, Boolean> cache = new LinkedHashMap<>();

    public FirstUnique(int[] nums) {
        for(int i=0; i<nums.length; i++) {

            if(!cache.containsKey(nums[i])) {
                cache.put(nums[i], true);
            } else {
                cache.put(nums[i], false);
            }
            queue.add(nums[i]);
        }




    }

    public int showFirstUnique() {

        for (Map.Entry<Integer, Boolean> map : cache.entrySet()) {

            if(map.getValue()) {
                return map.getKey();
            }

        }

        return -1;

    }

    public void add(int value) {

        if(!cache.containsKey(value)) {
            cache.put(value, true);
        } else {
            cache.put(value, false);
        }

        queue.add(value);

    }
}
