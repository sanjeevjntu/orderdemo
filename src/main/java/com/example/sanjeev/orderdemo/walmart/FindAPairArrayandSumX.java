package com.example.sanjeev.orderdemo.walmart;

import java.util.HashMap;

/**
 * Find the pair of integers in an array whose sum is x.
 *
 * @param
 */
public class FindAPairArrayandSumX {

    public static void main(String[] args) {

        int[] inputArray =  {1,2,3,9};
        System.out.println(subarraySum(inputArray, 12 ));

    }

    private static int subarraySum(int[] nums, int expectedSum) {
        int count = 0, sum = 0;
        HashMap < Integer, Integer > map = new HashMap < > ();
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - expectedSum)) {
                count += map.get(sum - expectedSum);
               // System.out.println(nums[i]);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}