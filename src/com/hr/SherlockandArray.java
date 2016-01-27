package com.hr;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/sherlock-and-array
 * 
 * @author kishore
 *
 */
public class SherlockandArray {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0) {
            int n = sc.nextInt();
            int[] input = new int[n];
            for (int i = 0; i < input.length; i++) {
                input[i] = sc.nextInt();
            }
            if (equilibriumPoint(input) > -1) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
        sc.close();
    }
    
    /**
     * returns index of the array where sum of elements on the left is equal to that of the right
     * 
     * @param data
     * @return -1 if there is no such element
     */
    public static int equilibriumPoint(int[] data) {
        
        double[] lrSum = new double[data.length];
        double[] rlSum = new double[data.length];
        
        lrSum[0] = data[0];
        for (int i = 1; i < data.length; ++i) {
            lrSum[i] = lrSum[i - 1] + data[i]; 
        }
        
        rlSum[data.length - 1] = data[data.length - 1];
        for (int i = data.length - 2; i >= 0; --i) {
            rlSum[i] = rlSum[i + 1] + data[i]; 
        }
        
        for (int i = 0; i < data.length; ++i) {
            if (lrSum[i] == rlSum[i]) {
                return i;
            }
        }
        
        return -1;
    }

}
