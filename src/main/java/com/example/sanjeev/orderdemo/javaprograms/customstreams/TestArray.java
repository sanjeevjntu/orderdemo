package com.example.sanjeev.orderdemo.javaprograms.customstreams;

/**
 * Find consecutive subarray with max value
 */
public class TestArray {

    public static void main(String[] args) {
        int[] input = {1, 2, 45, -1,100, 19, 1, 3, 4, 5, 6, 7};
        System.out.println(getSubArrayWithMaxValue(input));

        int[] subArrayWithMaxValue = getSubArrayWithMaxValue(input);

        for (int i = 0; i < subArrayWithMaxValue.length; i++) {

            System.out.println(subArrayWithMaxValue[i]);

        }
    }

    private static int[] getSubArrayWithMaxValue(int[] input) {
        int max = Integer.MIN_VALUE;
        int[] maxSubArray = new int[2];
        for (int i = 0, j = i + 1; (i < input.length && j < input.length); i++, j++) {
            int currentMax = input[i] + input[j];
            if (currentMax > max) {
                max = currentMax;
                maxSubArray[0] = input[i];
                maxSubArray[1] = input[j];
            }
        }

        return maxSubArray;
    }
}
