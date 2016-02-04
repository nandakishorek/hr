/**
 * 
 */
package com.hr;

import java.util.Arrays;

/**
 * @author kishore
 *
 */
public class MinUnfairness {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }
    
    public static int minUnfairness(int k, int[] arr) {
        Arrays.sort(arr);
        int minDiff = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length - k; ++i) {
            int curDiff = arr[i + k - 1] - arr[i];
            if (curDiff < minDiff) {
                minDiff = curDiff;
            }
        }
        return minDiff;
    }

}
