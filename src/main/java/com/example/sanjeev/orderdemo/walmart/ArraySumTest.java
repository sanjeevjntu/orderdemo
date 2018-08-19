package com.example.sanjeev.orderdemo.walmart;

public class ArraySumTest {
    /**
     * Find the pair of integers in an array whose sum is x.
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] inputArray = {1,2,3,6, 1};//{1,2,34,5,6,7,3,6, 4};//{ 4, 123, 5, 66, 23, 2, 234, 23, 1, 12, 8, 233, 1, 2334, 6, 7, 8, 9};
       // System.out.println(findPairOFIntswhoseSumisX(inputArray, 9));
        System.out.println(subarraySum(inputArray, 4));
        //findAllPairs(inputArray);
    }

  /*  private static int subarraySum(int[] inputArray, int number) {

        int sum=0, count=0;

        Arrays.stream(inputArray).sorted()



    }
*/


    public static int subarraySum(int[] nums, int sum) {

        int count = 0;

        for (int i = 0; i < nums.length; i++) {

            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == sum) {
                    count++;

                    System.out.println(nums[i]+" + "+nums[j]+" = "+sum);
                }
            }

        }

        return count;

    }

   /* public static void findAllPairs(int[] ints){
        for(int i=0, j=i+1; i<ints.length && j<ints.length; i++, j++){


        }
    }*/

    private static int[] findPairOFIntswhoseSumisX(int[] inputArray, int x) {

        int sum = 0;

        for (int i = 0, j = i + 1; i < inputArray.length && j < inputArray.length; i++, j++) {

            sum = inputArray[i] + inputArray[j];

            if (sum == x) {
                return new int[]{};
            } else {
                try {
                    throw new CustomExcption("Sanjeev", new Throwable());
                } catch (CustomExcption customExcption) {
                    ;

                    System.out.println(customExcption.getMessage());
                    System.out.println(customExcption.getCause());

                }
            }

        }
        return new int[]{0, 0};
    }
}
