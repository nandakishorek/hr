package com.hr;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/maxsubarray
 *  
 * @author kishore
 *
 */
public class MaximumSubarray {

    public static void main(String[] args) {
        /*try (Scanner sc = new Scanner(System.in)) {
            int t = sc.nextInt();
            while(t-- > 0) {
                int n = sc.nextInt();
                int[] input = new int[n];
                for (int i = 0; i < n; ++i) {
                    input[i] = sc.nextInt();
                }
                int[] output = maxSubArraySeq(input);
                System.out.printf("%d %d\n", output[0], output[1]);
            }
        }*/
        int[] input = {-100, -8, -4, -9};
        int[] output = maxSubArraySeq(input);
        System.out.printf("%d %d\n", output[0], output[1]);

    }
    
    /**
     * 
     * @param input
     * @return array of two integers representing max sum, first - subarray, second - subsequence
     */
    public static int[] maxSubArraySeq(int[] input) {
        boolean areAllNegative = true;
        
        int maxSubArraySum = 0;
        int maxSubArraySeq = 0;
        
        int curSum = 0;
        for (int i = 0; i < input.length; ++i) {
            if (curSum + input[i] > 0) {
                curSum += input[i];
                if (curSum > maxSubArraySum) {
                    maxSubArraySum = curSum;
                }
            } else {
                curSum = 0;
            }
            if (input[i] > 0) {
                areAllNegative = false;
                maxSubArraySeq += input[i];
            }
        }
        
        // if all the integers in the array are negative, return the maximum one
        if (areAllNegative) {
            int maxNeg = input[0];
            for (int i = 1; i < input.length; ++i) {
                if (input[i] > maxNeg) {
                    maxNeg = input[i];
                }
            }
            
            maxSubArraySum = maxSubArraySeq = maxNeg;
        }
        
        int[] ret = new int[2];
        ret[0] = maxSubArraySum;
        ret[1] = maxSubArraySeq;
        return ret;
    }

}
